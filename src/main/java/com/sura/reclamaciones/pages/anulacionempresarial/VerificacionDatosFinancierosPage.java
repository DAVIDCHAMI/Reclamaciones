package com.sura.reclamaciones.pages.anulacionempresarial;

import com.sura.reclamaciones.constantes.AnulacionConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificacionDatosFinancierosPage extends GeneralPage {

  @Page DetalleTransaccionPage detalleTransaccionPage;

  public VerificacionDatosFinancierosPage(WebDriver wdriver) {
    super(wdriver);
  }

  private List<WebElement> irFilaAnulada(String strNumeroTransaccion, String strTipoAnulacion) {
    Integer intNumeroPagina = Serenity.sessionVariableCalled(Variables.NUMERO_PAGINA);
    List<WebElement> lstPago;
    if (strTipoAnulacion.equals(AnulacionConstante.PAGO)) {
      if (intNumeroPagina.equals(0)) {
        lstPago = obtenerFilaTabla(strNumeroTransaccion, detalleTransaccionPage.getTblPago());
      } else {
        for (int i = 0; i < intNumeroPagina; i++) {
          irSiguientePagina();
        }
        lstPago = obtenerFilaTabla(strNumeroTransaccion, detalleTransaccionPage.getTblPago());
      }
    } else {
      if (intNumeroPagina.equals(0)) {
        lstPago =
            obtenerFilaTabla(strNumeroTransaccion, detalleTransaccionPage.getTblTransaccion());
      } else {
        for (int i = 0; i < intNumeroPagina; i++) {
          irSiguientePagina();
        }
        lstPago =
            obtenerFilaTabla(strNumeroTransaccion, detalleTransaccionPage.getTblTransaccion());
      }
    }
    return lstPago;
  }

  public boolean verificarEstadoAnulado(
      String strAnulacion, String strNumeroTransaccion, String strTipoAnulacion) {
    List<WebElement> lstPago = irFilaAnulada(strNumeroTransaccion, strTipoAnulacion);
    for (int i = 0; i < lstPago.size(); i++) {
      if (lstPago.get(i).getText().equals(strAnulacion)) {
        return true;
      }
    }
    return false;
  }
}
