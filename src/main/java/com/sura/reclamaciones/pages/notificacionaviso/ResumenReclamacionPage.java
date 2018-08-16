package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class ResumenReclamacionPage extends GeneralPage {

  @FindBy(
    xpath = "//div[@id='NewClaimSaved:NewClaimSavedScreen:NewClaimSavedDV:GoToClaim-inputEl']"
  )
  private WebElementFacade divNumeroReclamacion;

  @FindBy(xpath = "//a[@id='ClaimSummary:ClaimSummaryScreen:ClaimSummaryExposuresLV:0:Type']")
  private WebElementFacade lnkTipoExposicion;

  @FindBy(
    xpath =
        "//div[@id='ClaimSummary:ClaimSummaryScreen:ClaimSummaryHeadlinePanelSet:TotalGrossIncurred-inputEl']"
  )
  private WebElementFacade divReserva;

  public ResumenReclamacionPage(WebDriver driver) {
    super(driver);
  }

  public void resumenReclamacion() {
    String numeroReclamacion;
    divNumeroReclamacion.waitUntilVisible();
    numeroReclamacion = divNumeroReclamacion.getText();
    numeroReclamacion = numeroReclamacion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    LOGGER.info("el número de reclamación generado es: " + numeroReclamacion);
    divNumeroReclamacion.click();
  }

  public String validarExposicion() {
    String validadorExposicion;
    if (lnkTipoExposicion.isVisible()) {
      if (ReclamacionConstante.EXPOSICION_CONTENIDO.equals(
          lnkTipoExposicion.waitUntilVisible().getText())) {
        validadorExposicion = ConstanteGlobal.SI;
      } else if (ReclamacionConstante.EXPOSICION_PROPIEDAD.equals(
          lnkTipoExposicion.waitUntilVisible().getText())) {
        validadorExposicion = ConstanteGlobal.SI;
      } else {
        validadorExposicion = ConstanteGlobal.NO;
      }
    } else {
      validadorExposicion = ConstanteGlobal.NO;
    }
    return validadorExposicion;
  }

  public String validarReserva() {
    String validadorReserva;
    validadorReserva = divReserva.waitUntilVisible().getText();
    validadorReserva = validadorReserva.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    return validadorReserva;
  }
}
