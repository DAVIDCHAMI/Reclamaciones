package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.constantes.Constantes.*;

import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatoFinancieroPagoPage extends GeneralPage {

  public DatoFinancieroPagoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public String obtenerNumeroPagoRealizado() {
    realizarEsperaCarga();
    return obtenerDatoTablaCabecera(NUMERO_PAGO.getValor(), 1);
  }

  public boolean verificarPagoMenuTransaccion(String datoValidar, List<WebElement> lstFilaPago) {
    for (int i = 0; i < lstFilaPago.size(); i++) {
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

  private List<WebElement> obtenerFilaPagoAnulado(String strNumeroTransaccion, String tblPago) {
    List<WebElement> lstPago;
    lstPago = obtenerFilaTabla(strNumeroTransaccion, tblPago);
    return lstPago;
  }

  public boolean verificarEstadoAnuladoPago(String strNumeroTransaccion, String tblPago) {
    List<WebElement> lstPago = obtenerFilaPagoAnulado(strNumeroTransaccion, tblPago);
    for (int i = 0; i < lstPago.size(); i++) {
      if (lstPago.get(i).getText().equals(ESTADO_ANULACION.getValor())) {
        return true;
      }
    }
    return false;
  }

  public boolean ingresarDetalleCheque(String strNumeroTransaccion, String strEstadoPrevio) {
    List<WebElement> lstTransaccion;
    boolean estadoTransaccionPantalla = false;
    for (int i = 0; i <= Integer.parseInt(ITERACIONES_PAGO.getValor()); i++) {
      realizarEsperaCarga();
      lstTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblPago());
      WebElement elementoXpath =
          lstTransaccion.get(Integer.parseInt(UBICACION_ESTADO_PAGO.getValor()));
      estadoTransaccionPantalla = actualizarPantalla(strEstadoPrevio, elementoXpath);
      if (estadoTransaccionPantalla) {
        lstTransaccion.get(Integer.parseInt(VALOR_CERO.getValor())).click();
        lstTransaccion
            .get(Integer.parseInt(VALOR_CERO.getValor()))
            .findElement(
                By.xpath(
                    String.format(
                        "//a[@class='g-actionable'][contains(text(),'%s')]", strNumeroTransaccion)))
            .click();
        break;
      }
    }
    realizarEsperaCarga();
    return estadoTransaccionPantalla;
  }
}
