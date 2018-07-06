package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class BuscarPolizaPage extends GeneralPage {

    public BuscarPolizaPage(WebDriver driver) {
        super(driver);
    }

    private String selectTipoDocumento = "//li[.='COMODIN']";
    private String comodinTxt = "//td[.='COMODIN']//input";
    private String selectTipoPoliza = "//li[.='COMODIN']";
    private String XpathRbtBuscarPoliza = "//td[.='Buscar póliza']//input";
    private String XpathMnuTipoDePoliza = "//td[.='Tipo de póliza']//div";
    private String XpathTxtNumeroDePoliza = "//td[.='N.º de póliza']//input";
    private String XpatMnuTipoDeDocumento = "//tr[.='Tipo documento del asegurado']//div";
    private String XpathTxtNumeroDeDocumento = "//td[.='Número de documento del asegurado']//input";
    private String XpathMnuFechaDelSiniestro = "//td[.='Fecha del siniestro']//div";
    private String XpathBtnFechaDeHoy = "//span[.='Hoy']//span[@class='x-btn-button']";
    private String XpathTxtFecha = "//td[.='Fecha del siniestro']//input";
    private String XpathMnuPais = "//td[.='País']//div";
    private String XpathBtnColombia = "//li[.='Colombia']";
    private String XpathMnuDepartamento = "//td[.='Departamento']//div";
    private String XpathBtnAntioquia = "//li[.='Antioquia']";
    private String XpathMnuCiudad = "//td[.='Ciudad']//div";
    private String XpathBtnMedellin = "//li[.='Medellin']";
    private String XpathBtnBuscar = "//td[.='Buscar']//a";
    private String XpathLblAsegurado = "//td[.='Deseleccionar']/following-sibling::td[3]/div";
    private String XpathBtnSiguiente = "//span[.='Siguiente >']/span/span";

    @FindBy(xpath = "//td[.='Buscar póliza']//input")
    private WebElementFacade rbtBuscarPoliza;

    @FindBy(xpath = "//td[.='Tipo de póliza']//div")
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

    @FindBy(xpath = "//td[.='País']//div")
    private WebElementFacade mnuPais;

    @FindBy(xpath = "//li[.='Colombia']")
    private WebElementFacade btnColombia;

    @FindBy(xpath = "//td[.='Departamento']//div")
    private WebElementFacade mnuDepartamento;

    @FindBy(xpath = "//li[.='Antioquia']")
    private WebElementFacade btnAntioquia;

    @FindBy(xpath = "//td[.='Ciudad']//div")
    private WebElementFacade mnuCiudad;

    @FindBy(xpath = "//li[.='Medellin']")
    private WebElementFacade btnMedellin;

    @FindBy(xpath = "//td[.='Buscar']//a")
    private WebElementFacade btnBuscar;

    @FindBy(xpath = "//td[.='Deseleccionar']/following-sibling::td[3]/div")
    private WebElementFacade lblAsegurado;

    @FindBy(xpath = "//span[.='Siguiente >']/span/span")
    private WebElementFacade btnSiguiente;

    @FindBy(id = "FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:basicSearchSura:FNOLWizardFindPolicyInputSet:PolicyType-inputEl")
    private WebElementFacade cmbTipoPoliza;

    @FindBy(xpath = ".//a[@class='g-actionable miniButton' and contains(.,'Deseleccionar')]")
    private WebElementFacade elementoEspera;

    public void cliquearBuscarPoliza() {
        waitForPresenceOf(XpathRbtBuscarPoliza);
        rbtBuscarPoliza.click();
    }

    public void seleccionarTipoPoliza(String opcion) {
        cmbTipoPoliza.waitUntilVisible().click();
        seleccionarOpcionCombobox(opcion);
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

    //dd/mm/yyyy
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

    public void seleccionarPais() {
        waitForPresenceOf(XpathMnuPais);
        mnuPais.click();
        waitForPresenceOf(XpathBtnColombia);
        btnColombia.click();
    }

    public void seleccionarDepartamento() {
        waitForPresenceOf(XpathMnuDepartamento);
        mnuDepartamento.click();
        waitForPresenceOf(XpathBtnAntioquia);
        btnAntioquia.click();
    }

    public void seleccionarCiudad() {
        waitForPresenceOf(XpathMnuCiudad);
        mnuCiudad.click();
        waitForPresenceOf(XpathBtnMedellin);
        btnMedellin.click();
    }

    public void cliquearBuscar() {
        waitForPresenceOf(XpathBtnBuscar);
        btnBuscar.click();
        realizarEsperaCarga();
        //elementoEspera.waitUntilVisible();
    }

    public void tomarAsegurado() {
        waitForPresenceOf(XpathLblAsegurado);
        Serenity.setSessionVariable("autorReporte".toLowerCase().trim()).to(lblAsegurado.getText());
    }

    public void cliquearSiguiente() {
        waitForPresenceOf(XpathBtnSiguiente);
        btnSiguiente.click();
    }

    public void escribirPlaca(String numeroPlaca) {
        comodinTxt = comodinTxt.replace("COMODIN","Placa");
        $(comodinTxt).type(numeroPlaca);
    }

}
