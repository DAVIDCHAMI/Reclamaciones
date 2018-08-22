package com.sura.reclamaciones.steps.modelosimplificado;

import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.pages.modelosimplificado.ConsultarModeloSimplificadoPage;
import com.sura.reclamaciones.utils.ConexionBaseDatosUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class ConsultarModeloSimplificadoStep {

  @Page
  ConsultarModeloSimplificadoPage consultarModeloSimplificadoPage = new ConsultarModeloSimplificadoPage();

  @Step
  public Connection connection () throws SQLException {
    Connection conexion=null;
    return conexion= ConexionBaseDatosUtil.conectar();
  }


  public  ResultSet consultar (Connection bd, String transaccionConsulta) throws SQLException {
    ResultSet resultSet = consultarModeloSimplificadoPage.consultaModeloSimplificado(bd, transaccionConsulta);
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