package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.models.PersonaReclamacionAuto;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionAutoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ReclamacionDefinition {

  @Steps private GenericStep genericStep;
  @Steps private NuevaReclamacionAutoStep reclamacionStep;

  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;
  private ExposicionVehiculoTercero exposicionVehiculoTercero;
  private PersonaReclamacionAuto personaReclamacionAuto;
  private ExposicionLesiones exposicionLesiones;
  private Reserva reserva;
  private ReclamacionAuto direccionReclamacion;
  private ExposicionesAutomaticasAutos exposicionesAutomaticasAutos;

  @Dado("^que se tiene una poliza con las coberturas$")
  public void recibirReclamoResponsabilidadCivil() throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionRC"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "autoReclamacionSimple"));
    reclamacionStep.seleccionarMenu();
    reclamacionStep.completarFormularioBuscarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }

  @Cuando("se genere un siniestro por la causa y la culpabilidad$")
  public void ingresarDatosSiniestro() {
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
  }

  @Entonces(
      "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil$")
  public void generarReclamacionResponsabilidadCivil() throws IOException {
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo("responsabilidad_civil_vehiculo", "exposicionRcVehiculo"));
    personaReclamacionAuto =
        new PersonaReclamacionAuto(
            genericStep.getFilasModelo("persona_reclamacion_auto", "conductor"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo("direccion_reclamacion", "direccionExposicionVehicular"));
    reclamacionStep.crearExposionVehicular(
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        personaReclamacionAuto.getLstPersonaReclamacionAuto(),
        direccionReclamacion.getLstReclamacionAuto());
    personaReclamacionAuto =
        new PersonaReclamacionAuto(
            genericStep.getFilasModelo("persona_reclamacion_auto", "peaton"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo("direccion_reclamacion", "direccionExposicionLesiones"));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo("responsabilidad_civil_lesiones", "exposicionRcPersona"));
    reclamacionStep.crearExposicionLesiones(
        personaReclamacionAuto.getLstPersonaReclamacionAuto(),
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
    reclamacionStep.finalizarReclamacion();
    reclamacionStep.validarReclamacion();
    reclamacionStep.consultarReclamacion();
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo("exposicion_automatica", "exposicionesRC"));
    reclamacionStep.validarExposicion(exposicionesAutomaticasAutos.getLstExposiciones());
    reserva = new Reserva(genericStep.getFilasModelo("linea_reserva", "rc_Vehiculo_y_peaton"));
    reclamacionStep.consultarReservaResponsabilidadCivil(reserva.getLstReserva());
  }

  @Dado("^que se tiene una poliza con las coberturas para Daños$")
  public void recibirReclamoArchivo() throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionArchivo"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "reclamacionArchivo"));
    reclamacionStep.seleccionarMenu();
    reclamacionStep.completarFormularioBuscarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }

  @Entonces(
      "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo$")
  public void generarReclamacionArchivo() throws IOException {
    reclamacionStep.finalizarReclamacion();
    reclamacionStep.validarReclamacion();
    reclamacionStep.consultarReclamacion();
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo("exposicion_automatica", "exposicionesArchivo"));
    reclamacionStep.validarExposicion(exposicionesAutomaticasAutos.getLstExposiciones());
    reserva = new Reserva(genericStep.getFilasModelo("linea_reserva", "archivo_Subrogacion"));
    reclamacionStep.consultarValorReservaArchivo(reserva.getLstReserva());
  }

  @Dado("^que se tiene una poliza con las coberturas para Subrogación$")
  public void recibirReclamoSubrogacion() throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo("reclamacion_auto", "reclamacionSubrogacion"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "reclamacionSubrogacion"));
    reclamacionStep.seleccionarMenu();
    reclamacionStep.completarFormularioBuscarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }

  @Dado("^que se tiene una poliza con las coberturas para Solo Responsabilidad Civil$")
  public void recibirReclamoSoloResponsabilidadCivil() throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionSoloRC"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "reclamacionSoloRC"));
    reclamacionStep.seleccionarMenu();
    reclamacionStep.completarFormularioBuscarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }

  @Entonces(
      "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Solo Responsabilidad Civil$")
  public void generarReclamacionSoloResponsabilidadCivil() throws IOException {
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo("responsabilidad_civil_vehiculo", "exposicionRcVehiculo"));
    personaReclamacionAuto =
        new PersonaReclamacionAuto(
            genericStep.getFilasModelo("persona_reclamacion_auto", "conductor"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo("direccion_reclamacion", "direccionExposicionVehicular"));
    reclamacionStep.crearExposionVehicular(
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        personaReclamacionAuto.getLstPersonaReclamacionAuto(),
        direccionReclamacion.getLstReclamacionAuto());
    personaReclamacionAuto =
        new PersonaReclamacionAuto(
            genericStep.getFilasModelo("persona_reclamacion_auto", "peaton"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo("direccion_reclamacion", "direccionExposicionLesiones"));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo("responsabilidad_civil_lesiones", "exposicionRcPersona"));
    reclamacionStep.crearExposicionLesiones(
        personaReclamacionAuto.getLstPersonaReclamacionAuto(),
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
    reclamacionStep.finalizarReclamacion();
    reclamacionStep.validarReclamacion();
    reclamacionStep.consultarReclamacion();
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo("exposicion_automatica", "exposicionesSoloRC"));
    reclamacionStep.validarExposicion(exposicionesAutomaticasAutos.getLstExposiciones());
    reserva = new Reserva(genericStep.getFilasModelo("linea_reserva", "soloRC"));
    reclamacionStep.consultarReservaResponsabilidadCivil(reserva.getLstReserva());
  }
}
