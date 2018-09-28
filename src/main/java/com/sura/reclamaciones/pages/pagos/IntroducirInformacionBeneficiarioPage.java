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

  @FindBy(xpath = "//input[contains(@class, 'x-form-field x-form-radio x-form-cb')]")
  private WebElementFacade rbtPago;

  @FindBy(
    xpath =
        "//div[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:contactEFTLVid:ContactEFTSAPCheckLV']"
  )
  private WebElementFacade tblCuentaElectronica;

  private String PAIS = "Country-inputEl";
  private String DEPARTAMENTO = "State-inputEl";
  private String CIUDAD = "Sura_Colombian_City-inputEl";
  private String TIPO_DIRECCION = "Address_AddressType-inputEl";

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
          obtenerElementoTablaDatoDesconocido(tblCuentaElectronica, strCuenta, 1);
      elementoEncontrado
          .get(0)
          .findElement(By.xpath("//a[contains(.,'" + strSeleccionar + "')]"))
          .click();
    }
    realizarEsperaCarga();
  }

  public void obtenerElementoPantallaPago(String strElementoPantallaPago) {

    rbtPago.waitUntilClickable();
    rbtPago
        .findElement(
            By.xpath(
                "//following-sibling::label[contains( .,'"
                    + strElementoPantallaPago
                    + "')]//preceding-sibling::input"))
        .click();
  }

  public void seleccionarPagoSura(String strPagoSura) {
    rbtPago.waitUntilClickable();
    obtenerElementoPantallaPago(strPagoSura);
  }

  public void seleccionarPais(String strPais) {
    seleccionarElementoListado(PAIS, strPais);
  }

  public void seleccionarDepartamento(String strDepartamento) {
    seleccionarElementoListado(DEPARTAMENTO, strDepartamento);
  }

  public void seleccionarCiudad(String strCiudad) {
    seleccionarElementoListado(CIUDAD, strCiudad);
  }

  public void seleccionarTipoDireccion(String strTipoDireccion) {
    seleccionarElementoListado(TIPO_DIRECCION, strTipoDireccion);
  }
}
