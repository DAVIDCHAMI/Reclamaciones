package com.sura.reclamaciones.steps.maca.autos;

import static com.sura.reclamaciones.utils.constantes.MenuConstante.RECLAMACION_MENU;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;

import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.services.ConsumoServicioCreacionSiniestroAutos;
import com.sura.reclamaciones.utils.constantes.ReclamacionConstante;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ConsumoServicioCreacionAvisoSiniestroAutoStep {

  @Page MenuClaimPage menuClaimPage;

  @Step
  public void siniestrarPolizaAutos(
      List<ReclamacionAuto> lstReclamacionAuto,
      List<PersonaReclamacion> lstPersonaLesionada,
      List<PersonaReclamacion> lstConductor,
      List<Vehiculo> lstVehiculoParam) {
    ConsumoServicioCreacionSiniestroAutos consumoServicioCreacionSiniestroAutos =
        new ConsumoServicioCreacionSiniestroAutos();
    consumoServicioCreacionSiniestroAutos.asignarParametrosRequest(
        lstReclamacionAuto, lstPersonaLesionada, lstConductor, lstVehiculoParam);
    menuClaimPage.buscarReclamacion(
        RECLAMACION_MENU, Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor()));
  }

  @Step
  public void verificarSiniestro() {
    String numReclamacion = Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor());
    MatcherAssert.assertThat(
        "No se obtuvo el número del siniestro, verificar el consumo",
        numReclamacion.contains(ReclamacionConstante.VERIFICADOR_NUMERO_SINIESTRO));
  }
}
