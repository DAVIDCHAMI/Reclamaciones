package com.sura.reclamaciones.pages.reservas;

import static com.sura.reclamaciones.constantes.Constantes.VALOR_NUEVA_RESERVA_CAMPO;
import static com.sura.reclamaciones.constantes.MenuConstante.RESERVA;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AjusteReservaPage extends GeneralPage {

  @FindBy(xpath = "//img[@class='x-grid-checkcolumn']")
  private WebElementFacade chkLineaReserva;

  @FindBy(xpath = "//span[@id='NewReserveSet:NewReserveSetScreen:Remove-btnInnerEl']")
  private WebElementFacade btnQuitarLineaReserva;

  @FindBy(id = "NewReserveSet:NewReserveSetScreen:ReservesSummaryDV:EditableReservesLV")
  private WebElementFacade tblLineaReserva;

  @FindBy(xpath = "//span[@id='NewReserveSet:NewReserveSetScreen:Update-btnInnerEl']")
  private WebElementFacade btnGuardarAjusteReserva;

  @FindBy(
    xpath =
        "//span[@id='WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl']"
  )
  private WebElementFacade btnCerrarAdvertencia;

  @FindBy(xpath = "//ul[@class='x-list-plain']")
  private WebElementFacade listExposicion;

  @Page MenuClaimPage menuClaimPage;

  @Page GeneralPage generalPage;

  public AjusteReservaPage(WebDriver driver) {
    super(driver);
  }

  public String getTblLineaReserva() {
    return String.valueOf(tblLineaReserva);
  }

  public void ajustarReserva() {
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(RESERVA);
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
    int ubicacionFilaNuevaReserva = elementoEncontrado.size() - 1;
    WebElement filaNuevaReserva = elementoEncontrado.get(ubicacionFilaNuevaReserva);
    filaNuevaReserva.click();
    if (encabezadoColumnaDevolver.equals(VALOR_NUEVA_RESERVA_CAMPO.getValor())) {
      evaluateJavascript(
          String.format("$('input[name|=\"NewAmount\"]').val('%s')", valorCampoLineaReserva));
      btnGuardarAjusteReserva.click();
      realizarEsperaCarga();
    } else {
      generalPage.seleccionarOpcionLista(listExposicion, valorCampoLineaReserva);
    }
    realizarEsperaCarga();
  }

  public void cerrarAdvertenciaLimiteAgregado() {
    if (btnCerrarAdvertencia.isVisible()) {
      btnCerrarAdvertencia.click();
      realizarEsperaCarga();
      btnGuardarAjusteReserva.click();
    }
  }
}
