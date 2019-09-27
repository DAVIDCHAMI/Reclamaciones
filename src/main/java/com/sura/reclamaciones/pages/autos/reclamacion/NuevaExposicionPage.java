package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NuevaExposicionPage extends GeneralPage {

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

  @FindBy(xpath = "//*[@id=\"NewExposure:NewExposureScreen:Update-btnInnerEl\"]")
  private WebElementFacade btnActualizar;

  public NuevaExposicionPage(WebDriver wdriver) {
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
    Actions actions = new Actions(driver);
    actions.moveToElement(btnActualizar).build().perform();
    btnActualizar.click();
    realizarTiempoEsperaCarga();
  }
}
