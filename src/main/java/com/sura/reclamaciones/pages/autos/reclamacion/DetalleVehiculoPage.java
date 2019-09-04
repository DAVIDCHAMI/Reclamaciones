package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
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
    }

    public void seleccionarConductorVehiculoAsegurado() {
        seleccionarConductor();
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
        realizarEsperaCarga();
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
        realizarEsperaCarga();
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
