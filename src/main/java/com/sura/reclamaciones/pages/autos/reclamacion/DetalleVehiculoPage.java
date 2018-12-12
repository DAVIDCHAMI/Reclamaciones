package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.PersonaReclamacionAuto;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DetalleVehiculoPage extends GeneralPage {

  CrearServicioPage crearServicioPage;

  @FindBy(
    xpath =
        "//span[@class='x-btn-button']/span[@class='x-btn-inner x-btn-inner-center' and contains(.,'conductor')]"
  )
  WebElementFacade btnAgregarConductor;

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:ClaimContactPerson-inputEl']/../following-sibling::td"
  )
  WebElementFacade cmbPersona;

  @FindBy(
    xpath =
        "//div[contains(@class,'x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box')]//ul/li/following-sibling::li"
  )
  WebElementFacade lstNombrePersona;

  @FindBy(xpath = "//input[@class='x-form-field x-form-checkbox x-form-cb']")
  WebElementFacade chkServicioTaller;

  @FindBy(
    xpath = "//span[@class='x-btn-inner x-btn-inner-center' and contains(.,'Agregar Taller')]"
  )
  WebElementFacade btnAgregarTaller;

  @FindBy(id = "OtherServiceRequestPopup:NewServiceRequestDV:btnSearchProvider-btnInnerEl")
  WebElementFacade btnBuscarProveedor;

  @FindBy(
    id =
        "FNOLVehicleIncidentPopup:FNOLVehicleIncidentScreen:VehicleDetailInputSet:Vehicle_LicensePlate-inputEl"
  )
  WebElementFacade txtPlaca;

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
    id =
        "FNOLVehicleIncidentPopup:FNOLVehicleIncidentScreen:VehicleDetailInputSet:fasecoldaGet-btnInnerEl"
  )
  WebElementFacade btnRecuperarInformacion;

  public DetalleVehiculoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void agregarConductor() {
    btnAgregarConductor.waitUntilVisible().click();
    seleccionarConductor();
  }

  public void agregarConductorVehiculoAfectado(
      List<PersonaReclamacionAuto> datosPersonaReclamacion,
      List<ReclamacionAuto> datosReclamacionAuto) {
    datosPersonaReclamacion.forEach(
        conductor -> {
          btnAgregarConductor.waitUntilVisible().click();
          cmbTipoDocumento.clear();
          cmbTipoDocumento.sendKeys(conductor.getTipoDocumento());
          cmbTipoDocumento.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          txtNumeroDocumento.sendKeys(conductor.getNumeroDocumento());
          txtPrimerNombre.sendKeys(conductor.getPrimerNombre());
          txtPrimerApellido.sendKeys(conductor.getPrimerApellido());
          realizarEsperaCarga();
        });
    datosReclamacionAuto.forEach(
        direccionConductor -> {
          cmbDepartamento.clear();
          cmbDepartamento.sendKeys(direccionConductor.getDepartamento());
          cmbDepartamento.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          cmbCiudad.clear();
          cmbCiudad.sendKeys(direccionConductor.getCiudad());
          cmbCiudad.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          txtDireccion.sendKeys(direccionConductor.getDireccion());
          realizarEsperaCarga();
          cmbTipoDireccion.clear();
          cmbTipoDireccion.sendKeys(direccionConductor.getTipoDireccion());
          cmbTipoDireccion.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          aceptarOpcion();
        });
  }

  private void seleccionarConductor() {
    cmbPersona.waitUntilVisible().click();
    lstNombrePersona.click();
    realizarEsperaCarga();
    aceptarOpcion();
    realizarEsperaCarga();
  }

  public void seleccionarTaller(String taller) {
    seleccionarServicioTaller();
    agregarTaller();
    buscarProveedor();
    realizarEsperaCarga();
    crearServicioPage.seleccionarProveedor(taller);
    realizarEsperaCarga();
    aceptarOpcion();
    realizarEsperaCarga();
  }

  private void buscarProveedor() {
    btnBuscarProveedor.waitUntilVisible().click();
    realizarEsperaCarga();
    btnBuscarProveedor.waitUntilVisible().click();
  }

  public void ingresarVehiculoTercero(List<ExposicionVehiculoTercero> datosExposicionTercero) {
    datosExposicionTercero.forEach(
        placaVehiculoTercero -> {
          txtPlaca.sendKeys(placaVehiculoTercero.getPlacaTercero());
          realizarEsperaCarga();
          btnRecuperarInformacion.waitUntilVisible().click();
          realizarEsperaCarga();
        });
  }

  private void agregarTaller() {
    btnAgregarTaller.waitUntilVisible().click();
  }

  private void seleccionarServicioTaller() {
    chkServicioTaller.waitUntilVisible().click();
  }

  public void volverPasoAnterior() {
    aceptarOpcion();
    realizarEsperaCarga();
  }
}
