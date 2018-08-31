package com.sura.reclamaciones.runners.cierrefinanciero.lab;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/cierrefinanciero/revision_tabla_cuadre_mensaje.feature",
  glue = {"com.sura.reclamaciones.definitions"}
)
public class ConsultaTablaCuadreRunner {}
