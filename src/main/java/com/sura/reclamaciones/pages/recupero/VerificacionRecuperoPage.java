package com.sura.reclamaciones.pages.recupero;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

  public boolean validarRecupero(String estadoRecupero) {
    tblVerificacionRecupero.sendKeys("F5");
    if (btnCambioPagina.isCurrentlyVisible() == true) {
      btnCambioPagina.click();
    }
    List<WebElement> lstElementos = tblVerificacionRecupero.findElements(By.tagName("td"));
    for (int i = 0; i < lstElementos.size(); i++) {
      if (lstElementos.get(i).getText().equals(estadoRecupero)) {
        i = lstElementos.size();
        return true;
      }
    }
    return false;
  }
}
