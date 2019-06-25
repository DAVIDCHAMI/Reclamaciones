package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.steps.ResultadoArchivoProcesadoStep;
import com.sura.reclamaciones.steps.generics.DetalleSiniestroStep;
import com.sura.reclamaciones.steps.pagomasivo.CargaArchivoXlsStep;
import com.sura.reclamaciones.steps.pagomasivo.DetalleFacturaVolumenStep;
import com.sura.reclamaciones.steps.pagomasivo.ResultadoValidacionArchivoStep;
import cucumber.api.java.es.Cuando;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition {
  @Steps CargaArchivoXlsStep cargarArchivoXlsStep;

  @Steps ResultadoValidacionArchivoStep resultadoValidacionArchivoStep;

  @Steps DetalleSiniestroStep detalleSiniestroStep;

  @Steps ResultadoArchivoProcesadoStep resultadoArchivoProcesadoStep;

  @Steps DetalleFacturaVolumenStep detalleFacturaVolumenStep;

  @Cuando("^se crea uno o varios pagos a un mismo proveedor")
  public void crearPagoMasivo()
  {
    detalleSiniestroStep.consultarInformacionSiniestro();
    cargarArchivoXlsStep.cargarArchivoXls(MenuConstante.ESCRITORIO_MENU, MenuConstante.FACTURAS_VOLUMEN_MENU);
    resultadoValidacionArchivoStep.validarNumeroRegistrosArchivo();
    resultadoArchivoProcesadoStep.consultarResultadoArchivoProcesado();
    detalleFacturaVolumenStep.consultarBeneficiarioPago();
  }
}
