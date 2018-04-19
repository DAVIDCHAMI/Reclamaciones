package com.sura.reclamaciones.pages.generics;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class GeneralPages extends PageObject {

  WebDriver driver;

  public GeneralPages(WebDriver wdriver) {
    super(wdriver);
    driver = wdriver;
  }

  protected void ingresoUrl(String url) {
    driver.navigate().to(url);
  }

  protected void escribirDato(WebElementFacade elemento, String dato) {

    elemento.type(dato);
  }

  protected void clickEnElemento(WebElementFacade elemento) {
    elemento.click();
  }

  protected void seleccionarElemento(WebElementFacade elemento, String dato) {
    elemento.selectByValue(dato);
  }
}
