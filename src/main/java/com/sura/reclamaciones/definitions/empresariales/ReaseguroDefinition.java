package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.models.Reasegurador;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionSiniestroStep;
import com.sura.reclamaciones.steps.reaseguro.ReaseguroStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ReaseguroDefinition {

  private String tipoContrato;

  @Steps ReaseguroStep reaseguroStep;

  @Steps GenericStep genericStep;

  @Steps ConsumoServicioCreacionSiniestroStep creacionSiniestro;

  @Cuando(
      "^se genere una reclamacion de un contrato tipo (.*), por causal (.*) con un valor de pretension de (.*) e incidente de tipo (.*)$")
  public void crearSiniestro(
      String tipoContratoPoliza, String causa, String valorPretension, String tipoIncidente)
      throws IOException {
    tipoContrato = tipoContratoPoliza;
    creacionSiniestro.asignarValoresSiniestro(tipoContratoPoliza);
    creacionSiniestro.siniestrarPolizaEmpresarialAtr();
    reaseguroStep.buscarReclamacion();
  }

  @Entonces(
      "^para la transaccion (.*) se distribuye el reaseguro por cada contrato (.*) (.*) (.*) y cada uno de los reaseguradores")
  public void verificarReaseguro(
      String tipoTransaccion, String tipoContrato1, String tipoContrato2, String tipoContrato3)
      throws IOException {
    Contrato contrato1 = new Contrato(genericStep.getFilasModelo("contrato", tipoContrato));
    Reasegurador reasegurador1 =
        new Reasegurador(genericStep.getFilasModelo("reasegurador", tipoContrato1));
    Reasegurador reasegurador2 =
        new Reasegurador(genericStep.getFilasModelo("reasegurador", tipoContrato2));
    Reasegurador reasegurador3 =
        new Reasegurador(genericStep.getFilasModelo("reasegurador", tipoContrato3));
    reaseguroStep.verificarReaseguro(
        contrato1.getLstContrato(),
        reasegurador1.getLstReasegurador(),
        reasegurador2.getLstReasegurador(),
        reasegurador3.getLstReasegurador());
  }
}
