package com.sura.reclamaciones.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Utilidades {

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

  public static String obtenerFechaActual() {
    Date fechaActual = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
    return formateador.format(fechaActual);
  }

  public static int valorarMes(String mes) {
    Map<String, Integer> map = new HashMap<String, Integer>();
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

  public static int conversorCadenaEntero(String cadena) {
    return Integer.parseInt(cadena);
  }

}
