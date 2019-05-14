package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class MenuClaimsStep {

  @Page MenuClaimPage menuClaimPage;

  @Step
  public void consultarNumeroReclamacion(String numReclamacion) {
    menuClaimPage.buscarReclamacion(MenuConstante.RECLAMACION_MENU, numReclamacion);
  }
}
