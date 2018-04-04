package com.sura.produccion.runners.mrcback.dllo;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/ejemplos/HacerListaMercado.feature")
public class HacerListaMercadoRunner {}
