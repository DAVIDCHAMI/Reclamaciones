package com.sura.reclamaciones.definitions.modelosimplificado;

import com.sura.reclamaciones.steps.modelosimplificado.ConsultarModeloSimplificadoStep;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.thucydides.core.annotations.Steps;


public class ConsultaModeloSimplificadoDefinition {

  @Steps
  ConsultarModeloSimplificadoStep conexionBDSteps;
  Connection conexion=null;
  public ResultSet rs;
  String transaccion;

  @Dado("que se realiza un (.*)")
  public void que_se_realiza_un_Pago(String transaccionFinanciera) throws SQLException {
    transaccion= "3890";//se toma de la generacion del pago, reserva o recupero
    conexion = conexionBDSteps.connection();
  }

  @Cuando("la transaccion se ha efectuado")
  public void la_transaccion_se_ha_efectuado() throws SQLException, IOException {
      rs = conexionBDSteps.consulta(conexion, transaccion);
      System.out.println("Se ejecuto la consulta");
  }

  @Entonces("en las fuentes del tablero deben quedar correctos los valores de reaseguro")
  public void en_las_fuentes_del_tablero_deben_quedar_correctos_los_valores_de_reaseguro()
      throws SQLException {
    conexionBDSteps.verficarConsulta(rs);
  }

}
