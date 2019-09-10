package com.sura.reclamaciones.utils;

import com.sura.reclamaciones.constantes.NombresCsv;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

public final class UtilidadesCSV {

  private static final String RUTA_RECURSOS_DATOS_CSV = "/data/";
  private static final String PREFIJO_NOMBRE_DATOS_CSV = "datos_";
  private static final String EXTENSION_NOMBRE_DATOS_CSV = ".csv";
  private static final String NOMBRE_COLUMNA_FILTRO = "idFiltro";
  private static final char SEPARADOR_VALORES_CSV = ';';
  private static final String SEPARADOR_COMA = ",";

  private UtilidadesCSV() {}

  public static List<Map<String, String>> obtenerDatosPrueba(String nombreCSV, String filtro)
      throws IOException {
    TestDataSource datosOrigenCSV =
        new CSVTestDataSource(
            RUTA_RECURSOS_DATOS_CSV
                + PREFIJO_NOMBRE_DATOS_CSV
                + nombreCSV
                + EXTENSION_NOMBRE_DATOS_CSV,
            SEPARADOR_VALORES_CSV);
    return obtenerDatosFiltrados(datosOrigenCSV, filtro);
  }

  private static List<Map<String, String>> obtenerDatosFiltrados(
      TestDataSource datosCSV, String cadenaListadoFiltros) {
    List<Map<String, String>> lstTotalDatosCSV = datosCSV.getData();
    if ("".equals(cadenaListadoFiltros)) {
      return lstTotalDatosCSV;
    }
    String[] arrListadoFiltros =
        cadenaListadoFiltros.split(SEPARADOR_COMA);
    return filtrarDatos(arrListadoFiltros, lstTotalDatosCSV);
  }

  private static List<Map<String, String>> filtrarDatos(
      String[] arrListaFiltros, List<Map<String, String>> listaTotalDatos) {
    return listaTotalDatos
        .stream()
        .filter(fila -> Utilidades.filtrarArreglo(arrListaFiltros, fila.get(NOMBRE_COLUMNA_FILTRO)))
        .collect(Collectors.toList());
  }

  public static String obtenerDatoContenidoCSV(
      NombresCsv nomDiccionarioCSV,
      String nomColumnaPivote,
      String valorColumnaPivote,
      String nomColumnaRetornar)
      throws IOException {
    List<Map<String, String>> lstDiccionario =
        obtenerDatosPrueba(nomDiccionarioCSV.getValor(), valorColumnaPivote);
    Optional<String> valorObtenido =
        lstDiccionario
            .stream()
            .filter(registro -> valorColumnaPivote.equals(registro.get(nomColumnaPivote)))
            .map(registro -> registro.get(nomColumnaRetornar))
            .findFirst();
    if (valorObtenido.isPresent()) {
      return valorObtenido.get();
    }
    throw new IllegalArgumentException(
        String.format("Columna %s NO encontrada", nomColumnaRetornar));
  }
}
