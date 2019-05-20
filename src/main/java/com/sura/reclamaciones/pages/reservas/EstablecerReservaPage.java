package com.sura.reclamaciones.pages.reservas;

import static com.sura.reclamaciones.constantes.Constantes.CC_NOMBRE_CAMPO_VALOR_NUEVA_RESERVA;
import static com.sura.reclamaciones.constantes.Constantes.CC_POSICION_VALOR_RESERVA_EMPRESARIALES;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EstablecerReservaPage extends GeneralPage {

  @FindBy(xpath = "//img[@class='x-grid-checkcolumn']")
  private WebElementFacade chkLineaReserva;

  @FindBy(xpath = "//span[@id='NewReserveSet:NewReserveSetScreen:Remove-btnInnerEl']")
  private WebElementFacade btnQuitarLineaReserva;

  @FindBy(id = "NewReserveSet:NewReserveSetScreen:ReservesSummaryDV:EditableReservesLV")
  private WebElementFacade tblLineaReserva;

  @FindBy(xpath = "//span[@id='NewReserveSet:NewReserveSetScreen:Update-btnInnerEl']")
  private WebElementFacade btnGuardarAjusteReserva;

  @FindBy(xpath = "//ul[@class='x-list-plain']")
  private WebElementFacade listExposicion;

  @Page GeneralPage generalPage;

  public EstablecerReservaPage(WebDriver driver) {
    super(driver);
  }

  public void eliminarReservaVacia() {
    if (chkLineaReserva.isVisible()) {
      chkLineaReserva.click();
      btnQuitarLineaReserva.waitUntilClickable().click();
    }
  }

  public void diligenciarCampoLineaReserva(
      String valorCampoLineaReserva,
      String encabezadoColumnaDevolver,
      Integer posicionColumnaReserva) {
    realizarEsperaCarga();
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(
            tblLineaReserva, encabezadoColumnaDevolver, posicionColumnaReserva);
    int ubicacionFilaNuevaReserva =
        elementoEncontrado.size()
            + Integer.parseInt(CC_POSICION_VALOR_RESERVA_EMPRESARIALES.getValor());
    WebElement filaNuevaReserva = elementoEncontrado.get(ubicacionFilaNuevaReserva);
    filaNuevaReserva.click();
    if (encabezadoColumnaDevolver.equals(CC_NOMBRE_CAMPO_VALOR_NUEVA_RESERVA.getValor())) {
      evaluateJavascript(
          String.format("$('input[name|=\"NewAmount\"]').val('%s')", valorCampoLineaReserva));
      btnGuardarAjusteReserva.click();
    } else {
      generalPage.seleccionarOpcionLista(listExposicion, valorCampoLineaReserva);
    }
    realizarEsperaCarga();
  }
}
