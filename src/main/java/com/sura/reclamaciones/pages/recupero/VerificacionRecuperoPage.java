package com.sura.reclamaciones.pages.recupero;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static javafx.scene.input.KeyCode.F5;

public class VerificacionRecuperoPage extends GeneralPage {

  public VerificacionRecuperoPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(
    xpath =
        "//div[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV-body']//tr[last()]"
  )
  private WebElementFacade tblVerificacionRecupero;

  @FindBy(xpath = "//span[@class='x-btn-icon-el x-tbar-page-last ']")
  private WebElementFacade btnCambioPagina;

  public boolean validarRecupero(String datoValidar) {
  // if (btnCambioPagina.isCurrentlyVisible()) {
   //   btnCambioPagina.click();
    //}
    List<WebElement> lstElementos = tblVerificacionRecupero.findElements(By.tagName("td"));
    for (int i = 0; i < lstElementos.size(); i++) {
      if (lstElementos.get(i).getText().equals(datoValidar)) {
        return true;
      }
      break;
    }
    return false;
  }
}
