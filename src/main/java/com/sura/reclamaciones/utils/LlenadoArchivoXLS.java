package com.sura.reclamaciones.utils;

import com.sura.reclamaciones.models.Exposicion;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.generics.DetalleSiniestroPage;
import net.serenitybdd.core.Serenity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_PLACAS_VEHICULOS_INVOLUCRADOS;

public class LlenadoArchivoXLS {

    public void LlenarArchivoXls(String rutaCompleta, Exposicion datosExposicionPagoMasivo, Reserva datosReservaPagoMasivo, PagoSiniestro datosPagoSiniestroPagoMasivo) {
        try {
            ArchivoXLS.abrirArchivoXls(rutaCompleta, "ITEMS");
            ArchivoXLS.removerFilaSinEncabezado();
            ArchivoXLS.Guardar(rutaCompleta);

            String csv = "Daño general;GeneralDamage;Auto-Daños;PADanosCov;Auto-Daños;PADanosCov;Al costo;claimcost;Auto-Perdida Parcial Daños  autorizado TALLER;PAPerParcDanAutoTaller_Ext;Parcial;Partial;0%;0070;0070;IVA 0% e ICM 0%;0000;47,00;Pago parcial;Immediate;0001";

            String[] partsCsv = csv.split(";");

            String numeroSiniestro =
                    (Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor())
                            .toString());

            String placasVehiculos = Serenity.sessionVariableCalled(SESION_CC_PLACAS_VEHICULOS_INVOLUCRADOS.getValor()).toString();
            String[] placasVehiculosInvolucrados = placasVehiculos.split(",");
            List<String> placasVehiculosInvolucradosSiniestro = new ArrayList();
            for (String datosPlaca : placasVehiculosInvolucrados)
            {
                String placas=  datosPlaca.replaceAll("\\W+", "");
                placasVehiculosInvolucradosSiniestro.add(placas);
            }

            LocalDateTime fecha = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String fechaFormateada = formatter.format(fecha);
            List<String> listaInformacion = new ArrayList(27);

            for (int i = 0; i < placasVehiculosInvolucradosSiniestro.size(); i++) {
                LocalDateTime numeroFactura = LocalDateTime.now();
                DateTimeFormatter formatear = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");
                String numerofacturagenerado = formatear.format(numeroFactura);
                listaInformacion.add(numeroSiniestro);
                listaInformacion.add(placasVehiculosInvolucradosSiniestro.get(i).toString());
                int numeroMonto = (int) (Math.random() * 9999999 + 100);

                for (String datoCsv : partsCsv) {
                    listaInformacion.add(datoCsv);
                }


                listaInformacion.add(2,datosExposicionPagoMasivo.getTipoExposicion());
                listaInformacion.add(3,datosExposicionPagoMasivo.getExposureType());
                listaInformacion.add(4,datosExposicionPagoMasivo.getCobertura());
                listaInformacion.add(5,datosExposicionPagoMasivo.getCoverageType());
                listaInformacion.add(6,datosExposicionPagoMasivo.getSubtipoCobertura());
                listaInformacion.add(7,datosReservaPagoMasivo.getTipoCosto());
                listaInformacion.add(8,datosReservaPagoMasivo.getCostType());
                listaInformacion.add(9,datosReservaPagoMasivo.getCategoriaCosto());
                listaInformacion.add(10,datosReservaPagoMasivo.getCostCategory());
                listaInformacion.add(11,datosPagoSiniestroPagoMasivo.getTipoPago());
                listaInformacion.add(12,datosPagoSiniestroPagoMasivo.getPaymentType());
                listaInformacion.add(13,datosPagoSiniestroPagoMasivo.getPaymentType());
                listaInformacion.add(14, Integer.toString(numeroMonto));
                listaInformacion.add(15,datosPagoSiniestroPagoMasivo.getDescuento());
                listaInformacion.add(16,datosPagoSiniestroPagoMasivo.getCodigoRetencion());
                listaInformacion.add(17,datosPagoSiniestroPagoMasivo.getLineCategory());
                listaInformacion.add(18,datosPagoSiniestroPagoMasivo.getImpuesto());
                listaInformacion.add(19,datosPagoSiniestroPagoMasivo.getTaxesTypeExt());
                listaInformacion.add(20,datosPagoSiniestroPagoMasivo.getCodigoProducto());
                listaInformacion.add(21, numerofacturagenerado);
                listaInformacion.add(22, fechaFormateada);
                listaInformacion.add(23,datosPagoSiniestroPagoMasivo.getDescription());
                listaInformacion.add(24,datosPagoSiniestroPagoMasivo.getCondicionPago());
                listaInformacion.add(25,datosPagoSiniestroPagoMasivo.getPaymentConditionTypeExt());

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