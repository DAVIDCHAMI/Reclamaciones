package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class PropiedadesImplicadasPage extends GeneralPage {

  public PropiedadesImplicadasPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//td/div[@class='x-grid-cell-inner ']/div")
  private WebElementFacade rbtPropiedad;

  @FindBy(xpath = "//span[@id='FNOLWizard:FNOLWizard_PickPolicyRiskUnitsScreen:ttlBar']")
  private WebElementFacade titlePropiedadesImplicadas;

  public void seleccionarPropiedad() {
    if (titlePropiedadesImplicadas.isPresent()) {
      rbtPropiedad.waitUntilVisible();
      rbtPropiedad.click();
      continuarSiguientePantalla();
    }
  }
}