package com.sura.reclamaciones.steps.modelosimplificado;

import com.sura.reclamaciones.models.CredencialBD;
import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.models.TablaModeloSimplificado;
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

  @Page ConsultarModeloSimplificado consultarModeloSimplificado = new ConsultarModeloSimplificado();

  @Step
  public Connection conectarBaseDatos(List<CredencialBD> datosCredenciales) {
    datosCredenciales.forEach(
        datoCredencial -> {
          conexion =
              ConexionBaseDatosUtil.conectarBaseDatos(
                  datoCredencial.getUsuario(),
                  datoCredencial.getContrasena(),
                  datoCredencial.getURL(),
                  datoCredencial.getDriver());
        });
    return conexion;
  }

  public List<Map<String, String>> consultarModeloSimplificado(
      List<CredencialBD> credenciales,
      List<ModeloSimplificado> datosTransaccion,
      String movimientoFinanciero)
      throws SQLException {
    final String[] transaccionConsulta = {String.valueOf(new Object[1])};
    String sql = new String();
    if (movimientoFinanciero.equals("Reserva")) {
      Query sqlConsulta = Query.SqlModeloSimplificadoReserva;
      sql = sqlConsulta.getConsultaSql();
    } else if (movimientoFinanciero.equals("Pago")) {
      Query sqlConsulta = Query.SqlModeloSimplificadoPago;
      sql = sqlConsulta.getConsultaSql();
    } else if ((movimientoFinanciero.equals("Recupero"))
        || (movimientoFinanciero.equals("AnulacionRecupero"))) {
      Query sqlConsulta = Query.SqlModeloSimplificadoRecupero;
      sql = sqlConsulta.getConsultaSql();
    } else if (movimientoFinanciero.equals("AnulacionPago")) {
      Query sqlConsulta = Query.SqlModeloSimplificadoAnulacionPago;
      sql = sqlConsulta.getConsultaSql();
    }
    datosTransaccion.forEach(transaccion -> transaccionConsulta[0] = transaccion.getTransaccion());
    conexion = conectarBaseDatos(credenciales);
    List<Map<String, String>> resultadoConsulta =
        consultarModeloSimplificado.consultarModeloSimplificado(
            conexion, transaccionConsulta[0], sql);
    return resultadoConsulta;
  }

  public void verficarConsultaModeloSimplificado(
      List<TablaModeloSimplificado> resultadoConsulta, List<ModeloSimplificado> datosTransaccion) {
    for (TablaModeloSimplificado resultadoBaseDatos : resultadoConsulta) {
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
}
