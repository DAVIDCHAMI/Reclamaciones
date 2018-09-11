package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;

import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class VerificarPagoPage extends GeneralPage {

  public VerificarPagoPage(WebDriver wdriver) {
    super(wdriver);
  }

  @Page MenuClaimPage menuClaimPage;

  @FindBy(
    id ="ClaimFinancialsChecks:ClaimFinancialsChecksScreen:ChecksLV"
  )
  private WebElementFacade tblVerificacionPago;

  @FindBy (xpath = "//span[@class='x-btn-icon-el x-tbar-page-last ']")
  private WebElementFacade btnUltimaPagina;

  public String obtenerNumeroPagoRealizado() {
    irUltimaPagina();
    return obtenerDatoTablaCabecera(PagoConstante.PAGO_RECUPERO);
  }

  public boolean verificarPagoMenuTransaccion(String datoValidar, List <WebElement> lstFilaPago) {
      for (WebElement cantidadDatosListaRecupero : lstFilaPago) {
          if (cantidadDatosListaRecupero.getText().equals(datoValidar)) {
              return true;
          }
      }
      return false;
  }

    public void ingresarMenuTransacciones() {
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(MenuConstante.DATOS_FINANCIEROS,MenuConstante.TRANSACCIONES);
        seleccionarTipoTransaccion(PagoConstante.PAGOS);
        irUltimaPagina();

    }
}
