package com.sura.reclamaciones.pages.generics;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class CalculadoraCodigoFasecoldaPage extends GeneralPage {

  @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Vehicle_VehicleType-inputEl")
  private WebElementFacade cmbClaseVehiculo;

  @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Vehicle_Year-inputEl")
  private WebElementFacade cmbModelo;

  @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Vehicle_Make-inputEl")
  private WebElementFacade cmbMarca;

  @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Vehicle_Model-inputEl")
  private WebElementFacade cmbLinea;

  @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:ClaimPolicyGeneral_CancelPolicy")
  private WebElementFacade btnValidarCodigoFasecolda;

  @FindBy(id = "FNOLSuraFasecoldaCalculatorPopup:Update")
  private WebElementFacade btnAceptar;

  public CalculadoraCodigoFasecoldaPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void seleccionarClaseVehiculo(String claseVehiculo) {
    cmbClaseVehiculo.clear();
    cmbClaseVehiculo.typeAndTab(claseVehiculo);
  }

  public void seleccionarModeloVehiculo(String modeloVehiculo) {
    cmbModelo.clear();
    cmbModelo.typeAndTab(modeloVehiculo);
  }

  public void seleccionarMarcaVehiculo(String marcaVehiculo) {
    cmbMarca.clear();
    cmbMarca.typeAndTab(marcaVehiculo);
  }

  public void seleccionarLineaVehiculo(String lineaVehiculo) {
    cmbLinea.clear();
    cmbLinea.typeAndTab(lineaVehiculo);
  }

  public void generarCodigoFasecolda() {
    btnValidarCodigoFasecolda.waitUntilClickable();
    btnValidarCodigoFasecolda.click();
    realizarEsperaCarga();
  }

  public void crearCodigoFasecoldaVehiculo() {
    btnAceptar.waitUntilClickable();
    btnAceptar.click();
    realizarEsperaCarga();
  }
}
