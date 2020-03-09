package com.sura.reclamaciones.pages.general;

import com.sura.reclamaciones.utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DatoReservaPage extends GeneralPage {

  @FindBy(
    xpath =
        "//div[@id='ClaimFinancialsTransactionsDetail:ClaimFinancialsTransactionsDetailScreen:TransactionDetailPanelSet:TransactionReserveDV:TransactionBasicsInputSet:Amount-inputEl']"
  )
  private WebElementFacade lblCantidad;

  public DatoReservaPage(WebDriver wdriver) {
    super(wdriver);
  }

  public String obtenerCantidadReserva() {
    String cantidadReserva = lblCantidad.getText();
    return cantidadReserva.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
  }
}
