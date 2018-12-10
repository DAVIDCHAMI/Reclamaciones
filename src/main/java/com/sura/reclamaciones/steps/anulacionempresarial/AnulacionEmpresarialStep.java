package com.sura.reclamaciones.steps.anulacionempresarial;

import static com.sura.reclamaciones.utils.Constantes.NUMERO_TRANSACCION;
import static com.sura.reclamaciones.utils.Constantes.RECUPERO;
import static com.sura.reclamaciones.utils.Variables.TIPO_ANULACION;
import static org.junit.Assert.assertTrue;

import com.sura.reclamaciones.constantes.AnulacionConstante;
import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.constantes.RecuperoConstante;
import com.sura.reclamaciones.models.PagoEmpresarial;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.pages.anulacionempresarial.DetalleTransaccionPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class AnulacionEmpresarialStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleTransaccionPage detalleTransaccionPage;

  @Page
  VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Step
  public void ingresarAnulacionRecupero(List<Recupero> lstRecupero) {
    Serenity.setSessionVariable(Variables.TIPO_ANULACION).to(RECUPERO.getValor());
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
    for (Recupero diligenciador : lstRecupero) {
      String strNumeroTransaccion =
          detalleTransaccionPage.obtenerDatoTablaCabecera(NUMERO_TRANSACCION.getValor(), 1);
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
          MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
      detalleTransaccionPage.seleccionarTipoTransaccion(RecuperoConstante.TIPO_TRANSACCION);
      assertTrue(
          "El estado de la transaccion no permite que sea anulada",
          detalleTransaccionPage.ingresarAnulacionEmpresarial(
              strNumeroTransaccion,
              diligenciador.getEstadoTransaccion(),
              Serenity.sessionVariableCalled(TIPO_ANULACION)));
      assertTrue(
          "El número de transaccion, no tiene habilitado el boton de anular",
          detalleTransaccionPage.realizarAnulacion(Serenity.sessionVariableCalled(TIPO_ANULACION)));
      Serenity.setSessionVariable(NUMERO_TRANSACCION.getValor()).to(strNumeroTransaccion);
    }
  }

  @Step
  public void ingresarAnulacionPago(List<PagoEmpresarial> lstPago) {
    Serenity.setSessionVariable(Variables.TIPO_ANULACION).to(AnulacionConstante.PAGO);
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, PagoConstante.PAGOS);
    for (PagoEmpresarial diligenciador : lstPago) {
      String strNumeroTransaccion = verificacionDatosFinancierosPage.obtenerNumeroPagoRealizado();
      assertTrue(
          "El estado de la transaccion no permite que sea anulada",
          detalleTransaccionPage.ingresarAnulacionEmpresarial(
              strNumeroTransaccion,
              diligenciador.getEstadoTransaccion(),
              Serenity.sessionVariableCalled(TIPO_ANULACION)));
      assertTrue(
          "El número de transaccion, no tiene habilitado el boton de anular",
          detalleTransaccionPage.realizarAnulacion(Serenity.sessionVariableCalled(TIPO_ANULACION)));
      Serenity.setSessionVariable(NUMERO_TRANSACCION.getValor()).to(strNumeroTransaccion);
    }
  }

  @Step
  public void verificarAnulacionRealizada(String strAnulacionPago) {
    String strNumeroTransaccion = Serenity.sessionVariableCalled(NUMERO_TRANSACCION.getValor());
    String strTipoAnulacion = Serenity.sessionVariableCalled(TIPO_ANULACION);
    if (strTipoAnulacion.equals(AnulacionConstante.PAGO)) {
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
          MenuConstante.DATOS_FINANCIEROS, PagoConstante.PAGOS);
      assertTrue(
          "El pago no quedo en estado anulado",
          verificacionDatosFinancierosPage.verificarEstadoAnulado(
              strAnulacionPago, strNumeroTransaccion, strTipoAnulacion));
    } else {
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
          MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
      verificacionDatosFinancierosPage.seleccionarTipoTransaccion(
          RecuperoConstante.TIPO_TRANSACCION);
      assertTrue(
          "El recupero no quedo en estado anulado",
          verificacionDatosFinancierosPage.verificarEstadoAnulado(
              strAnulacionPago, strNumeroTransaccion, strTipoAnulacion));
    }
  }
}

