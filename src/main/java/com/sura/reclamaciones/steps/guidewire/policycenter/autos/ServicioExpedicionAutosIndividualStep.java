package com.sura.reclamaciones.steps.guidewire.policycenter.autos;

import com.sura.reclamaciones.models.Asegurado;
import com.sura.reclamaciones.models.CoberturaVehiculo;
import com.sura.reclamaciones.models.Tomador;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.models.comunes.ExpedicionAutosIndividualRequest;
import com.sura.reclamaciones.models.comunes.ExpedicionAutosIndividualResponse;
import com.sura.reclamaciones.services.ExpedicionAutosIndividualFactory;
import com.sura.reclamaciones.utils.Fecha;
import com.sura.service.clientes.comunes.ClienteGenericoConsumoREST;
import com.sura.service.util.enums.EnumCredencialesConsumoServicio;
import com.sura.service.util.enums.EnumUrlBase;
import java.text.ParseException;
import java.util.List;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class ServicioExpedicionAutosIndividualStep {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(ServicioExpedicionAutosIndividualStep.class);

  @Steps
  ExpedicionAutosIndividualFactory expedicionAutosIndividualFactory =
      new ExpedicionAutosIndividualFactory();

  ResponseEntity<ExpedicionAutosIndividualResponse> responseServicioExpedicion;

  @Step("Asignar información de fechas")
  public void asignarInformacionFechas(
      String vigencia, String terminoInicioVigencia, int cantidadDias) {
    final String FORMATO_FECHA_YYYYMMDDTHHMMSSSSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    String fechaActual = Fecha.obtenerFechaActualFormato(FORMATO_FECHA_YYYYMMDDTHHMMSSSSSZ);
    String fechaInicioVigencia =
        Fecha.obtenerFechaInicioVigenciaSegunTerminoInicio(cantidadDias, terminoInicioVigencia);
    expedicionAutosIndividualFactory.setFechaInicioVigencia(fechaInicioVigencia);
    expedicionAutosIndividualFactory.setFechaFinVigencia(
        Fecha.obtenerFechaFinVigencia(fechaInicioVigencia, vigencia));
    expedicionAutosIndividualFactory.setFechaTarifa(fechaInicioVigencia);
    try {
      expedicionAutosIndividualFactory.setFechaActualizacion(
          Fecha.convertirFechaUnix(fechaActual, FORMATO_FECHA_YYYYMMDDTHHMMSSSSSZ));
    } catch (ParseException e) {
      LOGGER.error("No se pudo convertir la fecha correctamente", 0);
    }
  }

  @Step("Asignar información del cliente")
  public void asignarInformacionCliente(Tomador tomador, Asegurado asegurado) {
    expedicionAutosIndividualFactory.setTomador(tomador);
    expedicionAutosIndividualFactory.setAsegurado(asegurado);
  }

  @Step("Asignar información del vehículo")
  public void asignarInformacionVehiculo(
      Vehiculo vehiculo, List<CoberturaVehiculo> lstCoberturasVehiculo) {
    expedicionAutosIndividualFactory.setVehiculo(vehiculo);
    expedicionAutosIndividualFactory.setLstCoberturasVehiculo(lstCoberturasVehiculo);
  }

  @Step("Consumir servicio de expedición de autos individual")
  public void expedirPolizaIndividual() {
    responseServicioExpedicion =
        new ClienteGenericoConsumoREST<
                ExpedicionAutosIndividualRequest, ExpedicionAutosIndividualResponse>(
                EnumUrlBase.URL_EDGE_AUTOS_EXPEDICION, EnumCredencialesConsumoServicio.USR_EDGE_CA)
            .ejecutarConsumo(
                expedicionAutosIndividualFactory.construirRequestExpedicion(),
                HttpMethod.POST,
                ExpedicionAutosIndividualResponse.class);
  }

  @Step("Verificar creación correcta de la póliza")
  public void verificarCreacionPoliza() {
    MatcherAssert.assertThat(
        "No se obtuvo el número de póliza correctamente"
            + responseServicioExpedicion.getBody().getResult(),
        responseServicioExpedicion.getBody().getResult().getQuotingData().getPolicyNumber()
            != null);
  }

  public String getNumeroPoliza() {
    return responseServicioExpedicion.getBody().getResult().getQuotingData().getPolicyNumber();
  }
}
