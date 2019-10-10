package com.sura.reclamaciones.pages.autos.reclamacion;

import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class NuevoIncidenteVehicularPage extends GeneralPage {

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:Vehicle_LicensePlate-inputEl"
  )
  private WebElementFacade txtPlacaVehiculo;

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

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:fasecoldaPopup-btnInnerEl"
  )
  private WebElementFacade btnGenerarCodigoFasecolda;

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:CCAddressInputSet:globalAddressContainer:Address_Picker-inputEl"
  )
  private WebElementFacade cmbLugar;

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Country-inputEl"
  )
  private WebElementFacade cmbPais;

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:State-inputEl"
  )
  private WebElementFacade cmbDepartamento;

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Sura_Colombian_City-inputEl"
  )
  private WebElementFacade cmbCiudad;

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:AddressLine1-inputEl"
  )
  private WebElementFacade cmbDireccion;

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:CCAddressInputSet:globalAddressContainer:Address_Picker-labelEl"
  )
  private WebElementFacade lblLugar;

  public NuevoIncidenteVehicularPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void ingresarPlacaVehiculoAfectado(
      List<ExposicionVehiculoTercero> datosVehiculoTercero, int j) {
    int consecutivoPlacaTercero =
        Integer.parseInt(datosVehiculoTercero.get(Integer.parseInt(VALOR_CERO.getValor())).getPlacaTercero().substring(3, 6));
    consecutivoPlacaTercero = consecutivoPlacaTercero + j;
    String placaVehiculoTercero =
        datosVehiculoTercero.get(Integer.parseInt(VALOR_CERO.getValor())).getPlacaTercero().substring(0, 3)
            + Integer.toString(consecutivoPlacaTercero);
    txtPlacaVehiculo.waitUntilClickable().sendKeys(placaVehiculoTercero);
    realizarEsperaCarga();
  }

  public void consultarInformacionVehiculoAfectado() {
    btnRecuperarInformacion.waitUntilVisible().waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public boolean validarPlacaExisteFasecolda() {
    if (btnGenerarCodigoFasecolda.isVisible()) {
      btnGenerarCodigoFasecolda.click();
      realizarEsperaCarga();
      return true;
    } else {
      seleccionarConductorVehiculoAfectado();
      return false;
    }
  }

  public void seleccionarLugarAtencion(String lugarAtencion) {
    cmbLugar.clear();
    cmbLugar.typeAndTab(lugarAtencion);
    realizarEsperaCarga();
  }

  public void seleccionarPaisAtencion(String pais) {
    cmbPais.clear();
    cmbPais.typeAndTab(pais);
    realizarEsperaCarga();
  }

  public void seleccionarDepartamentoAtencion(String departamento) {
    cmbDepartamento.clear();
    cmbDepartamento.typeAndTab(departamento);
    realizarEsperaCarga();
  }

  public void seleccionarCiudadAtencion(String ciudad) {
    cmbCiudad.clear();
    cmbCiudad.typeAndTab(ciudad);
    realizarEsperaCarga();
  }

  public void seleccionarDireccionAtencion(String direccion) {
    cmbDireccion.clear();
    cmbDireccion.typeAndTab(direccion);
    realizarEsperaCarga();
  }

  public void seleccionarConductorVehiculoAfectado() {
    String nombreConductorTercero =
        (Serenity.sessionVariableCalled(SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO.getValor())
            .toString());
    cmbNombreConductor.clear();
    cmbNombreConductor.typeAndTab(nombreConductorTercero);
    realizarEsperaCarga();
  }

  public void seleccionarServiciosTaller() {
    chkServicioTaller.waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public void seleccionarTaller() {
    btnAgregarTaller.waitUntilClickable().click();
  }
}
