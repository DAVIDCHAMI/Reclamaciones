package com.sura.reclamaciones.steps.anulacionPago;

import static com.sura.reclamaciones.constantes.MenuConstante.RECLAMACION_MENU;
import static org.junit.Assert.assertTrue;

import com.sura.reclamaciones.constantes.AnulacionConstante;
import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.models.AnulacionEmpresarial;
import com.sura.reclamaciones.pages.anulacionempresarial.DetallePagoPage;
import com.sura.reclamaciones.pages.anulacionempresarial.VerificacionAnulacionPagoPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class AnulacionEmpresarialStep {
  @Page MenuClaimPage menuClaimPage;
  @Page DetallePagoPage detallePagoPage;
  @Page VerificacionAnulacionPagoPage verificacionAnulacionPagoPage;

  @Step
  public void consultarNumeroReclamacion(List<AnulacionEmpresarial> lstNumeroReclamacion, String tipoTransaccion) {
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
  public void ingresarPagoAnular(List<AnulacionEmpresarial> lstNumeroPago) {
    for (AnulacionEmpresarial diligenciador : lstNumeroPago) {
      assertTrue(
          "No se pudo encontrar el numero de pago",
          detallePagoPage.ingresarAnulacionPago(
              diligenciador.getNumeroPago(), diligenciador.getEstadoPrevio()));
      detallePagoPage.realizarAnulacionPago(diligenciador.getComentario());
    }
  }

  @Step
  public void verificarAnulacionRealizada(
      String strAnulacionPago, List<AnulacionEmpresarial> lstNumeroPago) {
    for (AnulacionEmpresarial validador : lstNumeroPago) {
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
          MenuConstante.DATOS_FINANCIEROS, PagoConstante.PAGOS);
      assertTrue(
          "El pago no quedo en estado anulado",
          verificacionAnulacionPagoPage.verificarEstadoAnulado(
              strAnulacionPago, validador.getNumeroPago()));
    }
  }
}
