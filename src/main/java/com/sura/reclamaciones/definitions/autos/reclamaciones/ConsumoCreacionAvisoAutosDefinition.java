package com.sura.reclamaciones.definitions.autos.reclamaciones;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import static com.sura.reclamaciones.utils.enums.Filtros.CREACION_AVISO_AUTOS_WS;
import static com.sura.reclamaciones.utils.enums.Filtros.PERSONA_CONDUCTOR;
import static com.sura.reclamaciones.utils.enums.Filtros.PERSONA_LESIONADA;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_RECLAMACION_PERSONA_AUTO;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_SINIESTRO_AUTOS;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_VEHICULO;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_TIPO_COBERTURA_AFECTADA;

import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.maca.autos.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ConsumoCreacionAvisoAutosDefinition {

  ReclamacionAuto parametroAviso;
  PersonaReclamacion parametroPersonaReclamacionAuto;
  PersonaReclamacion parametroPersonaConductorAuto;
  Vehiculo reclamacionVehiculo;

  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;

  @Dado(
      "^que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de (.*) de autos$")
  public void parametrizarValoresSiniestro(String origenSinestro) throws IOException {
    parametroPersonaReclamacionAuto =
        new PersonaReclamacion(
            obtenerDatosPrueba(
                PARAMETROS_RECLAMACION_PERSONA_AUTO.getValor(), PERSONA_LESIONADA.getValor()));
    parametroPersonaConductorAuto =
        new PersonaReclamacion(
            obtenerDatosPrueba(
                PARAMETROS_RECLAMACION_PERSONA_AUTO.getValor(), PERSONA_CONDUCTOR.getValor()));
    reclamacionVehiculo =
        new Vehiculo(obtenerDatosPrueba(PARAMETROS_VEHICULO.getValor(), origenSinestro));
    parametroAviso =
        new ReclamacionAuto(
            obtenerDatosPrueba(
                PARAMETROS_SINIESTRO_AUTOS.getValor(), CREACION_AVISO_AUTOS_WS.getValor()));
  }

  @Cuando("^se genera un aviso que afecta la cobertura de (.*)$")
  public void siniestrarPolizaServicio(String tipoCobertura) {
    Serenity.setSessionVariable(SESION_CC_TIPO_COBERTURA_AFECTADA.getValor()).to(tipoCobertura);
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos(
        parametroAviso.getLstReclamacionAuto(),
        parametroPersonaReclamacionAuto.getLstPersonaReclamacion(),
        parametroPersonaConductorAuto.getLstPersonaReclamacion(),
        reclamacionVehiculo.getLstVehiculos());
  }

  @Entonces("^se le brindará al reclamante el número de reclamación$")
  public void verificarCreacionAviso() {
    creacionAvisoSiniestroAutoStep.verificarSiniestro();
  }
}
