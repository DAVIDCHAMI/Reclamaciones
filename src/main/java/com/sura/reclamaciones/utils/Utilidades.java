package com.sura.reclamaciones.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

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
}
