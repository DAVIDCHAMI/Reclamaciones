package com.sura.reclamaciones.steps.procesoauditoria;

import com.sura.reclamaciones.pages.procesoauditoria.AuditoriaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class ProcesoAuditoriaStep {

  @Page AuditoriaPage editarAuditoriaPage;

  @Step
  public void marcarAuditoria(String auditoria) {
    editarAuditoriaPage.seleccionarDetalleInvestigacionAuditoria();
    editarAuditoriaPage.verificarMarcacion(auditoria);
  }
}
