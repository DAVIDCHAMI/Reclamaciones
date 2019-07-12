package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagomasivo.FacturaVolumenPage;
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
