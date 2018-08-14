package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class ResumenReclamacionPage extends GeneralPage {

  @FindBy(
    xpath = "//div[@id='NewClaimSaved:NewClaimSavedScreen:NewClaimSavedDV:GoToClaim-inputEl']"
  )
  private WebElementFacade divNumeroReclamacion;

  @FindBy(id = "ClaimSummary:ClaimSummaryScreen:ClaimSummaryExposuresLV:0:Type")
  private WebElementFacade linkTipoExposicion;

  @FindBy(
    id = "ClaimSummary:ClaimSummaryScreen:ClaimSummaryHeadlinePanelSet:TotalGrossIncurred-inputEl"
  )
  private WebElementFacade divReserva;

  public ResumenReclamacionPage(WebDriver driver) {
    super(driver);
  }

  public void resumenReclamacion() {
    divNumeroReclamacion.waitUntilVisible();
    divNumeroReclamacion.click();
  }

  public String validarExposicion() {
    String validadorExposicion;
    if ("Contenido".equals(linkTipoExposicion.waitUntilVisible().getText())) {
      validadorExposicion = "Si";
    } else if ("Propiedad".equals(linkTipoExposicion.waitUntilVisible().getText())) {
      validadorExposicion = "Si";
    } else {
      validadorExposicion = "No";
    }
    return validadorExposicion;
  }

  public String validarReserva() {
    String validadorReserva;
    validadorReserva = divReserva.waitUntilVisible().getText();
    validadorReserva = validadorReserva.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    return validadorReserva;
  }
}
