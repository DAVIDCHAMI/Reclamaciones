package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_MANUAL_VEHICULAR;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_VEHICULAR_TERCERO;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_MASIVO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_NAVEGACION_MENU_ACCIONES;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.Exposicion;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.steps.generics.DetalleSiniestroStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.generics.MenuClaimsStep;
import com.sura.reclamaciones.steps.generics.ProcesoBatchStep;
import com.sura.reclamaciones.steps.pagomasivo.BusquedaLibretaContactoStep;
import com.sura.reclamaciones.steps.pagomasivo.CargaArchivoPagoMasivoStep;
import com.sura.reclamaciones.steps.pagomasivo.DatoFinancieroPagoStep;
import com.sura.reclamaciones.steps.pagomasivo.DetalleFacturaVolumenStep;
import com.sura.reclamaciones.steps.pagomasivo.FacturaVolumenStep;
import com.sura.reclamaciones.steps.pagomasivo.ResultadoArchivoProcesadoStep;
import com.sura.reclamaciones.steps.pagomasivo.ResultadoValidacionArchivoStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
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

  @Steps MenuClaimsStep menuClaimsStep;

  @Steps DatoFinancieroPagoStep datoFinancieroPagoStep;

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps GenericStep genericStep;

  @Cuando(
      "^se registra la información de las facturas del pago masivo de los siniestros con cobertura (.*) a un proveedor")
  public void ingresarInformacionFactura(String tipoCobertura) throws IOException {
    nuevoPagoStep.consultarPlacaAsegurado();
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(
                PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO.getValor(),
                EXPOSICION_VEHICULAR_TERCERO.getValor()));
    nuevoPagoStep.crearExposicionVehicularManual(
        genericStep.getFilasModelo(
            PARAMETROS_NAVEGACION_MENU_ACCIONES.getValor(), EXPOSICION_MANUAL_VEHICULAR.getValor()),
        exposicionVehiculoTercero.getLstExposicionTerceros());
    detalleSiniestroStep.consultarInformacionSiniestro();
    Exposicion datosExposicionPagoMasivo =
        new Exposicion(
            genericStep.getFilasModelo(String.valueOf(PAGO_MASIVO.getValor()), tipoCobertura));
    Reserva datosReservaPagoMasivo =
        new Reserva(
            genericStep.getFilasModelo(String.valueOf(PAGO_MASIVO.getValor()), tipoCobertura));
    PagoSiniestro datosPagoSiniestroPagoMasivo =
        new PagoSiniestro(
            genericStep.getFilasModelo(String.valueOf(PAGO_MASIVO.getValor()), tipoCobertura));
    cargaArchivoPagoMasivoStep.cargarArchivoXls(
        MenuConstante.ESCRITORIO_MENU,
        MenuConstante.FACTURAS_VOLUMEN_MENU,
        datosExposicionPagoMasivo,
        datosReservaPagoMasivo,
        datosPagoSiniestroPagoMasivo);
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
  public void validarPagoMasivo() {
    facturaVolumenStep.buscarNumeroFacturaPagoMasivo(
        MenuConstante.ESCRITORIO_MENU, MenuConstante.FACTURAS_VOLUMEN_MENU);
    detalleFacturaVolumenStep.validarPagoMasivo();
    menuClaimsStep.consultarNumeroReclamacion(
        Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor()));
    datoFinancieroPagoStep.validarPagosIndividuales(
        MenuConstante.DATOS_FINANCIEROS, MenuConstante.PAGOS);
  }
}
