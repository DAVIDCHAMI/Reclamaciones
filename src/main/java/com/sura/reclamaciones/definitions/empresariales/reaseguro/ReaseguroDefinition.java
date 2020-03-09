package com.sura.reclamaciones.definitions.empresariales.reaseguro;

import static com.sura.reclamaciones.constantes.Constantes.RESERVA;
import static com.sura.reclamaciones.constantes.NombresCsv.CONTRATO;
import static com.sura.reclamaciones.constantes.NombresCsv.RECUPERO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.guidewire.claimscenter.GenericStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.NuevaReclamacionGuardadaStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.ReaseguroStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.RecuperoStep;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ReaseguroDefinition {

  private String strTipoContrato =
      Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor());

  @Steps ReaseguroStep reaseguroStep;

  @Steps GenericStep genericStep;

  @Steps RecuperoStep recuperoStep;

  @Steps NuevaReclamacionGuardadaStep nuevaReclamacionGuardadaStep;

  @Y("^se realice al siniestro un recupero con un código de retención (.*)$")
  public void realizarRecuperoSiniestroEmpresarial(String strCodigoRetencionRecupero)
      throws IOException {
    Recupero recupero =
        new Recupero(genericStep.getFilasModelo(RECUPERO_SINIESTRO.getValor(), strTipoContrato));
    recuperoStep.diligenciarCreacionRecupero(recupero.getLstRecupero(), strCodigoRetencionRecupero);
  }

  @Entonces(
      "^para la transacción (.*) se distribuye el reaseguro según el retenido y el cedido de manera adecuada$")
  public void verificarReaseguro(String strTransaccion) throws IOException {
    if (strTransaccion.equals(RESERVA.getValor())) {
      nuevaReclamacionGuardadaStep.obtenerNumeroReclamacionGuardada();
    }
    Contrato contrato =
        new Contrato(genericStep.getFilasModelo(CONTRATO.getValor(), strTipoContrato));
    reaseguroStep.verificarReaseguro(contrato.getLstContrato(), strTransaccion);
  }
}
