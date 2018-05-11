package com.sura.reclamaciones.utils;

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
}
