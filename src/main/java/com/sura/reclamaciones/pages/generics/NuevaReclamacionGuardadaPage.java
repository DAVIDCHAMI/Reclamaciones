package com.sura.reclamaciones.pages.generics;

import com.sura.reclamaciones.utils.Utilidades;
import com.sura.reclamaciones.utils.Variables;
import java.util.concurrent.TimeUnit;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class NuevaReclamacionGuardadaPage extends GeneralPage {

  @FindBy(id = "NewClaimSaved:NewClaimSavedScreen:ttlBar")
  private WebElementFacade lblMensajeValidar;

  @FindBy(xpath = "//span[@id='TabBar:ClaimTab-btnInnerEl']")
  private WebElementFacade txtNumeroReclamacion;

  @FindBy(
    xpath = "//div[@id='NewClaimSaved:NewClaimSavedScreen:NewClaimSavedDV:GoToClaim-inputEl']"
  )
  private WebElementFacade lblNumeroReclamacion;

  @FindBy(xpath = "//input[@id='TabBar:ClaimTab:ClaimTab_FindClaim-inputEl']")
  private WebElementFacade mnuBuscar;

  public NuevaReclamacionGuardadaPage(WebDriver wdriver) {
    super(wdriver);
  }

  public String obtenerMensajeValidador() {
    String valorMensaje;
    lblMensajeValidar.waitUntilVisible();
    valorMensaje = lblMensajeValidar.getText();
    return valorMensaje;
  }

  public void abrirReclamacion() {
    lblNumeroReclamacion
        .withTimeoutOf(180, TimeUnit.SECONDS)
        .waitUntilVisible()
        .waitUntilClickable();
    lblNumeroReclamacion.click();
  }

  public String obtenerNumeroReclamacion() {
    String numeroReclamacion;
    lblNumeroReclamacion.waitUntilVisible().waitUntilClickable();
    numeroReclamacion = lblNumeroReclamacion.getText();
    numeroReclamacion = numeroReclamacion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    Utilidades.getLogger()
        .info(String.format("el número de reclamación generado es: %s%n", numeroReclamacion));
    lblNumeroReclamacion.click();
    return numeroReclamacion;
  }

  public void buscarReclamacion(String strReclamacion) {
    mnuBuscar.click();
    mnuBuscar.typeAndEnter(strReclamacion);
    realizarEsperaCarga();
  }
}
