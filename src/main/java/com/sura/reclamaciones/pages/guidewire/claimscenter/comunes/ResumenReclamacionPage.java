package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.Constantes.NO;
import static com.sura.reclamaciones.utils.enums.Constantes.SI;

import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.utils.Utilidades;
import com.sura.reclamaciones.utils.constantes.ReclamacionConstante;
import com.sura.reclamaciones.utils.enums.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class ResumenReclamacionPage extends GeneralPage {

  @FindBy(
    xpath = "//div[@id='NewClaimSaved:NewClaimSavedScreen:NewClaimSavedDV:GoToClaim-inputEl']"
  )
  private WebElementFacade divNumeroReclamacion;

  @FindBy(xpath = "//a[@id='ClaimExposures:ClaimExposuresScreen:ExposuresLV:0:Type']")
  private WebElementFacade lnkTipoExposicion;

  @FindBy(
    xpath =
        "//a[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV:0:Amount']"
  )
  private WebElementFacade lnkReservaTransaccion;

  @FindBy(
    xpath =
        "//span[@id='Claim:ClaimInfoBar:LicensePlate-btnInnerEl']//child::span[@class='infobar_elem_val']"
  )
  private WebElementFacade lblNumeroPlaca;

  public ResumenReclamacionPage(WebDriver driver) {
    super(driver);
  }

  public String validarExposicion() {
    String validadorExposicion;
    String validador;
    if (lnkTipoExposicion.isVisible()) {
      validador = lnkTipoExposicion.waitUntilVisible().getText();
      switch (validador) {
        case ReclamacionConstante.EXPOSICION_CONTENIDO:
        case ReclamacionConstante.EXPOSICION_PROPIEDAD:
        case ReclamacionConstante.EXPOSICION_GENERAL:
          validadorExposicion = SI.getValor();
          break;
        default:
          validadorExposicion = NO.getValor();
          break;
      }
    } else {
      validadorExposicion = NO.getValor();
    }
    return validadorExposicion;
  }

  public String validarReservaTransaccion(String montoReserva) {
    String validarReservaTransaccion;
    if (lnkReservaTransaccion.isVisible()) {
      validarReservaTransaccion = lnkReservaTransaccion.waitUntilVisible().getText();
      validarReservaTransaccion =
          validarReservaTransaccion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    } else {
      validarReservaTransaccion = montoReserva;
      Utilidades.getLogger().info("No se ha generado reserva en la sección de transacciones");
    }
    return validarReservaTransaccion;
  }

  public String consultarNumeroPlaca() {
    String numeroPlaca;
    numeroPlaca = lblNumeroPlaca.waitUntilVisible().getText();
    return numeroPlaca;
  }
}
