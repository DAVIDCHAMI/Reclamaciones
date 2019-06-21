package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class ResultadoValidacionArchivoPage extends GeneralPage
{
    @FindBy(
            xpath =
                    ".//label[contains(@class,'x-component x-component-default')]"
    )
    private WebElementFacade lblNroRegistrosFactura;

    public ResultadoValidacionArchivoPage(WebDriver wdriver) {
        super(wdriver);
    }
}
