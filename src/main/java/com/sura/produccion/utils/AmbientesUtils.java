package com.sura.produccion.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmbientesUtils {
  final Logger logger = LoggerFactory.getLogger(AmbientesUtils.class);

  public String getAmbiente() {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    String envVariable = variables.getProperty("ENV");
    logger.info("Ambiente en que corre el proceso. $ENV: " + envVariable);
    String ambienteValidado = ambientesValidos(envVariable);
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
