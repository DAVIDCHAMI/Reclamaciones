package com.sura.reclamaciones.pages.anulaciontransaccion;

import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_ANULACION;
import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_RECUPERO;
import static com.sura.reclamaciones.constantes.Constantes.PAGO;
import static com.sura.reclamaciones.constantes.Constantes.UBICACION_ESTADO_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.UBICACION_ESTADO_RECUPERO;
import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetalleTransaccionPage extends GeneralPage {

  @FindBy(xpath = "//span[@class='x-btn-button']//span[contains(text(),'Anular')]//parent::span")
  private WebElementFacade btnAnular;

  @FindBy(xpath = "//span[@class='x-btn-button']//span[contains(text(),'Aceptar')]")
  private WebElementFacade btnAceptar;

  public DetalleTransaccionPage(WebDriver wdriver) {
    super(wdriver);
  }

  private void anularTransaccion() {
    realizarEsperaCarga();
    btnAnular.waitUntilClickable();
    btnAnular.click();
    realizarEsperaCarga();
    btnAnular.waitUntilClickable();
    btnAnular.click();
    realizarEsperaCarga();
    btnAceptar.waitUntilClickable();
    btnAceptar.click();
    realizarEsperaCarga();
  }

  public boolean realizarAnulacion(String tipoAnulacion) {
    if (tipoAnulacion.equals(PAGO.getValor())) {
      for (int i = 0; i <= Integer.parseInt(ITERACIONES_ANULACION.getValor()); i++)
        if (btnAnular.containsElements(
            By.xpath(
                "//span[@class='x-btn-button']//span[contains(text(),'Anular')]//ancestor::a[contains(@class,'disabled')]"))) {
          realizarEsperaCarga();
          driver.navigate().refresh();
        } else {
          realizarEsperaCarga();
          anularTransaccion();
          return true;
        }
    } else {
      for (int i = 0; i <= Integer.parseInt(ITERACIONES_ANULACION.getValor()); i++)
        if (btnAnular.isVisible()) {
          anularTransaccion();
          return true;
        } else {
          driver.navigate().refresh();
        }
    }
    return false;
  }

  public boolean ingresarAnulacionEmpresarial(
      String strNumeroTransaccion, String strEstadoPrevio, String strTipoAnulacion) {
    final int POSICION_VALOR_MONTO_RECUPERO = 2;
    List<WebElement> lstTransaccion;
    boolean estadoTransaccionPantalla = false;
    if (strTipoAnulacion.equals(PAGO.getValor())) {
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
                          "//a[@class='g-actionable'][contains(text(),'%s')]",
                          strNumeroTransaccion)))
              .click();
          break;
        }
      }
    } else {
      for (int i = 0; i <= Integer.parseInt(ITERACIONES_RECUPERO.getValor()); i++) {
        realizarEsperaCarga();
        lstTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblTransaccion());
        WebElement elementoXpath =
            lstTransaccion.get(Integer.parseInt(UBICACION_ESTADO_RECUPERO.getValor()));
        estadoTransaccionPantalla = actualizarPantalla(strEstadoPrevio, elementoXpath);
        if (estadoTransaccionPantalla) {
          String strMontoRecupero = lstTransaccion.get(POSICION_VALOR_MONTO_RECUPERO).getText();
          lstTransaccion
              .get(POSICION_VALOR_MONTO_RECUPERO)
              .findElement(
                  By.xpath(
                      String.format(
                          "//a[@class='g-actionable'][contains(text(),'" + strMontoRecupero + "')]",
                          strNumeroTransaccion)))
              .click();
          break;
        }
      }
    }
    realizarEsperaCarga();
    return estadoTransaccionPantalla;
  }
}
