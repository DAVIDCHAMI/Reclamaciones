package com.sura.reclamaciones.pages.anulacionempresarial;

import static com.sura.reclamaciones.pages.anulacionempresarial.DetallePagoPage.variablesSesion.NUMERO_PAGINA;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificacionAnulacionPagoPage extends GeneralPage {

  public VerificacionAnulacionPagoPage(WebDriver wdriver) {
    super(wdriver);
  }

  private List<WebElement> irFilaAnulada(String strNumeroPago) {
    Integer intNumeroPagina = Serenity.sessionVariableCalled(NUMERO_PAGINA);
    List<WebElement> lstPago;
    if (intNumeroPagina.equals(0)) {
      lstPago = obtenerFilaTabla(PagoConstante.PAGOS, strNumeroPago);
    } else {
      for (int i = 0; i < intNumeroPagina; i++) {
        irSiguientePagina();
      }
      lstPago = obtenerFilaTabla(PagoConstante.PAGOS, strNumeroPago);
    }
    return lstPago;
  }

  public boolean verificarEstadoAnulado(String strAnulacionPago, String strNumeroPago) {
    List<WebElement> lstPago = irFilaAnulada(strNumeroPago);
    for (int i = 0; i < lstPago.size(); i++) {
      if (lstPago.get(i).getText().equals(strAnulacionPago)) {
        return true;
      }
    }
    return false;
  }
}
