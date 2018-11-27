package com.sura.reclamaciones.runners.uat.claimcenter.lote2autos;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/autos/siniestro_dano.feature",
  glue = {"com.sura.reclamaciones.definitions"},
  tags = {"@pruebaRegresion"}
)
public class SiniestroDanoRunner {}
