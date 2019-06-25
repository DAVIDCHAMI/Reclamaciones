package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CargaArchivoXlsPage extends GeneralPage {
  @FindBy(id = "BulkPay:BulkPayScreen:CreateNewWizardButton")
  private WebElementFacade btnFacturacionMasiva;

  public CargaArchivoXlsPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void generarFacturacionMasiva() {
    btnFacturacionMasiva.waitUntilClickable();
    btnFacturacionMasiva.click();
  }
}
