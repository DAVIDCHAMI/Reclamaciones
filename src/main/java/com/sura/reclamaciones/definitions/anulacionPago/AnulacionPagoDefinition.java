package com.sura.reclamaciones.definitions.anulacionPago;

import com.sura.reclamaciones.models.AnulacionPagoEmpresarial;
import com.sura.reclamaciones.steps.anulacionPago.AnulacionPagoStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class AnulacionPagoDefinition {

  @Steps GenericStep genericStep;
  @Steps AnulacionPagoStep anulacionPagoStep;

  AnulacionPagoEmpresarial anulacionPagoEmpresarial;

  @Dado("^Un siniestro de una poliza empresarial con producto (.*)$")
  public void ingresarPagos(String tipoProducto) throws Throwable {
    anulacionPagoEmpresarial =
        new AnulacionPagoEmpresarial(genericStep.getFilasModelo("anulacion_pago", tipoProducto));
    anulacionPagoStep.consultarNumeroReclamacion(
        anulacionPagoEmpresarial.getLstAnulacionPagoEmpresarialPago());
  }

  @Cuando("^se realice una transaccion de Anulación de pago$")
  public void realizarAnulacionPago() {
    anulacionPagoStep.ingresarPagoAnular(
        anulacionPagoEmpresarial.getLstAnulacionPagoEmpresarialPago());
  }

  @Entonces("^se debe obtener un estado de tipo (.*)$")
  public void seDebeObtenerUnEstadoDeTipoTipoEstado(String strTipoEstado) {
    anulacionPagoStep.verificarAnulacionRealizada(
        strTipoEstado, anulacionPagoEmpresarial.getLstAnulacionPagoEmpresarialPago());
  }
}
