package com.sura.reclamaciones.steps.modelosimplificado;

import com.sura.reclamaciones.pages.modelosimplificado.ConsultarModeloSimplificadoPage;
import com.sura.reclamaciones.querys.Query;
import com.sura.reclamaciones.utils.ConexionBaseDatosUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.thucydides.core.annotations.Step;

public class ConsultarModeloSimplificadoStep {


  @Step
  public Connection connection () throws SQLException {
    Connection conexion=null;
    return conexion= ConexionBaseDatosUtil.conectar();

  }

  public  ResultSet consultar (Connection bd, String transaccion) throws SQLException {
    ConsultarModeloSimplificadoPage consultarModeloSimplificado=null ;
    ResultSet resultSet= consultarModeloSimplificado.consultaModeloSimplificado(bd,transaccion);
    return resultSet;
  }

  public void verficarConsulta(ResultSet rs) throws SQLException {
    Map<Integer, ArrayList<String>> datos = new HashMap<Integer, ArrayList<String>>();
    ArrayList<String> fila = new ArrayList<String>();
    int z=1;
    while(rs.next()) {
        for (int y = 1; y <= rs.getMetaData().getColumnCount(); y++) {
          String dato = rs.getString(y);
          fila.add(y - 1, dato);
        }
        datos.put(z,fila);
        z++;
     System.out.println(datos + " ");
        //System.out.println (" dato " + y + " "+ rs.getString(y)+ "\t");
    }

    //System.out.println(datos + " ");
  }
  }

