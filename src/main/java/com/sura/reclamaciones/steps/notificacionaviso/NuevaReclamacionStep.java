package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.notificacionaviso.NuevaReclamacionPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class NuevaReclamacionStep {

  @Page NuevaReclamacionPage NuevaReclamacionPage;

  @Step
  public void seleccionarNuevaReclamacion() {
    NuevaReclamacionPage.cliquearReclamacion();
  }
}
