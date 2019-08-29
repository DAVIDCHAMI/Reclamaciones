package com.sura.reclamaciones.utils;

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

    public void LlenarArchivoXls(String rutaCompleta) {
        try {
            ArchivoXLS.abrirArchivoXls(rutaCompleta, "ITEMS");
            ArchivoXLS.removerFilaSinEncabezado();
            ArchivoXLS.Guardar(rutaCompleta);

            String csv = "Daño general;GeneralDamage;Auto-Daños;PADanosCov;Auto-Daños;PADanosCov;Al costo;claimcost;Auto-Perdida Parcial Daños  autorizado TALLER;PAPerParcDanAutoTaller_Ext;Parcial;Partial;0%;0070;0070;IVA 0% e ICM 0%;0000;47,00;Pago parcial;Immediate;0001";

            String[] partsCsv = csv.split(";");
            /*List<String> placa = new ArrayList();
            placa.add("YDC971");
            placa.add("YDC972");
            placa.add("YDC973");
            placa.add("YDC974");*/

            //String siniestro = "9190000036342";
            String numeroSiniestro =
                    (Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor())
                            .toString());

            List<String> placa = Collections.singletonList((Serenity.sessionVariableCalled(SESION_CC_PLACAS_VEHICULOS_INVOLUCRADOS.getValor())
                    .toString()));

            LocalDateTime fecha = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String fechaFormateada = formatter.format(fecha);
            List<String> listaInformacion = new ArrayList();

            for (int i = 0; i < placa.size(); i++) {
                LocalDateTime numeroFactura = LocalDateTime.now();
                DateTimeFormatter formatear = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSS");
                String numerofacturagenerado = formatear.format(numeroFactura);
                listaInformacion.add(numeroSiniestro);
                listaInformacion.add(placa.get(i).toString());
                int numeroMonto = (int) (Math.random() * 9999999 + 100);

                for (String datoCsv : partsCsv) {
                    listaInformacion.add(datoCsv);
                }
                listaInformacion.add(14, Integer.toString(numeroMonto));
                listaInformacion.add(21, numerofacturagenerado);
                listaInformacion.add(22, fechaFormateada);
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