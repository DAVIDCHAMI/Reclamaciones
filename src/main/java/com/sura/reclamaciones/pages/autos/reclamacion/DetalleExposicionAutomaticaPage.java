package com.sura.reclamaciones.pages.autos.reclamacion;

import static com.sura.reclamaciones.constantes.Constantes.ESTADO_LEGAL;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DetalleExposicionAutomaticaPage extends GeneralPage {

  @FindBy(
    id =
        "ExposureDetail:ExposureDetailScreen:ExposureDetailDV:SubView_AutoTotalLossCalculatorCardTab-btnInnerEl"
  )
  WebElementFacade lblCalculadoraPerdidaTotal;

  @FindBy(id = "ExposureDetail:ExposureDetailScreen:Edit-btnInnerEl")
  WebElementFacade btnEditar;

  @FindBy(
    id =
        "ExposureDetail:ExposureDetailScreen:ExposureDetailDV:TotalLossCalculatorDV:FireBurnDash_true-inputEl"
  )
  WebElementFacade rbtIncineracionTotalVehiculo;

  @FindBy(
    id =
        "ExposureDetail:ExposureDetailScreen:ExposureDetailDV:TotalLossCalculatorDV:FireBurnEngine_true-inputEl"
  )
  WebElementFacade rbtMotorDestruidoFuego;

  @FindBy(
    id =
        "ExposureDetail:ExposureDetailScreen:ExposureDetailDV:TotalLossCalculatorDV:FireBurnWindshield_true-inputEl"
  )
  WebElementFacade rbtHabitaculoPasajerosIncineradoTotalmente;

  @FindBy(xpath = "//span[@id='ExposureDetail:ExposureDetailScreen:Update-btnInnerEl']")
  WebElementFacade btnActualizar;

  @FindBy(
    xpath =
        "//span[@id='ExposureDetail:ExposureDetailScreen:ExposureDetailDV:VehicleDamage_DetailsCardTab-btnInnerEl'][contains(@class,'x-tab-inner x-tab-inner-center')]"
  )
  WebElementFacade lblDetallesExposicion;

  @FindBy(
    xpath =
        "//input[@id='ExposureDetail:ExposureDetailScreen:ExposureDetailDV:VehicleDamageDV:LegalStatus-inputEl']"
  )
  WebElementFacade cmbEstadoLegal;

  public DetalleExposicionAutomaticaPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void seleccionarCalculadoraPerdidaTotal() {
    lblCalculadoraPerdidaTotal.waitUntilVisible().waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public void editarCalculadoraPerdidaTotal() {
    btnEditar.click();
    realizarEsperaCarga();
  }

  public void seleccionarIncineracionTotalVehiculo() {
    rbtIncineracionTotalVehiculo.click();
  }

  public void seleccionarMotorDestruidoFuego() {
    rbtMotorDestruidoFuego.click();
  }

  public void seleccionarHabitaculoPasajerosIncinerado() {
    rbtHabitaculoPasajerosIncineradoTotalmente.click();
  }

  public void actualizarCalculadoraPerdidaTotal() {
    btnActualizar.click();
    realizarEsperaCarga();
    realizarEsperaCarga();
    realizarEsperaCarga();
  }

  public void seleccionarDetalleExposicion() {
    realizarEsperaCarga();
    lblDetallesExposicion.waitUntilVisible().waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public void editarDetalleExposicion() {
    btnEditar.waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public void ingresarEstadoLegalReclamacion() {
    cmbEstadoLegal.waitUntilVisible().waitUntilClickable().click();
    cmbEstadoLegal
        .findElement(By.xpath("//li[contains(.,'" + ESTADO_LEGAL.getValor() + "')]"))
        .click();
    realizarEsperaCarga();
  }

  public void actualizarDetalleExposicion() {
    btnActualizar.waitUntilVisible().waitUntilClickable().click();
    realizarEsperaCarga();
    realizarEsperaCarga();
  }
}
