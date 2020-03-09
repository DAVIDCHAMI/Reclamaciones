package com.sura.reclamaciones.definitions.autos.pagomasivo;

import static com.sura.reclamaciones.constantes.Filtros.CLASE_VEHICULO;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_MANUAL_VEHICULAR;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_VEHICULAR_TERCERO;
import static com.sura.reclamaciones.constantes.NombresCsv.CODIGO_FASECOLDA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_NAVEGACION_MENU_ACCIONES;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO;
import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;

import com.sura.reclamaciones.models.Exposicion;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.DetalleSiniestroStep;
import com.sura.reclamaciones.steps.generics.ExposicionVehicularManualStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition {

  ExposicionVehiculoTercero exposicionVehiculoTercero = new ExposicionVehiculoTercero();

  @Steps ExposicionVehicularManualStep nuevaExposicionVehiculoStep;

  @Steps DetalleSiniestroStep detalleSiniestroStep;

  @Cuando(
      "^se registra la información de las facturas del pago masivo a un proveedor de (.*) vehículos involucrados en el siniestro con coberturas (.*)")
  public void ingresarInformacionFactura(
      int numeroVehiculosInvolucradosTercero, String coberturasPoliza) throws IOException {
    Vehiculo datosVehiculos;
    Exposicion datosExposicionPagoMasivo;
    Reserva datosReservaPagoMasivo;
    PagoSiniestro datosPagoSiniestroPagoMasivo;
    final String PAGO_MASIVO = "pago_masivo";
    nuevaExposicionVehiculoStep.consultarPlacaAsegurado();
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            obtenerDatosPrueba(
                PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO.getValor(),
                EXPOSICION_VEHICULAR_TERCERO.getValor()));
    datosVehiculos =
        new Vehiculo(obtenerDatosPrueba(CODIGO_FASECOLDA.getValor(), CLASE_VEHICULO.getValor()));
    nuevaExposicionVehiculoStep.crearExposicionVehicularManual(
        obtenerDatosPrueba(
            PARAMETROS_NAVEGACION_MENU_ACCIONES.getValor(), EXPOSICION_MANUAL_VEHICULAR.getValor()),
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        numeroVehiculosInvolucradosTercero,
        datosVehiculos.getLstVehiculos());
    detalleSiniestroStep.consultarInformacionSiniestro();
    datosExposicionPagoMasivo = new Exposicion(obtenerDatosPrueba(PAGO_MASIVO, coberturasPoliza));
    datosReservaPagoMasivo = new Reserva(obtenerDatosPrueba(PAGO_MASIVO, coberturasPoliza));
    datosPagoSiniestroPagoMasivo =
        new PagoSiniestro(obtenerDatosPrueba(PAGO_MASIVO, coberturasPoliza));
  }

  @Cuando(
      "^se ingresa el tipo de proveedor (.*) y el nombre del proveedor (.*) con el tipo de moneda (.*) de la factura y el método de pago (.*) del cheque")
  public void crearPagoMasivo(
      String tipoContacto, String contacto, String tipoMoneda, String metodoPago) {
    //ToDo
  }

  @Entonces(
      "^se genera un número de pago individual por cada uno de los pagos registrados en el archivo de pagos masivos con un estado de pago solicitado$")
  public void validarPagoMasivo() {
    //ToDo
  }
}
