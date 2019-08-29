package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;

public class CargaArchivoPagoMasivoPage extends GeneralPage {

  @FindBy(id = "BulkPay:BulkPayScreen:CreateNewWizardButton")
  private WebElementFacade btnFacturacionMasiva;

  @FindBy(
    xpath =
        ".//input[contains(@class,'x-form-file-input')]"
  )
  private WebElementFacade btnExaminar;

  public CargaArchivoPagoMasivoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void generarFacturacionMasiva() {
    btnFacturacionMasiva.waitUntilClickable();
    btnFacturacionMasiva.click();
  }

  public void buscarArchivoPagoMasivo(String rutaCompleta)
  {
//    String nombreArchivoPagoMasivo= "PlantillaPagosMasivos.xlsx";
//  File resourcesDirectory = new File("src/test/resources/files");
    WebDriverWait wait = new WebDriverWait(getDriver(),0);
    WebElement btnExaminar1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//input[@name='fileContent']")));
    btnExaminar1.sendKeys(rutaCompleta);
  }
}







