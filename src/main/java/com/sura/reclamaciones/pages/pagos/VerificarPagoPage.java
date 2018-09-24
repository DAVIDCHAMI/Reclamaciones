package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificarPagoPage extends GeneralPage {

  public VerificarPagoPage(WebDriver wdriver) {
    super(wdriver);
  }

  @Page MenuClaimPage menuClaimPage;

  @FindBy(id = "ClaimFinancialsChecks:ClaimFinancialsChecksScreen:ChecksLV")
  private WebElementFacade tblVerificacionPago;

  @FindBy(xpath = "//span[@class='x-btn-icon-el x-tbar-page-last ']")
  private WebElementFacade btnUltimaPagina;

  @FindBy(xpath = "//span[@class='x-column-header-text'][contains(text(),'Número de pago')]")
  private WebElementFacade lblNumeroPago;

  public String obtenerNumeroPagoRealizado() {
    irUltimaPagina();
    lblNumeroPago.click();
    return obtenerDatoTablaCabecera(PagoConstante.NÚMERO_PAGO);
  }

  public boolean verificarPagoMenuTransaccion(String datoValidar, List<WebElement> lstFilaPago) {
    int i;
    for (i = 0; i < lstFilaPago.size(); i++) {
      String strDatoPantalla = lstFilaPago.get(i).getText();
      if (strDatoPantalla.contains(PagoConstante.COP)
          || strDatoPantalla.contains(PagoConstante.USD)) {
        strDatoPantalla = strDatoPantalla.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      }
      if (strDatoPantalla.equals(datoValidar)) {
        return true;
      }
    }
    return false;
  }
}
