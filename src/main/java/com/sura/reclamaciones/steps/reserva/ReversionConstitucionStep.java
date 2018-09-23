package com.sura.reclamaciones.steps.reserva;

import static com.sura.reclamaciones.constantes.ReservaConstante.*;

import com.sura.reclamaciones.pages.reservas.AjusteReservaPage;
import com.sura.reclamaciones.pages.reservas.TransaccionDatoFinancieroPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ReversionConstitucionStep {

  @Page AjusteReservaPage ajusteReservaPage;
  @Page TransaccionDatoFinancieroPage transaccionDatoFinancieroPage;

  public void ajustarReserva(String valorAjustar) {
    ajusteReservaPage.ajustarReserva();
    ajusteReservaPage.diligenciarCantidadAjusteReserva(valorAjustar, NUEVAS_RESERVAS_DISPONIBLES);
    ajusteReservaPage.cerrarAdvertenciaLimiteAgregado();
  }

  public void verificarAjusteReserva(String deducible) {
    String deducibleVisualizado;
    deducibleVisualizado = transaccionDatoFinancieroPage.obtenerDeducibleReversionConstitucion();
    MatcherAssert.assertThat(
        "Se esperaba un deducible de: "
            + deducible
            + " Pero se obtuvo un deducible de: "
            + deducibleVisualizado,
        deducibleVisualizado.equals(deducible));
  }
}
