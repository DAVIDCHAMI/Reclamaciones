package com.sura.reclamaciones.steps.guidewire.claimscenter.autos;

import com.sura.reclamaciones.models.Exposicion;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.autos.CargaArchivoPagoMasivoPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.utils.LlenadoArchivoXLS;
import java.io.File;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class CargaArchivoPagoMasivoStep {

  LlenadoArchivoXLS llenadoArchivoXLS = new LlenadoArchivoXLS();
  String nombreArchivoPagoMasivo = "PlantillaPagosMasivos.xlsx";
  File resourcesDirectory = new File("src/test/resources/files");

  String rutaArchivoPagoMasivo =
      resourcesDirectory.getAbsolutePath() + "\\" + nombreArchivoPagoMasivo;

  @Page MenuClaimPage menuClaimPage;
  @Page CargaArchivoPagoMasivoPage cargaArchivoPagoMasivoPage;
  @Page GeneralPage generalPage;

  @Step
  public void cargarArchivoXls(
      String nombreOpcion,
      String subItem,
      List<Exposicion> datosExposicionPagoMasivo,
      List<Reserva> datosReservaPagoMasivo,
      List<PagoSiniestro> datosPagoSiniestroPagoMasivo) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(nombreOpcion, subItem);
    cargaArchivoPagoMasivoPage.generarFacturacionMasiva();
    llenadoArchivoXLS.llenarArchivoXls(
        rutaArchivoPagoMasivo,
        datosExposicionPagoMasivo,
        datosReservaPagoMasivo,
        datosPagoSiniestroPagoMasivo);
    cargaArchivoPagoMasivoPage.buscarArchivoPagoMasivo(rutaArchivoPagoMasivo);
    generalPage.continuarSiguientePantalla();
  }
}
