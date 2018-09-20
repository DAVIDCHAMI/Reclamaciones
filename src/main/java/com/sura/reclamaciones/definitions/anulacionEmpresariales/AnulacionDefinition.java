package com.sura.reclamaciones.definitions.anulacionEmpresariales;

import com.sura.reclamaciones.models.AnulacionEmpresarial;
import com.sura.reclamaciones.steps.anulacionPago.AnulacionPagoStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class AnulacionDefinition {

  @Steps GenericStep genericStep;
  @Steps AnulacionPagoStep anulacionPagoStep;

  AnulacionEmpresarial anulacionEmpresarial;

  @Dado("^Un siniestro de una poliza empresarial con producto (.*)$")
  public void ingresarPagos(String tipoProducto) throws Throwable {
    anulacionEmpresarial =
        new AnulacionEmpresarial(genericStep.getFilasModelo("anulacion_empresarial", tipoProducto));
    anulacionPagoStep.consultarNumeroReclamacion(
            anulacionEmpresarial.getLstAnulacionEmpresarial());
  }

  @Y("^conociendo que se debe realizar una anulacion de (.*)$")
  public void ingresarMenuLateral(String tipoProducto) throws Throwable {
  }

  @Cuando("^se realice una transaccion de (.*) sobre un pago asociado$")
  public void realizarAnulacionPago() {
    anulacionPagoStep.ingresarPagoAnular(
        anulacionEmpresarial.getLstAnulacionEmpresarial());
  }

  @Entonces("^se debe obtener un estado de tipo (.*)$")
  public void seDebeObtenerUnEstadoDeTipoTipoEstado(String strTipoEstado) {
    anulacionPagoStep.verificarAnulacionRealizada(
        strTipoEstado, anulacionEmpresarial.getLstAnulacionEmpresarial());
  }


  @Y("^conociendo que se debe realizar una anulacion de (.*)$")
  public void conociendoQueSeDebeRealizarUnaAnulacionDeTipoTransaccion() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
}
