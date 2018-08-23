package com.sura.reclamaciones.steps.modelosimplificado;

import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.pages.modelosimplificado.ConsultarModeloSimplificadoPage;
import com.sura.reclamaciones.utils.ConexionBaseDatosUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.StringContains;

public class ConsultarModeloSimplificadoStep {

  @Page
  ConsultarModeloSimplificadoPage consultarModeloSimplificadoPage =
      new ConsultarModeloSimplificadoPage();

  @Step
  public Connection conectarBaseDatos() throws SQLException {
    Connection conexion = null;
    return conexion = ConexionBaseDatosUtil.conectarBaseDatos();
  }

  public ResultSet consultarModeloSimplificado(
      Connection bd, List<ModeloSimplificado> datosTransaccion) throws SQLException {
    final String[] transaccionConsulta = {String.valueOf(new Object[1])};
    datosTransaccion.forEach(transaccion -> transaccionConsulta[0] = transaccion.getTransaccion());
    ResultSet resultSet =
        consultarModeloSimplificadoPage.consultarModeloSimplificado(bd, transaccionConsulta[0]);
    return resultSet;
  }

  public void verficarConsultaModeloSimplificado(
      ResultSet rs, List<ModeloSimplificado> datosTransaccion) throws SQLException {
    List<String> registroTransaccion = llenarLista(rs);
    String valorPagarALosReaseguradoresModeloSimplificado = registroTransaccion.get(1);
    String valorNetoTransaccionConsultaModeloSimplificado = registroTransaccion.get(2);
    String valorTransaccionConsultaModeloSimplificado = registroTransaccion.get(3);
    datosTransaccion.forEach(
        dato -> {
          String valorTransaccionCalculado = dato.getValorTransaccion();
          String valorNetoTransaccionCalculado = dato.getValorNeto();
          String valorPagarALosReaseguradoresCalculado = dato.getValorCedidoReaseguradoras();
          MatcherAssert.assertThat(
              valorTransaccionConsultaModeloSimplificado,
              new StringContains(valorTransaccionCalculado));
          MatcherAssert.assertThat(
              valorNetoTransaccionConsultaModeloSimplificado,
              new StringContains(valorNetoTransaccionCalculado));
          MatcherAssert.assertThat(
              valorPagarALosReaseguradoresModeloSimplificado,
              new StringContains(valorPagarALosReaseguradoresCalculado));
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
