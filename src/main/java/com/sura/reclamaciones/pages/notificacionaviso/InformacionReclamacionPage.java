package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class InformacionReclamacionPage extends GeneralPage {

  private String lstCausaSiniestro = "//li[.='COMODIN']";

  @FindBy(
    xpath =
        "//span[@id='NewClaimDuplicatesWorksheet:NewClaimDuplicatesScreen:NewClaimDuplicatesWorksheet_CloseButton-btnInnerEl']"
  )
  private WebElementFacade btnCerrar;

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:LossEstimate-inputEl']"
  )
  private WebElementFacade txtValorPretension;

  @FindBy(
    xpath =
        "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:EditableFixedPropertyIncidentsLV_tb:Add-btnInnerEl']"
  )
  private WebElementFacade btnIncidentePropiedad;

  @FindBy(
    xpath =
        "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:FNOLSuraEditableContentPropertyIncidentsLV_tb:Add-btnInnerEl']"
  )
  private WebElementFacade btnIncidenteContenido;

  @FindBy(
    xpath =
        "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:EditableInjuryIncidentsLV_tb:Add-btnInnerEl']"
  )
  private WebElementFacade btnIncidenteLesiones;

  @FindBy(
    xpath =
        "//span[.='Aceptar']/span[@id='NewFixedPropertyIncidentPopup:NewFixedPropertyIncidentScreen:Update-btnInnerEl']"
  )
  private WebElementFacade btnAceptarIncPropiedad;

  @FindBy(
    xpath =
        "//span[.='Aceptar']/span[@id='NewPropertyContentsIncidentPopup:NewPropertyContentsIncidentScreen:Update-btnInnerEl']"
  )
  private WebElementFacade btnAceptarIncContenido;

  @FindBy(xpath = "//span[.='Finalizar']/span[@id='FNOLWizard:Finish-btnInnerEl']")
  private WebElementFacade btnFinalizar;

  @FindBy(xpath = "//span[@id='NewClaimSaved:NewClaimSavedScreen:ttlBar']")
  private WebElementFacade spanNuevaReclamacion;

  @FindBy(
    xpath =
        "//td[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_LossDetailsScreen:NewClaimLossDetailsDV:Claim_LossCause-inputCell']"
  )
  private WebElementFacade mnuCausa;

  public InformacionReclamacionPage(WebDriver driver) {
    super(driver);
  }

  public void cerrarReclamosDuplicados() {
    if (btnCerrar.isVisible()) {
      btnCerrar.waitUntilClickable();
      btnCerrar.click();
      realizarEsperaCarga();
    }
  }

  public void seleccionarCausaSiniestro(String causa) {
    mnuCausa.waitUntilPresent();
    mnuCausa.click();
    lstCausaSiniestro = lstCausaSiniestro.replace(ConstanteGlobal.COMODIN, causa);
    $(lstCausaSiniestro).waitUntilVisible();
    $(lstCausaSiniestro).click();
    realizarEsperaCarga();
  }

  public void escribirValorPretension(String valor) {
    txtValorPretension.waitUntilVisible();
    txtValorPretension.sendKeys(valor);
  }

  public void seleccionarTipoIncidente(String tipoIncidente) {
    if ("Propiedad".equalsIgnoreCase(tipoIncidente)) {
      btnIncidentePropiedad.waitUntilClickable();
      btnIncidentePropiedad.click();
      btnAceptarIncPropiedad.waitUntilVisible();
      btnAceptarIncPropiedad.click();
      realizarEsperaCarga();
    }
    if ("Contenido".equalsIgnoreCase(tipoIncidente)) {
      btnIncidenteContenido.waitUntilClickable();
      btnIncidenteContenido.click();
      btnAceptarIncContenido.waitUntilVisible();
      btnAceptarIncContenido.click();
      realizarEsperaCarga();
    }
    if ("Lesiones".equalsIgnoreCase(tipoIncidente)) {
      btnIncidenteLesiones.waitUntilClickable();
      btnIncidenteLesiones.click();
      btnIncidenteLesiones.waitUntilVisible();
      btnIncidenteLesiones.click();
      realizarEsperaCarga();
    }
  }

  public void finalizarSiniestro() {
    btnFinalizar.waitUntilVisible();
    btnFinalizar.click();
    realizarEsperaFinalizarReclamacion();
  }

  public String obtenerTituloReclamacionGenerada() {
    return spanNuevaReclamacion.waitUntilVisible().getText();
  }
}
