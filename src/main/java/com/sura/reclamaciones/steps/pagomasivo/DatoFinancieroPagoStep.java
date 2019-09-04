package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagomasivo.DatoFinancieroPagoPage;
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
