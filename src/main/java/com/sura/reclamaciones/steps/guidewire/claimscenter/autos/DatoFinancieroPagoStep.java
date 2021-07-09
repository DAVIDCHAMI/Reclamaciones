package com.sura.reclamaciones.steps.guidewire.claimscenter.autos;

import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.DatoFinancieroPagoPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import org.fluentlenium.core.annotation.Page;

public class DatoFinancieroPagoStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DatoFinancieroPagoPage datosFinancierosPage;

  public MenuClaimPage getMenuClaimPage() {
    return menuClaimPage;
  }

  public void validarPagosIndividuales(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(nombreOpcion, subItem);
    datosFinancierosPage.validarPagosIndividualesSiniestro();
  }
}
