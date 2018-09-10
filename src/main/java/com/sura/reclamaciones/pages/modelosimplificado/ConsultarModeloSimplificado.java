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

  PreparedStatement statement = null;
  List<Map<String, String>> lstFila = new ArrayList<Map<String, String>>();
  ResultSet resultSet;

  public List<Map<String, String>> consultarModeloSimplificado(
      Connection conexionBD, String numeroMovimientoFinanciero, String sql) throws SQLException {
    try {
      statement = conexionBD.prepareStatement(sql);
      statement.setString(1, numeroMovimientoFinanciero);
      resultSet = statement.executeQuery();
      ResultSetMetaData metaData = resultSet.getMetaData();
      int columnas = metaData.getColumnCount();
      while (resultSet.next()) {
        Map<String, String> fila = new HashMap<String, String>(columnas);
        for (int i = 1; i <= columnas; ++i) {
          fila.put(metaData.getColumnName(i), resultSet.getString(i));
        }
        lstFila.add(fila);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      resultSet.close();
      statement.close();
      conexionBD.close();
      return lstFila;
    }
  }
}
