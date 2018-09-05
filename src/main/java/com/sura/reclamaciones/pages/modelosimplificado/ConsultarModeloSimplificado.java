package com.sura.reclamaciones.pages.modelosimplificado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultarModeloSimplificado {

  public List<Map<String, String>> consultarModeloSimplificado(
      Connection conexionBD, String numeroTransaccion, String sql) throws SQLException {
    PreparedStatement stmt = null;
    stmt = conexionBD.prepareStatement(sql);
    stmt.setString(1, numeroTransaccion);
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
    conexionBD.close();
    return lstFila;
  }
}
