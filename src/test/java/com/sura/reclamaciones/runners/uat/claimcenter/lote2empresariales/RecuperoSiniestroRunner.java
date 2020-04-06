package com.sura.reclamaciones.runners.uat.claimcenter.lote2empresariales;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/autos/recuperos/recupero_siniestro.feature",
    glue = {"com.sura.reclamaciones.definitions"})
public class RecuperoSiniestroRunner {}
