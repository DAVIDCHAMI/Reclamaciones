package com.sura.reclamaciones.pages.pagos;

import static com.sura.reclamaciones.utils.Utilidades.obtenerFechaActual;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TOTAL_PAGO_RESERVAS;

import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import net.serenitybdd.core.Serenity;
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
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckInstructionsScreen:NewPaymentInstructionsDV:CheckWizardCheckSummaryInputSet:ScheduledPayDate_Ext-inputEl']"
  )
  private WebElementFacade txtFechaPosiblePago;

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckInstructionsScreen:NewPaymentInstructionsDV:CheckWizardCheckSummaryInputSet:Check_InvoiceNumber-inputEl'][contains(@class,'x-form-field x-form-text')]"
  )
  private WebElementFacade txtNumeroFactura;

  @FindBy(
    xpath =
        "//div[@id='NormalCreateCheckWizard:CheckWizard_CheckInstructionsScreen:NewPaymentInstructionsDV:CheckWizardCheckSummaryInputSet:Amount_Net-inputEl'][contains(@class,'x-form-display-field')]"
  )
  private WebElementFacade txtMontoNeto;

  public EstablecerInstruccionPagoPage(WebDriver driver) {
    super(driver);
  }

  public void obtenerPagoReservas() {
    String totalPagoReservas = txtMontoNeto.getText();
    totalPagoReservas = totalPagoReservas.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    Serenity.setSessionVariable(SESION_CC_TOTAL_PAGO_RESERVAS.getValor()).to(totalPagoReservas);
  }

  public void ingresarFechaFactura() {
    if (txtFechaPago.isVisible()) {
      txtFechaPago.waitUntilClickable();
      txtFechaPago.sendKeys(obtenerFechaActual());
    }
  }

  public void ingresarNumeroFactura(String strNumeroFactura) {
    txtNumeroFactura.click();
    txtNumeroFactura.sendKeys(strNumeroFactura);
  }
}
