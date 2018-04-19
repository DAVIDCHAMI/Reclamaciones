package com.sura.reclamaciones.steps.ejemplos;

import static com.google.common.collect.Lists.newArrayList;
import static net.serenitybdd.core.pages.PageObject.withParameters;
import static org.assertj.core.api.Assertions.assertThat;

import com.sura.reclamaciones.models.ejemplos.FiltroEstado;
import com.sura.reclamaciones.pages.ejemplos.TodoPage;
import com.sura.reclamaciones.utils.AmbientesUtils;
import net.thucydides.core.annotations.Step;

public class UnUsuarioSteps {
  @Step
  public void abrirAplicacionTodo() {
    AmbientesUtils ambienteUtils = new AmbientesUtils();
    todoPage.open(ambienteUtils.getAmbiente(), withParameters(""));
  }

  TodoPage todoPage;

  @Step
  public void agregarElemento(String nombreElemento) {
    todoPage.agrearElemento(nombreElemento);
  }

  @Step
  public void agregarElementos(String... nombreElemento) {
    newArrayList(nombreElemento).forEach(action -> agregarElemento(action));
  }

  @Step
  public void debeVerElElemento(String nombreElemento) {
    assertThat(todoPage.getElementos()).contains(nombreElemento);
  }

  @Step
  public void debeVerLosElementos(String... nombreElemento) {
    assertThat(todoPage.getElementos()).containsExactly(nombreElemento);
  }

  @Step
  public void filtrarPorEstado(FiltroEstado estado) {
    todoPage.filtrarPorEstado(estado);
  }
}
