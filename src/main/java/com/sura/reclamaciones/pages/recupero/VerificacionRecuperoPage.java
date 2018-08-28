package com.sura.reclamaciones.pages.recupero;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
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

  @FindBy(xpath = "//body")
  private WebElementFacade actualizar;

  public boolean validarRecupero(String datoValidar) {
    if (btnCambioPagina.isVisible()) {
      btnCambioPagina.waitUntilClickable();
      btnCambioPagina.click();
    }
    actualizar.sendKeys(Keys.F5);
    List<WebElement> lstFilaRecupero = tblVerificacionRecupero.findElements(By.tagName("td"));
    for (WebElement e : lstFilaRecupero) {
      if (e.getText().equals(datoValidar)) {
        return true;
      }
    }
    return false;
  }
}
