package com.sura.reclamaciones.definitions.comunes;

import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.PartesImplicadasPage;
import java.io.IOException;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class ValidacionSarlaftStep {

  @Page PartesImplicadasPage partesImplicadasPage;

  @Step
  public void validarSarlaft(String beneficiarioPago) throws IOException {
    boolean sarlaftValidado = false;
    sarlaftValidado = partesImplicadasPage.validarEstadoSarlaft(beneficiarioPago);
    if (!sarlaftValidado) {
      completarDatosContacto();
      partesImplicadasPage.validarSarlaft();
    }
  }

  @Step
  public void completarDatosContacto() throws IOException {
    partesImplicadasPage.completarDatosBeneficiario();
  }
}
