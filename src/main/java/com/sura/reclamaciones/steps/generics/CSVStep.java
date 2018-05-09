package com.sura.reclamaciones.steps.generics;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

public class CSVStep {

  public List<Map<String, String>> getRowsDatos(String columnaFiltro, String filtro)
      throws IOException {
    TestDataSource testData = new CSVTestDataSource("/data/datosReclamacion.csv", ';');
    return getDataCSVEnExampleTable(testData, columnaFiltro, filtro);
  }

  public static List<Map<String, String>> getDataCSVEnExampleTable(
      TestDataSource testData, String columnaFiltro, String filtro) {
    List<Map<String, String>> loadedData = testData.getData();
    List<String> cabeceras = testData.getHeaders();
    String[] arrayDatosParaFiltrar = filtro.split(",");
    List<Map<String, String>> loadedDataFiltrada =
        filtrarDataCSV(columnaFiltro, arrayDatosParaFiltrar, loadedData);
    return loadedDataFiltrada;
  }

  public static List<Map<String, String>> filtrarDataCSV(
      String columnaFiltro, String[] arr, List<Map<String, String>> loadedData) {
    List<Map<String, String>> loadedDataFiltered =
        loadedData
            .stream()
            .filter(fila -> inArray(arr, fila.get(columnaFiltro)))
            .collect(Collectors.toList());
    return loadedDataFiltered;
  }

  public static boolean inArray(String[] arr, String item) {
    if (arr.length > 0) {
      for (String n : arr) {
        if (item.equals(n)) {
          return true;
        }
      }
    }
    return false;
  }
}
