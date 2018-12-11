package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoAutoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ConsumoCreacionAvisoAutosDefinition {

  @Steps ConsumoServicioCreacionAvisoAutoStep consumoServicioCreacionAvisoAutoStep;

  @Dado("^que se tiene una póliza (.*) de autos$")
  public void parametrizarValoresSiniestro(String filtroCsv) throws IOException {
    consumoServicioCreacionAvisoAutoStep.asignarValoresSiniestro(filtroCsv);
  }

  @Cuando("^se genera un aviso$")
  public void siniestrarPolizaServicio() {
    consumoServicioCreacionAvisoAutoStep.siniestrarPolizaAutos();
  }

  @Entonces("^se le brindara al reclamante el numero de reclamacion$")
  public void verificarCreacionAviso() {
    consumoServicioCreacionAvisoAutoStep.verificarSiniestro();
  }
}
