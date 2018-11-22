package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionSiniestroStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ConsumoCreacionSiniestroEmpresarialDefinition {

  @Steps ConsumoServicioCreacionSiniestroStep consumoServicioCreacionSiniestroStep;

  @Dado("^que se recibe un aviso (.*) de una reclamacion$")
  public void parametrizarValoresSiniestro(String filtroCsv) throws IOException {
    consumoServicioCreacionSiniestroStep.asignarValoresSiniestro(filtroCsv);
  }

  @Cuando("^se toman los datos del mismo$")
  public void siniestrarPolizaServicio() {
    consumoServicioCreacionSiniestroStep.siniestrarPolizaEmpresarialAtr();
  }

  @Entonces("^se le brindara al reportante un numero de reclamacion$")
  public void verificarCreacionSiniestro() {
    consumoServicioCreacionSiniestroStep.verificarSiniestro();
  }
}
