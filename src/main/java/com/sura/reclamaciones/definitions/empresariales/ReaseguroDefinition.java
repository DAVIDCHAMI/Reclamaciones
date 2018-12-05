package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.utils.Constantes.NUMERO_SINIESTRO;
import static com.sura.reclamaciones.utils.Variables.TIPO_CONTRATO_POLIZA;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.models.Reasegurador;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionSiniestroStep;
import com.sura.reclamaciones.steps.reaseguro.ReaseguroStep;
import com.sura.reclamaciones.utils.Constantes;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;

public class ReaseguroDefinition {

  private Contrato contrato1;
  private Reasegurador reasegurador1, reasegurador2, reasegurador3;
  private String numeroReclamacion;

  @Steps ReaseguroStep reaseguroStep;

  @Steps GenericStep genericStep;

  @Steps ConsumoServicioCreacionSiniestroStep creacionSiniestro;

  @Page MenuClaimPage menuClaimPage;

  @Cuando(
      "^se genere una reclamacion de un contrato tipo (.*), por causal (.*) con un valor de pretension de (.*) e incidente de tipo (.*)$")
  public void generarReserva(
      String tipoContratoPoliza, String causa, String valorPretension, String tipoIncidente)
      throws IOException {
    Serenity.setSessionVariable(TIPO_CONTRATO_POLIZA).to(tipoContratoPoliza);
    creacionSiniestro.asignarValoresSiniestro(tipoContratoPoliza);
    creacionSiniestro.siniestrarPolizaEmpresarialAtr();
    numeroReclamacion = Serenity.sessionVariableCalled(NUMERO_SINIESTRO.getValor());
    menuClaimPage.buscarReclamacion(Constantes.RECLAMACION_MENU.getValor(), numeroReclamacion);
  }

  @Entonces(
      "^para la transaccion (.*) se distribuye el reaseguro por cada contrato (.*) (.*) (.*) y cada uno de los reaseguradores")
  public void verificarReaseguro(
      String tipoTransaccion, String tipoContrato1, String tipoContrato2, String tipoContrato3)
      throws IOException {
    contrato1 =
        new Contrato(
            genericStep.getFilasModelo(
                "contrato", Serenity.sessionVariableCalled(TIPO_CONTRATO_POLIZA)));
    reasegurador1 = new Reasegurador(genericStep.getFilasModelo("reasegurador", tipoContrato1));
    reasegurador2 = new Reasegurador(genericStep.getFilasModelo("reasegurador", tipoContrato2));
    reasegurador3 = new Reasegurador(genericStep.getFilasModelo("reasegurador", tipoContrato3));
    reaseguroStep.verificarReaseguro(
        contrato1.getLstContrato(),
        reasegurador1.getLstReasegurador(),
        reasegurador2.getLstReasegurador(),
        reasegurador3.getLstReasegurador());
  }
}
