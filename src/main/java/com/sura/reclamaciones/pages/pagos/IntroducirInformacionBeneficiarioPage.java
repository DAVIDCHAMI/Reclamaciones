package com.sura.reclamaciones.pages.pagos;

import static com.sura.reclamaciones.utils.Constantes.TRANSFERENCIA_ELECTRONICA;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntroducirInformacionBeneficiarioPage extends GeneralPage {

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

  private String pais = "Country-inputEl";
  private String departamento = "State-inputEl";
  private String ciudad = "Sura_Colombian_City-inputEl";
  private String tipoDireccion = "Address_AddressType-inputEl";

  public IntroducirInformacionBeneficiarioPage(WebDriver driver) {
    super(driver);
  }

  public void seleccionarNombreBeneficiario(String strNombreBeneficiario) {
    cmbNombreBeneficiario.click();
    seleccionarOpcionCombobox(strNombreBeneficiario);
    realizarEsperaCarga();
  }

  public void seleccionarTipoBeneficiario(String strTipoBeneficiario) {
    cmbTipoBeneficiario.waitUntilClickable().click();
    cmbTipoBeneficiario
        .findElement(By.xpath("//li[contains(.,'" + strTipoBeneficiario + "')]"))
        .click();
    realizarEsperaCarga();
  }

  public void seleccionarMetodoPago(String strMetodoPago, String strCuenta, String strSeleccionar) {
    obtenerElementoPantallaPago(strMetodoPago);
    if (strMetodoPago.equals(TRANSFERENCIA_ELECTRONICA.getValor())) {
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
    seleccionarElementoListado(pais, strPais);
  }

  public void seleccionarDepartamento(String strDepartamento) {
    seleccionarElementoListado(departamento, strDepartamento);
  }

  public void seleccionarCiudad(String strCiudad) {
    seleccionarElementoListado(ciudad, strCiudad);
  }

  public void seleccionarTipoDireccion(String strTipoDireccion) {
    seleccionarElementoListado(tipoDireccion, strTipoDireccion);
  }
}
