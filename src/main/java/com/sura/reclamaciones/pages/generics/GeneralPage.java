package com.sura.reclamaciones.pages.generics;

import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class GeneralPage extends PageObject {

  private String XpathPruebaLoader = "//div[contains(@class,'x-mask x-mask-fixed')]";

  @FindBy(xpath = "//div[contains(@class,'x-mask x-mask-fixed')]")
  WebElementFacade pruebaLoader;

  @FindBy(xpath = "//span[@id='FNOLWizard:Next-btnInnerEl']")
  private WebElementFacade btnSiguiente;

  WebDriver driver;

  public GeneralPage(WebDriver wdriver) {
    super(wdriver);
    driver = wdriver;
  }

  protected void escribirDato(WebElementFacade elemento, String dato) {
    elemento.type(dato);
  }

  public void clickElemento(WebElementFacade elemento) {
    elemento.click();
  }

  protected void seleccionarElemento(WebElementFacade elemento, String dato) {
    elemento.selectByVisibleText(dato);
  }

  public void seleccionarElementoContenido(
      String xPathContenedorElementos, String xPathTipoElemento, String textoOpcionASeleccionar) {
    int indiceElemento = 0;
    List<WebElementFacade> listaElementos =
        findAll(By.xpath(xPathContenedorElementos + "/" + xPathTipoElemento));
    for (indiceElemento = 0; indiceElemento < listaElementos.size(); indiceElemento++) {
      if (listaElementos
          .get(indiceElemento)
          .getTextValue()
          .trim()
          .equalsIgnoreCase(textoOpcionASeleccionar)) {
        break;
      }
    }
    $(xPathContenedorElementos + "/" + xPathTipoElemento + "[" + indiceElemento + "]").click();
  }

  public void realizarEsperaCarga() {
    pruebaLoader.waitUntilPresent().waitUntilNotVisible();
  }

  public void continuarSiguientePantalla() {
    btnSiguiente.waitUntilClickable();
    btnSiguiente.click();
    realizarEsperaCarga();
  }
}
