package com.sura.reclamaciones.pages.autos.reclamacion;

import static com.sura.reclamaciones.constantes.Constantes.TIEMPO_ESPERA_ELEMENTO_VISIBLE;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.concurrent.TimeUnit;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class NuevaReclamacionGuardadaPage extends GeneralPage {

  @FindBy(id = "NewClaimSaved:NewClaimSavedScreen:ttlBar")
  private WebElementFacade lblMensajeValidar;

  @FindBy(
    xpath = "//div[@id='NewClaimSaved:NewClaimSavedScreen:NewClaimSavedDV:GoToClaim-inputEl']"
  )
  private WebElementFacade lblNumeroReclamacion;

  @FindBy(xpath = "//span[@id='TabBar:ClaimTab-btnInnerEl']")
  private WebElementFacade txtNumeroReclamacion;

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
    withTimeoutOf(Integer.parseInt(TIEMPO_ESPERA_ELEMENTO_VISIBLE.getValor()), TimeUnit.SECONDS)
        .waitFor(lblNumeroReclamacion);
    lblNumeroReclamacion.click();
  }

  public String obtenerNumeroReclamacionConsultaPoliza() {
    String numeroReclamacion;
    txtNumeroReclamacion.waitUntilVisible();
    numeroReclamacion = txtNumeroReclamacion.getText();
    numeroReclamacion = numeroReclamacion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    return numeroReclamacion;
  }
}
