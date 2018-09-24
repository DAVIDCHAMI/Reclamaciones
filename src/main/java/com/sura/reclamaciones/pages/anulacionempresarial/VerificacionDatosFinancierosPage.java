package com.sura.reclamaciones.pages.anulacionempresarial;


import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;

import com.sura.reclamaciones.utils.Variables;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificacionDatosFinancierosPage extends GeneralPage {

  public VerificacionDatosFinancierosPage(WebDriver wdriver) {
    super(wdriver);
  }

  private List<WebElement> irFilaAnulada(String strNumeroPago) {
    Integer intNumeroPagina = Serenity.sessionVariableCalled(Variables.NUMERO_PAGINA);
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
