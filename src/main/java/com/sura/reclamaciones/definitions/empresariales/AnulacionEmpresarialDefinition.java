package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.models.AnulacionEmpresarial;
import com.sura.reclamaciones.steps.anulacionempresarial.AnulacionEmpresarialStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class AnulacionEmpresarialDefinition {

  @Steps GenericStep genericStep;
  @Steps AnulacionEmpresarialStep anulacionEmpresarialStep;

  AnulacionEmpresarial anulacionEmpresarial;

  @Dado(
      "^que se debe realizar una anulacion de (.*), de un siniestro de una poliza empresarial con producto (.*)$")
  public void ingresarVentanaAnulacion(String tipoTransaccion, String tipoProducto)
      throws IOException {
    anulacionEmpresarial =
        new AnulacionEmpresarial(genericStep.getFilasModelo("anulacion_empresarial", tipoProducto));
    anulacionEmpresarialStep.consultarNumeroReclamacion(
        anulacionEmpresarial.getLstAnulacionEmpresarial(), tipoTransaccion);
  }

  @Cuando("^se realice una transaccion de (.*) sobre un (.*) asociado$")
  public void realizarAnulacionPago(String tipoTransaccion, String tipoAnulacion) {
    anulacionEmpresarialStep.ingresarAnulacion(
        anulacionEmpresarial.getLstAnulacionEmpresarial(), tipoAnulacion);
  }

  @Entonces("^se debe obtener un estado de tipo (.*)$")
  public void seDebeObtenerUnEstadoDeTipoTipoEstado(String strTipoEstado) {
    anulacionEmpresarialStep.verificarAnulacionRealizada(
        strTipoEstado, anulacionEmpresarial.getLstAnulacionEmpresarial());
  }
}
