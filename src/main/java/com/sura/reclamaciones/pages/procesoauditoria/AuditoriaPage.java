package com.sura.reclamaciones.pages.procesoauditoria;

import static com.sura.reclamaciones.constantes.Constantes.DETALLES_INVESTIGACION_AUDITORIA;

import com.sura.reclamaciones.constantes.Constantes;
import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;

public class AuditoriaPage extends GeneralPage {

  @Page MenuClaimPage menuClaimPage;

  @FindBy(xpath = "//span[@id='SIDetails:SIDetailsScreen:Edit-btnInnerEl']")
  private WebElementFacade btnEditar;

  @FindBy(
    id =
        "SIDetails:SIDetailsScreen:SIDetailsDV:SITotalScoreEscalationInputSet:SIinfo_SIescalateSIU-inputEl"
  )
  private WebElementFacade cmbRequiereAuditoria;

  @FindBy(id = "SIDetails:SIDetailsScreen:Update-btnInnerEl")
  private WebElementFacade btnActualizar;

  @FindBy(xpath = "//span//img[@src='images/app/indicator_icon_siu.png']")
  private WebElementFacade imgAuditoria;

  @FindBy(xpath = "//div[contains(text(),'Elementos de línea : Para realizar el pago')]")
  private WebElementFacade msgRechazoPago;

  @FindBy(
    name =
        "SIDetails:SIDetailsScreen:SIDetailsDV:SITotalScoreEscalationInputSet:SIinfo_SIEscalateSIUNote"
  )
  private WebElementFacade txtAreaComentario;

  public AuditoriaPage(WebDriver driver) {
    super(driver);
  }

  public void seleccionarDetalleInvestigacionAuditoria() {
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DETALLES_SINIESTRO, DETALLES_INVESTIGACION_AUDITORIA.getValor());
  }

  public void editarMarcacionAuditoria() {
    btnEditar.waitUntilPresent().waitUntilVisible().waitUntilClickable().click();
  }

  public void seleccionarMarcacionAuditoria(String strAuditoria) {
    cmbRequiereAuditoria.waitUntilClickable().waitUntilPresent().waitUntilVisible().click();
    seleccionarOpcionCombobox(strAuditoria);
    realizarEsperaCarga();
    if (strAuditoria.equalsIgnoreCase(Constantes.SI.getValor())) {
      agregarComentarioAuditoria();
    }
  }

  public void agregarComentarioAuditoria() {
    txtAreaComentario.type(Constantes.COMENTARIO_AUDITORIA.getValor());
  }

  public void actualizarMarcacionAuditoria() {
    btnActualizar.waitUntilPresent().waitUntilVisible().waitUntilClickable().click();
  }

  public void verificarMarcacion(String strAuditoria) {
    if (strAuditoria.equalsIgnoreCase(Constantes.NO.getValor()) && verificarImagenAuditoria()) {
      editarMarcacionAuditoria();
      seleccionarMarcacionAuditoria(strAuditoria);
      actualizarMarcacionAuditoria();
    } else {
      if (strAuditoria.equalsIgnoreCase(Constantes.SI.getValor()) && !verificarImagenAuditoria()) {
        editarMarcacionAuditoria();
        seleccionarMarcacionAuditoria(strAuditoria);
        actualizarMarcacionAuditoria();
      }
    }
  }

  public boolean verificarImagenAuditoria() {
    boolean estado = false;
    if (imgAuditoria.isVisible()) {
      estado = true;
    }
    return estado;
  }

  public boolean verificarMensajeRechazo() {
    boolean estado = false;
    if (msgRechazoPago.isVisible()) {
      estado = true;
    }
    return estado;
  }

  public String capturarMensajeRechazo() {
    msgRechazoPago.waitUntilPresent().waitUntilVisible();
    return msgRechazoPago.getText();
  }
}
