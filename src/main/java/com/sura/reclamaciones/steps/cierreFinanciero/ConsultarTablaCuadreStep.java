package com.sura.reclamaciones.steps.cierreFinanciero;

import com.sura.reclamaciones.DAO.ConsultarTablaCuadre;
import com.sura.reclamaciones.models.CredencialBD;
import com.sura.reclamaciones.models.TablaCuadreBD;
import com.sura.reclamaciones.utils.ConexionBaseDatosUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import net.thucydides.core.annotations.Step;

public class ConsultarTablaCuadreStep {
  Connection conexion = null;
  ConsultarTablaCuadre consultarTablaCuadre = new ConsultarTablaCuadre();
  TablaCuadreBD tablaCuadreBD;

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

  public TablaCuadreBD consultarMovimiento(String numeroTransacion, List<CredencialBD> credenciales)
      throws SQLException {
    conexion = conectarBaseDatos(credenciales);
    return tablaCuadreBD =
        new TablaCuadreBD(consultarTablaCuadre.consultarTransaccion(conexion, numeroTransacion));
  }
}
