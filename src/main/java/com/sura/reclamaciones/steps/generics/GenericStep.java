package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.utils.Utilidades;
import com.sura.reclamaciones.utils.Variables;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

public class GenericStep {

  public List<Map<String, String>> getFilasModelo(String nombreCSV, String filtro)
      throws IOException {
    TestDataSource testData = new CSVTestDataSource("/data/datos_" + nombreCSV + ".csv", ';');
    return getDataCSVEnList(testData, filtro);
  }

  public static List<Map<String, String>> getDataCSVEnList(TestDataSource testData, String filtro) {
    List<Map<String, String>> loadedData = testData.getData();
    String[] arrayDatosParaFiltrar = filtro.split(",");
    return filtrarDataCSV(arrayDatosParaFiltrar, loadedData);
  }

  public static List<Map<String, String>> filtrarDataCSV(
      String[] arr, List<Map<String, String>> loadedData) {
    return loadedData
        .stream()
        .filter(
            fila ->
                Utilidades.filtrarArreglo(arr, fila.get(Variables.COLUMNA_FILTRO_CSV.getValor())))
        .collect(Collectors.toList());
  }

  public void generarArchivo(String valor) {
    try {
      ResourceBundle rutaRegistro = ResourceBundle.getBundle(ConstanteGlobal.RUTA_REGISTRO);
      String registroEmpresarial = rutaRegistro.getString("Registros");
      Date fecha = new Date();
      DateFormat horaFormateada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      File archivoLog = new File(registroEmpresarial, "");
      FileWriter escribirDato = new FileWriter(archivoLog, ConstanteGlobal.TRUE);
      escribirDato.write(valor + " " + horaFormateada.format(fecha));
      escribirDato.write("\r\n");
      escribirDato.close();
    } catch (Exception e) {
      Utilidades.getLogger().info("No se realizó el guardado del Log", e);
    }
  }
}
