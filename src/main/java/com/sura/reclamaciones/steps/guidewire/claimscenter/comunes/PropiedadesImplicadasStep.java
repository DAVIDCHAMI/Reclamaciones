package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.PropiedadesImplicadasPage;
import org.fluentlenium.core.annotation.Page;

public class PropiedadesImplicadasStep {

  @Page PropiedadesImplicadasPage propiedadesImplicadasPage;

  public void seleccionarPropiedadImplicada() {
    propiedadesImplicadasPage.seleccionarPropiedad();
  }
}
