package com.sura.reclamaciones.pages.pagos;

import static com.sura.reclamaciones.utils.Utilidades.obtenerFechaActual;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class EstablecerInstruccionPagoPage extends GeneralPage {

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckInstructionsScreen:NewPaymentInstructionsDV:CheckWizardCheckSummaryInputSet:Check_DateOfService-inputEl']"
  )
  private WebElementFacade txtFechaPago;

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckInstructionsScreen:NewPaymentInstructionsDV:CheckWizardCheckSummaryInputSet:Check_InvoiceNumber-inputEl']"
  )
  private WebElementFacade txtNumeroFactura;

  public EstablecerInstruccionPagoPage(WebDriver driver) {
    super(driver);
  }

  public void ingresarFechaFactura() {
    txtFechaPago.waitUntilClickable();
    txtFechaPago.sendKeys(obtenerFechaActual());
  }

  public void ingresarNumeroFactura(String strNumeroFactura) {
    txtNumeroFactura.click();
    txtNumeroFactura.sendKeys(strNumeroFactura);
  }
}
