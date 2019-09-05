package com.sura.reclamaciones.utils;

import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;
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

      //String csv = "Daño general;GeneralDamage;Auto-Daños;PADanosCov;Auto-Daños;PADanosCov;Al costo;claimcost;Auto-Perdida Parcial Daños  autorizado TALLER;PAPerParcDanAutoTaller_Ext;Parcial;Partial;0%;0070;0070;IVA 0% e ICM 0%;0000;47,00;Pago parcial;Immediate;0001";

      //String[] partsCsv = csv.split(";");

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

        /*for (String datoCsv : partsCsv) {
            listaInformacion.add(datoCsv);
        }*/

        listaInformacion.add(2, datosExposicionPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getTipoExposicion());
        listaInformacion.add(3, datosExposicionPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getExposureType());
        listaInformacion.add(4, datosExposicionPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getCobertura());
        listaInformacion.add(5, datosExposicionPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getCoverageType());
        listaInformacion.add(6, datosExposicionPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getSubtipoCobertura());
        listaInformacion.add(7, datosExposicionPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getCoverageSubtype());
        listaInformacion.add(8, datosReservaPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getTipoCosto());
        listaInformacion.add(9, datosReservaPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getCostType());
        listaInformacion.add(10, datosReservaPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getCategoriaCosto());
        listaInformacion.add(11, datosReservaPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getCostCategory());
        listaInformacion.add(12, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getTipoPago());
        listaInformacion.add(13, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getPaymentType());
        listaInformacion.add(14, Integer.toString(numeroMonto));
        listaInformacion.add(15, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getDescuento());
        listaInformacion.add(16, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getCodigoRetencion());
        listaInformacion.add(17, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getLineCategory());
        listaInformacion.add(18, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getImpuesto());
        listaInformacion.add(19, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getTaxesTypeExt());
        listaInformacion.add(20, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getCodigoProducto());
        listaInformacion.add(21, numerofacturagenerado);
        listaInformacion.add(22, fechaFormateada);
        listaInformacion.add(23, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getDescription());
        listaInformacion.add(24, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getCondicionPago());
        listaInformacion.add(25, datosPagoSiniestroPagoMasivo.get(Integer.valueOf(VALOR_CERO.getValor())).getPaymentConditionTypeExt());

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
