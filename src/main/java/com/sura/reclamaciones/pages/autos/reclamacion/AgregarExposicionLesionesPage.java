package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AgregarExposicionLesionesPage extends GeneralPage {

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuredBoolean_true-inputEl']"
  )
  WebElementFacade chkLesiones;

  @FindBy(
    xpath =
        "//span[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:AddPedestrianButton-btnInnerEl']"
  )
  WebElementFacade btnAgregarPeaton;

  @FindBy(
    xpath =
        "//td[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:DocumentType_Ext-inputCell']//input"
  )
  WebElementFacade cmbTipoDocumento;

  @FindBy(xpath = "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:TaxID-inputEl']")
  WebElementFacade txtNumeroDocumento;

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:GlobalPersonNameInputSet:FirstName-inputEl']"
  )
  WebElementFacade txtPrimerNombre;

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:GlobalPersonNameInputSet:LastName-inputEl']"
  )
  WebElementFacade txtPrimerApellido;

  @FindBy(
    xpath =
        "//td[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:State-inputCell']//input"
  )
  WebElementFacade cmbDepartamento;

  @FindBy(
    xpath =
        "//td[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Sura_Colombian_City-inputCell']//input"
  )
  WebElementFacade cmbCiudad;

  @FindBy(
    xpath =
        "//td[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:CCAddressInputSet:globalAddressContainer:Address_AddressType-inputCell']//input"
  )
  WebElementFacade cmbTipoDireccion;

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:AddressLine1-inputEl']"
  )
  WebElementFacade txtDireccion;

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:Severity-inputEl']"
  )
  WebElementFacade cmbGravedadLesion;

  @FindBy(
    xpath =
        "//textarea[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:InjuryDescription-inputEl']"
  )
  WebElementFacade txtDescribirLesiones;

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:PrimaryInjuryType-inputEl']"
  )
  WebElementFacade cmbTipoLesion;

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:DetailedInjuryType-inputEl']"
  )
  WebElementFacade cmbDetalleLesion;

  public AgregarExposicionLesionesPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void agregarPersonaLesionada() {
    btnAgregarPeaton.waitUntilVisible().click();
  }

  public void seleccionarTipoDocumento(String tipoDocumento) {
    cmbTipoDocumento.clear();
    cmbTipoDocumento.sendKeys(tipoDocumento);
    cmbTipoDocumento.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void ingresarNumeroDocumento(String numDocumento) {
    txtNumeroDocumento.sendKeys(numDocumento);
  }

  public void ingresarPrimerNombre(String primerNombre) {
    txtPrimerNombre.sendKeys(primerNombre);
  }

  public void ingresarPrimerApellido(String primerApellido) {
    txtPrimerApellido.sendKeys(primerApellido);
  }

  public void seleccionarDepartamento(String departamento) {
    cmbDepartamento.clear();
    cmbDepartamento.sendKeys(departamento);
    cmbDepartamento.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void seleccionarCiudad(String ciudad) {
    cmbCiudad.clear();
    cmbCiudad.sendKeys(ciudad);
    cmbCiudad.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void ingresarDireccion(String direccion) {
    txtDireccion.sendKeys(direccion);
    realizarEsperaCarga();
  }

  public void seleccionarTipoDireccion(String tipoDireccion) {
    cmbTipoDireccion.clear();
    cmbTipoDireccion.sendKeys(tipoDireccion);
    cmbTipoDireccion.sendKeys(Keys.ENTER);
  }

  public void seleccionarLesiones() {
    chkLesiones.waitUntilVisible().click();
  }

  public void seleccionarGravedadLesion(String gravedadLesion) {
    cmbGravedadLesion.clear();
    cmbGravedadLesion.sendKeys(gravedadLesion);
    cmbGravedadLesion.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void ingresarDescripcionLesiones(String describirLesiones) {
    txtDescribirLesiones.sendKeys(describirLesiones);
  }

  public void seleccionarTipoLesion(String tipoLesion) {
    cmbTipoLesion.clear();
    cmbTipoLesion.sendKeys(tipoLesion);
    cmbTipoLesion.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void seleccionarDetalleLesion(String detallesTipoLesion) {
    cmbDetalleLesion.clear();
    cmbDetalleLesion.sendKeys(detallesTipoLesion);
    cmbDetalleLesion.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void finalizarExposicion() {
    aceptarOpcion();
    realizarEsperaCarga();
  }
}
