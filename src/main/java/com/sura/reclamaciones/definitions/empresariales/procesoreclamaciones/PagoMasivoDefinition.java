package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Filtros.CLASE_VEHICULO;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_MANUAL_VEHICULAR;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_VEHICULAR_TERCERO;
import static com.sura.reclamaciones.constantes.NombresCsv.CODIGO_FASECOLDA;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_MASIVO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_NAVEGACION_MENU_ACCIONES;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO;
import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.CodigoFasecolda;
import com.sura.reclamaciones.models.Exposicion;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.steps.generics.DetalleSiniestroStep;
import com.sura.reclamaciones.steps.generics.ExposicionVehicularManualStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.pagomasivo.CargaArchivoPagoMasivoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition {

  ExposicionVehiculoTercero exposicionVehiculoTercero = new ExposicionVehiculoTercero();

  @Steps CargaArchivoPagoMasivoStep cargaArchivoPagoMasivoStep;

  @Steps ResultadoValidacionArchivoStep resultadoValidacionArchivoStep;

  @Steps DetalleSiniestroStep detalleSiniestroStep;

  @Steps ResultadoArchivoProcesadoStep resultadoArchivoProcesadoStep;

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
            obtenerDatosPrueba(CODIGO_FASECOLDA.getValor(), CLASE_VEHICULO.getValor()));
    nuevaExposicionVehiculoStep.crearExposicionVehicularManual(
        genericStep.getFilasModelo(
            PARAMETROS_NAVEGACION_MENU_ACCIONES.getValor(), EXPOSICION_MANUAL_VEHICULAR.getValor()),
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        numeroVehiculosInvolucradosTercero,
        datosCodigoFasecolda.getLstCodigoFasecolda());
    detalleSiniestroStep.consultarInformacionSiniestro();
    datosExposicionPagoMasivo =
        new Exposicion(
            obtenerDatosPrueba(String.valueOf(PAGO_MASIVO.getValor()), coberturasPoliza));
    datosReservaPagoMasivo =
        new Reserva(obtenerDatosPrueba(String.valueOf(PAGO_MASIVO.getValor()), coberturasPoliza));
    datosPagoSiniestroPagoMasivo =
        new PagoSiniestro(
            obtenerDatosPrueba(String.valueOf(PAGO_MASIVO.getValor()), coberturasPoliza));
    cargaArchivoPagoMasivoStep.cargarArchivoXls(
        MenuConstante.ESCRITORIO_MENU,
        MenuConstante.FACTURAS_VOLUMEN_MENU,
        datosExposicionPagoMasivo.getLstExposicion(),
        datosReservaPagoMasivo.getLstReserva(),
        datosPagoSiniestroPagoMasivo.getLstPago());
  }

  @Cuando(
      "^se ingresa el tipo de proveedor (.*) y el nombre del proveedor (.*) con el tipo de moneda (.*) de la factura y el método de pago (.*) del cheque")
  public void crearPagoMasivo()
  {
    //ToDo

  }

  @Entonces(
      "^se genera un número de pago individual por cada uno de los pagos registrados en el archivo de pagos masivos con un estado de pago solicitado$")
  public void validarPagoMasivo() {
    //ToDo
  }
}
