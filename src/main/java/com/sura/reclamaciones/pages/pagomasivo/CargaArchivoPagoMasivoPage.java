package com.sura.reclamaciones.pages.pagomasivo;

import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CargaArchivoPagoMasivoPage extends GeneralPage {

  @FindBy(id = "BulkPay:BulkPayScreen:CreateNewWizardButton")
  private WebElementFacade btnFacturacionMasiva;

  public CargaArchivoPagoMasivoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void generarFacturacionMasiva() {
    btnFacturacionMasiva.waitUntilClickable();
    btnFacturacionMasiva.click();
  }

  public void buscarArchivoPagoMasivo(String rutaCompleta) {
    WebDriverWait wait = new WebDriverWait(getDriver(), Integer.parseInt(VALOR_CERO.getValor()));
    WebElement btnExaminar =
        wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath(".//input[@name='fileContent']")));
    btnExaminar.sendKeys(rutaCompleta);
  }
}
