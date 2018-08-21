package com.sura.reclamaciones.definitions.modelosimplificado;

import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.steps.generics.GenericStep;
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

  ModeloSimplificado modeloSimplificado;
  Connection conexion=null;
  ResultSet rs;
  String numeroTransaccion;
  @Steps private GenericStep genericStep;
  @Steps ConsultarModeloSimplificadoStep conexionBDSteps;

  @Dado("^que se realiza un (.*)$")
  public void que_se_realiza_un_Pago(String transaccionFinanciera) throws SQLException, IOException {
    modeloSimplificado = new ModeloSimplificado(genericStep.getFilasModelo("reaseguro_modelo_simplificado", "escenarioCPExcReserva") );
    conexion = conexionBDSteps.connection();
  }

  @Cuando("^la transaccion se ha efectuado$")
  public void la_transaccion_se_ha_efectuado() throws SQLException, IOException {
    modeloSimplificado.getlstModeloSimplificado();
    conexionBDSteps.consultar()
    rs = conexionBDSteps.consultar(conexion,numeroTransaccion);
    System.out.println("Se ejecuto la consulta");
  }

  @Entonces("^en las fuentes del tablero deben quedar correctos los valores de reaseguro$")
  public void en_las_fuentes_del_tablero_deben_quedar_correctos_los_valores_de_reaseguro()
      throws SQLException {
    conexionBDSteps.verficarConsulta(rs);
  }

}
