package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_ANULACION;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DatoRecuperacionPage extends GeneralPage {

  @FindBy(xpath = "//span[@class='x-btn-button']//span[contains(text(),'Anular')]//parent::span")
  private WebElementFacade btnAnular;

  @FindBy(xpath = "//span[@class='x-btn-button']//span[contains(text(),'Aceptar')]")
  private WebElementFacade btnAceptar;

  public DatoRecuperacionPage(WebDriver wdriver) {
    super(wdriver);
  }

  private void anularRecupero() {
    realizarEsperaCarga();
    btnAnular.waitUntilClickable();
    btnAnular.click();
    realizarEsperaCarga();
    btnAnular.waitUntilClickable();
    btnAnular.click();
    realizarEsperaCarga();
    btnAceptar.waitUntilClickable();
    btnAceptar.click();
    realizarEsperaCarga();
  }

  public boolean realizarAnulacionRecupero() {
    for (int i = 0; i <= Integer.parseInt(ITERACIONES_ANULACION.getValor()); i++)
      if (btnAnular.isVisible()) {
        anularRecupero();
        return true;
      } else {
        driver.navigate().refresh();
      }
    return false;
  }
}
