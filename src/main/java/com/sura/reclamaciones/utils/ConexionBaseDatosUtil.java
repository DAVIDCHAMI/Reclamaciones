package com.sura.reclamaciones.utils;

import com.sura.reclamaciones.constantes.ConexionBDConstante;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionBaseDatosUtil {

  public static Connection conectarBaseDatos(){
    Connection conexion = null;
    try {
      String url = ConexionBDConstante.URL;
      String usuario = ConexionBDConstante.USUARIO;
      String clave = ConexionBDConstante.CLAVE;
      Class.forName(ConexionBDConstante.DRIVER).newInstance();
      conexion = DriverManager.getConnection(url, usuario, clave);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      return conexion;
    }
  }
}