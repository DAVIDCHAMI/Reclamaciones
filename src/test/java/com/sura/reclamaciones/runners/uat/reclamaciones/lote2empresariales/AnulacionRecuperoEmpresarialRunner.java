package com.sura.reclamaciones.runners.uat.reclamaciones.lote2empresariales;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/empresariales/recuperos/anular_recupero.feature",
    glue = {"com.sura.reclamaciones.definitions"},
    tags = {"@Empresarial"})
public class AnulacionRecuperoEmpresarialRunner {}
