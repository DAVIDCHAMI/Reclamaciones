package com.sura.reclamaciones.definitions.empresariales.reaseguro;

import static com.sura.reclamaciones.utils.enums.Constantes.RESERVA;
import static com.sura.reclamaciones.utils.enums.NombresCsv.CONTRATO;
import static com.sura.reclamaciones.utils.enums.NombresCsv.RECUPERO_SINIESTRO;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.GenericStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.NuevaReclamacionGuardadaStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.RecuperoStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.empresariales.ReaseguroStep;
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
