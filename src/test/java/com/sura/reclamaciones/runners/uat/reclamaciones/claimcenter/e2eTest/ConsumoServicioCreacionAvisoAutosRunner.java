package com.sura.reclamaciones.runners.uat.reclamaciones.claimcenter.e2eTest;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/autos/reclamaciones/crear_aviso_autos.feature",
    glue = {"com.sura.reclamaciones.definitions"},
    tags = {"@avisoServicioMacaNO"})
public class ConsumoServicioCreacionAvisoAutosRunner {}
