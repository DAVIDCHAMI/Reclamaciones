package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO;

import com.sura.reclamaciones.pages.general.GeneralPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NuevaExposicionVehiculoPage extends GeneralPage {

  @FindBy(
      id =
          "NewExposure:NewExposureScreen:NewExposureDV:NewClaimVehicleDamageDV:Claimant_Picker-inputEl")
  private WebElementFacade txtReclamanteExposicionVehicular;

  @FindBy(
      id =
          "NewExposure:NewExposureScreen:NewExposureDV:NewClaimVehicleDamageDV:Claimant_Type-inputEl")
  private WebElementFacade txtTipoReclamanteExposicion;

  @FindBy(
      id =
          "NewExposure:NewExposureScreen:NewExposureDV:NewClaimVehicleDamageDV:Vehicle_Incident:Vehicle_IncidentMenuIcon")
  private WebElementFacade btnNuevoIncidenteVehicular;

  @FindBy(xpath = "//span[contains(text(),'Nuevo incidente')]")
  private WebElementFacade lblNuevoIncidente;

  @FindBy(xpath = "//*[@id=\"NewExposure:NewExposureScreen:Update-btnInnerEl\"]")
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
    String nombreReclamante =
        (Serenity.sessionVariableCalled(SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO.getValor())
            .toString());
    txtReclamanteExposicionVehicular.clear();
    txtReclamanteExposicionVehicular.typeAndTab(nombreReclamante);
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
