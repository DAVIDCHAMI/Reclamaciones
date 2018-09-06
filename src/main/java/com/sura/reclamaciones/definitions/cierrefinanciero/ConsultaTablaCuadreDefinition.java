package com.sura.reclamaciones.definitions.cierrefinanciero;

import com.sura.reclamaciones.models.CredencialBD;
import com.sura.reclamaciones.models.TablaCuadreBD;
import com.sura.reclamaciones.steps.cierreFinanciero.ConsultarTablaCuadreStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import net.thucydides.core.annotations.Steps;

public class ConsultaTablaCuadreDefinition {

  Connection conexion = null;

  TablaCuadreBD lstTablaCuadreBD;

  @Steps CredencialBD credencialBD;

  @Steps GenericStep genericStep;

  @Steps private ConsultarTablaCuadreStep consultarTablaCuadreStep;

  @Cuando("^se genera un movimiento financiero de tipo (.*)$")
  public void consultarTransaccionBD(String tipoMovimiento) throws SQLException, IOException {
    credencialBD =
        new CredencialBD(genericStep.getFilasModelo("credencialBD", "conexionTablaCuadre"));
    String numeroTransacion = "CC:3635014";
    lstTablaCuadreBD =
        consultarTablaCuadreStep.consultarMovimiento(
            numeroTransacion, credencialBD.getCredenciales());
  }

  @Entonces(
      "^se garantiza que el movimiento cumpla con los filtros de la tabla para que se entregue correctamente a el sistema contables$")
  public void garantizarInformacionTransaccion() {
    consultarTablaCuadreStep.verificarDatos(lstTablaCuadreBD.getLstTablaCuadreBD());
  }
}
