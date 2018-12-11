package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.PersonaReclamacionAuto;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.services.ConsumoServicioCreacionSiniestroAutos;
import com.sura.reclamaciones.steps.generics.GenericStep;
import java.io.IOException;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.hamcrest.MatcherAssert;

public class ConsumoServicioCreacionAvisoAutoStep {

  List<ReclamacionAuto> lstReclamacionAuto;
  List<PersonaReclamacionAuto> lstPersonaReclamacionAuto;
  List<Vehiculo> lstVehiculoParam;
  ReclamacionAuto parametroAviso = new ReclamacionAuto();
  PersonaReclamacionAuto parametroPersonaReclamacionAuto = new PersonaReclamacionAuto();
  Vehiculo reclamacionVehiculo = new Vehiculo();

  GenericStep genericStep = new GenericStep();

  ConsumoServicioCreacionSiniestroAutos consumoServicioCreacionSiniestroAutos =
      new ConsumoServicioCreacionSiniestroAutos();

  @Step
  public void siniestrarPolizaAutos() {
    consumoServicioCreacionSiniestroAutos.asignarParametrosRequest(
        lstReclamacionAuto, lstPersonaReclamacionAuto, lstVehiculoParam);
  }

  @Step
  public void asignarValoresSiniestro(String filtroSiniestroCsv) throws IOException {
    parametroPersonaReclamacionAuto =
        new PersonaReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION_PERSONA, filtroSiniestroCsv));
    lstPersonaReclamacionAuto = parametroPersonaReclamacionAuto.getLstPersonaReclamacionAuto();
    reclamacionVehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION_VEHICULO, filtroSiniestroCsv));
    lstVehiculoParam = reclamacionVehiculo.getVehiculos();
    parametroAviso =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionSimple"));
    lstReclamacionAuto = parametroAviso.getLstReclamacionAuto();
  }

  public void verificarSiniestro() {
    String numReclamacion = Serenity.sessionVariableCalled(ReclamacionConstante.NUMERO_SINIESTRO);
    MatcherAssert.assertThat(
        "No se obtuvo el número del siniestro, verificar el consumo",
        numReclamacion.contains(ReclamacionConstante.VERIFICADOR_NUMERO_SINIESTRO));
  }
}
