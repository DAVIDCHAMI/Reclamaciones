package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CargaArchivoPagoMasivoPage extends GeneralPage {

  @FindBy(id = "BulkPay:BulkPayScreen:CreateNewWizardButton")
  private WebElementFacade btnFacturacionMasiva;

  @FindBy(
    xpath =
        ".//a[contains(@class,'x-btn x-form-file-btn x-unselectable x-btn-default-small x-noicon x-btn-noicon x-btn-default-small-noicon')]"
  )
  private WebElementFacade btnExaminar;

  @FindBy(xpath = "//*[contains(@ClassName,msctls_progress32') and contains(@LocalizedControlType,'barra indicadora de progreso')]")
  private WebElementFacade txtDireccionDocumento;

  public CargaArchivoPagoMasivoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void generarFacturacionMasiva() {
    btnFacturacionMasiva.waitUntilClickable();
    btnFacturacionMasiva.click();
  }

  public void buscarArchivoPagoMasivo() {
    btnExaminar.waitUntilPresent();
    btnExaminar.waitUntilClickable();
    btnExaminar.click();
  }

  public void ingresarDireccionArchivo()
  {
    //txtDireccionDocumento.waitUntilPresent();
    txtDireccionDocumento.click();
    txtDireccionDocumento.sendKeys("hola");
  }




}
