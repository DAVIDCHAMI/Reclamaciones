package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_MANUAL_VEHICULAR;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_VEHICULAR_TERCERO;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_NAVEGACION_MENU_ACCIONES;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO;
import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_LINEA_RESERVA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_COBERTURA_AFECTADA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PAGO;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.pagos.InformacionBeneficiarioPagoStep;
import com.sura.reclamaciones.steps.pagos.InformacionPagoStep;
import com.sura.reclamaciones.steps.pagos.InstruccionPagoStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.procesoauditoria.InclusionProcesoAuditoriaStep;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PagoSiniestroDefinition {

  PagoSiniestro pagoSiniestro;

  ExposicionVehiculoTercero exposicionVehiculoTercero = new ExposicionVehiculoTercero();

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps InformacionBeneficiarioPagoStep informacionBeneficiarioPagoStep;

  @Steps InformacionPagoStep informacionPagoStep;

  @Steps InstruccionPagoStep instruccionPagoStep;

  @Steps GenericStep genericStep;

  @Steps InclusionProcesoAuditoriaStep inclusionProcesoAuditoriaStep;

  @Dado("^el asegurado o algún tercero de la póliza tiene marca de riesgo consultable$")
  public void identificarRiesgoConsultable() {
    //TODO: Falta adaptar con la automatización de marcación de audotoría
  }

  @Cuando(
      "^se realiza un pago (.*) al beneficiario (.*) por el medio de pago de (.*) sobre la línea de reserva (.*) con cobertura de  (.*) donde el responsable (.*) es Sura con una retención de (.*)$")
  public void generarPagoReclamacion(
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String lineaReserva,
      String cobertura,
      String aplicaSoloSura)
      throws IOException {
    nuevoPagoStep.crearNuevoPago();
    pagoSiniestro =
        new PagoSiniestro(
            (obtenerDatosPrueba(String.valueOf(PAGO_SINIESTRO.getValor()), cobertura)));
    nuevoPagoStep.crearNuevoPago();
    informacionBeneficiarioPagoStep.ingresarInformacionBeneficiarioPago(
        beneficiarioPago, metodoPago, aplicaSoloSura, pagoSiniestro.getLstPago());
    informacionPagoStep.ingresarInformacionPago(lineaReserva, tipoPago, pagoSiniestro.getLstPago());
    instruccionPagoStep.finalizarCreacionPago(pagoSiniestro.getLstPago(), lineaReserva);
  }

  @Cuando(
      "^se genere un pago (.*) al beneficiario (.*) por el medio de pago de (.*) sobre la línea de reserva (.*) donde el responsable (.*) es Sura con una retención de (.*)$")
  public void crearPago(
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String lineaReserva,
      String aplicaSoloSura)
      throws IOException {
    nuevoPagoStep.seleccionarExposicionVehicularAsegurado();
    nuevoPagoStep.declararReclamacionPerdidaTotal();
    nuevoPagoStep.ingresarEstadoLegalReclamacion();
    pagoSiniestro =
        new PagoSiniestro(
            (obtenerDatosPrueba(
                PAGO_SINIESTRO.getValor(),
                Serenity.sessionVariableCalled(SESION_CC_TIPO_COBERTURA_AFECTADA.getValor()))));
    nuevoPagoStep.crearNuevoPago();
    informacionBeneficiarioPagoStep.ingresarInformacionBeneficiarioPago(
        beneficiarioPago, metodoPago, aplicaSoloSura, pagoSiniestro.getLstPago());
    informacionPagoStep.ingresarInformacionPago(lineaReserva, tipoPago, pagoSiniestro.getLstPago());
    instruccionPagoStep.finalizarCreacionPago(pagoSiniestro.getLstPago(), lineaReserva);
  }

  @Cuando(
      "^se genere un pago por siniestro de auto (.*) al beneficiario (.*) por el medio de pago de (.*) sobre las líneas de reserva (.*) y (.*) afectando la cobertura de (.*) es Sura con una retención de (.*)$")
  public void crearMultiPago(
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String lineaReserva,
      String lineaReserva2,
      String aplicaSoloSura)
      throws IOException {
    nuevoPagoStep.consultarPlacaAsegurado();
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            obtenerDatosPrueba(
                PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO.getValor(),
                EXPOSICION_VEHICULAR_TERCERO.getValor()));
    nuevoPagoStep.crearExposicionVehicularManual(
        obtenerDatosPrueba(
            PARAMETROS_NAVEGACION_MENU_ACCIONES.getValor(), EXPOSICION_MANUAL_VEHICULAR.getValor()),
        exposicionVehiculoTercero.getLstExposicionTerceros());
    nuevoPagoStep.seleccionarExposicionVehicularAsegurado();
    nuevoPagoStep.declararReclamacionPerdidaTotal();
    nuevoPagoStep.ingresarEstadoLegalReclamacion();
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(
                PAGO_SINIESTRO.getValor(),
                Serenity.sessionVariableCalled(SESION_CC_TIPO_COBERTURA_AFECTADA.getValor()))));
    nuevoPagoStep.crearNuevoPago();
    informacionBeneficiarioPagoStep.ingresarInformacionBeneficiarioPago(
        beneficiarioPago, metodoPago, aplicaSoloSura, pagoSiniestro.getLstPago());
    informacionPagoStep.ingresarInformacionPago(lineaReserva, tipoPago, pagoSiniestro.getLstPago());
    nuevoPagoStep.agregarPagoNuevaLineaReserva();
    informacionPagoStep.ingresarInformacionPago(
        lineaReserva2, tipoPago, pagoSiniestro.getLstPago());
    instruccionPagoStep.finalizarCreacionPago(pagoSiniestro.getLstPago(), lineaReserva);
  }

  @Entonces("^se genera una orden de pago para que le sea entregado al usuario$")
  public void verificarPago() {
    instruccionPagoStep.verificarPagoRealizado(pagoSiniestro.getLstPago());
  }

  @Cuando("^(.*)se notifique el proceso al área de auditoría$")
  public void notificarProcesoAuditoria(String requiereAuditoria) {
    nuevoPagoStep.consultarNumeroReclamacion();
    inclusionProcesoAuditoriaStep.marcarAuditoria(requiereAuditoria);
  }

  @Y("^se declara la reclamación como perdida total$")
  public void declararReclamacionPerdidaTotal() {
    nuevoPagoStep.declararReclamacionPerdidaTotal();
    nuevoPagoStep.ingresarEstadoLegalReclamacion();
  }

  @Cuando(
      "^se realiza un pago (.*) al beneficiario (.*) por el medio de pago de (.*) sobre la línea de reserva (.*) con cobertura de  (.*) donde el responsable (.*) es Sura$")
  public void ingresarPagoReclamacion(
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String lineaReserva,
      String cobertura,
      String aplicaSoloSura)
      throws IOException {
    pagoSiniestro =
        new PagoSiniestro(
            (obtenerDatosPrueba(String.valueOf(PAGO_SINIESTRO.getValor()), cobertura)));
    nuevoPagoStep.crearNuevoPago();
    informacionBeneficiarioPagoStep.ingresarInformacionBeneficiarioPago(
        beneficiarioPago, metodoPago, aplicaSoloSura, pagoSiniestro.getLstPago());
    informacionPagoStep.ingresarInformacionPago(lineaReserva, tipoPago, pagoSiniestro.getLstPago());
  }

  @Cuando("^se apliquen las siguientes retenciones$")
  public void aplicarRetencion(DataTable codigoRetencion) {
    List<String> retencion = codigoRetencion.asList(String.class);
    informacionPagoStep.ingresarInformacionRetencion(
        retencion, Serenity.sessionVariableCalled(SESION_CC_TIPO_PAGO.getValor()));
    instruccionPagoStep.finalizarCreacionPago(
        pagoSiniestro.getLstPago(),
        Serenity.sessionVariableCalled(SESION_CC_LINEA_RESERVA.getValor()));
  }
}
