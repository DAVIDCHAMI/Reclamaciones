package com.sura.reclamaciones.steps.guidewire.claimscenter.autos;

import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.FacturaVolumenPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class FacturaVolumenStep {

  @Page MenuClaimPage menuClaimPage;

  @Page FacturaVolumenPage facturaVolumenPage;

  @Step
  public void buscarNumeroFacturaPagoMasivo(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(nombreOpcion, subItem);
    facturaVolumenPage.obtenerUltimaPagina();
    facturaVolumenPage.buscarNumeroFacturaPagoMasivo();
  }
}
