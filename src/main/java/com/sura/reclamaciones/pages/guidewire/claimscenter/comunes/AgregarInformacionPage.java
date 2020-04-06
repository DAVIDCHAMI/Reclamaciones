package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.pages.general.GeneralPage;
import java.util.concurrent.TimeUnit;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AgregarInformacionPage extends GeneralPage {

  @FindBy(
      id =
          "NewClaimDuplicatesWorksheet:NewClaimDuplicatesScreen:NewClaimDuplicatesWorksheet_CloseButton-btnEl")
  private WebElementFacade btnCerrarVentanaEmergente;

  @FindBy(
      xpath =
          ".//input[@role='textbox' and @id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:LossEstimate-inputEl']")
  WebElementFacade txtPretension;

  @FindBy(xpath = ".//label[contains(.,'Causa')]/../following-sibling::td//input")
  private WebElementFacade cmbCausaSiniestro;

  @FindBy(
      xpath =
          "//input[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:OriginCause-inputEl']")
  private WebElementFacade cmbOrigenSiniestro;

  @FindBy(
      xpath =
          "//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:CategorizationDV:Notification_Fault-inputCell']//input")
  private WebElementFacade cmbCulpabilidad;

  @FindBy(
      xpath =
          "//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:AddressDetailInputSetRef:CCAddressInputSet:globalAddressContainer:Address_Picker-inputCell']/following-sibling::td")
  private WebElementFacade cmbLugar;

  @FindBy(xpath = "//td[@class='g-after-input-cell']/a/img")
  private WebElementFacade btnAbajoVehiculo;

  @FindBy(xpath = "//div/a/span[contains(.,'Editar')]")
  private WebElementFacade btnEditarVehiculo;

  @FindBy(
      xpath =
          ".//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:AuthorityTransit-inputCell']/input")
  private WebElementFacade txtIntervinoAutoridad;

  @FindBy(
      id =
          "FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:Description-inputEl")
  private WebElementFacade txtDescripcionHechos;

  @FindBy(
      id =
          "FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:AddVehicleButton-btnInnerEl")
  private WebElementFacade btnAgregarVehiculo;

  @FindBy(xpath = ".//span[@class='g-underlined' and contains(.,'F')]")
  private WebElementFacade btnFinalizar;

  @FindBy(
      id =
          "FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:AddPedestrianButton-btnInnerEl")
  WebElementFacade btnAgregarPeaton;

  public AgregarInformacionPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void cerrarVentanaEmergente() {
    if (btnCerrarVentanaEmergente.isVisible()) {
      btnCerrarVentanaEmergente.waitUntilVisible();
      btnCerrarVentanaEmergente.click();
      realizarEsperaCarga();
    }
  }

  public void escribirSucedido(String sucedido) {
    txtDescripcionHechos.type(sucedido);
    cmbCausaSiniestro.sendKeys(Keys.TAB);
    realizarEsperaCarga();
  }

  public void seleccionarCausa(String causa) {
    cmbCausaSiniestro.type(causa);
    cmbCausaSiniestro.sendKeys(Keys.TAB);
    realizarEsperaCarga();
  }

  public void seleccionarOrigen(String origen) {
    cmbOrigenSiniestro.type(origen);
    cmbOrigenSiniestro.sendKeys(Keys.ENTER);
  }

  public void escribirValorPretension(String valorPretension) {
    txtPretension.withTimeoutOf(5, TimeUnit.SECONDS).click();
    txtPretension.sendKeys(valorPretension);
  }

  public void seleccionarIntervinoAutoridad(String autoridad) {
    txtIntervinoAutoridad.type(autoridad);
    txtIntervinoAutoridad.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void seleccionarCulpabilidad(String culpabilidad) {
    cmbCulpabilidad.type(culpabilidad);
    cmbCulpabilidad.sendKeys(Keys.ENTER);
  }

  public void agregarExposicionVehiculoTercero() {
    btnAgregarVehiculo.waitUntilVisible().waitUntilClickable().click();
  }

  public void agregarExposicionPersona() {
    btnAgregarPeaton.waitUntilVisible().click();
  }

  public void seleccionarLugar(String lugar) {
    cmbLugar.waitUntilClickable().click();
    seleccionarOpcionCombobox(lugar);
    realizarEsperaCarga();
  }

  public void ingresarEdicionVehiculo() {
    btnAbajoVehiculo.click();
    btnEditarVehiculo.click();
    realizarEsperaCarga();
  }

  public void concluirReclamacion() {
    btnFinalizar.waitUntilVisible();
    btnFinalizar.click();
    realizarTiempoEsperaCarga();
  }
}
