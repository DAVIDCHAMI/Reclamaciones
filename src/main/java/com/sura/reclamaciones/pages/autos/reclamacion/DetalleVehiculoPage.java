package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
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
  WebElementFacade chkServicio;

  @FindBy(
    xpath = "//span[@class='x-btn-inner x-btn-inner-center' and contains(.,'Agregar Taller')]"
  )
  WebElementFacade btnAgregarTaller;

  @FindBy(id = "OtherServiceRequestPopup:NewServiceRequestDV:btnSearchProvider-btnInnerEl")
  WebElementFacade btnBuscarProveedor;

  @FindBy(xpath = ".//span[@class='x-btn-inner x-btn-inner-center' and contains(.,'Aceptar')]")
  WebElementFacade btnAceptar;

  public DetalleVehiculoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void agregarConductor() {
    btnAgregarConductor.waitUntilVisible().click();
    seleccionarConductor();
  }

  private void seleccionarConductor() {
    cmbPersona.waitUntilVisible().click();
    lstNombrePersona.click();
    realizarEsperaCarga();
    btnAceptar.click();
    realizarEsperaCarga();
  }

  public void seleccionarTaller(String taller) {
    seleccionarServicios();
    agregarTaller();
    buscarProveedor();
    crearServicioPage.seleccionarProveedor(taller);
    realizarEsperaCarga();
    btnAceptar.click();
    realizarEsperaCarga();
  }

  private void buscarProveedor() {
    btnBuscarProveedor.waitUntilVisible().click();
    realizarEsperaCarga();
  }

  private void agregarTaller() {
    btnAgregarTaller.waitUntilVisible().click();
  }

  private void seleccionarServicios() {
    chkServicio.waitUntilVisible().click();
  }

  public void agregarInformacion() {
    btnAceptar.click();
    realizarEsperaCarga();
  }
}
