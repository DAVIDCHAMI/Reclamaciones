package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.steps.ResultadoArchivoProcesadoStep;
import com.sura.reclamaciones.steps.generics.DetalleSiniestroStep;
import com.sura.reclamaciones.steps.pagomasivo.BusquedaLibretaContactoStep;
import com.sura.reclamaciones.steps.pagomasivo.CargaArchivoPagoMasivoStep;
import com.sura.reclamaciones.steps.pagomasivo.DetalleFacturaVolumenStep;
import com.sura.reclamaciones.steps.pagomasivo.ResultadoValidacionArchivoStep;
import cucumber.api.java.es.Cuando;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition {
  @Steps CargaArchivoPagoMasivoStep cargaArchivoPagoMasivoStep;

  @Steps ResultadoValidacionArchivoStep resultadoValidacionArchivoStep;

  @Steps DetalleSiniestroStep detalleSiniestroStep;

  @Steps ResultadoArchivoProcesadoStep resultadoArchivoProcesadoStep;

  @Steps DetalleFacturaVolumenStep detalleFacturaVolumenStep;

  @Steps BusquedaLibretaContactoStep busquedaLibretaContactoStep;

  @Cuando("^se ingresa la información en el archivo de Excel para realizar pagos masivos a un mismo proveedor")
  public void crearPagoMasivo()
  {
    detalleSiniestroStep.consultarInformacionSiniestro();
  }

  @Cuando("^se carga el archivo de Excel para realizar el pago masivo a el proveedor")
  public void cargarArchivoExcelPagoMasivo()
  {
    cargaArchivoPagoMasivoStep.cargarArchivoXls(MenuConstante.ESCRITORIO_MENU, MenuConstante.FACTURAS_VOLUMEN_MENU);
    resultadoValidacionArchivoStep.validarNumeroRegistrosArchivo();
    resultadoArchivoProcesadoStep.consultarResultadoArchivoProcesado();
  }

  @Cuando("^se ingresa el tipo de proveedor (.*) y el nombre del proveedor (.*) con el tipo de moneda (.*) de la factura y el método de pago (.*) del cheque")
  public void ingresarInformacionFactura(String tipoProveedor, String proveedor, String tipoMoneda, String metodoPago)
  {
    detalleFacturaVolumenStep.ingresarInformacionFactura(tipoMoneda, metodoPago);
    detalleFacturaVolumenStep.buscarBeneficiarioPago();


  }






}
