package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

  @FindBy(xpath = "//span[@id='TabBar:ClaimTab-btnInnerEl']")
  private WebElementFacade spanNumeroReclamacion;

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
    log.generarRegistro(numeroReclamacion, ConstanteGlobal.AUTOS);
    divNumeroReclamacion.waitUntilVisible();
    return numeroReclamacion;
  }

  public void abrirReclamacion() {
    divNumeroReclamacion.waitUntilVisible();
    divNumeroReclamacion.click();
  }

  public String obtenerNumeroReclamacionConsultaPoliza() {
    String numeroReclamacion;
    spanNumeroReclamacion.waitUntilVisible();
    numeroReclamacion = spanNumeroReclamacion.getText();
    numeroReclamacion = numeroReclamacion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    return numeroReclamacion;
  }

  public void consultarReclamacion(String culpabilidad) {

    switch (culpabilidad) {
      case "Archivo":
        break;
    }
  }
}
