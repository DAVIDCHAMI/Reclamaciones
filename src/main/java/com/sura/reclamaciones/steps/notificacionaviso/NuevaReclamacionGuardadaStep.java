package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.autos.reclamacion.NuevaReclamacionGuardadaPage;
import org.fluentlenium.core.annotation.Page;

public class NuevaReclamacionGuardadaStep {

  @Page NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;

  public void abrirReclamacionGuardada() {
    nuevaReclamacionGuardadaPage.abrirReclamacion();
  }
}
