package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.utils.constantes.MenuConstante;
import org.fluentlenium.core.annotation.Page;

public class MenuClaimsStep {

  @Page MenuClaimPage menuClaimPage;

  public void consultarNumeroReclamacion(String numReclamacion) {
    menuClaimPage.buscarReclamacion(MenuConstante.RECLAMACION_MENU, numReclamacion);
  }
}
