package com.sura.reclamaciones.definitions.recupero;

import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class RecuperoDefinition {
  Recupero recupero;

  @Steps RecuperoStep recuperoStep;
  @Steps GenericStep genericStep;

  @Dado("^que (.*) se cuenta con una reserva de (.*)$")
  public void navegarMenuRecupero(String condicionReserva, String tipoReserva) throws IOException {
    recupero = new Recupero(genericStep.getFilasModelo("recupero", "escenarioRecupero"));
    recuperoStep.seleccionarNumeroReclamacion("Re", recupero.getLstRecupero());
    recuperoStep.seleccionarRecupero();
  }

  @Cuando("^se genere un recupero de categoria (.*), con un codigo de retencion (.*)$")
  public void diligenciarRecupero(String categoriaRecupero, String codigoRetencion) {
    recuperoStep.diligenciarCreacionRecupero(
        recupero.getLstRecupero(), categoriaRecupero, codigoRetencion);
  }

  @Entonces("^se obtiene un recupero en estado (.*)$")
  public void verificarEstadoSolicitud(String estadoRecupero) {
    recuperoStep.validarCreacionRecupero(estadoRecupero);
  }
}
