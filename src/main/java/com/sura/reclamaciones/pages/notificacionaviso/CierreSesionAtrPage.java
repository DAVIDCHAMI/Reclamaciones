package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CierreSesionAtrPage extends GeneralPage {
  @FindBy(xpath = "//img[@src='media/png/icoaccount.png']")
  private WebElementFacade btnPerfilUsuario;

  @FindBy(xpath = "//a[contains(text(),'Cerrar sesión')]")
  private WebElementFacade btnCerrarSesion;

  public CierreSesionAtrPage(WebDriver driver) {
    super(driver);
  }

  public void cerrarSesionAtr() {
    btnPerfilUsuario.waitUntilPresent().waitUntilVisible().waitUntilClickable().click();
    btnCerrarSesion.waitUntilPresent().waitUntilVisible().waitUntilClickable().click();
  }
}
