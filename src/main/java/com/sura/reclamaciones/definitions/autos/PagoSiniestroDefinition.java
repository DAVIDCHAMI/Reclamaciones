package com.sura.reclamaciones.definitions.autos;

import static com.sura.reclamaciones.constantes.NombresCsv.EXPEDICION_AUTOS;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_RECLAMACION_PERSONA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_SINIESTRO_AUTOS;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_VEHICULO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_CREACION_AVISO_AUTOS_WS;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_PERSONA_CONDUCTOR;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_PERSONA_LESIONADA;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ExpedicionAuto;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.poliza.ConsumoServicioExpedicionAutoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PagoSiniestroDefinition {
  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;
  @Steps ConsumoServicioExpedicionAutoStep consumoServicioExpedicionAutoStep;
  @Steps GenericStep genericStep;
  @Steps NuevoPagoStep nuevoPagoStep;
  @Steps PagoSiniestro pagoSiniestro;
  String cobertura;
  List<ReclamacionAuto> lstReclamacionAuto;
  List<PersonaReclamacion> lstPersonaLesionada;
  List<PersonaReclamacion> lstConductor;
  List<Vehiculo> lstVehiculoParam;
  ReclamacionAuto parametroAviso = new ReclamacionAuto();
  PersonaReclamacion parametroPersonaReclamacionAuto = new PersonaReclamacion();
  PersonaReclamacion parametroPersonaConductorAuto = new PersonaReclamacion();
  Vehiculo reclamacionVehiculo = new Vehiculo();

  @Dado("^que se tiene un siniestro de (.*) con un tipo de cobertura de (.*)$")
  public void crearSiniestroAutos(String filtroCsv, String tipoCobertura) throws IOException {
    cobertura = tipoCobertura;
    parametroPersonaReclamacionAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION_PERSONA.getValor(), PARAMETRO_PERSONA_LESIONADA.getValor()));
    lstPersonaLesionada = parametroPersonaReclamacionAuto.getLstPersonaReclamacion();
    parametroPersonaConductorAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION_PERSONA.getValor(), PARAMETRO_PERSONA_CONDUCTOR.getValor()));
    lstConductor = parametroPersonaConductorAuto.getLstPersonaReclamacion();
    reclamacionVehiculo =
        new Vehiculo(genericStep.getFilasModelo(PARAMETROS_VEHICULO.getValor(), filtroCsv));
    lstVehiculoParam = reclamacionVehiculo.getVehiculos();
    parametroAviso =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_SINIESTRO_AUTOS.getValor(),
                PARAMETRO_CREACION_AVISO_AUTOS_WS.getValor()));
    lstReclamacionAuto = parametroAviso.getLstReclamacionAuto();
    String tipoPoliza = "póliza de auto";
    ExpedicionAuto expedicionAuto =
        new ExpedicionAuto(genericStep.getFilasModelo(EXPEDICION_AUTOS.getValor(), tipoPoliza));
    consumoServicioExpedicionAutoStep.consumirServicioExpedicion(
        expedicionAuto.getLstExpedicion(),
        Integer.parseInt(ConstanteGlobal.NUMERO_DIAS_VENCIMIENTO),
        ConstanteGlobal.FECHA_ACTUAL);
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos(
        lstReclamacionAuto, lstPersonaLesionada, lstConductor, lstVehiculoParam);
    creacionAvisoSiniestroAutoStep.verificarSiniestro();
  }

  @Cuando(
      "^se genere un pago (.*) al beneficiario (.*) por el medio de pago de (.*) sobre la linea de reserva (.*) donde el responsable (.*) es Sura con una retención de (.*)$")
  public void crearPagoAutos(
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String lineaReserva,
      String aplicaSoloSura,
      String codigoRetencion)
      throws IOException {
    nuevoPagoStep.consultarNumeroReclamacionAutos(
        Serenity.sessionVariableCalled(ReclamacionConstante.NUMERO_SINIESTRO));
    nuevoPagoStep.ingresarSeleccionarExposicionAutomatica();
    nuevoPagoStep.declararReclamacionPerdidaTotal();
    nuevoPagoStep.ingresarEstadoLegalReclamacion();
    nuevoPagoStep.seleccionarPagos();
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(String.valueOf(PAGO_SINIESTRO.getValor()), cobertura)));
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(
        lineaReserva,
        tipoPago,
        beneficiarioPago,
        metodoPago,
        aplicaSoloSura,
        codigoRetencion,
        pagoSiniestro.getLstPago());
  }

  @Entonces("^se obtiene el pago del beneficiario$")
  public void verificarPagoAutos() {
    nuevoPagoStep.verificarPagoRealizado(pagoSiniestro.getLstPago());
  }
}
