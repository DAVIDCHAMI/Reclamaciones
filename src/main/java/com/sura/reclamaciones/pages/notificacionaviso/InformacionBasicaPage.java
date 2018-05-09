package com.sura.reclamaciones.pages.notificacionaviso;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class InformacionBasicaPage extends PageObject {

  public InformacionBasicaPage(WebDriver driver) {
    super(driver);
  }


  private String XpathTxtNombreAutor = "//td[.='Nombre']/following-sibling::td//table//table//td[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name-inputCell']/following-sibling::td/div";

  @FindBy(xpath = "//td[.='Nombre']/following-sibling::td//table//table//td[@id='FNOLWizard:GeneralPropertyWizardStepSet:NewClaimWizard_MainContactsScreen:NewClaimPeopleDV:ReportedBy_Name-inputCell']/following-sibling::td/div")
  private WebElementFacade txtNombreAutor;



}
