package com.sura.produccion.runners.mrcback.dllo.definitions;

import com.sura.produccion.steps.ejemplos.UnUsuarioSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class HacerListaMercadoDefinitions {
  @Steps UnUsuarioSteps jane;

  @Given("^necesito (.*)$")
  public void hacerAlgo(String necesidad) throws Throwable {
    jane.abrirAplicacionTodo();
  }

  @When("^agrego el articulo (.*)$")
  public void agregarElemento(String articulo) throws Throwable {
    jane.agregarElemento(articulo);
  }

  @Then("^el articulo (.*), debe ser agregado a mi lista de TODO$")
  public void articuloAgregadoATodo(String articulo) throws Throwable {
    jane.debeVerElElemento(articulo);
  }
}
