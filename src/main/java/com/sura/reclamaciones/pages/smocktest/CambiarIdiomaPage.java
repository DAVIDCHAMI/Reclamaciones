package com.sura.reclamaciones.pages.smocktest;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CambiarIdiomaPage extends GeneralPage {

    public CambiarIdiomaPage(WebDriver driver) {
        super(driver);
    }

    private String tipoIdioma = "//div/a/span[contains(.,'COMODIN')]/../..";

    @FindBy(id = ":TabLinkMenuButton")
    private WebElementFacade btnAjuste;

    @FindBy(id = "TabBar:LanguageTabBarLink-textEl")
    private WebElementFacade linkInternacional;

    @FindBy(id = "TabBar:LanguageTabBarLink:languageSwitcher-textEl")
    private WebElementFacade linkIdioma;

    @FindBy(
            xpath =
                    "//div[@class='x-component x-header-text-container x-container-text-container x-container-text-container-default x-box-item x-component-default']/span/span"
    )
    private WebElementFacade letraComprobante;

    @FindBy(xpath = "//span[@id ='TabBar:LanguageTabBarLink:languageSwitcher:0:langs-textEl']")
    private WebElementFacade linkSeleccionarLenguaje;

    public void cliquearBtnConfiguraciones() {
        btnAjuste.click();
    }

    public void cliquearLinkInternacional() {
        linkInternacional.click();
    }

    public void cliquearLinkIdioma() {
        linkIdioma.click();
    }

    public String seleccionarIdioma() {
        if (linkSeleccionarLenguaje.getText().equals("English (US)")) {
            tipoIdioma = tipoIdioma.replace("COMODIN", "Spanish (CO)");
            $(tipoIdioma).click();
        } else {
            tipoIdioma = tipoIdioma.replace("COMODIN", "(US)");
            $(tipoIdioma).click();
        }
        return letraComprobante.waitUntilVisible().getText();
    }
}
