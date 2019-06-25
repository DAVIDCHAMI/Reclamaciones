package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagomasivo.CargaArchivoPagoMasivoPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class CargaArchivoPagoMasivoStep {
  @Page MenuClaimPage menuClaimPage;

  @Page
  CargaArchivoPagoMasivoPage cargaArchivoPagoMasivoStep;

  @Step
  public void cargarArchivoXls(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivelEscritorio(nombreOpcion, subItem);
    cargaArchivoPagoMasivoStep.generarFacturacionMasiva();
    cargaArchivoPagoMasivoStep.seleccionarArchivoXls();
  }
}
