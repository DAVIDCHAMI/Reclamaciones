package com.sura.reclamaciones.steps.modelosimplificado;

import com.sura.reclamaciones.models.CredencialBD;
import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.models.ModeloSimplificadoBD;
import com.sura.reclamaciones.pages.modelosimplificado.ConsultarModeloSimplificado;
import com.sura.reclamaciones.querys.Query;
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

  @Page
  ConsultarModeloSimplificado consultarModeloSimplificado = new ConsultarModeloSimplificado();

  @Step
  public Connection conectarBaseDatos(List<CredencialBD> datosCredenciales) {
    datosCredenciales.forEach(
        datoCredencial -> {
          conexion =
              ConexionBaseDatosUtil.conectarBaseDatos(
                  datoCredencial.getUsuario(), datoCredencial.getContrasena(),
                  datoCredencial.getURL(), datoCredencial.getDriver());
        });
    return conexion;
  }

  public List<Map<String, String>> consultarModeloSimplificado(
      List<CredencialBD> credenciales,
      List<ModeloSimplificado> datosTransaccion, String movimientoFinanciero) throws SQLException {
    String sql = new String();
    if (movimientoFinanciero.equals("Reserva")) {
      Query sqlConsulta = Query.SqlModeloSimplificadoReserva;
      sql = sqlConsulta.getConsultaSql();
    } else if (movimientoFinanciero.equals("Pago")) {
      Query sqlConsulta = Query.SqlModeloSimplificadoPago;
      sql = sqlConsulta.getConsultaSql();
    } else if ((movimientoFinanciero.equals("Recupero")) || (movimientoFinanciero
        .equals("AnulacionRecupero"))) {
      Query sqlConsulta = Query.SqlModeloSimplificadoRecupero;
      sql = sqlConsulta.getConsultaSql();
    } else if (movimientoFinanciero.equals("AnulacionPago")) {
      Query sqlConsulta = Query.SqlModeloSimplificadoPago;
      sql = sqlConsulta.getConsultaSql();
    }
    datosTransaccion.forEach(datoTransaccion -> {
      transaccionConsulta = datoTransaccion.getTransaccion();
    });
    conexion = conectarBaseDatos(credenciales);
    List<Map<String, String>> resultadoConsulta =
        consultarModeloSimplificado
            .consultarModeloSimplificado(conexion, transaccionConsulta, sql);
    return resultadoConsulta;
  }


  public void verficarConsultaModeloSimplificado1(
      List<ModeloSimplificadoBD> resultadoConsulta, List<ModeloSimplificado> datosTransaccion) {
    for (ModeloSimplificadoBD resultadoBaseDatos : resultadoConsulta) {
      for (ModeloSimplificado resultadoCalculado : datosTransaccion) {
        MatcherAssert.assertThat(
            "No coincide el valor cedido a las reaseguradoras",
            resultadoBaseDatos
                .getValorCedidoReaseguradoras()
                .equals(resultadoCalculado.getValorCedidoReaseguradoras()));
        MatcherAssert.assertThat(
            "No coincide el valor neto de la transacción",
            resultadoBaseDatos.getValorNeto().equals(resultadoCalculado.getValorNeto()));
        MatcherAssert.assertThat(
            "No coincide el valor de la transacción",
            resultadoBaseDatos
                .getValorTransaccion()
                .equals(resultadoCalculado.getValorTransaccion()));
      }
    }
  }

  public void verficarConsultaModeloSimplificado(
      List<ModeloSimplificadoBD> resultadoConsulta, List<ModeloSimplificado> datosTransaccion) {
    for (int i = 0; i < resultadoConsulta.size(); i++) {
      ModeloSimplificadoBD resultadoBD = resultadoConsulta.get(i);
       ModeloSimplificado resultadoCalculado = datosTransaccion.get(i);
      MatcherAssert.assertThat(
          "No coincide el valor cedido a las reaseguradoras",
          resultadoBD.getValorCedidoReaseguradoras().equals(resultadoCalculado.getValorCedidoReaseguradoras()));
    }
  }




}