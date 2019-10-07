package com.sura.reclamaciones.utils;

import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_PLACAS_VEHICULOS_INVOLUCRADOS;
import static org.terracotta.modules.ehcache.ToolkitInstanceFactoryImpl.LOGGER;

import com.sura.reclamaciones.models.Exposicion;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.serenitybdd.core.Serenity;

public class LlenadoArchivoXLS {

  Random numeroRandom = new Random();

  public void llenarArchivoExcel(
      String rutaCompletaArchivo,
      List<Exposicion> datosExposicionPagoMasivo,
      List<Reserva> datosReservaPagoMasivo,
      List<PagoSiniestro> datosPagoSiniestroPagoMasivo) {
    try {
      ArchivoExcel.abrirArchivoExcel(rutaCompletaArchivo, "ITEMS");
      ArchivoExcel.removerFilaSinEncabezado();
      ArchivoExcel.guardarArchivoExcel(rutaCompletaArchivo);
      String numeroSiniestro =
          (Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor()).toString());
      String placasVehiculos =
          Serenity.sessionVariableCalled(SESION_CC_PLACAS_VEHICULOS_INVOLUCRADOS.getValor())
              .toString();
      String[] placasVehiculosInvolucrados = placasVehiculos.split(",");
      List<String> placasVehiculosInvolucradosSiniestro = new ArrayList();
      for (String datosPlaca : placasVehiculosInvolucrados) {
        String placas = datosPlaca.replaceAll("\\W+", "");
        placasVehiculosInvolucradosSiniestro.add(placas);
      }
      LocalDateTime fecha = LocalDateTime.now();
      DateTimeFormatter cambiarFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      String fechaFormateada = cambiarFormato.format(fecha);
      List<String> listaInformacion = new ArrayList(26);
      for (int i = 0; i < placasVehiculosInvolucradosSiniestro.size(); i++) {
        LocalDateTime numeroFactura = LocalDateTime.now();
        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");
        String numerofacturagenerado = formatear.format(numeroFactura);
        listaInformacion.add(numeroSiniestro);
        listaInformacion.add(placasVehiculosInvolucradosSiniestro.get(i));
        int numeroMonto = numeroRandom.nextInt(200000) + 1000;
        int filaArchivoCsv = i;
        if (i >= 2) {
          filaArchivoCsv = 1;
        }
        listaInformacion.add(2, datosExposicionPagoMasivo.get(filaArchivoCsv).getTipoExposicion());
        listaInformacion.add(3, datosExposicionPagoMasivo.get(filaArchivoCsv).getExposureType());
        listaInformacion.add(4, datosExposicionPagoMasivo.get(filaArchivoCsv).getCobertura());
        listaInformacion.add(5, datosExposicionPagoMasivo.get(filaArchivoCsv).getCoverageType());
        listaInformacion.add(
            6, datosExposicionPagoMasivo.get(filaArchivoCsv).getSubtipoCobertura());
        listaInformacion.add(7, datosExposicionPagoMasivo.get(filaArchivoCsv).getCoverageSubtype());
        listaInformacion.add(8, datosReservaPagoMasivo.get(filaArchivoCsv).getTipoCosto());
        listaInformacion.add(9, datosReservaPagoMasivo.get(filaArchivoCsv).getCostType());
        listaInformacion.add(10, datosReservaPagoMasivo.get(filaArchivoCsv).getCategoriaCosto());
        listaInformacion.add(11, datosReservaPagoMasivo.get(filaArchivoCsv).getCostCategory());
        listaInformacion.add(12, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getTipoPago());
        listaInformacion.add(13, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getPaymentType());
        listaInformacion.add(14, Integer.toString(numeroMonto));
        listaInformacion.add(15, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getDescuento());
        listaInformacion.add(
            16, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getCodigoRetencion());
        listaInformacion.add(
            17, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getLineCategory());
        listaInformacion.add(18, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getImpuesto());
        listaInformacion.add(
            19, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getTaxesTypeExt());
        listaInformacion.add(
            20, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getCodigoProducto());
        listaInformacion.add(21, numerofacturagenerado);
        listaInformacion.add(22, fechaFormateada);
        listaInformacion.add(23, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getDescription());
        listaInformacion.add(
            24, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getCondicionPago());
        listaInformacion.add(
            25, datosPagoSiniestroPagoMasivo.get(filaArchivoCsv).getPaymentConditionTypeExt());
        ArchivoExcel.escribirExcelXfila(listaInformacion, rutaCompletaArchivo);
        for (int k = listaInformacion.size() - 1; k >= 0; k--) {
          listaInformacion.remove(k);
        }
      }
    } catch (Exception e) {
      LOGGER.info("No fue posible llenar el archivo de Excel", e);
    }
  }
}
