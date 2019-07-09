package com.sura.reclamaciones.steps.primapendiente;

import static com.sura.reclamaciones.constantes.MenuConstante.POLIZA;

import com.sura.reclamaciones.pages.autos.reclamacion.PolizaGeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class PrimaPendienteStep {

  @Page
  PolizaGeneralPage polizaGeneralPage;

  @Page
  MenuClaimPage menuClaimPage;

  public void verificarEstadoPrimaPendiente() {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(POLIZA);
    MatcherAssert.assertThat(
        "No tiene prima pendiente",
    polizaGeneralPage.verificarEstadoPrimaPendiente());
  }
}
