package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.PersonaReclamacionAuto;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.services.ConsumoServicioCreacionSiniestroAutos;
import com.sura.reclamaciones.steps.generics.GenericStep;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.hamcrest.MatcherAssert;

public class ConsumoServicioCreacionAvisoSiniestroAutoStep {

  GenericStep genericStep = new GenericStep();

  ConsumoServicioCreacionSiniestroAutos consumoServicioCreacionSiniestroAutos =
      new ConsumoServicioCreacionSiniestroAutos();

  @Step
  public void siniestrarPolizaAutos(
      List<ReclamacionAuto> lstReclamacionAuto,
      List<PersonaReclamacionAuto> lstPersonaLesionada,
      List<PersonaReclamacionAuto> lstConductor,
      List<Vehiculo> lstVehiculoParam) {
    consumoServicioCreacionSiniestroAutos.asignarParametrosRequest(
        lstReclamacionAuto, lstPersonaLesionada, lstConductor, lstVehiculoParam);
  }

  @Step
  public void verificarSiniestro() {
    String numReclamacion = Serenity.sessionVariableCalled(ReclamacionConstante.NUMERO_SINIESTRO);
    MatcherAssert.assertThat(
        "No se obtuvo el número del siniestro, verificar el consumo",
        numReclamacion.contains(ReclamacionConstante.VERIFICADOR_NUMERO_SINIESTRO));
  }
}
