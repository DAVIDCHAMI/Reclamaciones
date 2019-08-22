package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class FacturaVolumenStep {

  @Page MenuClaimPage menuClaimPage;

  @Step
  public void buscarNumeroFacturaPagoMasivo(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(nombreOpcion, subItem);
  }
}
