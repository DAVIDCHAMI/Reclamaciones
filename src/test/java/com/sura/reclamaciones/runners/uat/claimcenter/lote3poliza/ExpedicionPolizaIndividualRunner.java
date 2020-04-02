package com.sura.reclamaciones.runners.uat.claimcenter.lote3poliza;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features =
      "src/test/resources/features/expedicionpoliza/expedicion_poliza_auto_individual.feature",
  glue = {"com.sura.reclamaciones.definitions"}
)
public class ExpedicionPolizaIndividualRunner {}
