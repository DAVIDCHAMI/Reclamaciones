package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.NuevaReclamacionGuardadaPage;
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
