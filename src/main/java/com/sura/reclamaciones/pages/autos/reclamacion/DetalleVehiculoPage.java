package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DetalleVehiculoPage extends GeneralPage {

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
    id =
        "FNOLVehicleIncidentPopup:FNOLVehicleIncidentScreen:VehicleDetailInputSet:fasecoldaGet-btnInnerEl"
  )
  WebElementFacade btnRecuperarInformacion;

  public DetalleVehiculoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void agregarConductor() {
    btnAgregarConductor.waitUntilVisible().click();
  }

  public void seleccionarConductorVehiculoAsegurado() {
    seleccionarConductor();
  }

  private void seleccionarConductor() {
    cmbPersona.waitUntilVisible().click();
    lstNombrePersona.click();
    realizarEsperaCarga();
    aceptarOpcion();
    realizarEsperaCarga();
  }

  public void buscarProveedor() {
    btnBuscarProveedor.waitUntilVisible().click();
    realizarEsperaCarga();
  }

  public void ingresarVehiculoTercero(String placa) {
    txtPlaca.sendKeys(placa);
    realizarEsperaCarga();
  }

  public void recuperarInformacionVehiculo() {
    btnRecuperarInformacion.waitUntilVisible().click();
    realizarEsperaCarga();
  }

  public void agregarTaller() {
    btnAgregarTaller.waitUntilVisible().click();
  }

  public void seleccionarServicioTaller() {
    chkServicioTaller.waitUntilVisible().click();
  }

  public void volverPasoAnterior() {
    aceptarOpcion();
    realizarEsperaCarga();
  }
}
