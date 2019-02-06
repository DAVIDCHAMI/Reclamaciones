package com.sura.reclamaciones.pages.autos.reclamacion;

import static com.sura.reclamaciones.constantes.Constantes.ESTADO_LEGAL;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DetalleExposicionAutomaticaPage extends GeneralPage {

  @FindBy(
    id =
        "ExposureDetail:ExposureDetailScreen:ExposureDetailDV:SubView_AutoTotalLossCalculatorCardTab-btnInnerEl"
  )
  WebElementFacade calculadoraPerdidaTotal;

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

  @FindBy(id = "ExposureDetail:ExposureDetailScreen:Update-btnInnerEl")
  WebElementFacade btnActualizar;

  @FindBy(
    id =
        "ExposureDetail:ExposureDetailScreen:ExposureDetailDV:VehicleDamage_DetailsCardTab-btnInnerEl"
  )
  WebElementFacade lblDetallesExposicion;

  @FindBy(
    id = "ExposureDetail:ExposureDetailScreen:ExposureDetailDV:VehicleDamageDV:LegalStatus-inputEl"
  )
  WebElementFacade cmbEstadoLegal;

  public DetalleExposicionAutomaticaPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void declararReclamacionPerdidaTotal() {
    calculadoraPerdidaTotal.click();
    realizarEsperaCarga();
    btnEditar.click();
    realizarEsperaCarga();
    rbtIncineracionTotalVehiculo.click();
    rbtMotorDestruidoFuego.click();
    rbtHabitaculoPasajerosIncineradoTotalmente.click();
    btnActualizar.click();
    realizarEsperaCarga();
  }

  public void ingresarEstadoLegalReclamacion() {
    lblDetallesExposicion.click();
    realizarEsperaCarga();
    btnEditar.click();
    realizarEsperaCarga();
    cmbEstadoLegal.waitUntilClickable().sendKeys(ESTADO_LEGAL.getValor());
    realizarEsperaCarga();
    btnActualizar.click();
    realizarEsperaCarga();
  }
}
