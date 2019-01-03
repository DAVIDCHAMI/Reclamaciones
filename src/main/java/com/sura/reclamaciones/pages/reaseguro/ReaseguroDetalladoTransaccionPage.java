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

  public boolean verificarPorcentajeRetenido(
      Double dblValorRetenido, Double dblValorRetenidoDeducible) {
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, NUMERO_TRANSACCION.getValor(), 2);
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

  public boolean verificarPorcentajeCedido(
      String strValorReasegurado,
      Double dblValorRetenido,
      String strValorDeducible,
      Double dblValorRetenidoDeducible) {
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, NUMERO_TRANSACCION.getValor(), 2);
    for (WebElement aLstReaseguroDetallado : lstReaseguroDetallado) {
      String strNumeroTransaccion = aLstReaseguroDetallado.getText();
      List<WebElement> lstFilaTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblPago());
      String strDatoPantalla =
          lstFilaTransaccion.get(4).getText().replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      Integer intDatoPantalla = Integer.parseInt(strDatoPantalla);
      if ((intDatoPantalla
                  >= Double.parseDouble(strValorReasegurado) - dblValorRetenido - dblRetencionPura)
              && (intDatoPantalla
                  <= Double.parseDouble(strValorReasegurado) - dblValorRetenido + dblRetencionPura)
          || ((intDatoPantalla
                  >= Double.parseDouble(strValorDeducible)
                      - dblValorRetenidoDeducible
                      + dblRetencionPura)
              && (intDatoPantalla
                  <= Double.parseDouble(strValorDeducible)
                      - dblValorRetenidoDeducible
                      - dblRetencionPura))) {
        LOGGER.info("El cedido esta en el rango correcto");
      } else {
        return false;
      }
    }
    return true;
  }

  private String calcularValorDeducible(
      String strValorReasegurado, String strDeducible, String strPorcentajeDeducible) {
    Double dblValorReasegurado = Double.parseDouble(strValorReasegurado);
    Double dblDeducible = Double.parseDouble(strDeducible);
    Double dblPorcentaje =
        Double.parseDouble(strPorcentajeDeducible) / Double.parseDouble(PORCIENTO.getValor());
    Double dblValorDeducible = (dblValorReasegurado * dblPorcentaje);
    if (dblValorReasegurado < dblDeducible) {
      return String.valueOf(Math.floor(-dblValorReasegurado));
    }
    if (dblDeducible > dblValorDeducible) {
      return String.valueOf(Math.floor(-dblDeducible));
    }
    return String.valueOf(Math.floor(-dblValorDeducible));
  }

  private double calcularValorRetenido(
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
    boolean blnTransaccion = false;
    switch (strTransaccion) {
      case "Reserva":
        blnTransaccion =
            verificarReserva(
                dblRetencionPura,
                porcentajeRetenido,
                deducibleMinimo,
                porcentajeDeducibleMinimo,
                proporcionCuotaParte);
        break;
      case "Pago":
        blnTransaccion =
            verificarPago(
                dblRetencionPura,
                porcentajeRetenido,
                deducibleMinimo,
                porcentajeDeducibleMinimo,
                proporcionCuotaParte);
        break;
      case "Recupero":
        blnTransaccion =
            verificarRecupero(
                dblRetencionPura,
                porcentajeRetenido,
                deducibleMinimo,
                porcentajeDeducibleMinimo,
                proporcionCuotaParte);
        break;
      default:
        return blnTransaccion;
    }
    return blnTransaccion;
  }

  private boolean verificarRecupero(
      double dblRetencionPura,
      String porcentajeRetenido,
      String deducibleMinimo,
      String porcentajeDeducibleMinimo,
      String proporcionCuotaParte) {
    boolean verificacionRecupero =
        verificarPago(
            dblRetencionPura,
            porcentajeRetenido,
            deducibleMinimo,
            porcentajeDeducibleMinimo,
            proporcionCuotaParte);
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, NUMERO_TRANSACCION.getValor(), 4);
    for (int posicionElementoFila = 5;
        lstReaseguroDetallado.size() >= posicionElementoFila;
        posicionElementoFila++) {
      String strValorRecupero =
          lstReaseguroDetallado
              .get(4)
              .getText()
              .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      verificacionRecupero =
          (strValorRecupero.equals(Serenity.sessionVariableCalled(Variables.VALOR_RECUPERO)));
    }
    return verificacionRecupero;
  }

  private boolean verificarReserva(
      double dblRetencionPura,
      String porcentajeRetenido,
      String deducibleMinimo,
      String porcentajeDeducibleMinimo,
      String proporcionCuotaParte) {
    String strValorReasegurado =
        (obtenerDatoTablaCabecera(VALOR_REASEGURADO.getValor(), 2))
            .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    String strValorDeducible =
        calcularValorDeducible(strValorReasegurado, deducibleMinimo, porcentajeDeducibleMinimo);
    Double dblValorRetenido =
        calcularValorRetenido(strValorReasegurado, porcentajeRetenido, proporcionCuotaParte);
    Double dblValorRetenidoDeducible =
        calcularValorRetenido(strValorDeducible, porcentajeRetenido, proporcionCuotaParte);
    boolean blnRetencionPura = verificarRetencionPura(dblRetencionPura);
    boolean blnPorcentajeCedido =
        verificarPorcentajeCedido(
            strValorReasegurado, dblValorRetenido, strValorDeducible, dblValorRetenidoDeducible);
    boolean blnPorcentajeRetenido =
        verificarPorcentajeRetenido(dblValorRetenido, dblValorRetenidoDeducible);
    return blnRetencionPura && blnPorcentajeRetenido && blnPorcentajeCedido;
  }

  private boolean verificarPago(
      double dblRetencionPura,
      String porcentajeRetenido,
      String deducibleMinimo,
      String porcentajeDeducibleMinimo,
      String proporcionCuotaParte) {
    verificarReserva(
        this.dblRetencionPura,
        porcentajeRetenido,
        deducibleMinimo,
        porcentajeDeducibleMinimo,
        proporcionCuotaParte);
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, NUMERO_TRANSACCION.getValor(), 4);
    for (int posicionElementoFila = 2;
        lstReaseguroDetallado.size() > posicionElementoFila - 1;
        posicionElementoFila++) {
      String strValorPago =
          lstReaseguroDetallado
              .get(2)
              .getText()
              .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      if (strValorPago.equals(Serenity.sessionVariableCalled(Variables.VALOR_RESERVA))) {
        return true;
      }
    }
    return false;
  }
}
