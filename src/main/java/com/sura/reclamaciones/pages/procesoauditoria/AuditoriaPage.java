package com.sura.reclamaciones.pages.procesoauditoria;

import com.sura.reclamaciones.constantes.Constantes;
import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.pages.general.MenuClaimPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;

public class AuditoriaPage extends GeneralPage {

  @Page MenuClaimPage menuClaimPage;

  @FindBy(xpath = "//span[@id='SIDetails:SIDetailsScreen:Edit-btnInnerEl']")
  private WebElementFacade btnEditarProcesoAuditoria;

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

  private static final String COMENTARIO_AUDITORIA = "Requiere marcacion de auditoria";
  private static final String DETALLES_INVESTIGACION_AUDITORIA =
      "Detalles de investigación de auditoría";

  public AuditoriaPage(WebDriver driver) {
    super(driver);
  }

  public void seleccionarDetalleInvestigacionAuditoria() {
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DETALLES_SINIESTRO, DETALLES_INVESTIGACION_AUDITORIA);
  }

  public void editarMarcacionAuditoria() {
    btnEditarProcesoAuditoria.waitUntilPresent().waitUntilVisible().waitUntilClickable().click();
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
    txtAreaComentario.type(COMENTARIO_AUDITORIA);
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
