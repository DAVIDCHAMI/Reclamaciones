package com.sura.reclamaciones.pages.generics;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CalculadoraCodigoFasecoldaPage extends GeneralPage
{

    @FindBy(xpath = "//ul[@class='x-list-plain']")
    private WebElementFacade lstClaseVehiculo;

    @FindBy(xpath= "x-boundlist-list-ct x-unselectable"
    )
    private WebElementFacade tblPlacasVehiculosInvolucrados;
    public CalculadoraCodigoFasecoldaPage(WebDriver wdriver) {
        super(wdriver);
    }

    public void seleccionarTipoMoneda(String tipoMoneda) {
        cmbTipoMoneda.click();
        lstTipoMoneda
                .findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + tipoMoneda + "')]"))
                .click();
    }
    x-boundlist-list-ct x-unselectable
    //*[@id="boundlist-1514-listEl"]

}
