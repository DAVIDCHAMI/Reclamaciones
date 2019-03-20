package com.sura.reclamaciones.pages.reaseguro;

import static com.sura.reclamaciones.constantes.Constantes.ANULACION_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.CERO;
import static com.sura.reclamaciones.constantes.Constantes.NUMERO_TRANSACCION_REASEGURO;
import static com.sura.reclamaciones.constantes.Constantes.PORCIENTO;
import static com.sura.reclamaciones.utils.Variables.FORMATEAR_MONTOS;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_TRANSACCION;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RECUPERO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RESERVA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RESERVA_CONSTITUCION;
import static java.lang.Math.abs;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReaseguroDetalladoTransaccionPage extends GeneralPage {

  private double dblRetencionPura = 0.0;
  private Double dblValorRetenido = 0.0;
  private Double dblMaximoRetencioPura = 0.0;
  private String porcentajeRetenido = null;
  private String proporcionCuotaParte = null;
  private String porcentajeCoaseguroCedido = null;

  @FindBy(xpath = "//div[@class='x-container g-screen x-container-page x-table-layout-ct']")
  private WebElementFacade tblReaseguroDetalladoTransaccion;

  public ReaseguroDetalladoTransaccionPage(WebDriver driver) {
    super(driver);
  }

  private void setDblMaximoRetencioPura(Double dblMaximoRetencioPura) {
    this.dblMaximoRetencioPura = dblMaximoRetencioPura;
  }

  private void setPorcentajeRetenido(String porcentajeRetenido) {
    this.porcentajeRetenido = porcentajeRetenido;
  }

  private void setProporcionCuotaParte(String proporcionCuotaParte) {
    this.proporcionCuotaParte = proporcionCuotaParte;
  }

  private void setPorcentajeCoaseguroCedido(String porcentajeCoaseguroCedido) {
    this.porcentajeCoaseguroCedido = porcentajeCoaseguroCedido;
  }

  public boolean verificarReaseguro(
      Double dblMaximoRetencioPura,
      String strTransaccion,
      String porcentajeRetenido,
      String proporcionCuotaParte,
      String porcentajeCoaseguroCedido) {
    boolean blnTransaccion = false;
    setDblMaximoRetencioPura(dblMaximoRetencioPura);
    setPorcentajeRetenido(porcentajeRetenido);
    setProporcionCuotaParte(proporcionCuotaParte);
    setPorcentajeCoaseguroCedido(porcentajeCoaseguroCedido);
    switch (strTransaccion) {
      case "Reserva":
        blnTransaccion = verificarReserva();
        break;
      case "Pago":
        blnTransaccion = verificarPago();
        break;
      case "Recupero":
        blnTransaccion = verificarRecupero();
        break;
      case "Anulación Pago":
      case "Anulación Recupero":
        blnTransaccion = verificarAnulacion(strTransaccion);
        break;
      case "Reversión Constitución":
        blnTransaccion = verificarReversionConstitucion();
        break;
      default:
        return blnTransaccion;
    }
    return blnTransaccion;
  }

  private boolean verificarRetencionPura(
      List<WebElement> lstFilaTransaccion, Double dblMaximoValorRetencionPura) {
    String strRetencionPura;
    if (lstFilaTransaccion.size() > 11) {
      strRetencionPura =
          lstFilaTransaccion.get(17).getText().replaceAll(FORMATEAR_MONTOS.getValor(), "");
    } else {
      strRetencionPura =
          lstFilaTransaccion.get(6).getText().replaceAll(FORMATEAR_MONTOS.getValor(), "");
    }
    dblRetencionPura = abs(Double.parseDouble(strRetencionPura));
    return (dblRetencionPura >= -dblMaximoValorRetencionPura
        && dblRetencionPura <= dblMaximoValorRetencionPura);
  }

  private boolean verificarPorcentajeCedido(
      List<WebElement> lstFilaTransaccion,
      String porcentajeRetenido,
      String proporcionCuotaParte,
      String porcentajeCoaseguroCedido) {
    String strValorPantallaReaseguro;
    double dblValorCedido;
    if (lstFilaTransaccion.size() > 11) {
      strValorPantallaReaseguro =
          lstFilaTransaccion.get(13).getText().replaceAll(FORMATEAR_MONTOS.getValor(), "");
    } else {
      strValorPantallaReaseguro =
          lstFilaTransaccion.get(2).getText().replaceAll(FORMATEAR_MONTOS.getValor(), "");
    }
    dblValorRetenido =
        abs(
            calcularValorRetenido(
                strValorPantallaReaseguro,
                porcentajeRetenido,
                proporcionCuotaParte,
                porcentajeCoaseguroCedido));
    double dblDatoPantalla =
        abs(
            Double.parseDouble(
                lstFilaTransaccion.get(4).getText().replaceAll(FORMATEAR_MONTOS.getValor(), "")));
    if (porcentajeCoaseguroCedido.equals(CERO.getValor())) {
      dblValorCedido = abs(Double.parseDouble(strValorPantallaReaseguro)) - dblValorRetenido;
    } else {
      dblValorCedido =
          (abs(Double.parseDouble(strValorPantallaReaseguro))
                  * (Double.parseDouble(porcentajeCoaseguroCedido)
                      / Double.parseDouble(PORCIENTO.getValor())))
              - dblValorRetenido;
    }
    return ((dblDatoPantalla >= (Math.round(dblValorCedido - dblRetencionPura)))
        && (dblDatoPantalla <= (Math.round(dblValorCedido + dblRetencionPura))));
  }

  private double calcularValorRetenido(
      String strValorReasegurado,
      String strPorcentajeCedido,
      String strProporcionCuotaParte,
      String strPorcentajeCoaseguroCedido) {
    double dblPorcentajeCoaseguroCedido =
        Double.parseDouble(strPorcentajeCoaseguroCedido) / Double.parseDouble(PORCIENTO.getValor());
    double dblValorReasegurado = Double.parseDouble(strValorReasegurado);
    double dblPorcentajeCedido =
        Double.parseDouble(strPorcentajeCedido) / Double.parseDouble(PORCIENTO.getValor());
    double dblPorcentaCuotaParte =
        Double.parseDouble(strProporcionCuotaParte) / Double.parseDouble(PORCIENTO.getValor());
    if (strPorcentajeCoaseguroCedido.equals(CERO.getValor())) {
      return (dblPorcentajeCedido * dblValorReasegurado * dblPorcentaCuotaParte);
    } else {
      return (dblPorcentajeCedido * dblValorReasegurado * dblPorcentaCuotaParte)
          * dblPorcentajeCoaseguroCedido;
    }
  }

  private boolean verificarReversionConstitucion() {
    boolean blnValorReversion = false;
    boolean blnReaseguro = false;
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, SESION_CC_NUMERO_TRANSACCION.getValor(), 4);
    for (int posicionElementoFila = 0;
        lstReaseguroDetallado.size() > posicionElementoFila;
        posicionElementoFila++) {
      blnReaseguro =
          verificarDistribucionReaseguro(
              dblMaximoRetencioPura,
              porcentajeRetenido,
              proporcionCuotaParte,
              porcentajeCoaseguroCedido,
              posicionElementoFila + 1);
    }
    String strValorTransaccion =
        lstReaseguroDetallado.get(2).getText().replaceAll(FORMATEAR_MONTOS.getValor(), "");
    blnValorReversion =
        strValorTransaccion.equals(
            Serenity.sessionVariableCalled(SESION_CC_VALOR_RESERVA_CONSTITUCION.getValor()));
    return blnValorReversion && blnReaseguro;
  }

  private boolean verificarAnulacion(String strTransaccion) {
    boolean blnValorAnulacion = false;
    boolean blnReaseguro = false;
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, SESION_CC_NUMERO_TRANSACCION.getValor(), 4);
    for (int posicionElementoFila = lstReaseguroDetallado.size() - 1;
        lstReaseguroDetallado.size() > posicionElementoFila;
        posicionElementoFila++) {
      blnReaseguro =
          verificarDistribucionReaseguro(
              dblMaximoRetencioPura,
              porcentajeRetenido,
              proporcionCuotaParte,
              porcentajeCoaseguroCedido,
              1);
      String strValorTransaccion =
          lstReaseguroDetallado
              .get(posicionElementoFila)
              .getText()
              .replaceAll(FORMATEAR_MONTOS.getValor(), "");
      if (strTransaccion.equals(ANULACION_PAGO.getValor())) {
        blnValorAnulacion =
            strValorTransaccion.equals(
                "-" + Serenity.sessionVariableCalled((SESION_CC_VALOR_RESERVA.getValor())));
      } else {
        blnValorAnulacion =
            strValorTransaccion.equals(
                "-" + Serenity.sessionVariableCalled((SESION_CC_VALOR_RECUPERO.getValor())));
      }
    }
    return blnValorAnulacion && blnReaseguro;
  }

  private boolean verificarDistribucionReaseguro(
      Double dblMaximoRetencioPura,
      String porcentajeRetenido,
      String proporcionCuotaParte,
      String porcentajeCoaseguroCedido,
      int intFilaTransaccion) {
    String strNumeroTransaccion =
        obtenerDatoTablaCabecera(NUMERO_TRANSACCION_REASEGURO.getValor(), intFilaTransaccion);
    List<WebElement> lstFilaTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblPago());
    boolean blnRetencionPura = verificarRetencionPura(lstFilaTransaccion, dblMaximoRetencioPura);
    boolean blnPorcentajeCedido =
        verificarPorcentajeCedido(
            lstFilaTransaccion,
            porcentajeRetenido,
            proporcionCuotaParte,
            porcentajeCoaseguroCedido);
    boolean blnPorcentajeRetenido =
        verificarPorcentajeRetenido(lstFilaTransaccion, dblValorRetenido);
    return blnRetencionPura && blnPorcentajeCedido && blnPorcentajeRetenido;
  }

  private boolean verificarRecupero() {
    boolean blnValorRecupero = false;
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, SESION_CC_NUMERO_TRANSACCION.getValor(), 4);
    for (int posicionElementoFila = lstReaseguroDetallado.size() - 1;
        lstReaseguroDetallado.size() > posicionElementoFila;
        posicionElementoFila++) {
      boolean blnReaseguro =
          verificarDistribucionReaseguro(
              dblMaximoRetencioPura,
              porcentajeRetenido,
              proporcionCuotaParte,
              porcentajeCoaseguroCedido,
              1);
      String strValorTransaccion =
          lstReaseguroDetallado
              .get(posicionElementoFila)
              .getText()
              .replaceAll(FORMATEAR_MONTOS.getValor(), "");
      blnValorRecupero =
          strValorTransaccion.equals(
              Serenity.sessionVariableCalled(SESION_CC_VALOR_RECUPERO.getValor()));
      blnValorRecupero = blnValorRecupero && blnReaseguro;
    }
    return blnValorRecupero;
  }

  private boolean verificarReserva() {
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, SESION_CC_NUMERO_TRANSACCION.getValor(), 2);
    boolean blnReaseguro = false;
    for (int posicionElementoFila = 0;
        lstReaseguroDetallado.size() > posicionElementoFila;
        posicionElementoFila++) {
      blnReaseguro =
          verificarDistribucionReaseguro(
              dblMaximoRetencioPura,
              porcentajeRetenido,
              proporcionCuotaParte,
              porcentajeCoaseguroCedido,
              1);
    }
    return blnReaseguro;
  }

  private boolean verificarPorcentajeRetenido(
      List<WebElement> lstFilaTransaccion, Double dblValorRetenido) {
    double dblDatoPantalla;
    if (lstFilaTransaccion.size() > 11) {
      dblDatoPantalla =
          abs(
              Double.parseDouble(
                  lstFilaTransaccion
                      .get(16)
                      .getText()
                      .replaceAll(FORMATEAR_MONTOS.getValor(), "")));
    } else {
      dblDatoPantalla =
          abs(
              Double.parseDouble(
                  lstFilaTransaccion.get(5).getText().replaceAll(FORMATEAR_MONTOS.getValor(), "")));
    }
    return ((dblDatoPantalla >= (Math.round(dblValorRetenido - dblRetencionPura)))
        && (dblDatoPantalla <= (Math.round(dblValorRetenido + dblRetencionPura))));
  }

  private boolean verificarPago() {
    boolean blnValorPago = false;
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, NUMERO_TRANSACCION_REASEGURO.getValor(), 1);
    boolean blnReaseguro =
        verificarDistribucionReaseguro(
            dblMaximoRetencioPura,
            porcentajeRetenido,
            proporcionCuotaParte,
            porcentajeCoaseguroCedido,
            1);
    String strValorTransaccion = obtenerValorTransaccion(lstReaseguroDetallado.get(3).getText());
    blnValorPago =
        strValorTransaccion.equals(
            Serenity.sessionVariableCalled(SESION_CC_VALOR_RESERVA.getValor()));
    blnValorPago = blnValorPago && blnReaseguro;
    return blnValorPago;
  }

  private String obtenerValorTransaccion(String strNumeroReclamacion) {
    List<WebElement> lstFilaTransaccion = obtenerFilaTabla(strNumeroReclamacion, getTblPago());
    return lstFilaTransaccion.get(2).getText().replaceAll(FORMATEAR_MONTOS.getValor(), "");
  }
}
