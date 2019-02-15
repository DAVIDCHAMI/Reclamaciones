package com.sura.reclamaciones.pages.reaseguro;

import static com.sura.reclamaciones.constantes.Constantes.ANULACION_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.NUMERO_TRANSACCION;
import static com.sura.reclamaciones.constantes.Constantes.PORCIENTO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_TRANSACCION;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RECUPERO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RESERVA;
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

  private double dblRetencionPura = 0.0;
  private Double dblValorRetenido = 0.0;

  @FindBy(xpath = "//div[@class='x-container g-screen x-container-page x-table-layout-ct']")
  private WebElementFacade tblReaseguroDetalladoTransaccion;

  public ReaseguroDetalladoTransaccionPage(WebDriver driver) {
    super(driver);
  }

  private boolean verificarRetencionPura(
      List<WebElement> lstFilaTransaccion, Double dblMaximoValorRetencionPura) {
    String strRetencionPura = null;
    if (lstFilaTransaccion.size() > 10) {
      strRetencionPura =
          lstFilaTransaccion
              .get(16)
              .getText()
              .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    } else {
      strRetencionPura =
          lstFilaTransaccion.get(6).getText().replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    }
    dblRetencionPura = abs(Double.parseDouble(strRetencionPura));
    return (dblRetencionPura >= -dblMaximoValorRetencionPura
        && dblRetencionPura <= dblMaximoValorRetencionPura);
  }

  private boolean verificarPorcentajeCedido(
      List<WebElement> lstFilaTransaccion, String porcentajeRetenido, String proporcionCuotaParte) {
    String strValorPantalla = null;
    if (lstFilaTransaccion.size() > 10) {
      strValorPantalla =
          lstFilaTransaccion
              .get(12)
              .getText()
              .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    } else {
      strValorPantalla =
          lstFilaTransaccion.get(2).getText().replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    }
    dblValorRetenido =
        abs(calcularValorRetenido(strValorPantalla, porcentajeRetenido, proporcionCuotaParte));
    Double dblDatoPantalla =
        abs(
            Double.parseDouble(
                lstFilaTransaccion
                    .get(4)
                    .getText()
                    .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "")));
    return ((dblDatoPantalla
            >= (Math.round(
                abs(Double.parseDouble(strValorPantalla)) - dblValorRetenido - dblRetencionPura)))
        && (dblDatoPantalla
            <= (Math.round(
                abs(Double.parseDouble(strValorPantalla)) - dblValorRetenido + dblRetencionPura))));
  }

  private double calcularValorRetenido(
      String strValorReasegurado, String strPorcentajeCedido, String strProporcionCuotaParte) {
    double dblValorReasegurado = Double.parseDouble(strValorReasegurado);
    double dblPorcentajeCedido =
        Double.parseDouble(strPorcentajeCedido) / Double.parseDouble(PORCIENTO.getValor());
    double dblPorcentaCuotaParte =
        Double.parseDouble(strProporcionCuotaParte) / Double.parseDouble(PORCIENTO.getValor());
    return (dblPorcentajeCedido * dblValorReasegurado * dblPorcentaCuotaParte);
  }

  public boolean verificarReaseguro(
      Double dblMaximoRetencioPura,
      String strTransaccion,
      String porcentajeRetenido,
      String proporcionCuotaParte) {
    boolean blnTransaccion = false;
    switch (strTransaccion) {
      case "Reserva":
        blnTransaccion =
            verificarReserva(dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
        break;
      case "Pago":
        blnTransaccion =
            verificarPago(dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
        break;
      case "Recupero":
        blnTransaccion =
            verificarRecupero(dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
        break;
      case "Anulación Pago":
      case "Anulación Recupero":
        blnTransaccion =
            verificarAnulacion(
                dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte, strTransaccion);
        break;
      case "Reversión Constitución":
        blnTransaccion =
            verificarReversionConstitucion(
                dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
      default:
        return blnTransaccion;
    }
    return blnTransaccion;
  }

  private boolean verificarReversionConstitucion(
      Double dblMaximoRetencioPura, String porcentajeRetenido, String proporcionCuotaParte) {
    boolean blnValorReversion = false;
    boolean blnReaseguro = false;
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, SESION_CC_NUMERO_TRANSACCION.getValor(), 4);
    for (int posicionElementoFila = lstReaseguroDetallado.size() - 1;
        lstReaseguroDetallado.size() > posicionElementoFila;
        posicionElementoFila++) {
      blnReaseguro =
          verificarDistribucionReaseguro(
              dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
    }
    return blnValorReversion && blnReaseguro;
  }

  private boolean verificarAnulacion(
      Double dblMaximoRetencioPura,
      String porcentajeRetenido,
      String proporcionCuotaParte,
      String strTransaccion) {
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
              dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
      String strValorAnulacion =
          lstReaseguroDetallado
              .get(4)
              .getText()
              .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      if (strTransaccion.equals(ANULACION_PAGO)) {
        blnValorAnulacion =
            strValorAnulacion.equals(
                Serenity.sessionVariableCalled((SESION_CC_VALOR_RESERVA.getValor())));
      } else {
        blnValorAnulacion =
            strValorAnulacion.equals(
                Serenity.sessionVariableCalled((SESION_CC_VALOR_RECUPERO.getValor())));
      }
    }
    return blnValorAnulacion && blnReaseguro;
  }

  private boolean verificarDistribucionReaseguro(
      Double dblMaximoRetencioPura, String porcentajeRetenido, String proporcionCuotaParte) {
    String strNumeroReclamacion = obtenerDatoTablaCabecera(NUMERO_TRANSACCION.getValor(), 1);
    List<WebElement> lstFilaTransaccion = obtenerFilaTabla(strNumeroReclamacion, getTblPago());
    boolean blnRetencionPura = verificarRetencionPura(lstFilaTransaccion, dblMaximoRetencioPura);
    boolean blnPorcentajeCedido =
        verificarPorcentajeCedido(lstFilaTransaccion, porcentajeRetenido, proporcionCuotaParte);
    boolean blnPorcentajeRetenido =
        verificarPorcentajeRetenido(lstFilaTransaccion, dblValorRetenido);
    return blnRetencionPura && blnPorcentajeCedido && blnPorcentajeRetenido;
  }

  private boolean verificarRecupero(
      Double dblMaximoRetencioPura, String porcentajeRetenido, String proporcionCuotaParte) {
    boolean blnValorRecupero = false;
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, SESION_CC_NUMERO_TRANSACCION.getValor(), 4);
    for (int posicionElementoFila = lstReaseguroDetallado.size() - 1;
        lstReaseguroDetallado.size() > posicionElementoFila;
        posicionElementoFila++) {
      boolean blnReaseguro =
          verificarDistribucionReaseguro(
              dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
      String strValorRecupero =
          lstReaseguroDetallado
              .get(4)
              .getText()
              .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      blnValorRecupero =
          strValorRecupero.equals(
              Serenity.sessionVariableCalled(SESION_CC_VALOR_RECUPERO.getValor()));
      blnValorRecupero = blnValorRecupero && blnReaseguro;
    }
    return blnValorRecupero;
  }

  private boolean verificarReserva(
      Double dblMaximoRetencioPura, String porcentajeRetenido, String proporcionCuotaParte) {
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, SESION_CC_NUMERO_TRANSACCION.getValor(), 2);
    boolean blnReaseguro = false;
    for (int posicionElementoFila = 0;
        lstReaseguroDetallado.size() > posicionElementoFila;
        posicionElementoFila++) {
      blnReaseguro =
          verificarDistribucionReaseguro(
              dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
    }
    return blnReaseguro;
  }

  private boolean verificarPorcentajeRetenido(
      List<WebElement> lstFilaTransaccion, Double dblValorRetenido) {
    double dblDatoPantalla = 0.0;
    if (lstFilaTransaccion.size() > 10) {
      dblDatoPantalla =
          abs(
              Double.parseDouble(
                  lstFilaTransaccion
                      .get(15)
                      .getText()
                      .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "")));
    } else {
      dblDatoPantalla =
          abs(
              Double.parseDouble(
                  lstFilaTransaccion
                      .get(5)
                      .getText()
                      .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "")));
    }
    return ((dblDatoPantalla >= (Math.round(dblValorRetenido - dblRetencionPura)))
        && (dblDatoPantalla <= (Math.round(dblValorRetenido + dblRetencionPura))));
  }

  private boolean verificarPago(
      Double dblMaximoRetencioPura, String porcentajeRetenido, String proporcionCuotaParte) {
    boolean blnValorPago = false;
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, NUMERO_TRANSACCION.getValor(), 1);
    for (int posicionElementoFila = lstReaseguroDetallado.size() - 1;
        lstReaseguroDetallado.size() > posicionElementoFila;
        posicionElementoFila++) {
      boolean blnReaseguro =
          verificarDistribucionReaseguro(
              dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
      String strValorPago =
          lstReaseguroDetallado
              .get(2)
              .getText()
              .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
      blnValorPago =
          strValorPago.equals(Serenity.sessionVariableCalled(SESION_CC_VALOR_RESERVA.getValor()));
      blnValorPago = blnValorPago && blnReaseguro;
    }
    return blnValorPago;
  }
}
