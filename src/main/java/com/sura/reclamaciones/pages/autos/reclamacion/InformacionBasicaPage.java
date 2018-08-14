package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class InformacionBasicaPage extends GeneralPage {

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_BasicInfoScreen:PanelRow:BasicInfoDetailViewPanelDV:ReportedBy_Name-inputEl']/../following-sibling::td"
  )
  private WebElementFacade cmbNombre;

  @FindBy(
    xpath =
        "//div[@class='x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box']//li/following-sibling::li"
  )
  private WebElementFacade lstNombreAutor;

  public InformacionBasicaPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void seleccionarNombre() {
    cmbNombre.click();
    lstNombreAutor.click();
    realizarEsperaCarga();
    continuarSiguientePantalla();
    realizarEsperaCarga();
  }
}
