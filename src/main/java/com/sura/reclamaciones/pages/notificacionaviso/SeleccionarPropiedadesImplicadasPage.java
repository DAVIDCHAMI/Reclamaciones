package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.security.cert.X509Certificate;

public class SeleccionarPropiedadesImplicadasPage extends GeneralPage {

    public SeleccionarPropiedadesImplicadasPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td/div[@class='x-grid-cell-inner ']/div")
    private WebElementFacade rbtPropiedad;
    private String XpathRbtPropiedad = "//td/div[@class='x-grid-cell-inner ']/div";
    @FindBy(xpath = "//span[@id='FNOLWizard:FNOLWizard_PickPolicyRiskUnitsScreen:ttlBar']")
    private WebElementFacade titlePropiedadesImplicadas;
    private String XpathTitlePropiedadesImplicadas = "//span[@id='FNOLWizard:FNOLWizard_PickPolicyRiskUnitsScreen:ttlBar']";

    public void seleccionarPropiedad() {
        if (titlePropiedadesImplicadas.isPresent()) {
            waitForPresenceOf(XpathRbtPropiedad);
            rbtPropiedad.click();
            cliquearSiguiente();
        }
    }
}