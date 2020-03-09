package com.sura.reclamaciones.steps.guidewire.claimscenter;

import com.sura.reclamaciones.pages.guidewire.claimscenter.PropiedadesImplicadasPage;
import org.fluentlenium.core.annotation.Page;

public class PropiedadesImplicadasStep {

  @Page PropiedadesImplicadasPage propiedadesImplicadasPage;

  public void seleccionarPropiedadImplicada() {
    propiedadesImplicadasPage.seleccionarPropiedad();
  }
}
