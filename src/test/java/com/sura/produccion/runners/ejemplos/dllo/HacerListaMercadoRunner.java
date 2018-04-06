package com.sura.produccion.runners.ejemplos.dllo;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/ejemplos/HacerListaMercado.feature",
  glue = {"com.sura.produccion.definitions"}
)
public class HacerListaMercadoRunner {}
