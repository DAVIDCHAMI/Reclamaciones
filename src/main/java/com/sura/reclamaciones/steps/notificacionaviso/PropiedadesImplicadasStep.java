package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.notificacionaviso.PropiedadesImplicadasPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SeleccionarPropiedadesImplicadasStep {

  @Page PropiedadesImplicadasPage seleccionarPropiedadesImplicadasPage;

  @Step
  public void seleccionarPropiedadImplicada() { seleccionarPropiedadesImplicadasPage.seleccionarPropiedad();
  }
}
