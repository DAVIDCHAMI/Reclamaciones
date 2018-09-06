package com.sura.reclamaciones.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBaseDatosUtil {

  public static Connection conectarBaseDatos(
      String usuario, String clave, String url, String driver) {
    Connection conexion = null;
    try {
      Class.forName(driver).newInstance();
      conexion = DriverManager.getConnection(url, usuario, clave);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      return conexion;
    }
  }
}
