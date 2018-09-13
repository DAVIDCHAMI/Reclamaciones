package com.sura.reclamaciones.pages.anulacionpago;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.sura.reclamaciones.pages.anulacionpago.DetallePagoPage.variablesSesion.LISTA_PAGO;

public class VerificacionAnulacionPagoPage extends GeneralPage {

  public VerificacionAnulacionPagoPage(WebDriver wdriver) {
    super(wdriver);
  }


  public  boolean verificarEstadoAnulado(String strAnulacionPago) {
    List<WebElement> lstPago = Serenity.sessionVariableCalled(LISTA_PAGO);
    for (WebElement aLstPago : lstPago) {
      if (aLstPago.getText().equals(strAnulacionPago)) {
        return true;
      }
    }
    return false;
  }

}
