package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.constantes.NombresCsv;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import java.util.List;
import net.thucydides.core.annotations.Steps;

public class ConsumoCreacionAvisoAutosDefinition {

  List<ReclamacionAuto> lstReclamacionAuto;
  List<PersonaReclamacion> lstPersonaLesionada;
  List<PersonaReclamacion> lstConductor;
  List<Vehiculo> lstVehiculoParam;
  ReclamacionAuto parametroAviso = new ReclamacionAuto();
  PersonaReclamacion parametroPersonaReclamacionAuto = new PersonaReclamacion();
  PersonaReclamacion parametroPersonaConductorAuto = new PersonaReclamacion();
  Vehiculo reclamacionVehiculo = new Vehiculo();

  GenericStep genericStep = new GenericStep();

  @Steps GenericStep genericsStep;

  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;

  @Dado("^que se tiene una póliza (.*) de autos$")
  public void parametrizarValoresSiniestro(String filtroCsv) throws IOException {
    parametroPersonaReclamacionAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_RECLAMACION_PERSONA,
                NombresCsv.PARAMETRO_PERSONA_LESIONADA));
    lstPersonaLesionada = parametroPersonaReclamacionAuto.getLstPersonaReclamacion();
    parametroPersonaConductorAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_RECLAMACION_PERSONA,
                NombresCsv.PARAMETRO_PERSONA_CONDUCTOR));
    lstConductor = parametroPersonaConductorAuto.getLstPersonaReclamacion();
    reclamacionVehiculo =
        new Vehiculo(genericStep.getFilasModelo(NombresCsv.PARAMETROS_VEHICULO, filtroCsv));
    lstVehiculoParam = reclamacionVehiculo.getVehiculos();
    parametroAviso =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_SINIESTRO_AUTOS,
                NombresCsv.PARAMETRO_CREACION_AVISO_AUTOS_WS));
    lstReclamacionAuto = parametroAviso.getLstReclamacionAuto();
  }

  @Cuando("^se genera un aviso$")
  public void siniestrarPolizaServicio() {
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos(
        lstReclamacionAuto, lstPersonaLesionada, lstConductor, lstVehiculoParam);
  }

  @Entonces("^se le brindará al reclamante el número de reclamación$")
  public void verificarCreacionAviso() {
    creacionAvisoSiniestroAutoStep.verificarSiniestro();
  }
}
