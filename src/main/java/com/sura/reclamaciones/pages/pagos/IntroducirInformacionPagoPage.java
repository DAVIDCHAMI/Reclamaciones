package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntroducirInformacionPagoPage extends GeneralPage {

  public IntroducirInformacionPagoPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:ReserveLineInputSet:ReserveLine-inputEl']"
  )
  private WebElementFacade cmbLineaReserva;

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:Payment_PaymentType-inputEl']"
  )
  private WebElementFacade cmbTipoPago;

  @FindBy(
    xpath =
        "//div[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:Transaction_AvailableReserves-inputEl']"
  )
  private WebElementFacade txtValorReserva;

  @FindBy(
    xpath =
        "//div[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:EditablePaymentLineItemsLV']"
  )
  private WebElementFacade tblElementoLinea;

  @FindBy(xpath = "//textarea")
  private WebElementFacade txtComentario;

  @FindBy(
          xpath =
                  "//div[contains(@class,'x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box x-boundlist-above')]"
  )
  public WebElementFacade lstCodigo;

  public void seleccionarLineaReserva(String strLineaReserva) {
    cmbLineaReserva.waitUntilClickable().click();
    seleccionarOpcionCombobox(strLineaReserva);
    realizarEsperaCarga();
  }

  public void seleccionarTipoPago(String strTipoPago) {
    cmbTipoPago.waitUntilClickable().click();
    seleccionarOpcionCombobox(strTipoPago);
  }

  public void ingresarComentario(String comentario) {
    txtComentario.waitUntilClickable().click();
    txtComentario.sendKeys(comentario);
  }

  public double obtenerValorPagoReserva() {
    String strValorReserva = txtValorReserva.getText();
    strValorReserva = strValorReserva.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    Double dblValorReserva = Double.parseDouble(strValorReserva);
    return dblValorReserva;
  }

  public void ingresarCodigoRetencion(String elementoEscribir, String encabezadoColumnaDevolver) {
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(
            tblElementoLinea, elementoEscribir, encabezadoColumnaDevolver);
    elementoEncontrado.forEach(
        elemento -> {
          elemento.click();
          lstCodigo.waitUntilVisible();
          lstCodigo.findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + elementoEscribir + "')]")).click();
        });
  }

  public void ingresarCantidad(String strTipoPago, String cantidad) {
    double dblValorReserva = obtenerValorPagoReserva();
    Double dblCalculoVrReserva;
    if (strTipoPago.equals(PagoConstante.TIPO_PAGO)) {
      dblCalculoVrReserva = 0.2 * dblValorReserva;

    } else {
      dblCalculoVrReserva = dblValorReserva;
    }
    List<WebElement> elementoEncontrado =
            obtenerElementoTablaDatoDesconocido(
                    tblElementoLinea, strTipoPago, cantidad);
    elementoEncontrado.forEach(
            elemento->{
              elemento.click();
              evaluateJavascript(
                      String.format("$('input[name|=\"Amount\"]').val('%d')", dblCalculoVrReserva.intValue()));

    });
    continuarSiguientePantalla();
  }
}
