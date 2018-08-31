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

  ModeloSimplificado modeloSimplificado;
  Connection conexion = null;
  ResultSet rs;
  @Steps private GenericStep genericStep;
  @Steps ConsultarModeloSimplificadoStep conexionBDSteps;

  @Dado("^que se realiza un (.*)$")
  public void realizarConexionModeloSimplificado(String transaccionFinanciera)
      throws SQLException, IOException {
    if (transaccionFinanciera=="Reserva") {
      String idFiltro= "escenarioMovimientoReserva";
    }
    modeloSimplificado =
        new ModeloSimplificado(
            genericStep.getFilasModelo(
                "reaseguro_modelo_simplificado", "escenarioMovimientoReserva"));
  }

  @Cuando("^la transaccion se ha efectuado$")
  public void ejecutarConsultaModeloSimplificado() throws SQLException {
    rs =
        conexionBDSteps.consultarModeloSimplificado(
            conexion, modeloSimplificado.getlstModeloSimplificado());
  }

  @Entonces("^en las fuentes del tablero deben quedar correctos los valores de reaseguro$")
  public void obtenerDatosModeloSimplificado() throws SQLException {
    List<ModeloSimplificado> datosTransaccion = modeloSimplificado.getlstModeloSimplificado();
    conexionBDSteps.verficarConsultaModeloSimplificado(rs, datosTransaccion);
  }
}
