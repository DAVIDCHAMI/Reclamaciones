package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;

import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificarPagoPage extends GeneralPage {

  public VerificarPagoPage(WebDriver wdriver) {
    super(wdriver);
  }

  @Page MenuClaimPage menuClaimPage;

  @FindBy(
    id ="ClaimFinancialsChecks:ClaimFinancialsChecksScreen:ChecksLV"
  )
  private WebElementFacade tblVerificacionPago;

  @FindBy (xpath = "//span[@class='x-btn-icon-el x-tbar-page-last ']")
  private WebElementFacade btnUltimaPagina;

  public String capturarNumeroPagoRealizado(String strNumeroPago) {
    if (btnUltimaPagina.isVisible()){
      btnUltimaPagina.click();
    }
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblVerificacionPago, PagoConstante.PAGO_RECUPERO);
    int longitudTabla= elementoEncontrado.size();
    strNumeroPago= elementoEncontrado.get(longitudTabla-1).getText();
    return strNumeroPago;
  }

  public void verificarPagoMenuPagos(String strNumeroPago) {

    menuClaimPage.seleecionarOpcionMenuLateralPrimerNivel(PagoConstante.DATOS_FINANCIEROS);
    menuClaimPage.seleecionarOpcionMenuLateralPrimerNivel(PagoConstante.PAGOS_RECUPEROS);
    if (btnUltimaPagina.isVisible()){
      btnUltimaPagina.click();
    }
  }
}
