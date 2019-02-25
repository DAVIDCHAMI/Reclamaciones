package com.sura.reclamaciones.pages.smocktest;

import static com.sura.reclamaciones.constantes.Constantes.COMODIN;
import static com.sura.reclamaciones.constantes.Constantes.ENGLISH;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CambiarIdiomaPage extends GeneralPage {

  private String tipoIdioma = "//div/a/span[contains(.,'COMODIN')]/../..";

  @FindBy(id = ":TabLinkMenuButton")
  private WebElementFacade btnAjuste;

  @FindBy(id = "TabBar:LanguageTabBarLink-textEl")
  private WebElementFacade lnkInternacional;

  @FindBy(id = "TabBar:LanguageTabBarLink:languageSwitcher-textEl")
  private WebElementFacade lnkIdioma;

  @FindBy(
    xpath =
        "//div[@class='x-component x-header-text-container x-container-text-container x-container-text-container-default x-box-item x-component-default']/span/span"
  )
  private WebElementFacade letraComprobante;

  @FindBy(xpath = "//span[@id ='TabBar:LanguageTabBarLink:languageSwitcher:0:langs-textEl']")
  private WebElementFacade linkSeleccionarLenguaje;

  public CambiarIdiomaPage(WebDriver driver) {
    super(driver);
  }

  public void ingresarConfiguraciones() {
    btnAjuste.click();
  }

  public void elegirOpcionInternacional() {
    lnkInternacional.click();
  }

  public void elegirIdioma() {
    lnkIdioma.click();
  }

  public String seleccionarIdioma() {
    if (linkSeleccionarLenguaje.getText().equals(ENGLISH.getValor())) {
      tipoIdioma = tipoIdioma.replace(COMODIN.getValor(), "Spanish (CO)");
      $(tipoIdioma).click();
    } else {
      tipoIdioma = tipoIdioma.replace(COMODIN.getValor(), "(US)");
      $(tipoIdioma).click();
    }
    return letraComprobante.waitUntilVisible().getText();
  }
}
