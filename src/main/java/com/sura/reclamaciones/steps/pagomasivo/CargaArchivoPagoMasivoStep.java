package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagomasivo.CargaArchivoPagoMasivoPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class CargaArchivoPagoMasivoStep {

  @Page MenuClaimPage menuClaimPage;

  @Page CargaArchivoPagoMasivoPage cargaArchivoPagoMasivoStep;

  @Page GeneralPage generalPage;

  @Step
  public void ingresarOpcionPagoMasivo(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(nombreOpcion, subItem);
    cargaArchivoPagoMasivoStep.generarFacturacionMasiva();
    generalPage.continuarSiguientePantalla();
  }
}
