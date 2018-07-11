package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class InformacionBasicaPage extends GeneralPage {

  public InformacionBasicaPage(WebDriver driver) {
    super(driver);
  }

  private String XpathTxtNombreAutor =
      "//td[.='Nombre']/following-sibling::td//table//table//td[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name-inputCell']/following-sibling::td/div";

  @FindBy(
    xpath =
        "//td[.='Nombre']/following-sibling::td//table//table//td[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name-inputCell']/following-sibling::td/div"
  )
  private WebElementFacade txtNombreAutor;

  private String XpathAutorDelReporte = "//li[.='<ninguno>']/following-sibling::li";

  @FindBy(xpath = "//li[.='<ninguno>']/following-sibling::li")
  private WebElementFacade autorDelReporte;

  private String XpathTxtDetalleHechos =
      "//textarea[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:Description-inputEl']";

  @FindBy(
    xpath =
        "//textarea[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:Description-inputEl']"
  )
  private WebElementFacade txtDetalleHechos;

  public void seleccionarAutorDelReporte() {
    waitForPresenceOf(XpathTxtNombreAutor);
    txtNombreAutor.click();
    waitForPresenceOf(XpathAutorDelReporte);
    autorDelReporte.click();
    realizarEsperaCarga();
  }

  public void escribirDetallehechos(String detalle) {
    waitForPresenceOf(XpathTxtDetalleHechos);
    txtDetalleHechos.type(detalle);
    cliquearSiguiente();
  }
}
