package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.pages.general.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DatosPeatonPage extends GeneralPage {

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuredBoolean_true-inputEl']"
  )
  WebElementFacade chkLesiones;

  @FindBy(
    xpath =
        "//span[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:AddPedestrianButton-btnInnerEl']"
  )
  WebElementFacade btnAgregarPeaton;

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:Severity-inputEl']"
  )
  WebElementFacade cmbGravedadLesion;

  @FindBy(
    xpath =
        "//textarea[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:InjuryDescription-inputEl']"
  )
  WebElementFacade txtDescribirLesiones;

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:PrimaryInjuryType-inputEl']"
  )
  WebElementFacade cmbTipoLesion;

  @FindBy(
    xpath =
        "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:DetailedInjuryType-inputEl']"
  )
  WebElementFacade cmbDetalleLesion;

  public DatosPeatonPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void agregarPersonaLesionada() {
    btnAgregarPeaton.waitUntilVisible().click();
  }

  public void seleccionarLesiones() {
    chkLesiones.waitUntilVisible().click();
  }

  public void seleccionarGravedadLesion(String gravedadLesion) {
    cmbGravedadLesion.clear();
    cmbGravedadLesion.sendKeys(gravedadLesion);
    cmbGravedadLesion.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void ingresarDescripcionLesiones(String describirLesiones) {
    txtDescribirLesiones.sendKeys(describirLesiones);
  }

  public void seleccionarTipoLesion(String tipoLesion) {
    cmbTipoLesion.clear();
    cmbTipoLesion.sendKeys(tipoLesion);
    cmbTipoLesion.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void seleccionarDetalleLesion(String detallesTipoLesion) {
    cmbDetalleLesion.clear();
    cmbDetalleLesion.sendKeys(detallesTipoLesion);
    cmbDetalleLesion.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void finalizarExposicion() {
    aceptarOpcion();
    realizarEsperaCarga();
  }
}
