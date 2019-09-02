package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.pages.generics.NuevaReclamacionGuardadaPage;
import org.fluentlenium.core.annotation.Page;

public class NuevaReclamacionGuardadaStep {

  @Page NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;

  public void obtenerNumeroReclamacionGuardada() {
    nuevaReclamacionGuardadaPage.obtenerNumeroReclamacion();
  }
}
