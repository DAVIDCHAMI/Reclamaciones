package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class PagoSiniestroDefinition {

  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps GenericStep genericStep;

  PagoSiniestro pagoSiniestro;

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
    nuevoPagoStep.crearNuevoPago();
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(String.valueOf(PAGO_SINIESTRO.getValor()), cobertura)));
    nuevoPagoStep.ingresarInformacionPago(
        beneficiarioPago,
        metodoPago,
        aplicaSoloSura,
        lineaReserva,
        tipoPago,
        codigoRetencion,
        pagoSiniestro.getLstPago());
  }

  @Entonces("^se genera una orden de pago para que le sea entregado al usuario$")
  public void verificarPago() {
    nuevoPagoStep.verificarPagoRealizado(pagoSiniestro.getLstPago());
  }

  @Cuando("^(.*)se notifique el proceso de auditoria al area de auditoria$")
  public void notificarProcesoAuditoria() throws IOException {
    //ToDo
  }

  @Entonces("^(.*) se debe generar factura de pago al asegurado$")
  public void verificarFacturaAsegurado() throws IOException {
    //ToDO
  }
}
