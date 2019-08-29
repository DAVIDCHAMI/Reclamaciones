package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.constantes.Posiciones.POSICION_FILA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_PLACAS_VEHICULOS_INVOLUCRADOS;

import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetalleSiniestroPage extends GeneralPage {

  @FindBy(
    id =
        "ClaimLossDetails:ClaimLossDetailsScreen:LossDetailsPanelSet:LossDetailsCardCV:LossDetailsDV:EditableVehicleIncidentsLV"
  )
  private WebElementFacade tblPlacasVehiculosInvolucrados;

  @FindBy(
    id =
        "ClaimLossDetails:ClaimLossDetailsScreen:LossDetailsPanelSet:LossDetailsCardCV:LossDetailsDV:ClaimNumber-inputEl"
  )
  private WebElementFacade lblNumeroSiniestro;

  public DetalleSiniestroPage(WebDriver wdriver) {
    super(wdriver);
  }

  public DetalleSiniestroPage() {
    this.tblPlacasVehiculosInvolucrados = tblPlacasVehiculosInvolucrados;
    this.lblNumeroSiniestro = lblNumeroSiniestro;
  }

  public void obtenerNumeroPlacaPartesImplicadas()
  {
    List<String> placaVehiculosInvolucrados = new ArrayList<String>();
    final String PLACA = "Placa";
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(
            tblPlacasVehiculosInvolucrados, PLACA, Integer.parseInt(POSICION_FILA.getValor()));
    int tamanoLista = elementoEncontrado.size();
    Serenity.setSessionVariable(SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS.getValor())
        .to(tamanoLista);
    for (int i = 0; i <= tamanoLista - 1; i++)
    {
      placaVehiculosInvolucrados.add(i, elementoEncontrado.get(i).getText());
    }
      Serenity.setSessionVariable(SESION_CC_PLACAS_VEHICULOS_INVOLUCRADOS.getValor()).to(placaVehiculosInvolucrados);
      List<String> vehiculosInvolucrados = Serenity.sessionVariableCalled(SESION_CC_PLACAS_VEHICULOS_INVOLUCRADOS.getValor());
  }

  public String obtenerNumeroSiniestro() {
    return lblNumeroSiniestro.waitUntilClickable().getText();
  }
}
