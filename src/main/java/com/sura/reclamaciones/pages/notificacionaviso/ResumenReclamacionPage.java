package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Utilidades;
import com.sura.reclamaciones.utils.Variables;
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

  public ResumenReclamacionPage(WebDriver driver) {
    super(driver);
  }

  public String obtenerNumeroReclamacion() {
    String numeroReclamacion;
    divNumeroReclamacion.waitUntilVisible();
    numeroReclamacion = divNumeroReclamacion.getText();
    numeroReclamacion = numeroReclamacion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    Utilidades.getLogger()
        .info(String.format("el número de reclamación generado es: %s\n", numeroReclamacion));
    divNumeroReclamacion.click();
    return numeroReclamacion;
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
          validadorExposicion = ConstanteGlobal.SI;
          break;
        default:
          validadorExposicion = ConstanteGlobal.NO;
          break;
      }
    } else {
      validadorExposicion = ConstanteGlobal.NO;
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
}