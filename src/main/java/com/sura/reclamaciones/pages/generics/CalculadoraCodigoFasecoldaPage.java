package com.sura.reclamaciones.pages.generics;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CalculadoraCodigoFasecoldaPage extends GeneralPage
{

    @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Vehicle_VehicleType-inputEl"
    )
    private WebElementFacade cmbTipoMoneda;

    @FindBy(xpath = "//ul[@class='x-list-plain']")
    private WebElementFacade lstTipoMoneda;
    public CalculadoraCodigoFasecoldaPage(WebDriver wdriver) {
        super(wdriver);
    }

    public void seleccionarTipoMoneda(String tipoMoneda, List<ExposicionVehiculoTercero> datosVehiculoTercero) {
        cmbTipoMoneda.click();
        lstTipoMoneda
                .findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + tipoMoneda + "')]"))
                .click();
    }




}
