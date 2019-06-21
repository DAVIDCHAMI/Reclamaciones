package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagomasivo.CargaArchivoXlsPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class CargaArchivoXlsStep {
  @Page MenuClaimPage menuClaimPage;

  @Page CargaArchivoXlsPage cargaArchivoXlsStep;

  @Step
  public void cargarArchivoXls(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivelEscritorio(nombreOpcion, subItem);
    cargaArchivoXlsStep.generarFacturacionMasiva();
    cargaArchivoXlsStep.seleccionarArchivoXls();
  }
}
