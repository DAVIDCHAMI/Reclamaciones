package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.notificacionaviso.PropiedadesImplicadasPage;
import org.fluentlenium.core.annotation.Page;

public class PropiedadesImplicadasStep {

  @Page PropiedadesImplicadasPage propiedadesImplicadasPage;

  public void seleccionarPropiedadImplicada() {
    propiedadesImplicadasPage.seleccionarPropiedad();
  }
}
