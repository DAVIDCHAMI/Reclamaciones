package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_MANUAL_VEHICULAR;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_VEHICULAR_TERCERO;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_NAVEGACION_MENU_ACCIONES;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_COBERTURA_AFECTADA;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.generics.MenuClaimsStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.utils.VariablesSesion;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PagoSiniestroDefinition {

  PagoSiniestro pagoSiniestro;
  ExposicionVehiculoTercero exposicionVehiculoTercero = new ExposicionVehiculoTercero();

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps GenericStep genericStep;

  @Steps MenuClaimsStep menuClaimsStep;

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
      String aplicaSoloSura,
      String codigoRetencion)
      throws IOException {
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(String.valueOf(PAGO_SINIESTRO.getValor()), cobertura)));
    nuevoPagoStep.crearNuevoPago ();
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(
        beneficiarioPago, metodoPago, aplicaSoloSura, pagoSiniestro.getLstPago());
    nuevoPagoStep.ingresarInformacionPago(
        lineaReserva, tipoPago, codigoRetencion, pagoSiniestro.getLstPago());
    nuevoPagoStep.ingresarInstruccionesPago(lineaReserva, pagoSiniestro.getLstPago());
  }

  @Cuando(
      "^se genere un pago (.*) al beneficiario (.*) por el medio de pago de (.*) sobre la linea de reserva (.*) donde el responsable (.*) es Sura con una retención de (.*)$")
  public void crearPago(
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String lineaReserva,
      String aplicaSoloSura,
      String codigoRetencion)
      throws IOException {
    menuClaimsStep.consultarNumeroReclamacion(
        Serenity.sessionVariableCalled(VariablesSesion.SESION_CC_NUMERO_SINIESTRO.getValor()));
    nuevoPagoStep.seleccionarExposicionVehicularAsegurado();
    nuevoPagoStep.declararReclamacionPerdidaTotal();
    nuevoPagoStep.ingresarEstadoLegalReclamacion();
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(
                PAGO_SINIESTRO.getValor(),
                Serenity.sessionVariableCalled(SESION_CC_TIPO_COBERTURA_AFECTADA.getValor()))));
    nuevoPagoStep.crearNuevoPago ();
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(
        beneficiarioPago, metodoPago, aplicaSoloSura, pagoSiniestro.getLstPago());
    nuevoPagoStep.ingresarInformacionPago(
        lineaReserva, tipoPago, codigoRetencion, pagoSiniestro.getLstPago());
    nuevoPagoStep.ingresarInstruccionesPago(lineaReserva, pagoSiniestro.getLstPago());
  }

  @Cuando(
      "^se genere un pago por siniestro de auto (.*) al beneficiario (.*) por el medio de pago de (.*) sobre las lineas de reserva (.*) y (.*) afectando la cobertura de (.*) es Sura con una retención de (.*)$")
  public void crearMultiPago(
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String lineaReserva,
      String lineaReserva2,
      String aplicaSoloSura,
      String codigoRetencion)
      throws IOException {
    menuClaimsStep.consultarNumeroReclamacion(
        Serenity.sessionVariableCalled(VariablesSesion.SESION_CC_NUMERO_SINIESTRO.getValor()));
    nuevoPagoStep.consultarPlacaAsegurado();
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(
                PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO.getValor(),
                EXPOSICION_VEHICULAR_TERCERO.getValor()));
    nuevoPagoStep.crearExposicionVehicularManual(
        genericStep.getFilasModelo(
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
    nuevoPagoStep.crearNuevoPago ();
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(
        beneficiarioPago, metodoPago, aplicaSoloSura, pagoSiniestro.getLstPago());
    nuevoPagoStep.ingresarInformacionPago(
        lineaReserva, tipoPago, codigoRetencion, pagoSiniestro.getLstPago());
    nuevoPagoStep.agregarPagoNuevaLineaReserva();
    nuevoPagoStep.ingresarInformacionPago(
        lineaReserva2, tipoPago, codigoRetencion, pagoSiniestro.getLstPago());
    nuevoPagoStep.ingresarInstruccionesPago(lineaReserva, pagoSiniestro.getLstPago());
  }

  @Entonces("^se genera una orden de pago para que le sea entregado al usuario$")
  public void verificarPago() {
    nuevoPagoStep.verificarPagoRealizado(pagoSiniestro.getLstPago());
  }
}
