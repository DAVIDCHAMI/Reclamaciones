package com.sura.reclamaciones.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import net.thucydides.core.steps.StepInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Utilidades {

  private static Random aleatorio = new Random();

  private Utilidades() {
    super();
  }

  public static boolean filtrarArreglo(String[] arr, String item) {
    if (arr.length > 0) {
      for (String n : arr) {
        if (item.equals(n)) {
          return true;
        }
      }
    }
    return false;
  }

  public static String obtenerFechaActual() {
    Date fechaActual = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
    return formateador.format(fechaActual);
  }

  public static int valorarMes(String mes) {
    Map<String, Integer> map = new HashMap<>();
    map.put("Jan", 1);
    map.put("Ene", 1);
    map.put("Enero", 1);
    map.put("Feb", 2);
    map.put("Febrero", 2);
    map.put("Mar", 3);
    map.put("Marzo", 3);
    map.put("Apr", 4);
    map.put("Abr", 4);
    map.put("Abril", 4);
    map.put("May", 5);
    map.put("Mayo", 5);
    map.put("Jun", 6);
    map.put("Junio", 6);
    map.put("Jul", 7);
    map.put("Julio", 7);
    map.put("Aug", 8);
    map.put("Ago", 8);
    map.put("Agosto", 8);
    map.put("Sep", 9);
    map.put("Septiembre", 9);
    map.put("Oct", 10);
    map.put("Octubre", 10);
    map.put("Nov", 11);
    map.put("Noviembre", 11);
    map.put("Dec", 12);
    map.put("Dic", 12);
    map.put("Diciembre", 12);
    return map.get(mes);
  }

  public static Logger getLogger() {
    return LoggerFactory.getLogger(StepInterceptor.class);
  }

  public static int conversorCadenaEntero(String cadena) {
    return Integer.parseInt(cadena);
  }

  public static String obtenerDatosDiccionario(
      List<Map<String, String>> lstDiccionario, String filtro, String datoRequerido) {
    final String COLUMNA_FILTRO_CSV = "idFiltro";
    Optional<String> valorObtenido =
        lstDiccionario
            .stream()
            .filter(registro -> filtro.equals(registro.get(COLUMNA_FILTRO_CSV)))
            .map(registro -> registro.get(datoRequerido))
            .findFirst();
    if (valorObtenido.isPresent()) {
      return valorObtenido.get();
    }
    throw new IllegalArgumentException(String.format("Dato %s no encontrado", datoRequerido));
  }

  public static boolean transformarCadenaValorlogico(String parametro) {
    switch (parametro.toLowerCase()) {
      case "si":
      case "true":
        return true;
      case "no":
      case "false":
        return false;
      default:
        throw new IllegalArgumentException(String.format("Dato %s no encontrado", parametro));
    }
  }

  public static String generarPlacaAleatoria(int cantidadLetras, int cantidadNumeros) {
    return String.format(
        "%s%s", generarAleatoriosLetras(cantidadLetras), generarAleatoriosNumeros(cantidadNumeros));
  }

  public static String generarAleatoriosNumeros(int longitudSerie) {
    StringBuilder serieNros = new StringBuilder();
    for (int i = 1; i <= longitudSerie; i++) {
      serieNros.append(aleatorio.nextInt(10));
    }
    return serieNros.toString();
  }

  public static String generarAleatoriosLetras(int longitudSerie) {
    StringBuilder serieLetras = new StringBuilder();
    String[] abecedario = {
      "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
      "T", "U", "V", "W", "X", "Y", "Z"
    };
    for (int i = 1; i <= longitudSerie; i++) {
      serieLetras.append(abecedario[aleatorio.nextInt(26)]);
    }
    return serieLetras.toString();
  }
}
