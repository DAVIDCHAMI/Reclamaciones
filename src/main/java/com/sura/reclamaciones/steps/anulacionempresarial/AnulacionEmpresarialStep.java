package com.sura.reclamaciones.steps.anulacionempresarial;

import static com.sura.reclamaciones.constantes.MenuConstante.RECLAMACION_MENU;
import static com.sura.reclamaciones.steps.anulacionempresarial.AnulacionEmpresarialStep.variablesSesion.TIPO_ANULACION;
import static org.junit.Assert.assertTrue;

import com.sura.reclamaciones.constantes.AnulacionConstante;
import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.models.AnulacionEmpresarial;
import com.sura.reclamaciones.pages.anulacionempresarial.DetallePagoPage;
import com.sura.reclamaciones.pages.anulacionempresarial.VerificacionAnulacionPagoPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class AnulacionEmpresarialStep {
  @Page MenuClaimPage menuClaimPage;
  @Page DetallePagoPage detallePagoPage;
  @Page VerificacionAnulacionPagoPage verificacionAnulacionPagoPage;

  public enum variablesSesion {
    TIPO_ANULACION
  };

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
      }
    }
  }

  @Step
  public void ingresarAnulacion(List<AnulacionEmpresarial> lstNumeroPago, String tipoAnulacion) {
    Serenity.setSessionVariable(TIPO_ANULACION).to(tipoAnulacion);
    for (AnulacionEmpresarial diligenciador : lstNumeroPago) {
      if (tipoAnulacion.equals(AnulacionConstante.PAGO)) {
        assertTrue(
            "No se pudo encontrar el numero de pago",
            detallePagoPage.ingresarAnulacionEmpresarial(
                diligenciador.getNumeroTransaccion(),
                diligenciador.getEstadoPrevio(),
                tipoAnulacion));
        detallePagoPage.realizarAnulacion(diligenciador.getComentario());
      } else {
        assertTrue(
            "No se pudo encontrar el numero de recupero",
            detallePagoPage.ingresarAnulacionEmpresarial(
                diligenciador.getNumeroTransaccion(),
                diligenciador.getEstadoPrevio(),
                tipoAnulacion));
        detallePagoPage.realizarAnulacion(diligenciador.getComentario());
      }
    }
  }

  @Step
  public void verificarAnulacionRealizada(
      String strAnulacionPago, List<AnulacionEmpresarial> lstNumeroPago) {
    String tipoAnulacion = Serenity.sessionVariableCalled(TIPO_ANULACION);
    for (AnulacionEmpresarial validador : lstNumeroPago) {
      if (tipoAnulacion.equals(AnulacionConstante.PAGO)) {
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
            MenuConstante.DATOS_FINANCIEROS, PagoConstante.PAGOS);
        assertTrue(
            "El pago no quedo en estado anulado",
            verificacionAnulacionPagoPage.verificarEstadoAnulado(
                strAnulacionPago, validador.getNumeroTransaccion()));
      } else {
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
            MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
        assertTrue(
            "El recupero no quedo en estado anulado",
            verificacionAnulacionPagoPage.verificarEstadoAnulado(
                strAnulacionPago, validador.getNumeroTransaccion()));
      }
    }
  }
}
