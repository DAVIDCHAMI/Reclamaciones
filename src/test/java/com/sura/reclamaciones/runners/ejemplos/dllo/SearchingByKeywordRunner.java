package com.sura.reclamaciones.runners.ejemplos.dllo;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/ejemplos/SearchingByKeyword.feature",
  glue = {"com.sura.reclamaciones.definitions"}
)
public class SearchingByKeywordRunner {}
