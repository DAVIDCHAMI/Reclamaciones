package com.sura.reclamaciones.pages.modelosimplificado;

import com.sura.reclamaciones.querys.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarModeloSimplificado {

  public ConsultarModeloSimplificado() {
    super();
  }

  public ResultSet consultarModeloSimplificado(Connection conexionBD, String numeroTransaccion)
      throws SQLException {
    Query sqlConsulta = Query.SqlModeloSimplificadoReserva;
    String sql = sqlConsulta.getConsultaSql();
    PreparedStatement stmt = null;
    stmt = conexionBD.prepareStatement(sql);
    stmt.setString(1, numeroTransaccion);
    ResultSet rs = stmt.executeQuery();
    return rs;
  }
}
