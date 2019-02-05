package com.sura.reclamaciones.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class AmbientesUtil {

  public String getAmbiente() {
    String envVariable = getEnv();
    Utilidades.getLogger().info("Ambiente en que corre el proceso. $ENV: " + envVariable);
    return ambientesValidos(envVariable);
  }

  protected String getEnv() {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    return variables.getProperty("env");
  }

  public String ambientesValidos(String ambiente) {
    List<String> ambientesValidos =
        new ArrayList<String>(Arrays.asList("local", "dllo", "uat", "pdn"));
    if (ambientesValidos.contains(ambiente)) {
      return ambiente;
    } else {
      return "local";
    }
  }
}
