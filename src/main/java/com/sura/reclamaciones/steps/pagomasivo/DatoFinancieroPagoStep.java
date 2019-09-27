package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.NuevaReclamacionGuardadaPage;
import com.sura.reclamaciones.pages.pagomasivo.DatoFinancieroPagoPage;
import org.fluentlenium.core.annotation.Page;

public class DatoFinancieroPagoStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DatoFinancieroPagoPage datosFinancierosPage;

  @Page NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;

  public MenuClaimPage getMenuClaimPage() {
    return menuClaimPage;
  }

  public void validarPagosIndividuales(String numReclamacion, String nombreOpcion, String subItem) {
    menuClaimPage.buscarReclamacion(MenuConstante.RECLAMACION_MENU, numReclamacion);
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(nombreOpcion, subItem);
    datosFinancierosPage.validarPagosIndividualesSiniestro();
  }
}
