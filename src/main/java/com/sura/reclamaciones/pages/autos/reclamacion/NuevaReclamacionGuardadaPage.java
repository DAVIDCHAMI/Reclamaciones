package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class NuevaReclamacionGuardadaPage extends GeneralPage {

  public NuevaReclamacionGuardadaPage(WebDriver wdriver) {
    super(wdriver);
  }

  @FindBy(id = "NewClaimSaved:NewClaimSavedScreen:ttlBar")
  private WebElementFacade lblMensajeValidar;

  @FindBy(
      xpath = "//div[@id='NewClaimSaved:NewClaimSavedScreen:NewClaimSavedDV:GoToClaim-inputEl']"
  )
  private WebElementFacade divNumeroReclamacion;

  public String obtenerMensajeValidador() {
    String valorMensaje;
    lblMensajeValidar.waitUntilVisible();
    valorMensaje = lblMensajeValidar.getText();
    return valorMensaje;
  }

  public String obtenerNumeroReclamacion() {
    String numeroReclamacion;
    divNumeroReclamacion.waitUntilVisible();
    numeroReclamacion = divNumeroReclamacion.getText();
    numeroReclamacion = numeroReclamacion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    LOGGER.info(String.format("el número de reclamación generado es: %s\n", numeroReclamacion));
    GenericStep log = new GenericStep();
    log.generarRegistro(numeroReclamacion,ConstanteGlobal.AUTOS);
    divNumeroReclamacion.click();
    return numeroReclamacion;
  }

}
