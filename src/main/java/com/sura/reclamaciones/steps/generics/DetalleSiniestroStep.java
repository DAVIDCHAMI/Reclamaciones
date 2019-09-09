package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.DetalleSiniestroPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import org.fluentlenium.core.annotation.Page;

public class DetalleSiniestroStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleSiniestroPage detalleSiniestroPage;

  public void consultarInformacionSiniestro() {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(MenuConstante.DETALLES_SINIESTRO);
    detalleSiniestroPage.obtenerPlacaAsegurado();
    detalleSiniestroPage.obtenerNumeroPlacaPartesImplicadas();
    detalleSiniestroPage.obtenerNumeroSiniestro();
  }
}
