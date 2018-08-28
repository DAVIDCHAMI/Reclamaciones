package com.sura.reclamaciones.definitions.recupero;

import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class RecuperoDefinition {
  Recupero recupero;
  @Steps RecuperoStep recuperoStep;
  @Steps GenericStep genericStep;

  @Dado("^que se tiene un siniestro con una reserva por (.*)$")
  public void navegarMenuRecupero(String tipoReserva) throws Throwable {
    recupero = new Recupero(genericStep.getFilasModelo("recupero", "escenarioRecupero"));
    recuperoStep.seleccionarNumeroReclamacion("Re", recupero.getLstRecupero());
    recuperoStep.seleccionarRecupero();
  }

  @Cuando("^se genere un recupero de tipo (.*) con un codigo de retencion (.*)$")
  public void diligenciarRecupero(String tipoRecupero, String codigoRetencion) {
    recuperoStep.diligenciarCreacionRecupero(
        recupero.getLstRecupero(), tipoRecupero, codigoRetencion);
  }

  @Entonces("^se obtiene un reintegro de dinero al siniestro$")
  public void validarRecupero() {
    recuperoStep.validarCreacionRecupero(recupero.getLstRecupero());
  }
}
