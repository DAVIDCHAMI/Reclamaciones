package com.sura.reclamaciones.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmbientesUtil {
  final Logger logger = LoggerFactory.getLogger(AmbientesUtil.class);

  public String getAmbiente() {
    String envVariable = getEnv();
    logger.info("Ambiente en que corre el proceso. $ENV: " + envVariable);
    String ambienteValidado = ambientesValidos(envVariable);
    return ambienteValidado;
  }

  protected String getEnv() {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    return variables.getProperty("env");
  }

  public String ambientesValidos(String ambiente) {
    List<String> ambientesValidos =
        new ArrayList<String>(Arrays.asList("local", "dllo", "lab", "pdn"));
    if (ambientesValidos.contains(ambiente)) {
      return ambiente;
    } else {
      return "local";
    }
  }
}
