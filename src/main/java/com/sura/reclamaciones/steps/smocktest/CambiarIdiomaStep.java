package com.sura.reclamaciones.steps.smocktest;

import com.sura.reclamaciones.pages.smocktest.CambiarIdiomaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class CambiarIdiomaStep {

  @Page CambiarIdiomaPage cambiarIdiomaPage;

  @Step
  public void seleccionarIdioma() {
    cambiarIdiomaPage.cliquearBtnConfiguraciones();
    cambiarIdiomaPage.cliquearLinkInternacional();
    cambiarIdiomaPage.cliquearLinkIdioma();
  }

  @Step
  public void comprobarTextoPantalla() {
    String tipoIdioma = cambiarIdiomaPage.seleccionarIdioma();
    MatcherAssert.assertThat("No cambio el idioma en la aplicacion",tipoIdioma.equals("Actividades") || tipoIdioma.equals("Activities"));
  }
}
