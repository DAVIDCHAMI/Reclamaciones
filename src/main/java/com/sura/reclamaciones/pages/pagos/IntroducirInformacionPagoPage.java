package com.sura.reclamaciones.pages.pagos;

import static com.sura.reclamaciones.constantes.Constantes.CODIGO_RETENCION;
import static com.sura.reclamaciones.constantes.Constantes.PORCENTAJE;
import static com.sura.reclamaciones.constantes.Constantes.TIPO_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;
import static com.sura.reclamaciones.constantes.Tablas.CABECERAS_CC;
import static com.sura.reclamaciones.constantes.Tablas.REGISTROS_PAGOS_CC;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_LINEA_RESERVA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PAGO;
import static org.openqa.selenium.By.xpath;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
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
        "//div[@id='centerPanel']//div[@id='NormalCreateCheckWizard/NewCheckPayments']//*[contains(text(),'Agregar')]"
  )
  private WebElementFacade btnAgregarRetencion;

  @FindBy(id = "NormalCreateCheckWizard:CheckWizard_CheckPaymentsScreen:Add-btnInnerEl")
  private WebElementFacade btnAgregarPago;

  public IntroducirInformacionPagoPage(WebDriver driver) {
    super(driver);
  }

  public void seleccionarLineaReserva(String strLineaReserva) {
    cmbLineaReserva.waitUntilClickable().click();
    seleccionarOpcionCombobox(strLineaReserva);
    Serenity.setSessionVariable(SESION_CC_LINEA_RESERVA.getValor()).to(strLineaReserva);
    realizarEsperaCarga();
  }

  public void seleccionarTipoPago(String strTipoPago) {
    cmbTipoPago.waitUntilClickable().click();
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
      String strTipoPago,
      String strCantidadPago,
      int posicionIngresoDato,
      int cantidadCodigosRetencion) {
    calcularCantidadPago(strTipoPago, cantidadCodigosRetencion);
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocidoPago(
            tblElementoLinea, strCantidadPago, posicionIngresoDato);
    elementoEncontrado.get(Integer.parseInt(VALOR_CERO.getValor())).click();
    evaluateJavascript(
        String.format("$('input[name|=\"Amount\"]').val('%s')", intCalculoVrReserva));
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
}
