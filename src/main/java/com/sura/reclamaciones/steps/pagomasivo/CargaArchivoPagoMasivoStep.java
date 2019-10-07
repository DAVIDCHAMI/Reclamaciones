package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.models.Exposicion;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagomasivo.CargaArchivoPagoMasivoPage;
import com.sura.reclamaciones.utils.LlenadoArchivoExcel;
import java.io.File;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class CargaArchivoPagoMasivoStep {

  LlenadoArchivoExcel llenadoArchivoXLS = new LlenadoArchivoExcel();
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
    llenadoArchivoXLS.llenarArchivoExcel(
        rutaArchivoPagoMasivo,
        datosExposicionPagoMasivo,
        datosReservaPagoMasivo,
        datosPagoSiniestroPagoMasivo);
    cargaArchivoPagoMasivoPage.buscarArchivoPagoMasivo(rutaArchivoPagoMasivo);
    generalPage.continuarSiguientePantalla();
  }
}
