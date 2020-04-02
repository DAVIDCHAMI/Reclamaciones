package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.DetalleSiniestroPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.utils.constantes.MenuConstante;
import org.fluentlenium.core.annotation.Page;

public class DetalleSiniestroStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleSiniestroPage detalleSiniestroPage;

  public void consultarInformacionSiniestro() {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(MenuConstante.DETALLES_SINIESTRO);
    detalleSiniestroPage.obtenerNumeroPlacaPartesImplicadas();
  }
}
