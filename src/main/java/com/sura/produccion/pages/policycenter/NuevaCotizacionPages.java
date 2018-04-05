package com.sura.produccion.pages.policycenter;

import com.sura.produccion.pages.generics.GeneralPages;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NuevaCotizacionPages extends GeneralPages{

    public NuevaCotizacionPages(WebDriver wDriver) {
        super(wDriver);
    }

    @FindBy(xpath = "//input[@id='NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:ProducerSelectionInputSet:MainOffice-inputEl']")
    WebElementFacade txtOficinaRadicacion;

    @FindBy(xpath = "//input[@id='NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:ProducerSelectionInputSet:ProducerName-inputEl']" )
    WebElementFacade txtNombreAsesor;

    @FindBy(xpath = "//input[@id='NewSubmission:NewSubmissionScreen:SelectAccountAndProducerDV:ProducerSelectionInputSet:ProducerCode-inputEl']")
    WebElementFacade txtCodigoAsesor;

}
