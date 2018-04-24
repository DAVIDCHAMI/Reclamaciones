package com.sura.reclamaciones.steps.smocktest;

import com.sura.reclamaciones.pages.smocktest.CambiarIdiomaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class CambiarIdiomaStep {

  @Page CambiarIdiomaPage cambiarIdiomaPage;

  @Step
  public void seleccionarIdioma() {
    cambiarIdiomaPage.cliquearBtnConfiguraciones();
    cambiarIdiomaPage.cliquearLinkInternacional();
    cambiarIdiomaPage.cliquearLinkIdioma();
    cambiarIdiomaPage.cliquearlinkIngles();
  }

  @Step
  public void comprobarTextoPantalla() {
    cambiarIdiomaPage.comprobarTextoPantalla();
  }
}
