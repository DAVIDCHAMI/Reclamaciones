package com.sura.reclamaciones.runners.empresariales.lab;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ="src/test/resources/features/conectar_base_de_datos.feature", glue = {"com.sura.conexion.definitions"})
public class ConsultaModeloSimplificadoRunner {

}
