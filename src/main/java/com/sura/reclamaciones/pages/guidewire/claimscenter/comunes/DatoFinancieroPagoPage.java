package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.Constantes.*;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_NUMERO_PAGO_INDIVIDUAL;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS;

import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.utils.enums.Variables;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatoFinancieroPagoPage extends GeneralPage {

  @FindBy(xpath = ".//div[@class='x-panel x-panel-default x-grid']")
  private WebElementFacade tblPagoIndividual;

  public DatoFinancieroPagoPage(WebDriver wdriver) {
    super(wdriver);
  }

  public String obtenerNumeroPagoRealizado() {
    realizarEsperaCarga();
    return obtenerDatoTablaCabecera(NUMERO_PAGO.getValor(), 1);
  }

  public boolean verificarPagoMenuTransaccion(String datoValidar, List<WebElement> lstFilaPago) {
    for (int i = 0; i < lstFilaPago.size(); i++) {
      String strDatoPantalla = lstFilaPago.get(i).getText();
      if (strDatoPantalla.contains(COP.getValor()) || strDatoPantalla.contains(USD.getValor())) {
        strDatoPantalla = strDatoPantalla.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      }
      if (strDatoPantalla.equals(datoValidar)) {
        return true;
      }
    }
    return false;
  }

  private List<WebElement> obtenerFilaPagoAnulado(String strNumeroTransaccion, String tblPago) {
    return obtenerFilaTabla(strNumeroTransaccion, tblPago);
  }

  public boolean verificarEstadoAnuladoPago(String strNumeroTransaccion, String tblPago) {
    List<WebElement> lstPago = obtenerFilaPagoAnulado(strNumeroTransaccion, tblPago);
    for (int i = 0; i < lstPago.size(); i++) {
      if (lstPago.get(i).getText().equals(ESTADO_ANULACION.getValor())) {
        return true;
      }
    }
    return false;
  }

  public boolean ingresarDetalleCheque(String strNumeroTransaccion, String strEstadoPrevio) {
    List<WebElement> lstTransaccion;
    boolean estadoTransaccionPantalla = false;
    for (int i = 0; i <= Integer.parseInt(ITERACIONES_PAGO.getValor()); i++) {
      realizarEsperaCarga();
      lstTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblPago());
      WebElement elementoXpath =
          lstTransaccion.get(Integer.parseInt(UBICACION_ESTADO_PAGO.getValor()));
      estadoTransaccionPantalla = actualizarPantalla(strEstadoPrevio, elementoXpath);
      if (estadoTransaccionPantalla) {
        lstTransaccion.get(Integer.parseInt(VALOR_CERO.getValor())).click();
        lstTransaccion
            .get(Integer.parseInt(VALOR_CERO.getValor()))
            .findElement(
                By.xpath(
                    String.format(
                        "//a[@class='g-actionable'][contains(text(),'%s')]", strNumeroTransaccion)))
            .click();
        break;
      }
    }
    realizarEsperaCarga();
    return estadoTransaccionPantalla;
  }

  public void validarPagosIndividualesSiniestro() {
    List<WebElement> numeroPagosIndividuales =
        obtenerElementoTablaDatoDesconocidoDatosFinanciaero(tblPagoIndividual);
    List<WebElement> numeroPagosMasivo =
        obtenerElementoTablaDatoDesconocidoDatosFinanciaeroPagoMasivo(tblPagoIndividual);
    String contadorPagoIndividual =
        Serenity.getCurrentSession().get(SESION_CC_NUMERO_PAGO_INDIVIDUAL.getValor()).toString();
    String numeroPagoIndividuales = String.valueOf(numeroPagosIndividuales.size());

    for (int i = 0; i <= numeroPagosMasivo.size() - 1; i++) {
      MatcherAssert.assertThat(
          "El número del pago masivo generado no se encuentra en la consulta de pagos del siniestro",
          (numeroPagosMasivo.get(i).getText().equals(contadorPagoIndividual)));
    }

    MatcherAssert.assertThat(
        "El número del pago masivo generado no se encuentra en la consulta de pagos del siniestro",
        (numeroPagoIndividuales.equals(
            Serenity.getCurrentSession()
                .get(SESION_CC_NUMERO_PLACAS_PARTES_IMPLICADAS.getValor())
                .toString())));
  }
}
