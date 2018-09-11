package com.sura.reclamaciones.pages.reservas;

import static com.sura.reclamaciones.constantes.MenuConstante.*;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;

public class ConsultaReclamacionPage extends GeneralPage {

  @FindBy(xpath = "//input[@id='TabBar:ClaimTab:ClaimTab_FindClaim-inputEl']")
  WebElementFacade txtNumReclamacion;

  @Page MenuClaimPage menuClaimPage;

  public ConsultaReclamacionPage(WebDriver driver) {
    super(driver);
  }

  public void buscarReclamacion(String numeroReclamacion) {
    menuClaimPage.buscarReclamacion(RECLAMACION_MENU, numeroReclamacion);
  }
}
