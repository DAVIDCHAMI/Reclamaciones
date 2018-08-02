package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.utils.Utilidades;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

public class CSVStep {

  public List<Map<String, String>> getFilasModelo(
      String nombreCSV, String columnaFiltro, String filtro) throws IOException {
    TestDataSource testData = new CSVTestDataSource("/data/data_" + nombreCSV + ".csv", ';');
    return getDataCSVEnList(testData, columnaFiltro, filtro);
  }

  public static List<Map<String, String>> getDataCSVEnList(
      TestDataSource testData, String columnaFiltro, String filtro) {
    List<Map<String, String>> loadedData = testData.getData();
    String[] arrayDatosParaFiltrar = filtro.split(",");
    List<Map<String, String>> loadedDataFiltrada =
        filtrarDataCSV(columnaFiltro, arrayDatosParaFiltrar, loadedData);
    return loadedDataFiltrada;
  }

  public static List<Map<String, String>> filtrarDataCSV(
      String columnaFiltro, String[] arr, List<Map<String, String>> loadedData) {
    Utilidades utilidades = new Utilidades();
    List<Map<String, String>> loadedDataFiltered =
        loadedData
            .stream()
            .filter(fila -> utilidades.inArray(arr, fila.get(columnaFiltro)))
            .collect(Collectors.toList());
    return loadedDataFiltered;
  }
}
