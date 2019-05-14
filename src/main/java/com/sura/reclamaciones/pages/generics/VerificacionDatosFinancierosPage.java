package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.constantes.Constantes.COP;
import static com.sura.reclamaciones.constantes.Constantes.NUMERO_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.PAGO;
import static com.sura.reclamaciones.constantes.Constantes.USD;

import com.sura.reclamaciones.pages.anulacionetransaccion.DetalleTransaccionPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificacionDatosFinancierosPage extends GeneralPage {

  @Page DetalleTransaccionPage detalleTransaccionPage;

  public VerificacionDatosFinancierosPage(WebDriver wdriver) {
    super(wdriver);
  }

  public String obtenerNumeroPagoRealizado() {
    return obtenerDatoTablaCabecera(NUMERO_PAGO.getValor(), 1);
  }

  public boolean verificarPagoMenuTransaccion(String datoValidar, List<WebElement> lstFilaPago) {
    int i;
    for (i = 0; i < lstFilaPago.size(); i++) {
      String strDatoPantalla = lstFilaPago.get(i).getText();
      if (strDatoPantalla.contains(COP.getValor()) || strDatoPantalla.contains(USD.getValor())) {
        strDatoPantalla = strDatoPantalla.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      }
      if (strDatoPantalla.equals(datoValidar)) {
        return true;
      }
    }
    return false;
  }

  private List<WebElement> obtenerFilaAnulada(
      String strNumeroTransaccion, String strTipoAnulacion) {
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
    List<WebElement> lstPago = obtenerFilaAnulada(strNumeroTransaccion, strTipoAnulacion);
    for (int i = 0; i < lstPago.size(); i++) {
      if (lstPago.get(i).getText().equals(strAnulacion)) {
        return true;
      }
    }
    return false;
  }
}
