package com.sura.produccion.definitions;

import com.sura.produccion.steps.ejemplos.UnUsuarioSteps;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class HacerListaMercadoDefinitions {
  @Steps UnUsuarioSteps jane;

  @Dado("^necesito (.*)$")
  public void hacerAlgo(String necesidad) throws Throwable {
    jane.abrirAplicacionTodo();
  }

  @Cuando("^agrego el articulo (.*)$")
  public void agregarElemento(String articulo) throws Throwable {
    jane.agregarElemento(articulo);
  }

  @Entonces("^el articulo (.*), debe ser agregado a mi lista de TODO$")
  public void articuloAgregadoATodo(String articulo) throws Throwable {
    jane.debeVerElElemento(articulo);
  }
}
