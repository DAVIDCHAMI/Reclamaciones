package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class EstablecerInstruccionPagoPage extends GeneralPage {

    public EstablecerInstruccionPagoPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckInstructionsScreen:NewPaymentInstructionsDV:CheckWizardCheckSummaryInputSet:Check_DateOfService-inputEl']")
    private WebElementFacade txtFechaPago;

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckInstructionsScreen:NewPaymentInstructionsDV:CheckWizardCheckSummaryInputSet:Check_DateOfService-inputEl']")
    private WebElementFacade txtNumeroFactura;



}
