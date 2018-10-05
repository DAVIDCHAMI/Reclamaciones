package com.sura.reclamaciones.pages.anulacionempresarial;

import com.sura.reclamaciones.constantes.AnulacionConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.Serenity;
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

  @FindBy(
    xpath =
        "//div[@class='x-toolbar-text x-box-item x-toolbar-item x-toolbar-text-default'][contains(text(),'de')]"
  )
  private WebElementFacade lblNumeroPaginas;

  public static String tblPago =
      "//tr//td//div//a[contains(text(),'%s')]//parent::div//parent::td//parent::tr//td";
  public static String tblTransaccion =
      "//tr//td//div[contains(text(),'%s')]//parent::td//parent::tr//td";

  public DetalleTransaccionPage(WebDriver wdriver) {
    super(wdriver);
  }

  public boolean realizarAnulacion() {
    if (btnAnular.isVisible()) {
      btnAnular.waitUntilClickable();
      btnAnular.click();
      realizarEsperaCarga();
      btnAnular.waitUntilClickable();
      btnAnular.click();
      realizarEsperaCarga();
      btnAceptar.waitUntilClickable();
      btnAceptar.click();
      realizarEsperaCarga();
      return true;
    }
    return false;
  }

  private int obtenerNumeroPaginas() {
    if (lblNumeroPaginas.isVisible()) {
      String strNumeroPaginas = lblNumeroPaginas.getText();
      strNumeroPaginas = strNumeroPaginas.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      int intNumeroPaginas;
      intNumeroPaginas = Integer.parseInt(strNumeroPaginas);
      return intNumeroPaginas;
    } else {
      return 0;
    }
  }

  private boolean ingresarNumeroAnular(
      List<WebElement> lstPago,
      String strNumeroTransaccion,
      String strEstadoPrevio,
      String tipoAnulacion) {
    for (WebElement aLstPago : lstPago) {
      if (tipoAnulacion.equals(AnulacionConstante.PAGO)) {
        if (aLstPago.getText().equals(strNumeroTransaccion)
            && lstPago.get(5).getText().equals(strEstadoPrevio)) {
          aLstPago.click();
          aLstPago
              .findElement(
                  By.xpath(
                      String.format(
                          "//a[@class='g-actionable'][contains(text(),'%s')]",
                          strNumeroTransaccion)))
              .click();
          return true;
        } else {
          return false;
        }
      } else {
        if (aLstPago.getText().equals(strNumeroTransaccion)
            && lstPago.get(9).getText().equals(strEstadoPrevio)) {
          lstPago.get(2).click();
          return true;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  private boolean ingresarAnulacionPrimeraHoja(
      String strNumeroTransaccion,
      String strEstadoPrevio,
      int intNumeroPaginas,
      String tipoAnulacion) {
    boolean estadoPago;
    List<WebElement> lstPago;
    if (tipoAnulacion.equals(AnulacionConstante.PAGO)) {
      lstPago = obtenerFilaTabla(strNumeroTransaccion, tblPago);
    } else {
      lstPago = obtenerFilaTabla(strNumeroTransaccion, tblTransaccion);
    }
    int intLongitudFila = lstPago.size();
    if (intLongitudFila == 0) {
      return false;
    } else {
      estadoPago =
          ingresarNumeroAnular(lstPago, strNumeroTransaccion, strEstadoPrevio, tipoAnulacion);
      Serenity.setSessionVariable(Variables.NUMERO_PAGINA).to(intNumeroPaginas);
      return estadoPago;
    }
  }

  private boolean ingresarAnulacionHojaDiferentePrimera(
      String strNumeroTransaccion,
      String strEstadoPrevio,
      int intNumeroPaginas,
      String tipoAnulacion) {
    for (int i = 0; i < intNumeroPaginas; i++) {
      List<WebElement> lstPago;
      if (tipoAnulacion.equals(AnulacionConstante.PAGO)) {
        lstPago = obtenerFilaTabla(strNumeroTransaccion, tblPago);
      } else {
        lstPago = obtenerFilaTabla(strNumeroTransaccion, tblTransaccion);
      }
      int intLongitudFila = lstPago.size();
      if (intLongitudFila == 0) {
        if (i == (intNumeroPaginas - 1)) {
          return false;
        } else {
          irSiguientePagina();
        }
      } else {
        boolean estadoPago =
            ingresarNumeroAnular(lstPago, strNumeroTransaccion, strEstadoPrevio, tipoAnulacion);
        Serenity.setSessionVariable(Variables.NUMERO_PAGINA).to(i);
        return estadoPago;
      }
    }
    return true;
  }

  public boolean ingresarAnulacionEmpresarial(
      String strNumeroTransaccion, String strEstadoPrevio, String tipoAnulacion) {
    int intNumeroPagina = obtenerNumeroPaginas();
    boolean estadoPago;
    if (intNumeroPagina == 0) {
      estadoPago =
          ingresarAnulacionPrimeraHoja(
              strNumeroTransaccion, strEstadoPrevio, intNumeroPagina, tipoAnulacion);
      return estadoPago;
    } else {
      estadoPago =
          ingresarAnulacionHojaDiferentePrimera(
              strNumeroTransaccion, strEstadoPrevio, intNumeroPagina, tipoAnulacion);
      return estadoPago;
    }
  }
}
