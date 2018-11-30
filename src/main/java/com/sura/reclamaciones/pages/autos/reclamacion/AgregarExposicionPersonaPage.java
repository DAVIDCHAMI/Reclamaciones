package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.PersonaReclamacionAuto;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AgregarExposicionPersonaPage extends GeneralPage {

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
  WebElementFacade cmbGravedad;

  @FindBy(
    xpath =
        "//textarea[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:InjuryDescription-inputEl']"
  )
  WebElementFacade txtDescibirLesiones;

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

  public AgregarExposicionPersonaPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void agregarPeaton(
      List<PersonaReclamacionAuto> datosPersonaReclamacionAutos,
      List<ReclamacionAuto> datosReclamacionAuto,
      List<ExposicionLesiones> datosExposicionLesiones) {
    datosPersonaReclamacionAutos.forEach(
        dato -> {
          btnAgregarPeaton.waitUntilVisible().click();
          cmbTipoDocumento.clear();
          cmbTipoDocumento.sendKeys(dato.getTipoDocumento());
          cmbTipoDocumento.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          txtNumeroDocumento.sendKeys(dato.getnumeroDocumento());
          txtPrimerNombre.sendKeys(dato.getPrimerNombre());
          txtPrimerApellido.sendKeys(dato.getPrimerApellido());
        });

    datosReclamacionAuto.forEach(
        dato -> {
          cmbDepartamento.clear();
          cmbDepartamento.sendKeys(dato.getDepartamento());
          cmbDepartamento.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          cmbCiudad.clear();
          cmbCiudad.sendKeys(dato.getCiudad());
          cmbCiudad.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          txtDireccion.sendKeys(dato.getDireccion());
          realizarEsperaCarga();
          cmbTipoDireccion.clear();
          cmbTipoDireccion.sendKeys(dato.getTipoDireccion());
          cmbTipoDireccion.sendKeys(Keys.ENTER);
        });
    datosExposicionLesiones.forEach(
        dato -> {
          chkLesiones.waitUntilVisible().click();
          cmbGravedad.clear();
          cmbGravedad.sendKeys(dato.getGravedadLesion());
          cmbGravedad.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          txtDescibirLesiones.sendKeys(dato.getDescribirLesiones());
          cmbTipoLesion.clear();
          cmbTipoLesion.sendKeys(dato.getTipoLesion());
          cmbTipoLesion.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          cmbDetalleLesion.clear();
          cmbDetalleLesion.sendKeys(dato.getDetallesTipoLesion());
          cmbDetalleLesion.sendKeys(Keys.ENTER);
          realizarEsperaCarga();
          aceptarOpcion();
          realizarEsperaCarga();
        });
  }
}
