package com.sura.reclamaciones.runners.autos.lab;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/autos/siniestro_dano.feature",
  glue = {"com.sura.reclamaciones.definitions"}
)
public class SiniestroDano {}
