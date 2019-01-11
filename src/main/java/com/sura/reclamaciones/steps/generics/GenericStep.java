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
    Utilidades utilidades = new Utilidades();
    return loadedData
        .stream()
        .filter(
            fila ->
                Utilidades.filtrarArreglo(arr, fila.get(Variables.COLUMNA_FILTRO_CSV.getValor())))
        .collect(Collectors.toList());
  }

  public void generarRegistro(String valor, String tipoAviso) {
    try {
      Date date = new Date();
      DateFormat horaFormateada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      if (tipoAviso.equalsIgnoreCase(ConstanteGlobal.EMPRESARIALES)) {
        File archivoLogEmpresarial = new File("C:\\Log\\RegistrosEmpresarial.txt");
        FileWriter escribirEmp = new FileWriter(archivoLogEmpresarial, true);
        escribirEmp.write(valor + " " + horaFormateada.format(date));
        escribirEmp.write("\r\n");
        escribirEmp.close();
      } else {
        File archivoLogAuto = new File("C:\\Log\\RegistrosAutos.txt");
        FileWriter escribirAut = new FileWriter(archivoLogAuto, true);
        escribirAut.write(valor + " " + horaFormateada.format(date));
        escribirAut.write("\r\n");
        escribirAut.close();
      }
    } catch (Exception e) {
      Utilidades.getLogger().info("No se realizó el guardado del Log");
    }
  }
}
