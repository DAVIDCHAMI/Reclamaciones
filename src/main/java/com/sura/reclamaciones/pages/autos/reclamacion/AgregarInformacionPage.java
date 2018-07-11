package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class AgregarInformacionPage extends GeneralPage {

    public AgregarInformacionPage(WebDriver wdriver) {
        super(wdriver);
    }

    @FindBy(id = "NewClaimDuplicatesWorksheet:NewClaimDuplicatesScreen:NewClaimDuplicatesWorksheet_CloseButton-btnEl")
    private WebElementFacade btnCerrarVentanaEmergente;

    @FindBy(xpath = ".//td[@class='x-input-cell']/input")
    WebElementFacade txtPretension;

    @FindBy(xpath = "//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:Claim_LossCause2-inputCell']/following-sibling::td")
    private WebElementFacade cmbCausaSiniestro;

    @FindBy(xpath = "//input[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:OriginCause-inputEl']/../following-sibling::td")
    private WebElementFacade cmbOrigenSiniestro;

    @FindBy(xpath = "//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:AuthorityTransit-inputCell']/following-sibling::td")
    private WebElementFacade cmbIntervinoAutoridad;

    @FindBy(xpath = "//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:CategorizationDV:Notification_Fault-inputCell']/following-sibling::td")
    private WebElementFacade cmbCulpabilidad;

    @FindBy(xpath = "//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:AddressDetailInputSetRef:CCAddressInputSet:globalAddressContainer:Address_Picker-inputCell']/following-sibling::td")
    private WebElementFacade cmbLugar;

    @FindBy(xpath = "//td[@class='g-after-input-cell']/a/img")
    private WebElementFacade btnAbajoVehiculo;

    @FindBy(xpath = "//div/a/span[contains(.,'Editar')]")
    private WebElementFacade btnEditarVehiculo;

    public WebElementFacade getBtnCerrarVentanaEmergente() {
        return btnCerrarVentanaEmergente;
    }

    public void diligenciarFormulario(String label, String tipoCampo, String palabraAEscribir) {
        String formularioInformacionReclamacion = ".//div[contains(@id,'LossDetailsAddressDV')]/table//label[contains(.,'" + label + "')]/../following-sibling::td//" + tipoCampo;
        $(formularioInformacionReclamacion).sendKeys(palabraAEscribir);
    }

    public void escribirSucedido(String sucedido) {
        diligenciarFormulario(ReclamacionConstante.SUCEDIDO, "textArea", sucedido);
    }

    public void seleccionarCausa(String causa) {
        cmbCausaSiniestro.waitUntilVisible().click();
        seleccionarOpcionCombobox(causa);
    }

    public void seleccionarOrigen(String origen) {
        cmbOrigenSiniestro.click();
        seleccionarOpcionCombobox(origen);
    }

    public void escribirValorPretension(String valorPretension) {
        txtPretension.type(valorPretension);
    }

    public void seleccionarIntervinoAutoridad(String autoridad) {
        cmbIntervinoAutoridad.click();
        seleccionarOpcionCombobox(autoridad);
    }

    public void cliquearBotonCerrar() {
        btnCerrarVentanaEmergente.waitUntilVisible().click();
    }

    public void seleccionarCulpabilidad(String culpabilidad) {
        cmbCulpabilidad.click();
        seleccionarOpcionCombobox(culpabilidad);
    }

    public void seleccionarLugar(String lugar) {
        cmbLugar.click();
        seleccionarOpcionCombobox(lugar);
        realizarEsperaCarga();
    }

    public void seleccionarPais(String pais) {
        diligenciarFormulario(ReclamacionConstante.CULPABILIDAD, "input", pais);
    }

    public void seleccionarDepartamento(String departamento) {
        diligenciarFormulario(ReclamacionConstante.DEPARTAMENTO, "input", departamento);
    }

    public void seleccionarCiudad(String ciudad) {
        diligenciarFormulario(ReclamacionConstante.CIUDAD, "input", ciudad);
    }

    public void escribirDireccion(String direccion) {
        diligenciarFormulario(ReclamacionConstante.DIRRECCION, "input", direccion);
    }

    public void cliquearBotonEditarVehiculo() {
        btnAbajoVehiculo.click();
        btnEditarVehiculo.click();
        realizarEsperaCarga();
    }
}
