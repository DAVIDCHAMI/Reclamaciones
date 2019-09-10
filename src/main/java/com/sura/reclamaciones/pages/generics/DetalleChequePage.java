package com.sura.reclamaciones.pages.generics;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_ANULACION;

public class DetalleChequePage extends GeneralPage {

    @FindBy(xpath = "//span[@class='x-btn-button']//span[contains(text(),'Anular')]//parent::span")
    private WebElementFacade btnAnular;

    @FindBy(xpath = "//span[@class='x-btn-button']//span[contains(text(),'Aceptar')]")
    private WebElementFacade btnAceptar;

    public DetalleChequePage(WebDriver wdriver) {
        super(wdriver);
    }

    private void anularCheque() {
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

    public boolean realizarAnulacionCheque() {
        for (int i = 0; i <= Integer.parseInt(ITERACIONES_ANULACION.getValor()); i++)
            if (btnAnular.containsElements(
                    By.xpath(
                            "//span[@class='x-btn-button']//span[contains(text(),'Anular')]//ancestor::a[contains(@class,'disabled')]"))) {
                realizarEsperaCarga();
                driver.navigate().refresh();
            } else {
                anularCheque();
                return true;
            }
        return false;
    }
}
