package com.sura.reclamaciones.definitions.autos.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Filtros.CREACION_AVISO_AUTOS_WS;
import static com.sura.reclamaciones.constantes.Filtros.PERSONA_CONDUCTOR;
import static com.sura.reclamaciones.constantes.Filtros.PERSONA_LESIONADA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_RECLAMACION_PERSONA_AUTO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_SINIESTRO_AUTOS;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_VEHICULO;
import static com.sura.reclamaciones.constantes.NombresCsv.RECUPERO_SINIESTRO;

import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class RecuperoSiniestroDefinition {

  @Steps
  ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;

  @Steps
  RecuperoStep recuperoStep;

  @Steps
  GenericStep genericStep;

  Recupero recupero;

  String cobertura;

  @Dado("^que se tiene una reclamación de (.*) con un tipo de cobertura de (.*)$")
  public void crearSiniestroAutos(String origenSiniestro, String tipoCobertura) throws IOException {
    cobertura = tipoCobertura;
    PersonaReclamacion parametroPersonaLesionadaAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION_PERSONA_AUTO.getValor(), PERSONA_LESIONADA.getValor()));
    PersonaReclamacion parametroPersonaConductorAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION_PERSONA_AUTO.getValor(), PERSONA_CONDUCTOR.getValor()));
    Vehiculo reclamacionVehiculo =
        new Vehiculo(genericStep.getFilasModelo(PARAMETROS_VEHICULO.getValor(), origenSiniestro));
    ReclamacionAuto parametroAviso =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_SINIESTRO_AUTOS.getValor(), CREACION_AVISO_AUTOS_WS.getValor()));
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos(
        parametroAviso.getLstReclamacionAuto(),
        parametroPersonaLesionadaAuto.getLstPersonaReclamacion(),
        parametroPersonaConductorAuto.getLstPersonaReclamacion(),
        reclamacionVehiculo.getLstVehiculos());
    creacionAvisoSiniestroAutoStep.verificarSiniestro();
  }

  @Cuando("^se cree el recupero por el tipo de (.*) con un código de retención (.*) a una cobertura (.*)$")
  public void crearRecuperoReclamacionAutos(String tipoRecupero, String codigoRetencion,
      String cobertura)
      throws IOException {
    recupero = new Recupero((genericStep.getFilasModelo(RECUPERO_SINIESTRO.getValor(), cobertura)));
    recuperoStep.diligenciarCreacionRecupero(
        recupero.getLstRecupero(), tipoRecupero, codigoRetencion);
  }

  @Entonces("^se obtiene un ingreso de dinero sobre el siniestro$")
  public void verificarRecuperoAutos() {
    recuperoStep.verificarCreacionRecupero(recupero.getLstRecupero());
  }
}
