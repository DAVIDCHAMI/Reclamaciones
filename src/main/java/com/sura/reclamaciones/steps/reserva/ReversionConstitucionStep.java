package com.sura.reclamaciones.steps.reserva;

import static com.sura.reclamaciones.constantes.ReservaConstante.*;

import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.reservas.AjusteReservaPage;
import com.sura.reclamaciones.pages.reservas.ConsultaReclamacionPage;
import com.sura.reclamaciones.pages.reservas.TransaccionDatoFinancieroPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ReversionConstitucionStep {

  @Page AjusteReservaPage ajusteReservaPage;
  @Page ConsultaReclamacionPage consultaReclamacionPage;
  @Page TransaccionDatoFinancieroPage transaccionDatoFinancieroPage;

  public void consultarReclamacion(List<Reserva> lstReservaEmp) {
    lstReservaEmp.forEach(
        dato -> {
          consultaReclamacionPage.buscarReclamacion(dato.getNumeroReclamacion());
        });
  }

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
