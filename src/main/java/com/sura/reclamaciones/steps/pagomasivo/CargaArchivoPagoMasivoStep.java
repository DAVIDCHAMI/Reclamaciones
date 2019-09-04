package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagomasivo.CargaArchivoPagoMasivoPage;
import java.io.File;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class CargaArchivoPagoMasivoStep {

  String nombreArchivoPagoMasivo = "PlantillaPagosMasivos.xlsx";

  File resourcesDirectory = new File("src/test/resources/files");

  String rutaArchivoPagoMasivo = resourcesDirectory.getAbsolutePath() + "\\" + nombreArchivoPagoMasivo;

  @Page MenuClaimPage menuClaimPage;

  @Page CargaArchivoPagoMasivoPage cargaArchivoPagoMasivoPage;

  @Page GeneralPage generalPage;

  @Step
  public void cargarArchivoXls(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(nombreOpcion, subItem);
    cargaArchivoPagoMasivoPage.generarFacturacionMasiva();
    cargaArchivoPagoMasivoPage.buscarArchivoPagoMasivo(rutaArchivoPagoMasivo);
    generalPage.continuarSiguientePantalla();
  }
}
