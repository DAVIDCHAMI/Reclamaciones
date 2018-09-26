package com.sura.reclamaciones.steps.modelosimplificado;

import com.sura.reclamaciones.constantes.ModeloSimplificadoConstante;
import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.sentenciasSQL.ConsultarModeloSimplificado;
import com.sura.reclamaciones.utils.ConexionBaseDatosUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ConsultarModeloSimplificadoStep {

  Connection conexion = null;
  String transaccionConsulta = null;
  String sql = new String();
  List<Map<String, String>> resultadoConsulta = null;

  @Page
  ConexionBaseDatosUtil consultarModeloSimplificado = new ConexionBaseDatosUtil();

  ConsultarModeloSimplificado obtenerSql = new ConsultarModeloSimplificado();

  @Step
  public Connection conectarBaseDatos() {
    conexion =
        ConexionBaseDatosUtil.conectarBaseDatos(
            ModeloSimplificadoConstante.USUARIO, ModeloSimplificadoConstante.CLAVE,
            ModeloSimplificadoConstante.URL, ModeloSimplificadoConstante.DRIVER);
    return conexion;
  }

  public List<Map<String, String>> consultarModeloSimplificado(
      List<ModeloSimplificado> datosTransaccion, String movimientoFinanciero) throws SQLException {
    sql = obtenerSql.obtenerSentenciaSql(movimientoFinanciero);
    datosTransaccion.forEach(
        datoTransaccion -> transaccionConsulta = datoTransaccion.getTransaccion());
    conexion = conectarBaseDatos();
    resultadoConsulta =
        consultarModeloSimplificado.consultarBaseDatos(conexion, transaccionConsulta, sql);
    return resultadoConsulta;
  }

  public void verficarConsultaModeloSimplificado(
      List<ModeloSimplificado> resultadoConsulta, List<ModeloSimplificado> datosTransaccion) {
    for (int i = 0; i < resultadoConsulta.size(); i++) {
      ModeloSimplificado resultadoBD = resultadoConsulta.get(i);
      ModeloSimplificado resultadoCalculado = datosTransaccion.get(i);
      MatcherAssert.assertThat(
          "No coincide el valor cedido a las reaseguradoras",
          resultadoBD
              .getValorCedidoReaseguradoras()
              .equals(resultadoCalculado.getValorCedidoReaseguradoras()));
      MatcherAssert.assertThat(
          "No coincide el valor neto",
          resultadoBD.getValorNeto().equals(resultadoCalculado.getValorNeto()));
      MatcherAssert.assertThat(
          "No coincide el valor Transacción",
          resultadoBD
              .getValorMovimientoFinanciero()
              .equals(resultadoCalculado.getValorMovimientoFinanciero()));
      MatcherAssert.assertThat(
          "No coincide el estado del movimiento financiero",
          resultadoBD
              .getEstadoMovimientoFinanciero()
              .equals(resultadoCalculado.getEstadoMovimientoFinanciero()));
    }
  }
}
