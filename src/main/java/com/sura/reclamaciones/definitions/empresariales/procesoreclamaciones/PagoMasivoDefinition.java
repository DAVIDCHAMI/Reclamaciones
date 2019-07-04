package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.steps.generics.DetalleSiniestroStep;
import com.sura.reclamaciones.steps.pagomasivo.BusquedaLibretaContactoStep;
import com.sura.reclamaciones.steps.pagomasivo.CargaArchivoPagoMasivoStep;
import com.sura.reclamaciones.steps.pagomasivo.DetalleFacturaVolumenStep;
import com.sura.reclamaciones.steps.pagomasivo.ResultadoArchivoProcesadoStep;
import com.sura.reclamaciones.steps.pagomasivo.ResultadoValidacionArchivoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition {

  @Steps CargaArchivoPagoMasivoStep cargaArchivoPagoMasivoStep;

  @Steps ResultadoValidacionArchivoStep resultadoValidacionArchivoStep;

  @Steps DetalleSiniestroStep detalleSiniestroStep;

  @Steps ResultadoArchivoProcesadoStep resultadoArchivoProcesadoStep;

  @Steps DetalleFacturaVolumenStep detalleFacturaVolumenStep;

  @Steps BusquedaLibretaContactoStep busquedaLibretaContactoStep;

  @Cuando("^se registra la información de las facturas del pago masivo a un mismo proveedor")
  public void ingresarInformacionFactura() {
    detalleSiniestroStep.consultarInformacionSiniestro();
    cargaArchivoPagoMasivoStep.cargarArchivoXls(
        MenuConstante.ESCRITORIO_MENU, MenuConstante.FACTURAS_VOLUMEN_MENU);
    resultadoValidacionArchivoStep.validarNumeroRegistrosArchivo();
    resultadoArchivoProcesadoStep.consultarResultadoArchivoProcesado();
  }

  @Cuando(
      "^se ingresa el tipo de proveedor (.*) y el nombre del proveedor (.*) con el tipo de moneda (.*) de la factura y el método de pago (.*) del cheque")
  public void crearPagoMasivo(
      String tipoContacto, String contacto, String tipoMoneda, String metodoPago) {
    detalleFacturaVolumenStep.ingresarInformacionFactura(tipoMoneda, metodoPago);
    busquedaLibretaContactoStep.buscarContactoPagoMasivo(tipoContacto, contacto);
    detalleFacturaVolumenStep.crearPagoMasivo();
  }

  @Entonces(
      "^se genera un número de pago individual por cada uno de los pagos registrados en el archivo de pagos masivos con un estado de pago solicitado$")
  public void validarPagoMasivo() {}
}
