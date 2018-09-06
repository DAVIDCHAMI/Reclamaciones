package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntroducirInformacionBeneficiarioPage extends GeneralPage {

  public IntroducirInformacionBeneficiarioPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PrimaryPayee_Name-inputEl']"
  )
  private WebElementFacade cmbNombreBeneficiario;

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PrimaryPayee_Type-inputEl']"
  )
  private WebElementFacade cmbTipoBeneficiario;

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PaymentMethod_option1-inputEl']"
  )
  private WebElementFacade rbnTransferenciaElectronica;

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PaymentMethod_option2-inputEl']"
  )
  private WebElementFacade rbnPagoBanco;

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PaymentMethod_option3-inputEl']"
  )
  private WebElementFacade rbnPagoCajaSura;

  @FindBy(xpath = "//input[contains(@class, 'x-form-field x-form-radio x-form-cb')]")
  private WebElementFacade rbnPago;

  @FindBy(
    xpath =
        "//div[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:contactEFTLVid:ContactEFTSAPCheckLV']"
  )
  private WebElementFacade tblCuentaElectronica;

  public void seleccionarNombreBeneficiario(String strNombreBeneficiario) {
    cmbNombreBeneficiario.click();
    seleccionarOpcionCombobox(strNombreBeneficiario);
  }

  public void seleccionarTipoBeneficiario(String strTipoBeneficiario) {
    cmbTipoBeneficiario.waitUntilClickable().click();
    cmbTipoBeneficiario
        .findElement(By.xpath("//li[contains(.,'" + strTipoBeneficiario + "')]"))
        .click();
  }

  public void seleccionarMetodoPago(String strMetodoPago, String strCuenta, String strSeleccionar) {
    obtenerElementoPantallaPago(strMetodoPago);
    if (strMetodoPago.equals(PagoConstante.TRANSFERENCIA_ELECTRONICA)) {
      List<WebElement> elementoEncontrado =
          obtenerElementoTablaDatoDesconocido(tblCuentaElectronica, strCuenta);
      elementoEncontrado
          .get(0)
          .findElement(By.xpath("//a[contains(.,'" + strSeleccionar + "')]"))
          .click();
    }
    realizarEsperaCarga();
  }

  public void obtenerElementoPantallaPago(String strElementoPantallaPago) {

    rbnPago.waitUntilClickable();
    rbnPago
        .findElement(
            By.xpath(
                "//following-sibling::label[contains( .,'"
                    + strElementoPantallaPago
                    + "')]//preceding-sibling::input"))
        .click();
  }

  public void seleccionarPagoSura(String strPagoSura) {
    rbnPago.waitUntilClickable();
    obtenerElementoPantallaPago(strPagoSura);
  }
}
