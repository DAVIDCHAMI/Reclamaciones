package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Filtros.*;
import static com.sura.reclamaciones.constantes.NombresCsv.*;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;
import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.*;
import com.sura.reclamaciones.steps.generics.*;
import com.sura.reclamaciones.steps.pagomasivo.*;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition {

  ExposicionVehiculoTercero exposicionVehiculoTercero = new ExposicionVehiculoTercero();

  @Steps CargaArchivoPagoMasivoStep cargaArchivoPagoMasivoStep;

  @Steps ResultadoValidacionArchivoStep resultadoValidacionArchivoStep;

  @Steps DetalleSiniestroStep detalleSiniestroStep;

  @Steps ResultadoArchivoProcesadoStep resultadoArchivoProcesadoStep;

  @Steps DetalleFacturaVolumenStep detalleFacturaVolumenStep;

  @Steps BusquedaLibretaContactoStep busquedaLibretaContactoStep;

  @Steps ProcesoBatchStep procesoBatchStep;

  @Steps FacturaVolumenStep facturaVolumenStep;

  @Steps DatoFinancieroPagoStep datoFinancieroPagoStep;

  @Steps ExposicionVehicularManualStep nuevaExposicionVehiculoStep;

  @Steps GenericStep genericStep;

  Exposicion datosExposicionPagoMasivo;

  Reserva datosReservaPagoMasivo;

  PagoSiniestro datosPagoSiniestroPagoMasivo;

  CodigoFasecolda datosCodigoFasecolda;

  @Cuando(
      "^se registra la información de las facturas del pago masivo a un proveedor de (.*) vehículos involucrados en el siniestro con coberturas (.*)")
  public void ingresarInformacionFactura(
      int numeroVehiculosInvolucradosTercero, String coberturasPoliza) throws IOException {
    nuevaExposicionVehiculoStep.consultarPlacaAsegurado();
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(
                PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO.getValor(),
                EXPOSICION_VEHICULAR_TERCERO.getValor()));
    datosCodigoFasecolda =
        new CodigoFasecolda(
            genericStep.getFilasModelo(CODIGO_FASECOLDA.getValor(), CLASE_VEHICULO.getValor()));
    nuevaExposicionVehiculoStep.crearExposicionVehicularManual(
        genericStep.getFilasModelo(
            PARAMETROS_NAVEGACION_MENU_ACCIONES.getValor(), EXPOSICION_MANUAL_VEHICULAR.getValor()),
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        numeroVehiculosInvolucradosTercero,
        datosCodigoFasecolda.getLstCodigoFasecolda());
    detalleSiniestroStep.consultarInformacionSiniestro();
    datosExposicionPagoMasivo =
        new Exposicion(
            genericStep.getFilasModelo(String.valueOf(PAGO_MASIVO.getValor()), coberturasPoliza));
    datosReservaPagoMasivo =
        new Reserva(
            genericStep.getFilasModelo(String.valueOf(PAGO_MASIVO.getValor()), coberturasPoliza));
    datosPagoSiniestroPagoMasivo =
        new PagoSiniestro(
            genericStep.getFilasModelo(String.valueOf(PAGO_MASIVO.getValor()), coberturasPoliza));
    cargaArchivoPagoMasivoStep.cargarArchivoXls(
        MenuConstante.ESCRITORIO_MENU,
        MenuConstante.FACTURAS_VOLUMEN_MENU,
        datosExposicionPagoMasivo.getLstExposicion(),
        datosReservaPagoMasivo.getLstReserva(),
        datosPagoSiniestroPagoMasivo.getLstPago());
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
    procesoBatchStep.ejecutarProcesoBatch();
  }

  @Entonces(
      "^se genera un número de pago individual por cada uno de los pagos registrados en el archivo de pagos masivos con un estado de pago solicitado$")
  public void validarPagoMasivo(String strOpcionMenu, String numReclamacion) {
    facturaVolumenStep.buscarNumeroFacturaPagoMasivo(
        MenuConstante.ESCRITORIO_MENU, MenuConstante.FACTURAS_VOLUMEN_MENU);
    detalleFacturaVolumenStep.validarPagoMasivo();
    datoFinancieroPagoStep.validarPagosIndividuales(
        Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor()),
        MenuConstante.DATOS_FINANCIEROS,
        MenuConstante.PAGOS);
  }
}
