package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.Constantes.COMODIN;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_VALOR_RECUPERO;

import com.sura.reclamaciones.pages.general.GeneralPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreacionRecuperoPage extends GeneralPage {

  private String pais = "Country-inputEl";
  private String departamento = "State-inputEl";
  private String ciudad = "City-inputEl";
  private String seleccionarOpcion = "//li[.='COMODIN']";

  @FindBy(
      xpath =
          "//table[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:Payer-triggerWrap']//td/following-sibling::td/div")
  private WebElementFacade txtPagador;

  @FindBy(
      xpath =
          "//input[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:ReserveLineInputSet:ReserveLine-inputEl']")
  private WebElementFacade txtLineaReserva;

  @FindBy(id = "NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:RecoveryCategory-inputEl")
  private WebElementFacade txtCategoriaRecuperacion;

  @FindBy(id = "NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:idIngresoSAP-inputEl")
  private WebElementFacade txtComprobanteBancario;

  @FindBy(id = "NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:SuraEditableRecoveryLineItemsLV")
  private WebElementFacade tblElementoLinea;

  @FindBy(xpath = "//input[@name='Amount']")
  private WebElementFacade txtCantidad;

  @FindBy(
      xpath =
          "//input[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:dateTransaction-inputEl']")
  private WebElementFacade txtFechaComprobante;

  @FindBy(
      xpath =
          "//a[@class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']/span[@id='NewRecoverySet:NewRecoveryScreen:Update-btnWrap']")
  private WebElementFacade btnActualizar;

  @FindBy(
      xpath = "//span[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:ttlBar']")
  private WebElementFacade lblTituloRecupero;

  public CreacionRecuperoPage(WebDriver driver) {
    super(driver);
  }

  public void seleccionarPagador(String pagador) {
    txtPagador.waitUntilClickable();
    txtPagador.click();
    esperarCargaElemento();
    seleccionarOpcionCombobox(pagador);
    realizarEsperaCarga();
  }

  public void seleccionarLineaReserva(String lineaReserva) {
    txtLineaReserva.click();
    seleccionarOpcionCombobox(lineaReserva);
    realizarEsperaCarga();
  }

  public void seleccionarPais(String pais) {
    seleccionarElementoListado(this.pais, pais);
  }

  public void seleccionarDepartamento(String departamento) {
    seleccionarElementoListado(this.departamento, departamento);
  }

  public void seleccionarCiudad(String ciudad) {
    seleccionarElementoListado(this.ciudad, ciudad);
  }

  public void seleccionarCategoriaRecuperacion(String recupero) {
    String auxiliarSeleccionarOpcion = "";
    txtCategoriaRecuperacion.click();
    realizarEsperaCarga();
    auxiliarSeleccionarOpcion = seleccionarOpcion.replace(COMODIN.getValor(), recupero);
    $(auxiliarSeleccionarOpcion).click();
    realizarEsperaCarga();
  }

  public void diligenciarCodigoRetencion(String codigoRetencion, String encabezadoColumnaDevolver) {
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblElementoLinea, encabezadoColumnaDevolver, 1);
    elementoEncontrado.forEach(
        elemento -> {
          elemento.click();
          lstOpcionesCombobox.waitUntilVisible();
          seleccionarOpcionCombobox(codigoRetencion);
        });
    realizarEsperaCarga();
  }

  public void diligenciarCantidadRecupero(String montoRecupero, String encabezadoColumnaDevolver) {
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblElementoLinea, encabezadoColumnaDevolver, 1);
    elementoEncontrado.forEach(
        elemento -> {
          elemento.click();
          evaluateJavascript(
              String.format("$('input[name|=\"Amount\"]').val('%s')", montoRecupero));
        });
    Serenity.setSessionVariable(SESION_CC_VALOR_RECUPERO.getValor()).to(montoRecupero);
  }

  public void actualizarRecupero() {
    btnActualizar.waitUntilClickable();
    btnActualizar.click();
    lblTituloRecupero.waitUntilVisible();
    lblTituloRecupero.isVisible();
  }
}
