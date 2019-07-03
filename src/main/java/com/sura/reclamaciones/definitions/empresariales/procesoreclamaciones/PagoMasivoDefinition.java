package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.steps.pagomasivo.CargaArchivoPagoMasivoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition {

  @Steps CargaArchivoPagoMasivoStep cargaArchivoPagoMasivoStep;

  @Cuando(
      "^se ingresa la información en el archivo de Excel para realizar pagos masivos a un mismo proveedor")
  public void crearPagoMasivo() {
    //ToDo
  }

  @Cuando("^se carga el archivo de Excel para realizar el pago masivo a el proveedor")
  public void cargarArchivoExcelPagoMasivo() {
    cargaArchivoPagoMasivoStep.cargarArchivoXls(
        MenuConstante.ESCRITORIO_MENU, MenuConstante.FACTURAS_VOLUMEN_MENU);
  }

  @Cuando(
      "^se ingresa el tipo de proveedor (.*) y el nombre del proveedor (.*) con el tipo de moneda (.*) de la factura y el método de pago (.*) del cheque")
  public void ingresarInformacionFactura() {
    //ToDo
  }

  @Entonces(
      "^se genera un número de pago individual por cada uno de los pagos registrados en el archivo de pagos masivos con un estado de pago solicitado")
  public void validarCreacionPagoMasivo() {
    //ToDo
  }
}
