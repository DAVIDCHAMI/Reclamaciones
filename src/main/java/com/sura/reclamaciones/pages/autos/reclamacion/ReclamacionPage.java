package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ReclamacionPage extends PageObject {

    @FindBy(xpath = ".//td[@class='x-input-cell']/input")
    WebElementFacade txtPretension;

    @FindBy(xpath = "//span[@class='x-btn-button']/span[@class='x-btn-inner x-btn-inner-center' and contains(.,'conductor')]")
    WebElementFacade btnAgregarConductor;

    public void diligenciarFormulario(String label, String tipoCampo, String palabraAEscribir) {
        String formularioInformacionReclamacion = ".//div[contains(@id,'LossDetailsAddressDV')]/table//label[contains(.,'" + label + "')]/../following-sibling::td//" + tipoCampo;
        $(formularioInformacionReclamacion).sendKeys(palabraAEscribir);
    }

    public void escribirSucedido(String sucedido) {
        diligenciarFormulario(ReclamacionConstante.SUCEDIDO, "textArea", sucedido);
    }

    public void seleccionarCausa(String causa) {
        diligenciarFormulario(ReclamacionConstante.CAUSA_SINIESTRO, "input", causa);
    }

    public void seleccionarOrigen(String origen) {
        diligenciarFormulario(ReclamacionConstante.ORIGEN_SINIESTRO, "input", origen);
    }

    public void escribirValorPretension(String valorPretension) {
        txtPretension.sendKeys(valorPretension);
    }

    public void seleccionarIntervinoAutoridad(String autoridad) {
        diligenciarFormulario(ReclamacionConstante.AUTORIDAD, "input", autoridad);
    }

    public void seleccionarCulpabilidad(String culpabilidad) {
        diligenciarFormulario(ReclamacionConstante.CULPABILIDAD, "input", culpabilidad);
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

    public void agregarConductor() {
        cliquearBtnAgregarConductor();
       // seleccionarConductor();
    }

    private void cliquearBtnAgregarConductor() {
        btnAgregarConductor.waitUntilVisible()
                .click();
    }

    public void seleccionarTaller() {
       /** seleccionarServicios();
        cliquearBtnAgregarTaller();
        cliquearBtnNuscarProveedor();**/
        
    }


}
