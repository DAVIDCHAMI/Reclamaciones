package com.sura.reclamaciones.steps.anulacionempresarial;

import static com.sura.reclamaciones.utils.Constantes.NUMERO_TRANSACCION;
import static com.sura.reclamaciones.utils.Constantes.PAGO;
import static com.sura.reclamaciones.utils.Constantes.RECUPERO;
import static com.sura.reclamaciones.utils.Constantes.TIPO_TRANSACCION;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_TRANSACCION;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_ANULACION;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.models.PagoEmpresarial;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.pages.anulacionempresarial.DetalleTransaccionPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AnulacionEmpresarialStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleTransaccionPage detalleTransaccionPage;

  @Page
  VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Step
  public void ingresarAnulacionRecupero(List<Recupero> lstRecupero) {
    Serenity.setSessionVariable(SESION_CC_TIPO_ANULACION.getValor()).to(RECUPERO.getValor());
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
    for (Recupero diligenciador : lstRecupero) {
      String strNumeroTransaccion =
          detalleTransaccionPage.obtenerDatoTablaCabecera(NUMERO_TRANSACCION.getValor(), 1);
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
          MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
      detalleTransaccionPage.seleccionarTipoTransaccion(TIPO_TRANSACCION.getValor());
      MatcherAssert.assertThat(
          "El estado de la transaccion no permite que sea anulada",
          detalleTransaccionPage.ingresarAnulacionEmpresarial(
              strNumeroTransaccion,
              diligenciador.getEstadoTransaccion(),
              Serenity.sessionVariableCalled(SESION_CC_TIPO_ANULACION.getValor())));
      MatcherAssert.assertThat(
          "El número de transaccion, no tiene habilitado el boton de anular",
          detalleTransaccionPage.realizarAnulacion(Serenity.sessionVariableCalled(SESION_CC_TIPO_ANULACION.getValor())));
      Serenity.setSessionVariable(SESION_CC_NUMERO_TRANSACCION.getValor()).to(strNumeroTransaccion);
    }
  }

  @Step
  public void ingresarAnulacionPago(List<PagoEmpresarial> lstPago) {
    Serenity.setSessionVariable(SESION_CC_TIPO_ANULACION.getValor()).to(PAGO.getValor());
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, PagoConstante.PAGOS);
    for (PagoEmpresarial diligenciador : lstPago) {
      String strNumeroTransaccion = verificacionDatosFinancierosPage.obtenerNumeroPagoRealizado();
      MatcherAssert.assertThat(
          "El estado de la transaccion no permite que sea anulada",
          detalleTransaccionPage.ingresarAnulacionEmpresarial(
              strNumeroTransaccion,
              diligenciador.getEstadoTransaccion(),
              Serenity.sessionVariableCalled(SESION_CC_TIPO_ANULACION.getValor())));
      MatcherAssert.assertThat(
          "El número de transaccion, no tiene habilitado el boton de anular",
          detalleTransaccionPage.realizarAnulacion(Serenity.sessionVariableCalled(SESION_CC_TIPO_ANULACION.getValor())));
      Serenity.setSessionVariable(NUMERO_TRANSACCION.getValor()).to(strNumeroTransaccion);
    }
  }

  @Step
  public void verificarAnulacionRealizada(String strAnulacionPago) {
    String strNumeroTransaccion = Serenity.sessionVariableCalled(SESION_CC_NUMERO_TRANSACCION.getValor());
    String strTipoAnulacion = Serenity.sessionVariableCalled(SESION_CC_TIPO_ANULACION.getValor());
    if (strTipoAnulacion.equals(PAGO.getValor())) {
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
          MenuConstante.DATOS_FINANCIEROS, PagoConstante.PAGOS);
      MatcherAssert.assertThat(
          "El pago no quedo en estado anulado",
          verificacionDatosFinancierosPage.verificarEstadoAnulado(
              strAnulacionPago, strNumeroTransaccion, strTipoAnulacion));
    } else {
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
          MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
      verificacionDatosFinancierosPage.seleccionarTipoTransaccion(
          TIPO_TRANSACCION.getValor());
      MatcherAssert.assertThat(
          "El recupero no quedo en estado anulado",
          verificacionDatosFinancierosPage.verificarEstadoAnulado(
              strAnulacionPago, strNumeroTransaccion, strTipoAnulacion));
    }
  }
}

