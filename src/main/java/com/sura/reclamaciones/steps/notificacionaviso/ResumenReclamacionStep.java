package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ResumenReclamacionStep {
  @Page ResumenReclamacionPage resumenReclamacionPage;

  public void visualizarResumenReclamacion() {
    resumenReclamacionPage.resumenReclamacion();
  }

  public void validarExposicionVisualizada(String exposicion) {
    String validar = resumenReclamacionPage.validarExposicion();
    MatcherAssert.assertThat(
        "No generó exposición, verificar las reglas de administración de exposiciones o data ingresada",
        validar.equals(exposicion));
  }

  public void validarReservaVisualizada(String monto) {
    String validar = resumenReclamacionPage.validarReserva();
    MatcherAssert.assertThat(
        "No generó reserva, verificar las reglas de administración de reserva o data ingresada",
        validar.equals(monto));
  }
}
