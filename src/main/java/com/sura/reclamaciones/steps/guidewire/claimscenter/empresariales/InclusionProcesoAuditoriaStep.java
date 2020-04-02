package com.sura.reclamaciones.steps.guidewire.claimscenter.empresariales;

import com.sura.reclamaciones.pages.guidewire.claimscenter.empresariales.AuditoriaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class InclusionProcesoAuditoriaStep {

  private @Page AuditoriaPage editarAuditoriaPage;

  @Step
  public void marcarAuditoria(String auditoria) {
    editarAuditoriaPage.seleccionarDetalleInvestigacionAuditoria();
    editarAuditoriaPage.verificarMarcacion(auditoria);
  }
}
