package com.sura.reclamaciones.pages.smocktest;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

public class CambiarIdiomaPage extends GeneralPage {

  public CambiarIdiomaPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = ":TabLinkMenuButton")
  private WebElementFacade btnAjuste;

  @FindBy(id = "TabBar:LanguageTabBarLink-textEl")
  private WebElementFacade linkInternacional;

  @FindBy(id = "TabBar:LanguageTabBarLink:languageSwitcher-textEl")
  private WebElementFacade linkIdioma;

  @FindBy(xpath = "//div/a/span[contains(.,'Inglés (US)')]")
  private WebElementFacade linkIngles;

  @FindBy(xpath = "//div/span/span[contains(.,'Activities')]")
  private WebElementFacade letraComprobante;

  public void cliquearBtnConfiguraciones() {
    clickElemento(btnAjuste);
  }

  public void cliquearLinkInternacional() {
    clickElemento(linkInternacional);
  }

  public void cliquearLinkIdioma() {
    clickElemento(linkIdioma);
  }

  public void cliquearlinkIngles() {
    clickElemento(linkIngles);
  }

  public void comprobarTextoPantalla() {
    MatcherAssert.assertThat(
        "No se encontro el texto a verificar", letraComprobante.getText().equals("Activities"));
  }
}
