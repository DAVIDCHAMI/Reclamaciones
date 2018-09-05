package com.sura.reclamaciones.definitions.modelosimplificado;

import com.sura.reclamaciones.models.CredencialBD;
import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.models.ModeloSimplificadoBD;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.modelosimplificado.ConsultarModeloSimplificadoStep;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import net.thucydides.core.annotations.Steps;

public class ConsultaModeloSimplificadoDefinition {

  Connection conexion = null;

  String movimientoFinanciero;

  @Steps
  CredencialBD credencial;

  @Steps ModeloSimplificado modeloSimplificado;

  @Steps private GenericStep genericStep;

  @Steps ConsultarModeloSimplificadoStep conexionBDStep;

  ModeloSimplificadoBD modeloSimplificadoBD;

  @Dado("^que se realiza un (.*)$")
  public void realizarConexionModeloSimplificado(String transaccionFinanciera) throws IOException {
    movimientoFinanciero= transaccionFinanciera;
    modeloSimplificado =
        new ModeloSimplificado(
            genericStep.getFilasModelo("reaseguro_modelo_simplificado", transaccionFinanciera));
  }

  @Cuando("^la transaccion se ha efectuado$")
  public void ejecutarConsultaModeloSimplificado() throws SQLException, IOException {
    credencial = new CredencialBD (genericStep.getFilasModelo("credencialBD", "conexionGWBD"));
    modeloSimplificadoBD =
        new ModeloSimplificadoBD(
            conexionBDStep.consultarModeloSimplificado(
                credencial.getCredenciales(), modeloSimplificado.getlstModeloSimplificado(), movimientoFinanciero));
  }

  @Entonces("^en las fuentes del tablero deben quedar correctos los valores de reaseguro$")
  public void obtenerDatosModeloSimplificado() {
    conexionBDStep.verficarConsultaModeloSimplificado(
        modeloSimplificadoBD.getLstModeloSimplificadoBD(), modeloSimplificado.getlstModeloSimplificado());
  }
}