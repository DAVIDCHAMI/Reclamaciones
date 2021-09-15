package com.sura.reclamaciones.pages.guidewire.claimscenter.autos;

import static com.sura.reclamaciones.utils.enums.Posiciones.POSICION_FILA;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_NUMERO_FACTURA_PAGO_MASIVO;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_NUMERO_PAGO_INDIVIDUAL;

import com.sura.reclamaciones.pages.general.GeneralPage;
import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetalleFacturaVolumenPage extends GeneralPage {

  @FindBy(
      id =
          "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Currency-inputEl")
  private WebElementFacade cmbTipoMoneda;

  @FindBy(xpath = "//ul[@class='x-list-plain']")
  private WebElementFacade lstTipoMoneda;

  @FindBy(xpath = "//label[@class='x-form-cb-label x-form-cb-label-after']")
  private WebElementFacade rbtMetodoPago;

  @FindBy(
      id =
          "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Payee:PayeeMenuIcon")
  private WebElementFacade btnBuscarBeneficiario;

  @FindBy(
      id =
          "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Payee:MenuItem_Search-textEl")
  private WebElementFacade btnBuscarBeneficiarioPago;

  @FindBy(id = "BulkPayWizard:Finish-btnInnerEl")
  private WebElementFacade btnFinalizarPagoMasivo;

  @FindBy(id = "EditBulkInvoiceDetail:BulkInvoiceDetailScreen:SubmitButton-btnInnerEl")
  private WebElementFacade btnEnviarPagoMasivo;

  @FindBy(
      id =
          "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:InvoiceNumber-bodyEl")
  private WebElementFacade lblNumeroFacturaPagoMasivo;

  @FindBy(id = "BulkPay:BulkPayScreen:BulkInvoicesLV")
  private WebElementFacade tblNumeroPagoIndividual;

  @FindBy(
      id =
          "EditBulkInvoiceDetail:BulkInvoiceDetailScreen:BulkInvoiceDetailDV:InvoiceNumber-inputEl")
  private WebElementFacade lblNumeroFactura;

  @FindBy(
      xpath =
          "//div[@id='EditBulkInvoiceDetail:BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Status-inputEl']")
  private WebElementFacade lblEstadoPagoMasivo;

  @FindBy(id = "EditBulkInvoiceDetail:EditBulkInvoiceDetail_UpLink")
  private WebElementFacade lblIrAFacturaPorVolumen;

  public DetalleFacturaVolumenPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void seleccionarTipoMoneda(String tipoMoneda) {
    cmbTipoMoneda.click();
    lstTipoMoneda
        .findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + tipoMoneda + "')]"))
        .click();
  }

  public void buscarBeneficiario() {
    btnBuscarBeneficiario.waitUntilClickable();
    btnBuscarBeneficiario.click();
  }

  public void buscarBeneficiarioPago() {
    btnBuscarBeneficiarioPago.waitUntilPresent();
    btnBuscarBeneficiarioPago.click();
  }

  public void seleccionarMetodoPago(String metodoPago) {
    rbtMetodoPago.waitUntilClickable();
    rbtMetodoPago
        .findElement(
            By.xpath(
                "//following-sibling::label[contains( .,'"
                    + metodoPago
                    + "')]//preceding-sibling::input"))
        .click();
  }

  public void finalizarPagoMasivo() {
    btnFinalizarPagoMasivo.waitUntilClickable();
    btnFinalizarPagoMasivo.click();
    realizarEsperaCarga();
  }

  public void enviarPagoMasivo() {
    btnEnviarPagoMasivo.waitUntilClickable();
    btnEnviarPagoMasivo.click();
    realizarEsperaCarga();
  }

  public void obtenerNumeroFacturaPagoMasivo() {
    lblNumeroFacturaPagoMasivo.getText();
    Serenity.setSessionVariable(SESION_CC_NUMERO_FACTURA_PAGO_MASIVO.getValor())
        .to(lblNumeroFacturaPagoMasivo.getText());
  }

  public void validarEstadoPagoMasivo() {
    String estadoPagoMasivo = "Solicitando";
    esperarCargaElemento();
    esperarCargaElemento();
    MatcherAssert.assertThat(
        "El número de registros de la pantalla no es igual al número de registros del archivo XLS",
        (estadoPagoMasivo.equals(lblEstadoPagoMasivo.getText())));
    esperarCargaElemento();
    lblIrAFacturaPorVolumen.click();
    esperarCargaElemento();
  }

  public void obtenerNumeroPagoIndividual() {
    List<String> numeroPagosIndividuales = new ArrayList<String>();
    int aux = 0;
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocidoPagoMasivo(
            tblNumeroPagoIndividual, Integer.parseInt(POSICION_FILA.getValor()));

    int tamanoLista = elementoEncontrado.size();
    for (int i = 0; i <= tamanoLista - 1; i++) {
      aux = i;
      numeroPagosIndividuales.add(i, elementoEncontrado.get(i).getText());
      String pruebaDos = elementoEncontrado.get(i).getText();
      String auxx =
          Serenity.getCurrentSession()
              .get(SESION_CC_NUMERO_FACTURA_PAGO_MASIVO.getValor())
              .toString();

      if (pruebaDos.equals(
          Serenity.getCurrentSession()
              .get(SESION_CC_NUMERO_FACTURA_PAGO_MASIVO.getValor())
              .toString())) {

        Serenity.setSessionVariable(SESION_CC_NUMERO_PAGO_INDIVIDUAL.getValor())
            .to(numeroPagosIndividuales.get(aux));
      }
    }
  }
}
