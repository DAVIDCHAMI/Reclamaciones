package com.sura.reclamaciones.definitions.comunes;

import com.sura.reclamaciones.steps.guidewire.claimscenter.CambiarIdiomaStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class CambiarIdiomaDefinition {

  @Steps CambiarIdiomaStep cambiarIdiomaStep;

  @Cuando("cambie el idioma a us")
  public void cambiarIdioma() {
    cambiarIdiomaStep.seleccionarIdioma();
  }

  @Entonces("el idioma de reclamaciones debe ser us")
  public void verPantallaIdiomaDiferente() {
    cambiarIdiomaStep.comprobarTextoPantalla();
  }
}
