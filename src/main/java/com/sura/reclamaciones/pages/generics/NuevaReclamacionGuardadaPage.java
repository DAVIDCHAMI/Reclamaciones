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

  public NuevaReclamacionGuardadaPage(WebDriver wdriver) {
    super(wdriver);
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
}
