package com.sura.reclamaciones.pages.reservas;

import static com.sura.reclamaciones.constantes.MenuConstante.*;
import static com.sura.reclamaciones.constantes.ReclamacionConstante.*;

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
  WebElementFacade chkLineaReserva;

  @FindBy(xpath = "//span[@id='NewReserveSet:NewReserveSetScreen:Remove-btnInnerEl']")
  WebElementFacade btnQuitarLineaReserva;

  @FindBy(
    xpath = "//div[@id='NewReserveSet:NewReserveSetScreen:ReservesSummaryDV:EditableReservesLV']"
  )
  WebElementFacade tblLineaReserva;

  @FindBy(xpath = "//span[@id='NewReserveSet:NewReserveSetScreen:Update-btnInnerEl']")
  WebElementFacade btnGuardarAjusteReserva;

  @FindBy(
    xpath =
        "//span[@id='WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl']"
  )
  WebElementFacade btnCerrarAdvertencia;

  @Page MenuClaimPage menuClaimPage;

  public AjusteReservaPage(WebDriver driver) {
    super(driver);
  }

  public void ajustarReserva() {
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(RESERVA);
    if (chkLineaReserva.isVisible()) {
      chkLineaReserva.click();
      btnQuitarLineaReserva.waitUntilClickable().click();
    }
  }

  public void diligenciarCantidadAjusteReserva(
      String montoAjusteReserva, String encabezadoColumnaDevolver) {
    realizarEsperaCarga();
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblLineaReserva, encabezadoColumnaDevolver, -1);
    elementoEncontrado.forEach(
        elemento -> {
          elemento.click();
          evaluateJavascript(
              String.format("$('input[name|=\"NewAmount\"]').val('%s')", montoAjusteReserva));
          btnGuardarAjusteReserva.click();
          realizarEsperaCarga();
        });
  }

  public void cerrarAdvertenciaLimiteAgregado() {
    if (btnCerrarAdvertencia.isVisible()) {
      btnCerrarAdvertencia.click();
      realizarEsperaCarga();
      btnGuardarAjusteReserva.click();
    }
  }

  public void verificarReservaAjustada() {
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(DATOS_FINANCIEROS, TRANSACCIONES);
  }
}
