package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PayCoinsuranceOnlySura_Ext_true-inputEl']"
  )
  private WebElementFacade rbnPagoSoloSuraSi;

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PayCoinsuranceOnlySura_Ext_false-inputEl']"
  )
  private WebElementFacade rbnPagoSoloSuraNo;

  @FindBy(xpath = "//div[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:contactEFTLVid:ContactEFTSAPCheckLV']")
  private  WebElementFacade tblCuentaElectronica;

  public void seleccionarNombreBeneficiario(String strNombreBeneficiario) {
    cmbNombreBeneficiario.click();
    seleccionarOpcionCombobox(strNombreBeneficiario);
  }

  public void seleccionarTipoBeneficiario(String strTipoBeneficiario) {
    cmbTipoBeneficiario.waitUntilClickable().click();
    cmbTipoBeneficiario.sendKeys(strTipoBeneficiario);
    cmbTipoBeneficiario.click();
  }

  public void seleccionarMetodoPago(String strMetodoPago, String strCuenta) {

    switch (strMetodoPago) {
      case PagoConstante.TRANSFERENCIA_ELECTRONICA:
        rbnTransferenciaElectronica.waitUntilClickable().click();
        List<WebElement> elementoEncontrado =
                obtenerElementoTablaDatoDesconocido(
                        tblCuentaElectronica, "", strCuenta);
        elementoEncontrado.get(0).click();
        break;
      case PagoConstante.PAGO_BANCO:
        rbnPagoBanco.waitUntilClickable().click();
        break;
      case PagoConstante.CAJA_SURA:
        rbnPagoCajaSura.waitUntilClickable().click();
        break;
    }
  }

  public void seleccionarPagoSura(String strPagoSura) {

    if (strPagoSura.equals(PagoConstante.PAGO_SURA)) {
      rbnPagoSoloSuraSi.waitUntilClickable().click();
    } else {
      rbnPagoSoloSuraNo.waitUntilClickable().click();
    }
    continuarSiguientePantalla();
  }
}
