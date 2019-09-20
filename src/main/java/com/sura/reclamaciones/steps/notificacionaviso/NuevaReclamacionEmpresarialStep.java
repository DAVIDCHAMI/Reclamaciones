package com.sura.reclamaciones.steps.notificacionaviso;

import static com.sura.reclamaciones.constantes.Constantes.VALIDADOR_NUEVA_RECLAMACION;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class NuevaReclamacionEmpresarialStep {

  @Page MenuClaimPage menuClaimPage;

  @Page InformacionReclamacionPage informacionReclamacionPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  public void validarReclamacion() {
    String verificar;
    verificar = informacionReclamacionPage.obtenerTituloReclamacionGenerada();
    MatcherAssert.assertThat(
        "No se ha obtenido el número de reclamación",
        verificar.equals(VALIDADOR_NUEVA_RECLAMACION.getValor()));
  }

  public void seleccionarNuevaReclamacion(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(nombreOpcion, subItem);
  }

  public void visualizarResumenReclamacion() {
    resumenReclamacionPage.obtenerNumeroReclamacion();
  }

  public void validarExposicionVisualizada(String exposicion) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(ReclamacionConstante.EXPOSICIONES);
    MatcherAssert.assertThat(
        "No generó exposición, verificar las reglas de administración de exposiciones o data ingresada",
        resumenReclamacionPage.validarExposicion().equals(exposicion));
  }

  public void validarReservaDatosFinancieros(List<ReclamacionEmpresarial> datoReserva) {
    datoReserva.forEach(
        reserva -> {
          String validar =
              resumenReclamacionPage.validarReservaTransaccion(reserva.getReservaTransaccion());
          MatcherAssert.assertThat(
              "Se esperaba una reserva de: "
                  + reserva.getReservaTransaccion()
                  + ", pero se ha obtenido una reserva de: "
                  + validar,
              reserva.getReservaTransaccion().equals(validar));
        });
  }
}
