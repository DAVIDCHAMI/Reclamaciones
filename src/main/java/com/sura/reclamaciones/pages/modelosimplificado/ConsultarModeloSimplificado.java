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
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      resultSet.close();
      statement.close();
      conexionBD.close();
      return lstFila;
    }
  }

  public String obtenerSentenciaSql(String movimientoFinanciero) {
    Map<String, String> sentenciaSql = new HashMap<String, String>();
    sentenciaSql.put(
        "Reserva",
        "select REFERENCE,CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT, AMOUNT from ADM_GWCC.CCX_RESERVEDENORM_EXT where REFERENCE in ?");
    sentenciaSql.put(
        "Recupero",
        "select REFERENCE,CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT, AMOUNT  from ADM_GWCC.CCX_RECOVERYDENORM_EXT where REFERENCE in ?");
    sentenciaSql.put(
        "Pago",
        "select REFERENCE,CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT,AMOUNT from ADM_GWCC.CCX_CHECKDENORM_EXT where reference in ?");
    sentenciaSql.put(
        "AnulacionPago",
        "select REFERENCE,CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT,AMOUNT from ADM_GWCC.CCX_CHECKDENORM_EXT where reference in ?");
    sentenciaSql.put(
        "AnulacionRecupero",
        "select REFERENCE,CLAIMNUMBER,CEDEDREINSURANCE,NETAMOUNT, AMOUNT  from ADM_GWCC.CCX_RECOVERYDENORM_EXT where REFERENCE in ?");
    return sentenciaSql.get(movimientoFinanciero);
  }
}
