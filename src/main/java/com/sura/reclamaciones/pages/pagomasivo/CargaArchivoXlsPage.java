package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CargaArchivoXlsPage extends GeneralPage
{
    @FindBy(xpath =  ".//a[contains(@class,'x-btn x-form-file-btn x-unselectable x-btn-default-small x-noicon x-btn-noicon x-btn-default-small-noicon')]")
    private WebElementFacade btnExaminar;

    public CargaArchivoXlsPage (WebDriver wdriver)
    {
        super(wdriver);
    }

    public void seleccionarArchivoXls()
    {
        btnExaminar.waitUntilClickable();
        btnExaminar.click();
    }
}


