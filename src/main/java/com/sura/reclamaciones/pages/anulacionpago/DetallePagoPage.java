package com.sura.reclamaciones.pages.anulacionpago;

import static com.sura.reclamaciones.pages.anulacionpago.DetallePagoPage.variablesSesion.NUMERO_PAGINA;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetallePagoPage extends GeneralPage {

  @FindBy(
    xpath =
        "//span[@id='ClaimFinancialsChecksDetail:ClaimFinancialsChecksDetailScreen:ClaimFinancialsChecksDetail_VoidStopButton-btnInnerEl']"
  )
  private WebElementFacade btnAnularDetener;

  @FindBy(
    xpath = "//span[@id='VoidStopCheck:VoidStopCheckScreen:VoidStopCheck_VoidButton-btnInnerEl']"
  )
  private WebElementFacade btnAnularCheque;

  @FindBy(
    xpath =
        "//div[@class='x-window x-message-box x-layer x-window-default x-closable x-window-closable x-window-default-closable x-border-box']//div//span[@class='x-btn-inner x-btn-inner-center'][contains(text(),'Aceptar')]"
  )
  private WebElementFacade btnAceptar;

  @FindBy(
    xpath =
        "//div[@class=\"x-toolbar-text x-box-item x-toolbar-item x-toolbar-text-default\"][contains(text(),'de')]"
  )
  private WebElementFacade lblNumeroPaginas;

  public enum variablesSesion {
    NUMERO_PAGINA
  }

  public DetallePagoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void realizarAnulacionPago() {
    btnAnularDetener.waitUntilClickable();
    btnAnularDetener.click();
    realizarEsperaCarga();
    btnAnularCheque.waitUntilClickable();
    btnAnularCheque.click();
    realizarEsperaCarga();
    btnAceptar.waitUntilClickable();
    btnAceptar.click();
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
      List<WebElement> lstPago, String strNumeroPago, String strEstadoPrevio) {
    for (WebElement aLstPago : lstPago) {
      if (aLstPago.getText().equals(strNumeroPago)
          && lstPago.get(5).getText().equals(strEstadoPrevio)) {
        aLstPago.click();
        aLstPago
            .findElement(
                By.xpath(
                    String.format(
                        "//a[@class='g-actionable'][contains(text(),'%s')]", strNumeroPago)))
            .click();
        return true;
      }
    }
    return false;
  }

  public boolean ingresarAnulacionPago(String strNumeroPago, String strEstadoPrevio) {
    int intNumeroPagina = obtenerNumeroPaginas();
    boolean estadoPago;
    if (intNumeroPagina == 0) {
      List<WebElement> lstPago = obtenerFilaTabla(PagoConstante.PAGOS, strNumeroPago);
      int intLongitudFila = lstPago.size();
      if (intLongitudFila == 0) {
        return false;
      } else {
        estadoPago= ingresarNumeroAnular(lstPago, strNumeroPago, strEstadoPrevio);
        Serenity.setSessionVariable(NUMERO_PAGINA).to(intNumeroPagina);
        return estadoPago;
      }
    } else {
      for (int i = 0; i < intNumeroPagina; i++) {
        List<WebElement> lstPago = obtenerFilaTabla(PagoConstante.PAGOS, strNumeroPago);
        int intLongitudFila = lstPago.size();
        if (intLongitudFila == 0) {
           if (i == (intNumeroPagina -1)){
             return false;
           }
           else {
             irSiguientePagina();
           }
          }
        else {
          estadoPago= ingresarNumeroAnular(lstPago, strNumeroPago, strEstadoPrevio);
          Serenity.setSessionVariable(NUMERO_PAGINA).to(i);
          return estadoPago;
        }
      }
    }
    return true;
  }
}
