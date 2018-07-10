package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class InformacionReclamacionPage extends GeneralPage {
    public InformacionReclamacionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='g-underlined'][contains(text(),'e')]")
    private WebElementFacade btnCerrar;
    private String XpathBtnCerrar = "//span[@class='g-underlined'][contains(text(),'e')]";

    @FindBy(xpath = "//td[.='Causa del siniestro']//input")
    private WebElementFacade txtCausaSiniestro;
    private String XpathTxtCausaSiniestro = "//td[.='Causa del siniestro']//input";

    @FindBy(xpath = "//td[.='Valor de la pretensión']//following-sibling::td//input")
    private WebElementFacade txtValorPretension;
    private String XpathTxtValorPretension = "//td[.='Valor de la pretensión']//following-sibling::td//input";

    @FindBy(xpath = "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:EditableFixedPropertyIncidentsLV_tb:Add-btnInnerEl']")
    private WebElementFacade btnIncidentePropiedad;
    private String XpathBtnIncidentePropiedad = "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:EditableFixedPropertyIncidentsLV_tb:Add-btnInnerEl']";

    @FindBy(xpath = "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:FNOLSuraEditableContentPropertyIncidentsLV_tb:Add-btnInnerEl']")
    private WebElementFacade btnIncidenteContenido;
    private String XpathBtnIncidenteContenido = "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:FNOLSuraEditableContentPropertyIncidentsLV_tb:Add-btnInnerEl']";

    @FindBy(xpath = "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:EditableInjuryIncidentsLV_tb:Add-btnInnerEl']")
    private WebElementFacade btnIncidenteLesiones;
    private String XpathBtnIncidenteLesiones = "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:EditableInjuryIncidentsLV_tb:Add-btnInnerEl']";

    @FindBy(xpath = "//span[.='Aceptar']/span[@id='NewFixedPropertyIncidentPopup:NewFixedPropertyIncidentScreen:Update-btnInnerEl']")
    private WebElementFacade btnAceptarIncPropiedad;
    private String XpathBtnAceptarIncPropiedad = "//span[.='Aceptar']/span[@id='NewFixedPropertyIncidentPopup:NewFixedPropertyIncidentScreen:Update-btnInnerEl']";

    @FindBy(xpath = "//span[.='Aceptar']/span[@id='NewPropertyContentsIncidentPopup:NewPropertyContentsIncidentScreen:Update-btnInnerEl']")
    private WebElementFacade btnAceptarIncContenido;
    private String XpathBtnAceptarIncContenido = "//span[.='Aceptar']/span[@id='NewPropertyContentsIncidentPopup:NewPropertyContentsIncidentScreen:Update-btnInnerEl']";

    @FindBy(xpath = "//span[.='Aceptar']/span[@id='NewInjuryIncidentPopup:NewInjuryIncidentScreen:Update-btnInnerEl']")
    private WebElementFacade btnAceptarIncLesion;
    private String XpathBtnAceptarIncLesion = "//span[.='Aceptar']/span[@id='NewInjuryIncidentPopup:NewInjuryIncidentScreen:Update-btnInnerEl']";

    @FindBy(xpath = "//span[.='Finalizar']/span[@id='FNOLWizard:Finish-btnInnerEl']")
    private WebElementFacade btnFinalizar;
    private String XpathBtnFinalizar = "//span[.='Finalizar']/span[@id='FNOLWizard:Finish-btnInnerEl']";

    @FindBy(xpath = "//div[@class='x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box']//li")
    private WebElementFacade mnuCausa;
    private String XpathMnuCausa = "//div[@class='x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box']//li";


    public void cerrarReclamosDuplicados() {
        if (btnCerrar.isPresent()) {
            waitForPresenceOf(XpathBtnCerrar);
            btnCerrar.click();
        }
    }

    public void seleccionarCausaSiniestro(String causa) {
        waitForPresenceOf(XpathTxtCausaSiniestro);
        realizarEsperaCarga();
        txtCausaSiniestro.clear();
        txtCausaSiniestro.type(causa);
        waitForPresenceOf(XpathMnuCausa);
        mnuCausa.click();
    }

    public void escribirValorPretension(String valor) {
        waitForPresenceOf(XpathTxtValorPretension);
        realizarEsperaCarga();
        txtValorPretension.type(valor);
    }

    public void seleccionarTipoIncidente(String tipoIncidente) {
        if (tipoIncidente.equals("Propiedad")) {
            waitForPresenceOf(XpathBtnIncidentePropiedad);
            btnIncidentePropiedad.click();
            waitForPresenceOf(XpathBtnAceptarIncPropiedad);
            btnAceptarIncPropiedad.click();
            realizarEsperaCarga();
        }
        if (tipoIncidente.equals("Contenido")) {
            waitForPresenceOf(XpathBtnIncidenteContenido);
            btnIncidenteContenido.click();
            waitForPresenceOf(XpathBtnAceptarIncContenido);
            btnAceptarIncContenido.click();
            realizarEsperaCarga();
        }
        if (tipoIncidente.equals("Lesiones")) {
            waitForPresenceOf(XpathBtnIncidenteLesiones);
            btnIncidenteLesiones.click();
            waitForPresenceOf(XpathBtnAceptarIncLesion);
            btnIncidenteLesiones.click();
            realizarEsperaCarga();
        } else {
            System.out.println("No se ha indicado un tipo de Incidente. Se genera Reclamción sin Incidente asociado");
        }
    }

    public void finalizarSiniestro() {
        waitForPresenceOf(XpathBtnFinalizar);
        btnFinalizar.click();
        realizarEsperaCarga();
    }
}



