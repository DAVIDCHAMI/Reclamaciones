package com.sura.reclamaciones.utils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PageUtil extends PageObject {

  public final Actions actions = new Actions(getDriver());

  public int ConsultarNumeroElementosTabla(String pathTabla) {
    List<WebElementFacade> listaFacturas = this.getList(pathTabla);
    return listaFacturas.size();
  }

  public List<WebElementFacade> getList(String locator) {
    return withTimeoutOf(55, TimeUnit.SECONDS).findAll(locator);
  }

  public WebElementFacade getElemento(String locator) {
    return withTimeoutOf(1, TimeUnit.SECONDS).find(locator);
  }

  public WebElementFacade ConsultarElementoConIndiceConcatenadoFilaColumna(
      String path, int indiceFila, int indiceColumna) {
    return getElemento(path + "[" + indiceFila + "]" + "/td[" + indiceColumna + "]");
  }

  public String ConsultarTextoCeldaTabla(String path, int indiceFila, int indiceColumna) {
    WebElementFacade elemento =
        getElemento(path + "[" + indiceFila + "]" + "/td[" + indiceColumna + "]");
    return elemento.getText();
  }

  public boolean validarObjetoClikeableServidor(String pathElemento, int maximoEjecuciones) {
    return ValidarObjetoClikeableServidor(pathElemento, maximoEjecuciones);
  }

  public void waitUntil(int seconds) {
    Integer i = 0;
    Wait<Integer> wait =
        new FluentWait<Integer>(i)
            .withTimeout(seconds, TimeUnit.SECONDS)
            .pollingEvery(seconds, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
    try {
      wait.until(
          new Function<Integer, Boolean>() {
            public Boolean apply(Integer i) {
              return false;
            }
          });
    } catch (TimeoutException ex) {
    }
  }

  public void EsperarObjetoClikeableServidor(String pathElemento) {
    WebElementFacade elemento;
    boolean ejecuto = false;
    int maximoEjecuciones = 120;
    int ejecuciones = 0;
    while (ejecuciones < maximoEjecuciones && !ejecuto) {
      try {
        elemento = withTimeoutOf(1, TimeUnit.SECONDS).find(pathElemento);
        elemento.waitUntilClickable().click();
        ejecuto = true;
      } catch (Exception ex) {
      }
      ejecuciones = ejecuciones + 1;
    }
    if (!ejecuto) {
      MatcherAssert.assertThat("No se pudo dar click a botón", false);
    }
  }

  public boolean ValidarObjetoClikeableServidor(String pathElemento, int maximoEjecuciones) {
    WebElementFacade elemento;
    boolean ejecuto = false;
    int ejecuciones = 0;
    while (!ejecuto && ejecuciones < maximoEjecuciones) {
      try {
        elemento = withTimeoutOf(1, TimeUnit.SECONDS).find(pathElemento);
        elemento.waitUntilClickable().click();
        ejecuto = true;
      } catch (Exception ex) {
      }
      ejecuciones = ejecuciones + 1;
    }
    return ejecuto;
  }
}
