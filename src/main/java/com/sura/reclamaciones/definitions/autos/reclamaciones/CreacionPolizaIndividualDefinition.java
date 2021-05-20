package com.sura.reclamaciones.definitions.autos.reclamaciones;

import static com.sura.reclamaciones.utils.enums.NombresCsv.ASEGURADO;
import static com.sura.reclamaciones.utils.enums.NombresCsv.COBERTURAS_AUTOS;
import static com.sura.reclamaciones.utils.enums.NombresCsv.DICCIONARIO_COBERTURAS_AUTOS;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_VEHICULO;
import static com.sura.reclamaciones.utils.enums.NombresCsv.TOMADOR;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_PC_NUMERO_POLIZA;

import com.sura.reclamaciones.models.Asegurado;
import com.sura.reclamaciones.models.CoberturaVehiculo;
import com.sura.reclamaciones.models.Tomador;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.guidewire.policycenter.autos.ServicioExpedicionAutosIndividualStep;
import com.sura.reclamaciones.utils.UtilidadesCSV;
import com.sura.reclamaciones.utils.enums.Separador;
import cucumber.api.java.es.Dado;
import java.io.IOException;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class CreacionPolizaIndividualDefinition {

  @Steps ServicioExpedicionAutosIndividualStep servicioExpedicionAutosIndividualStep;

  @Dado(
      "^se tiene una póliza de autos individual con plan (.+) de vigencia (.+) con (\\d+) de (.+)$")
  public void consumirServicioExpedicion(
      String planAutos, String tipoVigencia, int cantidadDias, String terminoInicioVigencia)
      throws IOException {
    final String FILTRO_ASEGURADO = "asegurado riesgo estándar";
    final String FILTRO_TOMADOR = "tomador riesgo estándar";
    final String FILTRO_VEHICULO = "vehículo riesgo estándar";
    final String FILTRO_COBERTURAS;
    Asegurado asegurado =
        new Asegurado(
            UtilidadesCSV.obtenerPrimerDatoPrueba(ASEGURADO.getValor(), FILTRO_ASEGURADO));
    Tomador tomador =
        new Tomador(UtilidadesCSV.obtenerPrimerDatoPrueba(TOMADOR.getValor(), FILTRO_TOMADOR));
    Vehiculo vehiculo =
        new Vehiculo(
            UtilidadesCSV.obtenerPrimerDatoPrueba(PARAMETROS_VEHICULO.getValor(), FILTRO_VEHICULO));
    FILTRO_COBERTURAS =
        String.format(
            "%s%s%s%s%s",
            vehiculo.getClaseVehiculo(),
            Separador.SEPARADOR_VIRGULILLA.getValor(),
            planAutos,
            Separador.SEPARADOR_VIRGULILLA.getValor(),
            vehiculo.getModelo());
    List<CoberturaVehiculo> lstCoberturasVehiculo =
        CoberturaVehiculo.obtenerListaCoberturas(
            UtilidadesCSV.obtenerDatosPrueba(COBERTURAS_AUTOS.getValor(), FILTRO_COBERTURAS),
            UtilidadesCSV.obtenerDatosPrueba(DICCIONARIO_COBERTURAS_AUTOS.getValor(), ""));
    servicioExpedicionAutosIndividualStep.asignarInformacionFechas(
        tipoVigencia, terminoInicioVigencia, cantidadDias);
    servicioExpedicionAutosIndividualStep.asignarInformacionCliente(tomador, asegurado);
    servicioExpedicionAutosIndividualStep.asignarInformacionVehiculo(
        vehiculo, lstCoberturasVehiculo);

    servicioExpedicionAutosIndividualStep.expedirPolizaIndividual();
    servicioExpedicionAutosIndividualStep.verificarCreacionPoliza();
    Serenity.setSessionVariable(SESION_PC_NUMERO_POLIZA)
        .to(servicioExpedicionAutosIndividualStep.getNumeroPoliza());
  }
}
