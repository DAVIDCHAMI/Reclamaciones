package com.sura.reclamaciones.pages.anulacionempresarial;

import static com.sura.reclamaciones.utils.Constantes.PAGO;

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

  @FindBy(
    xpath =
        "//div[@class='x-toolbar-text x-box-item x-toolbar-item x-toolbar-text-default'][contains(text(),'de')]"
  )
  private WebElementFacade lblNumeroPaginas;

  public DetalleTransaccionPage(WebDriver wdriver) {
    super(wdriver);
  }

  private void anularTransaccion() {
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
      if (btnAnular.containsElements(
          By.xpath(
              "//span[@class='x-btn-button']//span[contains(text(),'Anular')]//ancestor::a[contains(@class,'disabled')]"))) {
        return false;
      } else {
        anularTransaccion();
        return true;
      }
    } else {
      if (btnAnular.isVisible()) {
        anularTransaccion();
        return true;
      } else {
        return false;
      }
    }
  }

  private boolean ingresarNumeroAnular(
      List<WebElement> lstTransaccion,
      String strNumeroTransaccion,
      String strEstadoPrevio,
      String tipoAnulacion) {
    for (WebElement aLstPago : lstTransaccion)
      if (tipoAnulacion.equals(PAGO.getValor())) {
        if (aLstPago.getText().equals(strNumeroTransaccion)
            && lstTransaccion.get(5).getText().equals(strEstadoPrevio)) {
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
            && lstTransaccion.get(9).getText().equals(strEstadoPrevio)) {
          aLstPago
              .findElement(
                  By.xpath(String.format("//a[@class='g-actionable'][contains(text(),'$')]")))
              .click();
          return true;
        } else {
          return false;
        }
      }
    return true;
  }

  public boolean ingresarAnulacionEmpresarial(
      String strNumeroTransaccion, String strEstadoPrevio, String strTipoAnulacion) {
    boolean estadoPago;
    List<WebElement> lstTransaccion;
    if (strTipoAnulacion.equals(PAGO.getValor())) {
      lstTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblPago());
    } else {
      lstTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblTransaccion());
    }
    estadoPago =
        ingresarNumeroAnular(
            lstTransaccion, strNumeroTransaccion, strEstadoPrevio, strTipoAnulacion);
    return estadoPago;
  }
}
