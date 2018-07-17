package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DetalleVehiculoPage extends GeneralPage {

    public DetalleVehiculoPage(WebDriver wdriver) {
        super(wdriver);
    }

    CrearServicioPage crearServicioPage;

    @FindBy(xpath = "//span[@class='x-btn-button']/span[@class='x-btn-inner x-btn-inner-center' and contains(.,'conductor')]")
    WebElementFacade btnAgregarConductor;

    @FindBy(xpath = "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:ClaimContactPerson-inputEl']/../following-sibling::td")
    WebElementFacade cmbPersona;

    @FindBy(xpath = "//div[contains(@class,'x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box')]//ul/li/following-sibling::li")
    WebElementFacade lstNombrePersona;

    @FindBy(id = "FNOLContactPopup:FNOLContactScreen:Update-btnInnerEl")
    WebElementFacade btnAceptar;

    @FindBy(xpath = "//input[@class='x-form-field x-form-checkbox x-form-cb']")
    WebElementFacade chkServicio;

    @FindBy(xpath = "//span[@class='x-btn-inner x-btn-inner-center' and contains(.,'Agregar Taller')]")
    WebElementFacade btnAgregarTaller;

    @FindBy(id = "OtherServiceRequestPopup:NewServiceRequestDV:btnSearchProvider-btnInnerEl")
    WebElementFacade btnBuscarProveedor;

    public void agregarConductor() {
        cliquearBtnAgregarConductor();
        seleccionarConductor();
    }

    private void cliquearBtnAgregarConductor() {
        btnAgregarConductor.waitUntilVisible()
                .click();
    }

    private void seleccionarConductor(){
        cmbPersona.waitUntilVisible().click();
        lstNombrePersona.click();
        realizarEsperaCarga();
        btnAceptar.click();
        realizarEsperaCarga();
    }

    public void seleccionarTaller() {
         seleccionarServicios();
         cliquearBtnAgregarTaller();
         cliquearBtnBuscarProveedor();
         crearServicioPage.seleccionarProveedor("ANDAR S.A.");

    }

    private void cliquearBtnBuscarProveedor() {
        btnBuscarProveedor.waitUntilVisible().click();
        realizarEsperaCarga();
    }

    private void cliquearBtnAgregarTaller() {
        btnAgregarTaller.waitUntilVisible()
                .click();
    }

    private void seleccionarServicios(){
        chkServicio.waitUntilVisible().click();
    }
}
