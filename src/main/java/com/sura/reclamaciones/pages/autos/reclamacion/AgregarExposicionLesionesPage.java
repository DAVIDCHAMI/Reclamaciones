package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AgregarExposicionLesionesPage extends GeneralPage {

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

  public AgregarExposicionLesionesPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void agregarPersonaLesionada(
      List<Persona> datosPersonaReclamacionAutos,
      List<ReclamacionAuto> datosReclamacionAuto,
      List<ExposicionLesiones> datosExposicionLesiones) {
    datosPersonaReclamacionAutos.forEach(
        peaton -> {
          btnAgregarPeaton.waitUntilVisible().click();
          cmbTipoDocumento.clear();
          cmbTipoDocumento.sendKeys(peaton.getTipoDocumento());
          cmbTipoDocumento.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          txtNumeroDocumento.sendKeys(peaton.getNumDocumento());
          txtPrimerNombre.sendKeys(peaton.getPrimerNombre());
          txtPrimerApellido.sendKeys(peaton.getPrimerApellido());
        });
    datosReclamacionAuto.forEach(
        direccionPeaton -> {
          cmbDepartamento.clear();
          cmbDepartamento.sendKeys(direccionPeaton.getDepartamento());
          cmbDepartamento.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          cmbCiudad.clear();
          cmbCiudad.sendKeys(direccionPeaton.getCiudad());
          cmbCiudad.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          txtDireccion.sendKeys(direccionPeaton.getDireccion());
          realizarEsperaCarga();
          cmbTipoDireccion.clear();
          cmbTipoDireccion.sendKeys(direccionPeaton.getTipoDireccion());
          cmbTipoDireccion.sendKeys(Keys.ENTER);
        });
    datosExposicionLesiones.forEach(
        lesionesPeaton -> {
          chkLesiones.waitUntilVisible().click();
          cmbGravedadLesion.clear();
          cmbGravedadLesion.sendKeys(lesionesPeaton.getGravedadLesion());
          cmbGravedadLesion.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          txtDescribirLesiones.sendKeys(lesionesPeaton.getDescribirLesiones());
          cmbTipoLesion.clear();
          cmbTipoLesion.sendKeys(lesionesPeaton.getTipoLesion());
          cmbTipoLesion.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          cmbDetalleLesion.clear();
          cmbDetalleLesion.sendKeys(lesionesPeaton.getDetallesTipoLesion());
          cmbDetalleLesion.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          aceptarOpcion();
          realizarEsperaCarga();
        });
  }
}
