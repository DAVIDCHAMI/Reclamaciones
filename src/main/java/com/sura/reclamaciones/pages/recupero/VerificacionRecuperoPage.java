package com.sura.reclamaciones.pages.recupero;

import static com.sura.reclamaciones.constantes.Constantes.NUMERO_TRANSACCION;
import static com.sura.reclamaciones.constantes.Constantes.TIPO_TRANSACCION;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificacionRecuperoPage extends GeneralPage {

  @Page MenuClaimPage menuClaimPage;

  private static String tblRecupero =
      "//tr//td//div[contains(text(),'%s')]//parent::td//parent::tr//td";

  public VerificacionRecuperoPage(WebDriver driver) {
    super(driver);
  }

  public List<WebElement> obtenerListaRecupero() {
    String strNumeroRecupero = obtenerDatoTablaCabecera(NUMERO_TRANSACCION.getValor(), 1);
   // seleccionarTipoTransaccion(TIPO_TRANSACCION.getValor());
    List<WebElement> lstFilaRecupero;
    lstFilaRecupero = obtenerFilaTabla(strNumeroRecupero, tblRecupero);
    return lstFilaRecupero;
  }

  public boolean verificarRecupero(String datoValidar, List<WebElement> lstFilaRecupero) {
    for (WebElement cantidadDatosListaRecupero : lstFilaRecupero) {
      if (cantidadDatosListaRecupero.getText().equals(datoValidar)) {
        return true;
      }
    }
    return false;
  }
}
