package com.sura.reclamaciones.pages.pagos;

import static org.openqa.selenium.By.xpath;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntroducirInformacionPagoPage extends GeneralPage {

  private Integer intCalculoVrReserva;

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
  private WebElementFacade txtComentarioPago;

  @FindBy(
    xpath =
        "//div[contains(@class,'x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box x-boundlist-above')]"
  )
  private WebElementFacade lstCodigoRetencion;

  @FindBy(
    xpath =
        "//span[@id='FNOLWizard:Next-btnInnerEl' or @id='NormalCreateCheckWizard:Next-btnInnerEl' or @id='NormalCreateCheckWizard:Next-btnWrap']//parent::a"
  )
  private WebElementFacade btnSiguiente;

  public IntroducirInformacionPagoPage(WebDriver driver) {
    super(driver);
  }


  public void seleccionarLineaReserva(String strLineaReserva) {
    cmbLineaReserva.waitUntilClickable().click();
    seleccionarOpcionCombobox(strLineaReserva);
    realizarEsperaCarga();
  }

  public void seleccionarTipoPago(String strTipoPago) {
    cmbTipoPago.waitUntilClickable().click();
    seleccionarOpcionCombobox(strTipoPago);
    realizarEsperaCarga();
  }

  public void ingresarComentario(String strComentario) {
    txtComentarioPago.waitUntilClickable().click();
    txtComentarioPago.sendKeys(strComentario);
  }

  private double obtenerValorPagoReserva() {
    String strValorReserva = txtValorReserva.getText();
    strValorReserva = strValorReserva.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    Double dblValorReserva;
    dblValorReserva = Double.parseDouble(strValorReserva);
    return dblValorReserva;
  }

  public void ingresarCodigoRetencion(String strCodigoRetencion, String encabezadoColumnaDevolver) {
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblElementoLinea, encabezadoColumnaDevolver, 1);
    elementoEncontrado.forEach(
        elemento -> {
          elemento.click();
          lstCodigoRetencion.waitUntilVisible();
          lstCodigoRetencion
              .findElement(xpath("//li[contains(.,'" + strCodigoRetencion + "')]"))
              .click();
        });
    realizarEsperaCarga();
  }

  private Integer calcularCantidadPago(String strTipoPago) {
    double dblValorReserva = obtenerValorPagoReserva();
    Double dblCalculoVrReserva;
    if (strTipoPago.equals(PagoConstante.TIPO_PAGO)) {
      dblCalculoVrReserva = PagoConstante.PORCENTAJE * dblValorReserva;
    } else {
      dblCalculoVrReserva = dblValorReserva;
    }
     intCalculoVrReserva = dblCalculoVrReserva.intValue();
     return intCalculoVrReserva;
  }

  public void ingresarCantidadPago(String strTipoPago, String strCantidadPago) {
    calcularCantidadPago(strTipoPago);
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblElementoLinea, strCantidadPago, 1);
    elementoEncontrado.forEach(
        elemento -> {
          elemento.click();
          evaluateJavascript(
              String.format("$('input[name|=\"Amount\"]').val('%d')", intCalculoVrReserva));
          txtComentarioPago.click();
          Serenity.setSessionVariable(Variables.VALOR_RESERVA).to(intCalculoVrReserva.toString());
        });
  }

  public void irSiguientePantalla() {
    btnSiguiente.waitUntilClickable();
    btnSiguiente.click();
    if (pgrBarCarga.isVisible()) {
      realizarEsperaCarga();
    }
  }
}
