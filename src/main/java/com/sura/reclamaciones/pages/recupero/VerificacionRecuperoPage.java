package com.sura.reclamaciones.pages.recupero;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.RecuperoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificacionRecuperoPage extends GeneralPage {

  public VerificacionRecuperoPage(WebDriver driver) {
    super(driver);
  }

  @Page MenuClaimPage menuClaimPage;

  @FindBy(
    xpath =
        "//div[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV-body']"
  )
  private WebElementFacade tblVerificacionRecupero;

  public List<WebElement> obtenerListaRecupero() {
    verificarBotonUltimaPaginaVisible();
    realizarEsperaCarga();
    String strNumeroRecupero = obtenerNumeroTransaccion(RecuperoConstante.NUMERO_TRANSACCION);
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
    seleccionarTipoTransaccion(RecuperoConstante.TIPO_TRANSACCION);
    verificarBotonUltimaPaginaVisible();
    List<WebElement> lstFilaRecupero= obtenerFilaTransacciones(strNumeroRecupero);
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
