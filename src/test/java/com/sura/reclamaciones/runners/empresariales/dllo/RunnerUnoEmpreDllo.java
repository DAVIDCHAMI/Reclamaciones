package com.sura.reclamaciones.runners.empresariales.dllo;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/procesosfinancieros/facturacion_por_asegurado_nueva.feature",
    glue = {"com.sura.reclamaciones.definitions"}
)

public class RunnerUnoEmpreDllo { }
