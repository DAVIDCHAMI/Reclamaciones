package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.pages.generics.NuevaReclamacionGuardadaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class NuevaReclamacionGuardadaStep {

  @Page NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;

  @Step
  public void obtenerNumeroReclamacionGuardada() {
    nuevaReclamacionGuardadaPage.obtenerNumeroReclamacion();
  }

  public void abrirNuevaReclamacionGuardada() {
    nuevaReclamacionGuardadaPage.abrirReclamacion();
  }
}
