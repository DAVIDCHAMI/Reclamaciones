package com.sura.reclamaciones.definitions.autos;

import static com.sura.reclamaciones.constantes.Constantes.FECHA_ACTUAL;
import static com.sura.reclamaciones.constantes.Constantes.NUMERO_DIAS_VENCIMIENTO;
import static com.sura.reclamaciones.constantes.Filtros.CREACION_AVISO_AUTOS_WS;
import static com.sura.reclamaciones.constantes.Filtros.PERSONA_CONDUCTOR;
import static com.sura.reclamaciones.constantes.Filtros.PERSONA_LESIONADA;
import static com.sura.reclamaciones.constantes.NombresCsv.EXPEDICION_AUTOS;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_RECLAMACION_PERSONA_AUTO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_SINIESTRO_AUTOS;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_VEHICULO;

import com.sura.reclamaciones.models.ExpedicionAuto;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import com.sura.reclamaciones.steps.poliza.ConsumoServicioExpedicionAutoStep;
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

  @Steps ConsumoServicioExpedicionAutoStep consumoServicioExpedicionAutoStep;

  @Dado("^que se tiene una póliza (.*) de autos$")
  public void parametrizarValoresSiniestro(String filtroCsv) throws IOException {
    parametroPersonaReclamacionAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION_PERSONA_AUTO.getValor(), PERSONA_LESIONADA.getValor()));
    lstPersonaLesionada = parametroPersonaReclamacionAuto.getLstPersonaReclamacion();
    parametroPersonaConductorAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION_PERSONA_AUTO.getValor(), PERSONA_CONDUCTOR.getValor()));
    lstConductor = parametroPersonaConductorAuto.getLstPersonaReclamacion();
    reclamacionVehiculo =
        new Vehiculo(genericStep.getFilasModelo(PARAMETROS_VEHICULO.getValor(), filtroCsv));
    lstVehiculoParam = reclamacionVehiculo.getLstVehiculos();
    parametroAviso =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_SINIESTRO_AUTOS.getValor(), CREACION_AVISO_AUTOS_WS.getValor()));
    lstReclamacionAuto = parametroAviso.getLstReclamacionAuto();
  }

  @Cuando("^se genera un aviso$")
  public void siniestrarPolizaServicio() throws IOException {
    String tipoPoliza = "póliza de auto";
    ExpedicionAuto expedicionAuto =
        new ExpedicionAuto(genericsStep.getFilasModelo(EXPEDICION_AUTOS.getValor(), tipoPoliza));
    consumoServicioExpedicionAutoStep.consumirServicioExpedicion(
        expedicionAuto.getLstExpedicion(),
        Integer.parseInt(NUMERO_DIAS_VENCIMIENTO.getValor()),
        FECHA_ACTUAL.getValor());
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos(
        lstReclamacionAuto, lstPersonaLesionada, lstConductor, lstVehiculoParam);
  }

  @Entonces("^se le brindará al reclamante el número de reclamación$")
  public void verificarCreacionAviso() {
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos(
        lstReclamacionAuto, lstPersonaLesionada, lstConductor, lstVehiculoParam);
    creacionAvisoSiniestroAutoStep.verificarSiniestro();
  }
}
