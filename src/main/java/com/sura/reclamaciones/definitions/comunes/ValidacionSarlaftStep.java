package com.sura.reclamaciones.definitions.comunes;

import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.PartesImplicadasPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class ValidacionSarlaftStep {

  @Page PartesImplicadasPage partesImplicadasPage;

  @Step
  public void validarSarlaft(String beneficiarioPago) {
    boolean sarlaftValidado = false;
    sarlaftValidado = partesImplicadasPage.validarEstadoSarlaft(beneficiarioPago);
    if (!sarlaftValidado) {
      partesImplicadasPage.validarSarlaft();
    }
  }
}
