package com.sura.reclamaciones.utils;

import com.sura.reclamaciones.constantes.ConexionBDConstante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBaseDatosUtil {

  public static Connection conectar() throws SQLException {
    Connection conexion=null;
    try {
      String url= ConexionBDConstante.URL;
      String usuario= ConexionBDConstante.USUARIO;
      String clave= ConexionBDConstante.CLAVE;
      Class.forName(ConexionBDConstante.DRIVER).newInstance();
      conexion= DriverManager
          .getConnection(url, usuario, clave);
      if (conexion != null) {
        System.out.println("Conexion exitosa");
      }
    }catch (Exception e) {
      e.printStackTrace();
    }finally {
      return conexion;
    }
  }
}