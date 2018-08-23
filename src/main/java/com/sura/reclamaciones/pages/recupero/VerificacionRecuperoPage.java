package com.sura.reclamaciones.pages.recupero;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class VerificacionRecuperoPage extends GeneralPage {

  public VerificacionRecuperoPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV")
  private WebElementFacade tblVerificacionRecupero;

  public boolean validarRecupero(String estadoRecupero) {

    if (tblVerificacionRecupero.isCurrentlyVisible() == true) {
      return true;
    }
    return false;
  }
}
