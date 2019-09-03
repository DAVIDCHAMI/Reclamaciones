package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagomasivo.CargaArchivoPagoMasivoPage;
import com.sura.reclamaciones.utils.LlenadoArchivoXLS;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.io.File;

public class CargaArchivoPagoMasivoStep {


  LlenadoArchivoXLS llenadoArchivoXLS = new LlenadoArchivoXLS();
  String nombreArchivoPagoMasivo= "PlantillaPagosMasivos.xlsx";
  File resourcesDirectory = new File("src/test/resources/files");

  String rutaCompleta = resourcesDirectory.getAbsolutePath()+"\\"+nombreArchivoPagoMasivo;

  @Page MenuClaimPage menuClaimPage;

  @Page CargaArchivoPagoMasivoPage cargaArchivoPagoMasivoPage;

  @Page GeneralPage generalPage;

  @Step
  public void cargarArchivoXls(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(nombreOpcion, subItem);
    cargaArchivoPagoMasivoPage.generarFacturacionMasiva();
    //llenadoArchivoXLS.LlenarArchivoXls(rutaCompleta);
    //cargaArchivoPagoMasivoPage.buscarArchivoPagoMasivo(rutaCompleta);
    generalPage.continuarSiguientePantalla();
  }
}
