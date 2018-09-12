package com.sura.reclamaciones.steps.reserva;

import static com.sura.reclamaciones.constantes.ReservaConstante.*;

import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.pages.reservas.AjusteReservaPage;
import com.sura.reclamaciones.pages.reservas.ConsultaReclamacionPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;

public class ReversionConstitucionStep {

  @Page AjusteReservaPage ajusteReservaPage;
  @Page ConsultaReclamacionPage consultaReclamacionPage;

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

  public void verificarAjusteReserva(String deducible) {}
}
