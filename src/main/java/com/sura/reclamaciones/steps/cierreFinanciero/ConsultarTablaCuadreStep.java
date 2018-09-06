package com.sura.reclamaciones.steps.cierreFinanciero;

import com.sura.reclamaciones.DAO.ConsultarTablaCuadre;
import com.sura.reclamaciones.models.CredencialBD;
import com.sura.reclamaciones.models.TablaCuadreBD;
import com.sura.reclamaciones.utils.ConexionBaseDatosUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ConsultarTablaCuadreStep {
  Connection conexion = null;
  ConsultarTablaCuadre consultarTablaCuadre = new ConsultarTablaCuadre();
  TablaCuadreBD tablaCuadreBD;

  public TablaCuadreBD consultarMovimiento(String numeroTransacion, List<CredencialBD> credenciales)
      throws SQLException {
    credenciales.forEach(
        datoCredencial -> {
          conexion =
              ConexionBaseDatosUtil.conectarBaseDatos(
                  datoCredencial.getUsuario(),
                  datoCredencial.getContrasena(),
                  datoCredencial.getURL(),
                  datoCredencial.getDriver());
        });
    return tablaCuadreBD =
        new TablaCuadreBD(consultarTablaCuadre.consultarTransaccion(conexion, numeroTransacion));
  }

  public void verificarDatos(List<TablaCuadreBD> lstTablaCuadreBD) {}
}
