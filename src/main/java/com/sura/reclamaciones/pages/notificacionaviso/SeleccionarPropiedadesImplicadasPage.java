package com.sura.reclamaciones.pages.notificacionaviso;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class SeleccionarPropiedadesImplicadasPage extends PageObject {

  public SeleccionarPropiedadesImplicadasPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//td/div[@class='x-grid-cell-inner ']/div")
  private WebElementFacade rbtPropiedad;

  private String XpathRbtPropiedad = "//td/div[@class='x-grid-cell-inner ']/div";

  public void seleccionarPropiedad() {
    waitForPresenceOf(XpathRbtPropiedad);
    rbtPropiedad.click();
  }
}
