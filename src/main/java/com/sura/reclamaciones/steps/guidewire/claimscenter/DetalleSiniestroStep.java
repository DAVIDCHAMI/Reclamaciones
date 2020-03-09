package com.sura.reclamaciones.steps.guidewire.claimscenter;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.general.DetalleSiniestroPage;
import com.sura.reclamaciones.pages.general.MenuClaimPage;
import org.fluentlenium.core.annotation.Page;

public class DetalleSiniestroStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleSiniestroPage detalleSiniestroPage;

  public void consultarInformacionSiniestro() {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(MenuConstante.DETALLES_SINIESTRO);
    detalleSiniestroPage.obtenerNumeroPlacaPartesImplicadas();
  }
}
