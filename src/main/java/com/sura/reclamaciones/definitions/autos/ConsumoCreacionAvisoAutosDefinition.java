package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ConsumoCreacionAvisoAutosDefinition {

  @Steps GenericStep genericsStep;

  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;

  @Dado("^que se tiene una póliza (.*) de autos$")
  public void parametrizarValoresSiniestro(String filtroCsv) throws IOException {
    creacionAvisoSiniestroAutoStep.asignarValoresSiniestro(filtroCsv);
  }

  @Cuando("^se genera un aviso$")
  public void siniestrarPolizaServicio() {
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos();
  }

  @Entonces("^se le brindará al reclamante el número de reclamación$")
  public void verificarCreacionAviso() {
    creacionAvisoSiniestroAutoStep.verificarSiniestro();
  }
}
