package com.sura.reclamaciones.steps.anulacionempresarial;

import static com.sura.reclamaciones.constantes.MenuConstante.RECLAMACION_MENU;
import static org.junit.Assert.assertTrue;

import com.sura.reclamaciones.constantes.AnulacionConstante;
import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.constantes.RecuperoConstante;
import com.sura.reclamaciones.models.AnulacionEmpresarial;
import com.sura.reclamaciones.pages.anulacionempresarial.DetalleTransaccionPage;
import com.sura.reclamaciones.pages.anulacionempresarial.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class AnulacionEmpresarialStep {
  @Page MenuClaimPage menuClaimPage;
  @Page DetalleTransaccionPage detalleTransaccionPage;
  @Page VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Step
  public void consultarNumeroReclamacion(
      List<AnulacionEmpresarial> lstNumeroReclamacion, String tipoTransaccion) {
    for (AnulacionEmpresarial navegador : lstNumeroReclamacion) {
      menuClaimPage.buscarReclamacion(RECLAMACION_MENU, navegador.getNumeroReclamacion());
      if (tipoTransaccion.equals(AnulacionConstante.PAGO)) {
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
            MenuConstante.DATOS_FINANCIEROS, PagoConstante.PAGOS);
      } else {
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
            MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
        menuClaimPage.seleccionarTipoTransaccion(RecuperoConstante.TIPO_TRANSACCION);
      }
    }
  }

  @Step
  public void ingresarAnulacion(List<AnulacionEmpresarial> lstNumeroTransaccion, String tipoAnulacion) {
    Serenity.setSessionVariable(Variables.TIPO_ANULACION).to(tipoAnulacion);
    for (AnulacionEmpresarial diligenciador : lstNumeroTransaccion) {
      assertTrue(
          "No se pudo encontrar el numero de transaccion",
          detalleTransaccionPage.ingresarAnulacionEmpresarial(
              diligenciador.getNumeroTransaccion(),
              diligenciador.getEstadoPrevio(),
              tipoAnulacion));
      assertTrue(
          "El número de transaccion, no tiene habilitado el boton de anular",
          detalleTransaccionPage.realizarAnulacion());
    }
  }

  @Step
  public void verificarAnulacionRealizada(
      String strAnulacionPago, List<AnulacionEmpresarial> lstNumeroTransaccion) {
    String strTipoAnulacion = Serenity.sessionVariableCalled(Variables.TIPO_ANULACION);
    for (AnulacionEmpresarial validador : lstNumeroTransaccion) {
      if (strTipoAnulacion.equals(AnulacionConstante.PAGO)) {
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
            MenuConstante.DATOS_FINANCIEROS, PagoConstante.PAGOS);
        assertTrue(
            "El pago no quedo en estado anulado",
            verificacionDatosFinancierosPage.verificarEstadoAnulado(
                strAnulacionPago, validador.getNumeroTransaccion(), strTipoAnulacion));
      } else {
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
            MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
        verificacionDatosFinancierosPage.seleccionarTipoTransaccion(
            RecuperoConstante.TIPO_TRANSACCION);
        assertTrue(
            "El recupero no quedo en estado anulado",
            verificacionDatosFinancierosPage.verificarEstadoAnulado(
                strAnulacionPago, validador.getNumeroTransaccion(), strTipoAnulacion));
      }
    }
  }
}
