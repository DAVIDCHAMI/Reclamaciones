package com.sura.reclamaciones.pages.autos.reclamacion;

import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CONDUCTOR_AFECTADO_SINIESTRO;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class NuevoIncidenteVehicularPage extends GeneralPage {

  public NuevoIncidenteVehicularPage(WebDriver wdriver) {
    super(wdriver);
  }

  @FindBy(
      id =
          "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:Vehicle_LicensePlate-inputEl"
  )
  private WebElementFacade txtPlacaVehículo;

  @FindBy(
      id =
          "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:fasecolda-btnInnerEl"
  )
  private WebElementFacade btnRecuperarInformacion;

  @FindBy(
      xpath =
          "//input[@id='NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:Driver_Picker-inputEl'][contains(@class,'x-form-field x-form-text')]"
  )
  private WebElementFacade cmbNombreConductor;

  @FindBy(
      id =
          "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:OtherServicesLVInputGroupInputSet:OtherServicesInputGroup:_checkbox"
  )
  private WebElementFacade chkServicioTaller;

  @FindBy(
      id =
          "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:OtherServicesLVInputGroupInputSet:OtherServicesInputGroup:OtherServicesLVInputSet:OtherServicesLV_tb:AddAutoRepairShopServiceRequest-btnInnerEl"
  )
  private WebElementFacade btnAgregarTaller;

  private int campoDato = 0;

  public void diligenciarNuevoIncidenteVehicular(
      List<ExposicionVehiculoTercero> datosVehiculoTercero) {
    txtPlacaVehículo
        .waitUntilClickable()
        .sendKeys(datosVehiculoTercero.get(campoDato).getPlacaTercero());
    realizarEsperaCarga();
    btnRecuperarInformacion.waitUntilVisible().waitUntilClickable().click();
    realizarEsperaCarga();
    cmbNombreConductor.waitUntilVisible().waitUntilClickable().click();
    seleccionarOpcionCombobox(
        Serenity.sessionVariableCalled(SESION_CONDUCTOR_AFECTADO_SINIESTRO.getValor()));
    realizarEsperaCarga();
  }

  public void asignarServicioTaller() {
    chkServicioTaller.waitUntilClickable().click();
    realizarEsperaCarga();
    btnAgregarTaller.waitUntilClickable().click();
  }
}
