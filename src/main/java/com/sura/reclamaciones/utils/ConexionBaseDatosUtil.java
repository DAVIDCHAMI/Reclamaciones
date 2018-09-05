package com.sura.reclamaciones.utils;

import com.sura.reclamaciones.constantes.ConexionBDConstante;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBaseDatosUtil {

  public static Connection conectarBaseDatos(String url, String usuario, String clave) {
    Connection conexion = null;
    try {
      Class.forName(ConexionBDConstante.DRIVER).newInstance();
      conexion = DriverManager.getConnection(url, usuario, clave);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      return conexion;
    }
  }
}