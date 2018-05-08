package com.sura.reclamaciones.pages.notificacionaviso;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class NuevaReclamacionPage extends PageObject {

  public NuevaReclamacionPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//a[.='Reclamación']/span")
  private WebElementFacade btnReclamacion;

  private String XpathBtnReclamacion = "//a[.='Reclamación']/span";

  @FindBy(xpath = "//a[.='Nueva reclamación']/span")
  private WebElementFacade btnNuevaReclamacion;

  private String XpathBtnNuevaReclamacion = "//a[.='Nueva reclamación']/span";

  public void cliquearReclamacion() {
    waitForPresenceOf(XpathBtnReclamacion);
    btnReclamacion.click();
    waitForPresenceOf(XpathBtnNuevaReclamacion);
    btnNuevaReclamacion.click();
  }
}
