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
import java.util.List;
import net.thucydides.core.annotations.Steps;


public class ConsultaModeloSimplificadoDefinition {

  @Steps ConsultarModeloSimplificadoStep conexionBDSteps;
  ModeloSimplificado modeloSimplificado;
  Connection conexion=null;
  ResultSet rs;
  @Steps private GenericStep genericStep;


  @Dado("^que se realiza un (.*)$")
  public void realizarConexionModeloSimplificado(String transaccionFinanciera) throws SQLException, IOException {
    modeloSimplificado = new ModeloSimplificado(genericStep.getFilasModelo("reaseguro_modelo_simplificado", "escenarioCPExcReserva") );
    conexion = conexionBDSteps.connection();
  }

  @Cuando("^la transaccion se ha efectuado$")
  public void ejecutarConsultaModeloSimplificado() throws SQLException, IOException {
    List<ModeloSimplificado> datosTransaccion= modeloSimplificado.getlstModeloSimplificado();
    final String[] transaccionConsulta = {String.valueOf(new Object[1])};
    datosTransaccion.forEach(
        transaccion->
            transaccionConsulta[0] = transaccion.getTransaccion()
    );
    rs = conexionBDSteps.consultar(conexion, transaccionConsulta[0]);
    System.out.println(rs);
    System.out.println("Se ejecuto la consulta");
  }

  @Entonces("^en las fuentes del tablero deben quedar correctos los valores de reaseguro$")
  public void obtenerDatosModeloSimplificado() throws SQLException {
    conexionBDSteps.verficarConsulta(rs);
  }

}