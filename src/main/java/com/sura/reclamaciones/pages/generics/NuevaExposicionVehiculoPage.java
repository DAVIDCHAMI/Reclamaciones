package com.sura.reclamaciones.pages.generics;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO;

public class NuevaExposicionVehiculoPage extends GeneralPage {

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



  @FindBy(xpath = ".//span[contains(@id,'NewExposure:NewExposureScreen:Update-btnWrap') and contains(text(),'Act')]")
  private WebElementFacade btnActualizar;






  public NuevaExposicionVehiculoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void crearNuevoIncidenteVehicular() {
    btnNuevoIncidenteVehicular.waitUntilClickable().click();
    lblNuevoIncidente.waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public void seleccionarReclamanteExposicion() {
    /*txtReclamanteExposicionVehicular.waitUntilClickable().click();
    seleccionarOpcionCombobox(reclamante);
    realizarEsperaCarga();*/

    String nombreReclamante =
            (Serenity.sessionVariableCalled(SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO.getValor())
                    .toString());
    txtReclamanteExposicionVehicular.clear();
    txtReclamanteExposicionVehicular.typeAndTab(nombreReclamante);;
    realizarEsperaCarga();
  }

  public void seleccionarTipoReclamanteExposicion(String tipoReclamante) {
    txtTipoReclamanteExposicion.waitUntilClickable().click();
    txtTipoReclamanteExposicion
        .findElement(By.xpath("//li[contains(.,'" + tipoReclamante + "')]"))
        .click();
  }

  public void actualizarNuevaExposicion() {
   /*btnActualizar.waitUntilVisible().waitUntilClickable().click();
    realizarEsperaCarga();
    waitFor(
        ExpectedConditions.presenceOfElementLocated(
            By.id("ClaimExposures:ClaimExposuresScreen:ClaimExposures_CloseExposure-btnInnerEl")));
    //realizarEsperaCarga();*/

    realizarEsperaCarga();
    Actions actions = new Actions(driver);
    actions.moveToElement(btnActualizar).click().build().perform();
    btnActualizar.click();
  }
}
