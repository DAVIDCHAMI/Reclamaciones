package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.constantes.MenuConstante.CAMBIO_PLACA_PRIMA_PENDIENTE;
import static com.sura.reclamaciones.utils.enums.Constantes.CANTIDAD;
import static com.sura.reclamaciones.utils.enums.Constantes.CODIGO_RETENCION;
import static com.sura.reclamaciones.utils.enums.Constantes.PORCENTAJE;
import static com.sura.reclamaciones.utils.enums.Constantes.TIPO_PAGO;
import static com.sura.reclamaciones.utils.enums.Constantes.VALOR_CERO;
import static com.sura.reclamaciones.utils.enums.Tablas.CABECERAS_CC;
import static com.sura.reclamaciones.utils.enums.Tablas.REGISTROS_PAGOS_CC;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.*;
import static org.openqa.selenium.By.xpath;

import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.utils.enums.Variables;
import java.util.List;
import java.util.stream.Collectors;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IntroducirInformacionPagoPage extends GeneralPage {

  private Integer intCalculoVrReserva;

  @FindBy(
      xpath =
          "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:ReserveLineInputSet:ReserveLine-inputEl']")
  private WebElementFacade cmbLineaReserva;

  @FindBy(
      xpath =
          "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:Payment_PaymentType-inputEl']")
  private WebElementFacade cmbTipoPago;

  @FindBy(
      xpath =
          "//div[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:Transaction_AvailableReserves-inputEl']")
  private WebElementFacade txtValorReserva;

  @FindBy(
      xpath =
          "//div[@id='NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:EditablePaymentLineItemsLV']")
  private WebElementFacade tblElementoLinea;

  @FindBy(xpath = "//textarea")
  private WebElementFacade txtComentarioPago;

  @FindBy(
      xpath =
          "//div[contains(@class,'x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box x-boundlist-above')]")
  private WebElementFacade lstCodigoRetencion;

  @FindBy(
      xpath =
          "//div[@id='centerPanel']//div[@id='NormalCreateCheckWizard/NewCheckPayments']//*[contains(text(),'Agregar')]")
  private WebElementFacade btnAgregarRetencion;

  @FindBy(id = "NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:Add-btnInnerEl")
  private WebElementFacade btnAgregarPago;

  @FindBy(
      id =
          "NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:NewCheckPaymentPanelSet:NewPaymentDetailDV:Pending_Bonus_Payment_true-inputEl")
  private WebElementFacade rbtDescontarSaldoPrima;

  public IntroducirInformacionPagoPage(WebDriver driver) {
    super(driver);
  }

  public void seleccionarLineaReserva(String strLineaReserva) {
    String strLineaReservaDos = "";
    realizarEsperaCarga();
    cmbLineaReserva.waitUntilClickable().click();
    /* if (strLineaReserva.contains(CAMBIO_PLACA_PRIMA_PENDIENTE)) {
      strLineaReservaDos =
          strLineaReserva.replace(
              CAMBIO_PLACA_PRIMA_PENDIENTE,
              Serenity.getCurrentSession().get(SESION_CC_NUMERO_PLACA).toString());
    } */
    seleccionarOpcionCombobox(strLineaReserva);
    Serenity.setSessionVariable(SESION_CC_LINEA_RESERVA.getValor()).to(strLineaReservaDos);
    realizarEsperaCarga();
  }

  public void seleccionarTipoPago(String strTipoPago) {
    cmbTipoPago.waitUntilVisible().waitUntilClickable().click();
    seleccionarOpcionCombobox(strTipoPago);
    Serenity.setSessionVariable(SESION_CC_TIPO_PAGO.getValor()).to(strTipoPago);
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

  private Integer calcularCantidadPago(String strTipoPago, int cantidadCodigosRetencion) {
    double dblValorReserva = obtenerValorPagoReserva();
    Double dblCalculoVrReserva = null;
    if (strTipoPago.equals(TIPO_PAGO.getValor())) {
      dblCalculoVrReserva = Double.parseDouble(PORCENTAJE.getValor()) * dblValorReserva;
    } else {
      dblCalculoVrReserva = dblValorReserva / (cantidadCodigosRetencion - 1);
    }
    intCalculoVrReserva = dblCalculoVrReserva.intValue();
    return intCalculoVrReserva;
  }

  public void ingresarCantidadPago(
      String strTipoPago, int posicionIngresoDato, int cantidadCodigosRetencion) {
    calcularCantidadPago(strTipoPago, cantidadCodigosRetencion);
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocidoPago(
            tblElementoLinea, CANTIDAD.getValor(), posicionIngresoDato);
    elementoEncontrado.get(Integer.parseInt(VALOR_CERO.getValor())).click();
    evaluateJavascript(
        String.format("$('input[name|=\"Amount\"]').val('%s')", intCalculoVrReserva));
    Serenity.setSessionVariable(SESION_CC_VALOR_PAGO.getValor()).to(intCalculoVrReserva);
  }

  public void agregarNuevoPago() {
    btnAgregarPago.waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public void agregarNuevaRetencion() {
    realizarEsperaCarga();
    Actions actions = new Actions(driver);
    actions.moveToElement(btnAgregarRetencion).click().build().perform();
    btnAgregarRetencion.click();
  }

  public void agregarCodigoRetencion(String strCodigoRetencion, int posicion) {
    realizarEsperaCarga();
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocidoPago(
            tblElementoLinea, CODIGO_RETENCION.getValor(), posicion);
    elementoEncontrado.forEach(
        elemento -> {
          elementoEncontrado.get(Integer.parseInt(VALOR_CERO.getValor())).click();
          lstCodigoRetencion.waitUntilVisible();
          lstCodigoRetencion
              .findBy(xpath("//li[contains(.,'" + strCodigoRetencion + "')]"))
              .click();
        });
    realizarEsperaCarga();
  }

  public List<WebElement> obtenerElementoTablaDatoDesconocidoPago(
      WebElementFacade elemento, String encabezadoColumnaDevolver, int posicionFila) {
    final int POSICION_COLUMNA_TABLA = 1;
    List<String> cabeceraTabla = obtenerCabecerasTabla(elemento, CABECERAS_CC);
    int posicionColumna = cabeceraTabla.indexOf(encabezadoColumnaDevolver) + POSICION_COLUMNA_TABLA;
    List<WebElement> elementoEncontrado = obtenerFilasTabla(elemento, REGISTROS_PAGOS_CC);
    return elementoEncontrado
        .stream()
        .map(
            fila ->
                fila.findElement(
                    By.xpath(String.format("./tr[%d]/td[%d]/div", posicionFila, posicionColumna))))
        .collect(Collectors.toList());
  }

  public void seleccionarOpcionDescontarSaldoPrima() {
    realizarEsperaCarga();
    rbtDescontarSaldoPrima.waitUntilClickable().click();
    esperarCargaElemento();
  }
}
