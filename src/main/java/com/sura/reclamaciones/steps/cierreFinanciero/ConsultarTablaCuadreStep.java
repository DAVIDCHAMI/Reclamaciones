package com.sura.reclamaciones.steps.cierreFinanciero;

import com.sura.reclamaciones.DAO.ConsultarTablaCuadre;
import com.sura.reclamaciones.models.Credencial;
import com.sura.reclamaciones.models.TablaCuadre;
import com.sura.reclamaciones.utils.ConexionBaseDatosUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ConsultarTablaCuadreStep {
  Connection conexion = null;
  ConsultarTablaCuadre consultarTablaCuadre = new ConsultarTablaCuadre();
  TablaCuadre tablaCuadre;


  public void consultarMovimiento(String numeroTransacion, List<Credencial> credenciales)
      throws SQLException {
    credenciales.forEach(
        datoCredencial -> {
          conexion =
              ConexionBaseDatosUtil.conectarBaseDatos(
                  datoCredencial.getUsuario(), datoCredencial.getContrasena());
        });
    tablaCuadre =  new TablaCuadre(consultarTablaCuadre.consultarTransaccion(conexion, numeroTransacion));
  }
}
