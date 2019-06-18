package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CargaArchivoXlsPage extends GeneralPage
{
    @FindBy(xpath =  ".//input[contains(@id,'textfield-')]")
    private WebElementFacade txtRutaArchivo;

    public CargaArchivoXlsPage (WebDriver wdriver)
    {
        super(wdriver);
    }

    public void seleccionarArchivoXls()
    {
        txtRutaArchivo.sendKeys("C:/Users/anammoar/Documents/PlantillaPagosMasivos.xlsx");
    }




}


