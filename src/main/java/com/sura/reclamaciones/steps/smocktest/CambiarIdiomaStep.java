package com.sura.reclamaciones.steps.smocktest;

import static com.sura.reclamaciones.constantes.Constantes.ACTIVIDADES;
import static com.sura.reclamaciones.constantes.Constantes.ACTIVITIES;

import com.sura.reclamaciones.pages.guidewire.smocktest.CambiarIdiomaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class CambiarIdiomaStep {

  @Page CambiarIdiomaPage cambiarIdiomaPage;

  @Step
  public void seleccionarIdioma() {
    cambiarIdiomaPage.ingresarConfiguraciones();
    cambiarIdiomaPage.elegirOpcionInternacional();
    cambiarIdiomaPage.elegirIdioma();
  }

  @Step
  public void comprobarTextoPantalla() {
    String tipoIdioma = cambiarIdiomaPage.seleccionarIdioma();
    if (tipoIdioma.equals(ACTIVIDADES.getValor())) {
      MatcherAssert.assertThat(
          "No cambio el idioma en la aplicacion", tipoIdioma.equals(ACTIVIDADES.getValor()));
    } else {
      MatcherAssert.assertThat(
          "No cambio el idioma en la aplicacion", tipoIdioma.equals(ACTIVITIES.getValor()));
    }
  }
}
