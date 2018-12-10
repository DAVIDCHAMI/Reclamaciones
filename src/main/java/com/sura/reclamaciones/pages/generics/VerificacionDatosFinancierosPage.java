package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.utils.Constantes.PAGO;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.anulacionempresarial.DetalleTransaccionPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificacionDatosFinancierosPage extends GeneralPage {

  @Page
  DetalleTransaccionPage detalleTransaccionPage;

  @FindBy(id = "ClaimFinancialsChecks:ClaimFinancialsChecksScreen:ChecksLV")
  private WebElementFacade tblVerificacionPago;

  @FindBy(xpath = "//span[@class='x-btn-icon-el x-tbar-page-last ']")
  private WebElementFacade btnUltimaPagina;

  @FindBy(xpath = "//span[@class='x-column-header-text'][contains(text(),'Número de pago')]")
  private WebElementFacade lblNumeroPago;

  public VerificacionDatosFinancierosPage(WebDriver wdriver) {
    super(wdriver);
  }

  public String obtenerNumeroPagoRealizado() {
    return obtenerDatoTablaCabecera(PagoConstante.NUMERO_PAGO, 1);
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

  private List<WebElement> irFilaAnulada(String strNumeroTransaccion, String strTipoAnulacion) {
    List<WebElement> lstPago;
    if (strTipoAnulacion.equals(PAGO.getValor())) {
      lstPago = obtenerFilaTabla(strNumeroTransaccion, detalleTransaccionPage.getTblPago());
    } else {
      lstPago = obtenerFilaTabla(strNumeroTransaccion, detalleTransaccionPage.getTblTransaccion());
    }
    return lstPago;
  }

  public boolean verificarEstadoAnulado(
      String strAnulacion, String strNumeroTransaccion, String strTipoAnulacion) {
    irUltimaPagina();
    List<WebElement> lstPago = irFilaAnulada(strNumeroTransaccion, strTipoAnulacion);
    for (int i = 0; i < lstPago.size(); i++) {
      if (lstPago.get(i).getText().equals(strAnulacion)) {
        return true;
      }
    }
    return false;
  }
}
