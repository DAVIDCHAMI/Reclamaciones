package com.sura.reclamaciones.pages.reaseguro;

import static com.sura.reclamaciones.constantes.Constantes.PORCIENTO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_TRANSACCION;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RECUPERO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RESERVA;

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
    String strRetencionPura =
        lstFilaTransaccion.get(6).getText().replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    dblRetencionPura = Double.parseDouble(strRetencionPura);
    return (dblRetencionPura >= -dblMaximoValorRetencionPura
        && dblRetencionPura <= dblMaximoValorRetencionPura);
  }

  private boolean verificarPorcentajeCedido(
      List<WebElement> lstFilaTransaccion,
      int posicionElementoFila,
      String porcentajeRetenido,
      String proporcionCuotaParte) {
    String strValorPantalla =
        lstFilaTransaccion.get(2).getText().replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    dblValorRetenido =
        calcularValorRetenido(strValorPantalla, porcentajeRetenido, proporcionCuotaParte);
    Double dblDatoPantalla =
        Double.parseDouble(
            lstFilaTransaccion
                .get(4)
                .getText()
                .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), ""));
    return ((dblDatoPantalla
            >= (Math.round(
                Double.parseDouble(strValorPantalla) - dblValorRetenido - dblRetencionPura)))
        && (dblDatoPantalla
            <= (Math.round(
                Double.parseDouble(strValorPantalla) - dblValorRetenido + dblRetencionPura))));
  }

  private double calcularValorRetenido(
      String strValorReasegurado, String strPorcentajeCedido, String strProporcionCuotaParte) {
    Double dblValorReasegurado = Double.parseDouble(strValorReasegurado);
    Double dblPorcentajeCedido =
        Double.parseDouble(strPorcentajeCedido) / Double.parseDouble(PORCIENTO.getValor());
    Double dblPorcentaCuotaParte =
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
      default:
        return blnTransaccion;
    }
    return blnTransaccion;
  }

  private boolean verificarRecupero(
      Double dblMaximoRetencioPura, String porcentajeRetenido, String proporcionCuotaParte) {
    boolean verificacionRecupero =
        verificarPago(dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
    String strValorRecupero = null;
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, SESION_CC_NUMERO_TRANSACCION.getValor(), 4);
    for (int posicionElementoFila = 5;
        lstReaseguroDetallado.size() >= posicionElementoFila;
        posicionElementoFila++) {
      strValorRecupero =
          lstReaseguroDetallado
              .get(4)
              .getText()
              .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    }
    return verificacionRecupero
        && (strValorRecupero.equals(
            Serenity.sessionVariableCalled(SESION_CC_VALOR_RECUPERO.getValor())));
  }

  private boolean verificarReserva(
      Double dblMaximoRetencioPura, String porcentajeRetenido, String proporcionCuotaParte) {
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, SESION_CC_NUMERO_TRANSACCION.getValor(), 2);
    boolean blnPorcentajeCedido = false;
    boolean blnRetencionPura = false;
    boolean blnPorcentajeRetenido = false;
    for (int posicionElementoFila = 0;
        lstReaseguroDetallado.size() > posicionElementoFila;
        posicionElementoFila++) {
      String strNumeroTransaccion = lstReaseguroDetallado.get(posicionElementoFila).getText();
      List<WebElement> lstFilaTransaccion = obtenerFilaTabla(strNumeroTransaccion, getTblPago());
      blnRetencionPura = verificarRetencionPura(lstFilaTransaccion, dblMaximoRetencioPura);
      blnPorcentajeCedido =
          verificarPorcentajeCedido(
              lstFilaTransaccion, posicionElementoFila, porcentajeRetenido, proporcionCuotaParte);
      blnPorcentajeRetenido = verificarPorcentajeRetenido(lstFilaTransaccion, dblValorRetenido);
      if (!(blnRetencionPura && blnPorcentajeRetenido && blnPorcentajeCedido)) {
        break;
      }
    }
    return blnRetencionPura && blnPorcentajeRetenido && blnPorcentajeCedido;
  }

  private boolean verificarPorcentajeRetenido(
      List<WebElement> lstFilaTransaccion, Double dblValorRetenido) {
    Double dblDatoPantalla =
        Double.parseDouble(
            lstFilaTransaccion
                .get(5)
                .getText()
                .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), ""));
    return ((dblDatoPantalla >= (Math.round(dblValorRetenido - dblRetencionPura)))
        && (dblDatoPantalla <= (Math.round(dblValorRetenido + dblRetencionPura))));
  }

  private boolean verificarPago(
      Double dblMaximoRetencioPura, String porcentajeRetenido, String proporcionCuotaParte) {
    boolean blnVerificarPago =
        verificarReserva(dblMaximoRetencioPura, porcentajeRetenido, proporcionCuotaParte);
    String strValorPago = null;
    List<WebElement> lstReaseguroDetallado =
        obtenerElementoTablaDatoDesconocido(
            tblReaseguroDetalladoTransaccion, SESION_CC_NUMERO_TRANSACCION.getValor(), 4);
    for (int posicionElementoFila = 2;
        lstReaseguroDetallado.size() > posicionElementoFila - 1;
        posicionElementoFila++) {
      strValorPago =
          lstReaseguroDetallado
              .get(2)
              .getText()
              .replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    }
    return (strValorPago.equals(Serenity.sessionVariableCalled(SESION_CC_VALOR_RESERVA.getValor())))
        && blnVerificarPago;
  }
}
