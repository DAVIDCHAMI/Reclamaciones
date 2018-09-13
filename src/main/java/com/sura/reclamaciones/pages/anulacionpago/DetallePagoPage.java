package com.sura.reclamaciones.pages.anulacionpago;

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

import static com.sura.reclamaciones.pages.anulacionpago.DetallePagoPage.variablesSesion.NUMERO_PAGINA;

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
    if (btnAnularDetener.isSelected()) {
      btnAnularDetener.click();
      btnAnularCheque.waitUntilClickable();
      btnAnularCheque.click();
      btnAceptar.waitUntilClickable();
      btnAceptar.click();
    } else {
      LOGGER.info("El boton de anulación no se encuentra activo");
      driver.quit();
    }
  }

  public int obtenerNumeroPaginas() {
    if (lblNumeroPaginas.isVisible()) {
      String strNumeroPaginas = lblNumeroPaginas.getText();
      strNumeroPaginas = strNumeroPaginas.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      int intNumeroPaginas = Integer.parseInt(strNumeroPaginas);
      return intNumeroPaginas;
    } else {
      return 0;
    }
  }


  public void ingresarNumeroAnular(List<WebElement> lstPago, String strNumeroPago){
    for (WebElement aLstPago : lstPago) {
      if (aLstPago.getText().equals(strNumeroPago)) {
        aLstPago.click();
        aLstPago
                .findElement(
                        By.xpath(
                                String.format(
                                        "//a[@class='g-actionable'][contains(text(),'%s')]", strNumeroPago)))
                .click();
        break;
      }
    }
  }

  public void ingresarAnulacionPago(String strNumeroPago) {
    int intNumeroPagina = obtenerNumeroPaginas();
    if (intNumeroPagina == 0) {
      List<WebElement> lstPago = obtenerFilaTabla(PagoConstante.PAGOS_RECUPEROS, strNumeroPago);
      int intLongitudFila = lstPago.size();
      if (intLongitudFila == 0){
        LOGGER.info("La reclamación, no tiene pagos");
        driver.quit();
      }else{
        ingresarNumeroAnular(lstPago,strNumeroPago);
        Serenity.setSessionVariable(NUMERO_PAGINA).to(intNumeroPagina);
      }
    } else {
      for (int i = 0; i < intNumeroPagina; i++) {
        List<WebElement> lstPago = obtenerFilaTabla(PagoConstante.PAGOS_RECUPEROS, strNumeroPago);
        int intLongitudFila = lstPago.size();
        if (intLongitudFila == 0) {
          if(intNumeroPagina == i){
            LOGGER.info("El numero de pago ingresado no existe");
            driver.quit();
          }
          irSiguientePagina();
        } else {
          ingresarNumeroAnular(lstPago,strNumeroPago);
          Serenity.setSessionVariable(NUMERO_PAGINA).to(i);
          i= intNumeroPagina;
            }
          }
        }
      }
}
