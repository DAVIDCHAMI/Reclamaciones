package com.sura.reclamaciones.pages.generics;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NuevaExposicionVehiculoPage extends GeneralPage
{

  @FindBy(
    id =
        "NewExposure:NewExposureScreen:NewExposureDV:NewClaimVehicleDamageDV:Claimant_Picker-inputEl"
  )
  private WebElementFacade txtReclamanteExposicionVehicular;

  @FindBy(
    id = "NewExposure:NewExposureScreen:NewExposureDV:NewClaimVehicleDamageDV:Claimant_Type-inputEl"
  )
  private WebElementFacade txtTipoReclamanteExposicion;

  @FindBy(
    id =
        "NewExposure:NewExposureScreen:NewExposureDV:NewClaimVehicleDamageDV:Vehicle_Incident:Vehicle_IncidentMenuIcon"
  )
  private WebElementFacade btnNuevoIncidenteVehicular;

  @FindBy(xpath = "//span[contains(text(),'Nuevo incidente')]")
  private WebElementFacade lblNuevoIncidente;

  @FindBy(
    xpath = "//span[contains(@class,'x-btn-inner x-btn-inner-center')][contains(text(),'Act')]"
  )
  private WebElementFacade btnActualizar;

  public NuevaExposicionVehiculoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void crearNuevoIncidenteVehicular() {
    btnNuevoIncidenteVehicular.waitUntilClickable().click();
    lblNuevoIncidente.waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public void seleccionarReclamanteExposicion(String reclamante) {
    txtReclamanteExposicionVehicular.waitUntilClickable().click();
    seleccionarOpcionCombobox(reclamante);
    realizarEsperaCarga();
  }

  public void seleccionarTipoReclamanteExposicion(String tipoReclamante) {
    txtTipoReclamanteExposicion.waitUntilClickable().click();
    txtTipoReclamanteExposicion
        .findElement(By.xpath("//li[contains(.,'" + tipoReclamante + "')]"))
        .click();
  }

  public void actualizarNuevaExposicion() {
    btnActualizar.waitUntilVisible().waitUntilClickable().click();
    waitFor(
        ExpectedConditions.presenceOfElementLocated(
            By.id("ClaimExposures:ClaimExposuresScreen:ClaimExposures_CloseExposure-btnInnerEl")));
  }
}
