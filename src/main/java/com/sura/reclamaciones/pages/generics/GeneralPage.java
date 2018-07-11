package com.sura.reclamaciones.pages.generics;

import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class GeneralPage extends PageObject {

  @FindBy(xpath = "//div[contains(@class,'x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box')]/div/ul")
  private WebElementFacade lstOpcionesCombobox;

  @FindBy(xpath = "//div[contains(@class,'x-mask x-mask-fixed')]")
  WebElementFacade pruebaLoader;

  WebDriver driver;

  public GeneralPage(WebDriver wdriver) {
    super(wdriver);
    driver = wdriver;
  }

  public void seleccionarOpcionCombobox(String opcion) {
    lstOpcionesCombobox.findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + opcion + "')]")).click();
  }

  public void realizarEsperaCarga() {
    pruebaLoader.waitUntilPresent().waitUntilNotVisible();
  }

}
