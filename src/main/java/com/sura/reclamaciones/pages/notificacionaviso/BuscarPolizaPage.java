package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BuscarPolizaPage extends GeneralPage {

    GeneralPage generalPage;

    public BuscarPolizaPage(WebDriver driver) {
        super(driver);
    }

    private String selectTipoDocumento = "//li[.='COMODIN']";
    private String selectTipoPoliza = "//li[.='COMODIN']";
    private String selectPais = "//li[.='COMODIN']";
    private String selectDepartamento = "//li[.='COMODIN']";
    private String selectCiudad = "//li[.='COMODIN']";
    private String XpathRbtBuscarPoliza = "//td[.='Buscar póliza']//input";
    private String XpathMnuTipoDePoliza = "//td[.='Tipo de póliza']//tbody//tbody//td//following-sibling::td/div";
    private String XpathTxtNumeroDePoliza = "//td[.='N.º de póliza']//input";
    private String XpatMnuTipoDeDocumento = "//tr[.='Tipo documento del asegurado']//div";
    private String XpathTxtNumeroDeDocumento = "//td[.='Número de documento del asegurado']//input";
    private String XpathMnuFechaDelSiniestro = "//td[.='Fecha del siniestro']//div";
    private String XpathBtnFechaDeHoy = "//span[.='Hoy']//span[@class='x-btn-button']";
    private String XpathTxtFecha = "//td[.='Fecha del siniestro']//input";
    private String XpathMnuPais = "//td[.='País']//div[@class='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first']";
    private String XpathMnuDepartamento = "//td[.='Departamento']//div[@class='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first']";
    private String XpathTxtCiudad = "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:locationSearchSura:FNOLWizard_PolicySearchInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Sura_Colombian_City-inputEl']";
    private String XpathBtnBuscar = "//span[@class='g-underlined'][contains(text(),'s')]";
    private String XpathLblAsegurado = "//td[.='Deseleccionar']/following-sibling::td[3]/div";
    private String XpathLabelNoDePoliza = "//span[.='N.º de póliza']";

    @FindBy(xpath = "//td[.='Buscar póliza']//input")
    private WebElementFacade rbtBuscarPoliza;

    @FindBy(xpath = "//td[.='Tipo de póliza']//tbody//tbody//td//following-sibling::td/div")
    private WebElementFacade mnuTipoDePoliza;

    @FindBy(xpath = "//td[.='N.º de póliza']//input")
    private WebElementFacade txtNumeroDePoliza;

    @FindBy(xpath = "//tr[.='Tipo documento del asegurado']//div")
    private WebElementFacade mnuTipoDeDocumento;

    @FindBy(xpath = "//td[.='Número de documento del asegurado']//input")
    private WebElementFacade txtNumeroDeDocumento;

    @FindBy(xpath = "//td[.='Fecha del siniestro']//div")
    private WebElementFacade mnuFechaDelSiniestro;

    @FindBy(xpath = "//span[.='Hoy']//span[@class='x-btn-button']")
    private WebElementFacade btnFechaDeHoy;

    @FindBy(xpath = "//td[.='Fecha del siniestro']//input")
    private WebElementFacade txtFecha;

    @FindBy(xpath = "//td[.='País']//div[@class='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first']")
    private WebElementFacade mnuPais;

    @FindBy(xpath = "//td[.='Departamento']//div[@class='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first']")
    private WebElementFacade mnuDepartamento;

    @FindBy(xpath = "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:locationSearchSura:FNOLWizard_PolicySearchInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Sura_Colombian_City-inputEl']")
    private WebElementFacade txtCiudad;

    @FindBy(xpath = "//span[@class='g-underlined'][contains(text(),'s')]")
    private WebElementFacade btnBuscar;

    @FindBy(xpath = "//td[.='Deseleccionar']/following-sibling::td[3]/div")
    private WebElementFacade lblAsegurado;

    public void elemento(String nombreElemento) {
        $("#new-todo").type(nombreElemento).then().sendKeys(Keys.ENTER);
    }

    public void cliquearBuscarPoliza() {
        waitForPresenceOf(XpathRbtBuscarPoliza);
        rbtBuscarPoliza.click();
    }

    public void seleccionarPoliza(String poliza) {
        waitForPresenceOf(XpathMnuTipoDePoliza);
        mnuTipoDePoliza.click();
        selectTipoPoliza = selectTipoPoliza.replace("COMODIN", poliza);
        $(selectTipoPoliza).click();
    }

    public void escribirNumeroPoliza(String numPoliza) {
        waitForPresenceOf(XpathTxtNumeroDePoliza);
        txtNumeroDePoliza.type(numPoliza);
    }

    public void seleccionarTipoDocumento(String tipoDocumento) {
        waitForPresenceOf(XpatMnuTipoDeDocumento);
        mnuTipoDeDocumento.click();
        selectTipoDocumento = selectTipoDocumento.replace("COMODIN", tipoDocumento);
        $(selectTipoDocumento).click();
    }

    public void escribirNumeroDocumento(String numDocumento) {
        waitForPresenceOf(XpathTxtNumeroDeDocumento);
        txtNumeroDeDocumento.type(numDocumento);
    }

    public void seleccionarFechaHoySiniestro() {
        waitForPresenceOf(XpathMnuFechaDelSiniestro);
        mnuFechaDelSiniestro.click();
        waitForPresenceOf(XpathBtnFechaDeHoy);
        btnFechaDeHoy.click();
    }

    public void escribirFechaSiniestro(String fecha) {
        waitForPresenceOf(XpathTxtFecha);
        txtFecha.type(fecha);
    }

    public void seleccionarPais(String pais) {
        waitForPresenceOf(XpathMnuPais);
        mnuPais.click();
        selectPais = selectPais.replace("COMODIN", pais);
        waitForPresenceOf(selectPais);
        $(selectPais).click();
    }

    public void seleccionarDepartamento(String departamento) {
        waitForPresenceOf(XpathMnuDepartamento);
        mnuDepartamento.click();
        selectDepartamento = selectDepartamento.replace("COMODIN", departamento);
        waitForPresenceOf(selectDepartamento);
        $(selectDepartamento).click();
    }

    public void seleccionarCiudad(String ciudad) {
        waitForPresenceOf(XpathTxtCiudad);
        realizarEsperaCarga();
        txtCiudad.clear();
        txtCiudad.type(ciudad);
    }

    public void cliquearBuscar() {
        waitForPresenceOf(XpathBtnBuscar);
        btnBuscar.click();
        realizarEsperaCarga();
        cliquearSiguiente();
    }
}
