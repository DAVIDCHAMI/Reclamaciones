package com.sura.reclamaciones.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultarTablaCuadre {

  public List<Map<String, String>> consultarTransaccion(
      Connection conexion, String numeroTransacion) throws SQLException {
    int uno = 1;
    String sql = "";
    PreparedStatement stmt = conexion.prepareStatement(sql);
    stmt.setString(uno, numeroTransacion);
    ResultSet rs = stmt.executeQuery();
    ResultSetMetaData md = rs.getMetaData();
    int columnas = md.getColumnCount();
    List<Map<String, String>> lstFila = new ArrayList<Map<String, String>>();
    while (rs.next()) {
      Map<String, String> fila = new HashMap<String, String>(columnas);
      for (int i = 1; i <= columnas; ++i) {
        fila.put(md.getColumnName(i), rs.getString(i));
      }
      lstFila.add(fila);
    }
    rs.close();
    stmt.close();
    conexion.close();
    return lstFila;
  }
}
