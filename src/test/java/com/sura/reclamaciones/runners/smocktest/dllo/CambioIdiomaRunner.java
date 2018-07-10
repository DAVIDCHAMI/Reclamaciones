package com.sura.reclamaciones.runners.smocktest.dllo;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/smocktest/CambioIdioma.feature",
  glue = {"com.sura.reclamaciones.definitions"}
)
public class CambioIdiomaRunner {}
