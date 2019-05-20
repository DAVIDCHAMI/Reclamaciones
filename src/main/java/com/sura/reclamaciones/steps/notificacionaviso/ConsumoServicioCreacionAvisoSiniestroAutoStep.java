package com.sura.reclamaciones.steps.notificacionaviso;

import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.services.ConsumoServicioCreacionSiniestroAutos;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.hamcrest.MatcherAssert;

public class ConsumoServicioCreacionAvisoSiniestroAutoStep {

  ConsumoServicioCreacionSiniestroAutos consumoServicioCreacionSiniestroAutos =
      new ConsumoServicioCreacionSiniestroAutos();


  @Step
  public void siniestrarPolizaAutos(
      List<ReclamacionAuto> lstReclamacionAuto,
      List<PersonaReclamacion> lstPersonaLesionada,
      List<PersonaReclamacion> lstConductor,
      List<Vehiculo> lstVehiculoParam) {
    consumoServicioCreacionSiniestroAutos.asignarParametrosRequest(
        lstReclamacionAuto, lstPersonaLesionada, lstConductor, lstVehiculoParam);
  }

  @Step
  public void verificarSiniestro() {
    String numReclamacion = Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor());
    MatcherAssert.assertThat(
        "No se obtuvo el número del siniestro, verificar el consumo",
        numReclamacion.contains(ReclamacionConstante.VERIFICADOR_NUMERO_SINIESTRO));
  }
}
