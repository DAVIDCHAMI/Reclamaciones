package com.sura.produccion.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class AmbientesUtils {
  public String getAmbiente() {
    String ambiente = "local";
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    String envVariable = variables.getProperty("env");
    if (envVariable != null && envVariable.isEmpty()) {
      ambiente = envVariable;
    }
    String ambienteValidado = ambientesValidos(ambiente);
    return ambienteValidado;
  }

  public String ambientesValidos(String ambiente) {
    List<String> ambientesValidos = new ArrayList<>(Arrays.asList("local", "dllo", "lab", "pdn"));
    if (ambientesValidos.contains(ambiente)) {
      return ambiente;
    } else {
      return "local";
    }
  }
}
