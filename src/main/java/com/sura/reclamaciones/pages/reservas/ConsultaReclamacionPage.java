package com.sura.reclamaciones.pages.reservas;

import static com.sura.reclamaciones.constantes.MenuConstante.RECLAMACION_MENU;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;

public class ConsultaReclamacionPage extends GeneralPage {

  @FindBy(
    id =
        "ClaimLossDetails:ClaimLossDetailsScreen:LossDetailsPanelSet:LossDetailsCardCV:LossDetailsDV:ClaimNumber-inputEl"
  )
  private WebElementFacade lblNumeroSiniestro;

  @FindBy(id = "TabBar:ClaimTab-btnInnerEl")
  public WebElementFacade lblNumeroReclamacion;

  @Page MenuClaimPage menuClaimPage;

  public ConsultaReclamacionPage(WebDriver driver) {
    super(driver);
  }

  public void buscarReclamacion(String numeroReclamacion) {
    menuClaimPage.buscarReclamacion(RECLAMACION_MENU, numeroReclamacion);
  }

  public String getLblNumeroSiniestro() {
    return lblNumeroSiniestro.waitUntilPresent().waitUntilVisible().getText();
  }

  public String obtenerNumeroSiniestro() {
    String numeroReclamacion = lblNumeroReclamacion.getText().replaceAll("\\D+", "");
    realizarEsperaCarga();
    return numeroReclamacion;
  }
}
