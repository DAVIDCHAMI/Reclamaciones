package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class InformacionBasicaPage extends GeneralPage {

  public InformacionBasicaPage(WebDriver driver) {
    super(driver);
  }

  //td[.='Nombre']/following-sibling::td//table//table//td[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name-inputCell']/following-sibling::td/div
  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name-inputEl']"
  )
  private WebElementFacade txtNombreAutor;

  @FindBy(
    xpath =
        "//div[@class='x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box']//li"
  )
  private WebElementFacade lstAutorReporte;

  @FindBy(
    xpath =
        "//div[@class='x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box']//li[2]"
  )
  private WebElementFacade lstAutorReporteCliente;

  @FindBy(
    xpath =
        "//textarea[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:Description-inputEl']"
  )
  private WebElementFacade txtDetalleHechos;

  @FindBy(
    xpath =
        " //a[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name:ReportedBy_NameMenuIcon']"
  )
  private WebElementFacade btnCotactManager;

  @FindBy(
    xpath =
        "//span[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name:MenuItem_Search-textEl']"
  )
  private WebElementFacade btnBuscarContactoExistente;

  @FindBy(
    xpath =
        "//input[@id='AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchDV:TaxID-inputEl']"
  )
  private WebElementFacade txtNit;

  @FindBy(
    xpath =
        "//a[@id='AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']"
  )
  private WebElementFacade btnBuscarNit;

  @FindBy(
    xpath =
        "//a[@id='AddressBookPickerPopup:AddressBookSearchScreen:AddressBookSearchLV:0:_Select']"
  )
  private WebElementFacade btnSeleccionarContacto;

  @FindBy(
    xpath =
        " //input[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:Claim_ReportedByType-inputEl']"
  )
  private WebElementFacade btnRelacionAsegurado;

  @FindBy(xpath = "//li[contains(text(),'Amigo')]")
  private WebElementFacade lstAmigo;

  public void seleccionarAutorReporte() {
    txtNombreAutor.waitUntilVisible();
    txtNombreAutor.click();
    //String autorReporte = lstAutorReporte.getText();
    if (lstAutorReporteCliente.isVisible()) {
      lstAutorReporteCliente.waitUntilVisible();
      lstAutorReporteCliente.click();
      realizarEsperaCarga();
    } else {
      //if (autorReporte.equalsIgnoreCase("<ninguno>")) {
      btnCotactManager.waitUntilClickable();
      btnCotactManager.click();
      btnBuscarContactoExistente.waitUntilClickable();
      btnBuscarContactoExistente.click();
      txtNit.waitUntilVisible();
      txtNit.sendKeys(ConstanteGlobal.NIT);
      btnBuscarNit.waitUntilClickable();
      btnBuscarNit.click();
      btnSeleccionarContacto.waitUntilClickable();
      btnSeleccionarContacto.click();
      realizarEsperaCarga();
      btnRelacionAsegurado.waitUntilClickable();
      btnRelacionAsegurado.click();
      lstAmigo.waitUntilVisible();
      lstAmigo.click();
    }
  }

  public void escribirDetallehechos(String detalle) {
    txtDetalleHechos.waitUntilVisible();
    txtDetalleHechos.type(detalle);
    continuarSiguientePantalla();
  }
}
