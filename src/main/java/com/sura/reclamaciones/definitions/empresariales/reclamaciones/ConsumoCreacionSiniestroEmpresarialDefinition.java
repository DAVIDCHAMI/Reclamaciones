package com.sura.reclamaciones.definitions.empresariales.reclamaciones;

import com.sura.reclamaciones.steps.guidewire.claimscenter.empresariales.ConsumoServicioCreacionSiniestroStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ConsumoCreacionSiniestroEmpresarialDefinition {

  @Steps ConsumoServicioCreacionSiniestroStep consumoServicioCreacionSiniestroStep;

  @Dado("^que se tiene una póliza (.*) de empresariales$")
  public void parametrizarValoresSiniestro(String filtroCsv) throws IOException {
    consumoServicioCreacionSiniestroStep.asignarValoresSiniestro(filtroCsv);
  }

  @Cuando("^se genera un siniestro$")
  public void siniestrarPolizaServicio() {
    consumoServicioCreacionSiniestroStep.siniestrarPolizaEmpresarialAtr();
  }

  @Entonces("^se le brindara al reportante un numero de reclamacion$")
  public void verificarCreacionSiniestro() {
    consumoServicioCreacionSiniestroStep.verificarSiniestro();
  }
}
