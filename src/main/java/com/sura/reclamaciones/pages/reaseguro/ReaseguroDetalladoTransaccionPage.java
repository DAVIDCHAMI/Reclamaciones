package com.sura.reclamaciones.pages.reaseguro;

import static com.sura.reclamaciones.utils.Constantes.NUMERO_TRANSACCION;
import static com.sura.reclamaciones.utils.Constantes.PORCIENTO;
import static com.sura.reclamaciones.utils.Constantes.RETENCION_PURA_ENCABEZADO;
import static com.sura.reclamaciones.utils.Constantes.VALOR_REASEGURADO;
import static java.lang.Math.abs;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReaseguroDetalladoTransaccionPage extends GeneralPage {

  private Double dblRetencionPura = 0.0;

  @FindBy(xpath = "//div[@class='x-container g-screen x-container-page x-table-layout-ct']")
  private WebElementFacade tblReaseguroDetalladoTransaccion;

  @FindBy(xpath = "//a[@id='ReinsuranceTransactionDetailSummary:__crumb__']")
  private WebElementFacade btnVolverReaseguroDetalladoTransaccion;

  public ReaseguroDetalladoTransaccionPage(WebDriver driver) {
    super(driver);
  }

  public boolean verificarRetencionPura(Double dblMaximoValorRetencionPura) {
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, NUMERO_TRANSACCION.getValor(), 2);
    for (int posicionElementoFila = 0;
        lstReaseguroDetallado.size() > posicionElementoFila;
        posicionElementoFila++) {
      String strRetencionPura =
          obtenerDatoTablaCabecera(RETENCION_PURA_ENCABEZADO.getValor(), posicionElementoFila + 1)
              .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      if (abs(dblRetencionPura) <= abs(Double.parseDouble(strRetencionPura))) {
        dblRetencionPura = abs(Double.parseDouble(strRetencionPura));
      }
      if (dblRetencionPura >= -dblMaximoValorRetencionPura
          && dblRetencionPura <= dblMaximoValorRetencionPura) {
        LOGGER.info(
            "El elemento " + posicionElementoFila + "esta en el rango permitido de retencion pura");
      } else {
        return false;
      }
    }
    return true;
  }

  public boolean verificarRetenido(
      String strPorcentajeRetenido,
      String strDeducible,
      String strPorcentajeDeducible,
      String strProporcionCuotaParte) {
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, NUMERO_TRANSACCION.getValor(), 2);
    String strValorReasegurado =
        (obtenerDatoTablaCabecera(VALOR_REASEGURADO.getValor(), 2))
            .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    String strValorDeducible =
        calcularDeducible(strValorReasegurado, strDeducible, strPorcentajeDeducible);
    Double dblValorRetenido =
        calcularRetenido(strValorReasegurado, strPorcentajeRetenido, strProporcionCuotaParte);
    Double dblValorRetenidoDeducible =
        calcularRetenido(strValorDeducible, strPorcentajeRetenido, strProporcionCuotaParte);
    for (WebElement aLstReaseguroDetallado : lstReaseguroDetallado) {
      String strNumeroTransaccion = aLstReaseguroDetallado.getText();
      List<WebElement> lstFilaTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblPago());
      String strDatoPantalla =
          lstFilaTransaccion.get(5).getText().replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      Integer intDatoPantalla = Integer.parseInt(strDatoPantalla);
      if ((intDatoPantalla >= dblValorRetenido - dblRetencionPura)
              && (intDatoPantalla <= dblValorRetenido + dblRetencionPura)
          || ((intDatoPantalla >= dblValorRetenidoDeducible - dblRetencionPura)
              && (intDatoPantalla <= dblValorRetenidoDeducible + dblRetencionPura))) {
        LOGGER.info("El retenido esta en el rango correcto");
      } else {
        return false;
      }
    }
    return true;
  }

  public boolean verificarCedido(
      String strPorcentajeRetenido,
      String strDeducible,
      String strPorcentajeDeducible,
      String strProporcionCuotaParte) {
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, NUMERO_TRANSACCION.getValor(), 2);
    String strValorReasegurado =
        (obtenerDatoTablaCabecera(VALOR_REASEGURADO.getValor(), 2))
            .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    String strValorDeducible =
        calcularDeducible(strValorReasegurado, strDeducible, strPorcentajeDeducible);
    Double dblValorRetenido =
        calcularRetenido(strValorReasegurado, strPorcentajeRetenido, strProporcionCuotaParte);
    Double dblValorRetenidoDeducible =
        calcularRetenido(strValorDeducible, strPorcentajeRetenido, strProporcionCuotaParte);
    for (WebElement aLstReaseguroDetallado : lstReaseguroDetallado) {
      String strNumeroTransaccion = aLstReaseguroDetallado.getText();
      List<WebElement> lstFilaTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblPago());
      String strDatoPantalla =
          lstFilaTransaccion.get(4).getText().replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      Integer intDatoPantalla = Integer.parseInt(strDatoPantalla);
      if ((intDatoPantalla
                  >= Math.round(
                      Double.parseDouble(strValorReasegurado)
                          - dblValorRetenido
                          - dblRetencionPura))
              && (intDatoPantalla
                  <= Math.round(
                      Double.parseDouble(strValorReasegurado)
                          - dblValorRetenido
                          + dblRetencionPura))
          || ((intDatoPantalla
                  >= Math.round(
                      Double.parseDouble(strValorDeducible)
                          - dblValorRetenidoDeducible
                          - dblRetencionPura))
              && (intDatoPantalla
                  <= Math.round(
                      Double.parseDouble(strValorDeducible)
                          - dblValorRetenidoDeducible
                          + dblRetencionPura)))) {
        LOGGER.info("El cedido esta en el rango correcto");
      } else {
        return false;
      }
    }
    return true;
  }

  private String calcularDeducible(
      String strValorReasegurado, String strDeducible, String strPorcentajeDeducible) {
    Double dblValorReasegurado = Double.parseDouble(strValorReasegurado);
    Double dblDeducible = Double.parseDouble(strDeducible);
    Double dblPorcentaje =
        Double.parseDouble(strPorcentajeDeducible) / Double.parseDouble(PORCIENTO.getValor());
    Double dblValorDeducible = (dblValorReasegurado * dblPorcentaje);
    if (dblDeducible > dblValorDeducible) {
      return String.valueOf(Math.floor(-dblDeducible));
    }
    return String.valueOf(Math.floor(-dblValorDeducible));
  }

  private double calcularRetenido(
      String strValorReasegurado, String strPorcentajeCedido, String strProporcionCuotaParte) {
    Double dblValorReasegurado = Double.parseDouble(strValorReasegurado);
    Double dblPorcentajeCedido =
        Double.parseDouble(strPorcentajeCedido) / Double.parseDouble(PORCIENTO.getValor());
    Double dblPorcentaCuotaParte =
        Double.parseDouble(strProporcionCuotaParte) / Double.parseDouble(PORCIENTO.getValor());
    return Math.floor(dblPorcentajeCedido * dblValorReasegurado * dblPorcentaCuotaParte);
  }

  public boolean verificarReaseguro(
      double dblRetencionPura,
      String strTransaccion,
      String porcentajeRetenido,
      String deducibleMinimo,
      String porcentajeDeducibleMinimo,
      String proporcionCuotaParte) {

    switch (strTransaccion) {
      case "Reserva":
        verificarReserva(
            dblRetencionPura,
            porcentajeRetenido,
            deducibleMinimo,
            porcentajeDeducibleMinimo,
            proporcionCuotaParte);
        break;
      case "Pago":
        verificarReserva(
            dblRetencionPura,
            porcentajeRetenido,
            deducibleMinimo,
            porcentajeDeducibleMinimo,
            proporcionCuotaParte);
        verificarPago();
        break;
      case "Recupero":
        verificarReserva(
            dblRetencionPura,
            porcentajeRetenido,
            deducibleMinimo,
            porcentajeDeducibleMinimo,
            proporcionCuotaParte);
        verificarPago();
      default:
        return false;
    }
    return true;
  }

  private void verificarReserva(
      double dblRetencionPura,
      String porcentajeRetenido,
      String deducibleMinimo,
      String porcentajeDeducibleMinimo,
      String proporcionCuotaParte) {
    verificarRetencionPura(dblRetencionPura);
    verificarCedido(
        porcentajeRetenido, deducibleMinimo, porcentajeDeducibleMinimo, proporcionCuotaParte);
    verificarRetenido(
        porcentajeRetenido, deducibleMinimo, porcentajeDeducibleMinimo, proporcionCuotaParte);
  }

  private boolean verificarPago() {
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, NUMERO_TRANSACCION.getValor(), 2);
    String strValorPago = lstReaseguroDetallado.get(2).getText();
    List<WebElement> lstPago = obtenerFilaTabla(strValorPago, getTblPago());
    if (strValorPago.equals(Serenity.sessionVariableCalled(Variables.VALOR_RESERVA))) {
      return true;
    }
    return false;
  }
}
