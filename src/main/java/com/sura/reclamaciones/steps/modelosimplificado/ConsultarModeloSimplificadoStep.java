package com.sura.reclamaciones.steps.modelosimplificado;

import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.pages.modelosimplificado.ConsultarModeloSimplificado;
import com.sura.reclamaciones.utils.ConexionBaseDatosUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ConsultarModeloSimplificadoStep {

  @Page ConsultarModeloSimplificado consultarModeloSimplificado = new ConsultarModeloSimplificado();

  @Step
  public Connection conectarBaseDatos() throws SQLException {
    Connection conexion = null;
    return conexion = ConexionBaseDatosUtil.conectarBaseDatos();
  }

  public ResultSet consultarModeloSimplificado(
      Connection conexionBD, List<ModeloSimplificado> datosTransaccion) throws SQLException {
    final String[] transaccionConsulta = {String.valueOf(new Object[1])};
    datosTransaccion.forEach(transaccion -> transaccionConsulta[0] = transaccion.getTransaccion());
    ResultSet resultSet =
        consultarModeloSimplificado.consultarModeloSimplificado(conexionBD, transaccionConsulta[0]);
    return resultSet;
  }

  public void verficarConsultaModeloSimplificado(
      ResultSet rs, List<ModeloSimplificado> datosTransaccion) throws SQLException {
    List<String> registroTransaccion = llenarLista(rs);
    String valorPagarReaseguradoresModeloSimplificado = registroTransaccion.get(1);
    String valorNetoTransaccionConsultaModeloSimplificado = registroTransaccion.get(2);
    String valorTransaccionConsultaModeloSimplificado = registroTransaccion.get(3);
    datosTransaccion.forEach(
        dato -> {
          String valorTransaccionCalculado = dato.getValorTransaccion();
          String valorNetoTransaccionCalculado = dato.getValorNeto();
          String valorPagarReaseguradoresCalculado = dato.getValorCedidoReaseguradoras();
          MatcherAssert.assertThat(
              "No coninciden los datos del valor de la transacción",
              valorTransaccionConsultaModeloSimplificado.equals(valorTransaccionCalculado));
          MatcherAssert.assertThat(
              "No coninciden los datos del valor neto de la transacción",
              valorNetoTransaccionConsultaModeloSimplificado.equals(valorNetoTransaccionCalculado));
          MatcherAssert.assertThat(
              "No coninciden los datos del valor a pagar a los reaseguradores",
              valorPagarReaseguradoresModeloSimplificado.equals(valorPagarReaseguradoresCalculado));
        });
  }

  public List<String> llenarLista(ResultSet rs) throws SQLException {
    List<String> fila = new ArrayList<String>();
    while (rs.next()) {
      for (int y = 1; y <= rs.getMetaData().getColumnCount(); y++) {
        String dato = rs.getString(y);
        fila.add(y - 1, dato);
      }
    }
    return fila;
  }
}
