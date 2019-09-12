package com.sura.reclamaciones.utils;

import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_PLACAS_VEHICULOS_INVOLUCRADOS;

import com.sura.reclamaciones.models.Exposicion;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.core.Serenity;

public class LlenadoArchivoXLS {

  public void LlenarArchivoXls(
      String rutaCompleta,
      List<Exposicion> datosExposicionPagoMasivo,
      List<Reserva> datosReservaPagoMasivo,
      List<PagoSiniestro> datosPagoSiniestroPagoMasivo) {
    try {
      ArchivoXLS.abrirArchivoXls(rutaCompleta, "ITEMS");
      ArchivoXLS.removerFilaSinEncabezado();
      ArchivoXLS.Guardar(rutaCompleta);
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
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
      String fechaFormateada = formatter.format(fecha);
      List<String> listaInformacion = new ArrayList(26);
      for (int i = 0; i < placasVehiculosInvolucradosSiniestro.size(); i++) {
        LocalDateTime numeroFactura = LocalDateTime.now();
        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");
        String numerofacturagenerado = formatear.format(numeroFactura);
        listaInformacion.add(numeroSiniestro);
        listaInformacion.add(placasVehiculosInvolucradosSiniestro.get(i).toString());
        int numeroMonto = (int) (Math.random() * 9999999 + 100);
        int j = i;

        if (i >= 2) {
          j = 1;
        }
        listaInformacion.add(2, datosExposicionPagoMasivo.get(j).getTipoExposicion());
        listaInformacion.add(3, datosExposicionPagoMasivo.get(j).getExposureType());
        listaInformacion.add(4, datosExposicionPagoMasivo.get(j).getCobertura());
        listaInformacion.add(5, datosExposicionPagoMasivo.get(j).getCoverageType());
        listaInformacion.add(6, datosExposicionPagoMasivo.get(j).getSubtipoCobertura());
        listaInformacion.add(7, datosExposicionPagoMasivo.get(j).getCoverageSubtype());
        listaInformacion.add(8, datosReservaPagoMasivo.get(j).getTipoCosto());
        listaInformacion.add(9, datosReservaPagoMasivo.get(j).getCostType());
        listaInformacion.add(10, datosReservaPagoMasivo.get(j).getCategoriaCosto());
        listaInformacion.add(11, datosReservaPagoMasivo.get(j).getCostCategory());
        listaInformacion.add(12, datosPagoSiniestroPagoMasivo.get(j).getTipoPago());
        listaInformacion.add(13, datosPagoSiniestroPagoMasivo.get(j).getPaymentType());
        listaInformacion.add(14, Integer.toString(numeroMonto));
        listaInformacion.add(15, datosPagoSiniestroPagoMasivo.get(j).getDescuento());
        listaInformacion.add(16, datosPagoSiniestroPagoMasivo.get(j).getCodigoRetencion());
        listaInformacion.add(17, datosPagoSiniestroPagoMasivo.get(j).getLineCategory());
        listaInformacion.add(18, datosPagoSiniestroPagoMasivo.get(j).getImpuesto());
        listaInformacion.add(19, datosPagoSiniestroPagoMasivo.get(j).getTaxesTypeExt());
        listaInformacion.add(20, datosPagoSiniestroPagoMasivo.get(j).getCodigoProducto());
        listaInformacion.add(21, numerofacturagenerado);
        listaInformacion.add(22, fechaFormateada);
        listaInformacion.add(23, datosPagoSiniestroPagoMasivo.get(j).getDescription());
        listaInformacion.add(24, datosPagoSiniestroPagoMasivo.get(j).getCondicionPago());
        listaInformacion.add(25, datosPagoSiniestroPagoMasivo.get(j).getPaymentConditionTypeExt());

        ArchivoXLS.escribirExcelXfila(listaInformacion, rutaCompleta);
        for (int k = listaInformacion.size() - 1; k >= 0; k--) {

          listaInformacion.remove(k);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
