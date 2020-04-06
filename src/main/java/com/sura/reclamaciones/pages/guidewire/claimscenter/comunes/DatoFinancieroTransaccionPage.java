package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.Constantes.ESTADO_ANULACION;
import static com.sura.reclamaciones.utils.enums.Constantes.ITERACIONES_RECUPERO;
import static com.sura.reclamaciones.utils.enums.Constantes.UBICACION_ESTADO_RECUPERO;
import static com.sura.reclamaciones.utils.enums.Posiciones.POSICION_FILA;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_VALOR_PAGO;

import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.utils.Utilidades;
import com.sura.reclamaciones.utils.constantes.ReservaConstante;
import com.sura.reclamaciones.utils.enums.Variables;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatoFinancieroTransaccionPage extends GeneralPage {

  @FindBy(
      xpath =
          "//div[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV']")
  private WebElementFacade tblTransaccion;

  @FindBy(
      id = "ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV:0:Amount")
  private WebElementFacade lnkReservaTransaccion;

  @FindBy(id = "ClaimFinancialsChecks:ClaimFinancialsChecksScreen:ChecksLV")
  private WebElementFacade tblDatosFinancierosPagos;

  public static final String VALOR_TOTAL = "Valor total";

  public DatoFinancieroTransaccionPage(WebDriver wdriver) {
    super(wdriver);
  }

  public String obtenerEstadoReservaRealizada(int posicionEstadoVerificar) {
    final String ESTADO = "Estado";
    return obtenerDatoTablaCabecera(ESTADO, posicionEstadoVerificar);
  }

  private List<WebElement> obtenerFilaRecuperoAnulado(
      String strNumeroTransaccion, String tblTransaccion) {
    return obtenerFilaTabla(strNumeroTransaccion, tblTransaccion);
  }

  public boolean verificarEstadoAnuladoRecupero(
      String strNumeroTransaccion, String tblTransaccion) {
    List<WebElement> lstTransaccion =
        obtenerFilaRecuperoAnulado(strNumeroTransaccion, tblTransaccion);
    for (int i = 0; i < lstTransaccion.size(); i++) {
      if (lstTransaccion.get(i).getText().equals(ESTADO_ANULACION.getValor())) {
        return true;
      }
    }
    return false;
  }

  public void ingresarDatoReserva() {
    irUltimaPagina();
    tblTransaccion.waitUntilPresent();
    List<WebElement> elementroEncontrado =
        obtenerElementoTablaDatoDesconocido(
            tblTransaccion, ReservaConstante.CANTIDAD, Integer.parseInt(POSICION_FILA.getValor()));
    int longitudTabla = elementroEncontrado.size();
    int datoPosicionReserva = longitudTabla - Integer.parseInt(POSICION_FILA.getValor());
    elementroEncontrado
        .listIterator()
        .next()
        .findElement(
            By.xpath(
                "//a[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV:"
                    + datoPosicionReserva
                    + ":Amount']"))
        .click();
  }

  public boolean ingresarDatoRecuperacion(String strNumeroTransaccion, String strEstadoPrevio) {
    final int POSICION_VALOR_MONTO_RECUPERO = 2;
    List<WebElement> lstTransaccion;
    boolean estadoTransaccionPantalla = false;
    for (int i = 0; i <= Integer.parseInt(ITERACIONES_RECUPERO.getValor()); i++) {
      realizarEsperaCarga();
      lstTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblTransaccion());
      WebElement elementoXpath =
          lstTransaccion.get(Integer.parseInt(UBICACION_ESTADO_RECUPERO.getValor()));
      estadoTransaccionPantalla = actualizarPantalla(strEstadoPrevio, elementoXpath);
      if (estadoTransaccionPantalla) {
        String strMontoRecupero = lstTransaccion.get(POSICION_VALOR_MONTO_RECUPERO).getText();
        lstTransaccion
            .get(POSICION_VALOR_MONTO_RECUPERO)
            .findElement(
                By.xpath(
                    String.format(
                        "//a[@class='g-actionable'][contains(text(),'" + strMontoRecupero + "')]",
                        strNumeroTransaccion)))
            .click();
        break;
      }
    }
    realizarEsperaCarga();
    return estadoTransaccionPantalla;
  }

  public String obtenerMontoReserva() {
    String validarReservaTransaccion = "";
    if (lnkReservaTransaccion.isVisible()) {
      validarReservaTransaccion = lnkReservaTransaccion.waitUntilVisible().getText();
      validarReservaTransaccion =
          validarReservaTransaccion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    } else {
      Utilidades.getLogger().info("No se ha generado reserva en la sección de transacciones");
    }
    return validarReservaTransaccion;
  }

  public boolean verificarValorPagoPrimaPendiente(String valorPrimaPendiente) {
    List<WebElement> lstValorTotal =
        obtenerElementoTablaDatoDesconocido(
            tblDatosFinancierosPagos, VALOR_TOTAL, Integer.parseInt(POSICION_FILA.getValor()));
    for (int i = 0; i < lstValorTotal.size(); i++) {
      if (valorPrimaPendiente.equals(lstValorTotal.get(i).getText())) {
        return true;
      }
    }
    return false;
  }

  public boolean verificarValorPagoMenosPrimaPendiente(String valorPrimaPendiente) {
    int valorPago = (Serenity.sessionVariableCalled(SESION_CC_VALOR_PAGO.getValor()));
    int valorPagoMenosPrimaPendiente =
        valorPago - Integer.parseInt(valorPrimaPendiente.replaceAll("\\D+", ""));
    List<WebElement> lstValorTotal =
        obtenerElementoTablaDatoDesconocido(
            tblDatosFinancierosPagos, VALOR_TOTAL, Integer.parseInt(POSICION_FILA.getValor()));
    for (int i = 0; i < lstValorTotal.size(); i++) {
      String valorTransaccionPago = lstValorTotal.get(i).getText().replaceAll("\\D+", "");
      if (Integer.parseInt(valorTransaccionPago) == valorPagoMenosPrimaPendiente) {
        return true;
      }
    }
    return false;
  }
}
