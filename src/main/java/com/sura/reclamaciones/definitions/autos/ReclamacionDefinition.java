package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevoAvisoSiniestroAutoStep;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class ReclamacionDefinition {

  @Steps private GenericStep genericStep;

  @Steps private NuevoAvisoSiniestroAutoStep reclamacionStep;

  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;
  private ExposicionVehiculoTercero exposicionVehiculoTercero;
  private Persona personaReclamacionAuto;
  private ExposicionLesiones exposicionLesiones;
  private Reserva reserva;
  private ReclamacionAuto direccionReclamacion;
  private ExposicionesAutomaticasAutos exposicionesAutomaticasAutos;

  @Dado("^que se tiene una poliza con las coberturas$")
  public void recibirReclamoResponsabilidadCivil(DataTable coberturas) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionRC"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "autoReclamacionSimple"));
    consultarPoliza();
  }

  @Cuando("se genere un siniestro por la causa y la culpabilidad$")
  public void ingresarDatosSiniestro(DataTable culpabilidad) {
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
  }

  @Entonces(
      "^se obtendran exposiciones automaticas y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil$")
  public void generarReclamacionResponsabilidadCivil(DataTable reservas) throws IOException {
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo("responsabilidad_civil_vehiculo", "exposicionRcVehiculo"));
    personaReclamacionAuto =
        new Persona(genericStep.getFilasModelo("parametros_persona_reclamacion_auto", "conductor"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo("direccion_reclamacion", "direccionExposicionVehicular"));
    crearNuevaExposicionVehicular();
    personaReclamacionAuto =
        new Persona(genericStep.getFilasModelo("parametros_persona_reclamacion_auto", "peaton"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo("direccion_reclamacion", "direccionExposicionLesiones"));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo("responsabilidad_civil_lesiones", "exposicionRcPersona"));
    crearNuevaExposicionLesiones();
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo("exposicion_automatica", "exposicionesRC"));
    validarExposicionesAutomaticas();
    reserva = new Reserva(genericStep.getFilasModelo("linea_reserva", "rcVehiculoPeaton"));
    reclamacionStep.validarValorReservasResponsabilidadCivil(reserva.getLstReserva());
  }

  @Dado("^que se tiene una poliza con las coberturas para Daños$")
  public void recibirReclamoArchivo(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionArchivo"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "autoReclamacionSimple"));
    consultarPoliza();
  }

  @Entonces(
      "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo$")
  public void generarReclamacionArchivo(DataTable reservas) throws IOException {
    reclamacionStep.finalizarReclamacionAutos();
    reclamacionStep.validarReclamacionAutos();
    reclamacionStep.consultarReclamacionAutos();
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo("exposicion_automatica", "exposicionesArchivo"));
    validarExposicionesAutomaticas();
    reserva = new Reserva(genericStep.getFilasModelo("linea_reserva", "archivoSubrogacion"));
    reclamacionStep.validarValorReservasArchivo(reserva.getLstReserva());
  }

  @Dado("^que se tiene una poliza con las coberturas para Subrogación$")
  public void recibirReclamoSubrogacion(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo("reclamacion_auto", "reclamacionSubrogacion"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "reclamacionSubrogacion"));
    consultarPoliza();
  }

  @Dado("^que se tiene una poliza con las coberturas para Solo Responsabilidad Civil$")
  public void recibirReclamoSoloResponsabilidadCivil(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(genericStep.getFilasModelo("reclamacion_auto", "reclamacionSoloRC"));
    vehiculo = new Vehiculo(genericStep.getFilasModelo("vehiculo", "reclamacionSoloRC"));
    consultarPoliza();
  }

  @Entonces(
      "^se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Solo Responsabilidad Civil$")
  public void generarReclamacionSoloResponsabilidadCivil(DataTable reservas) throws IOException {
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo("responsabilidad_civil_vehiculo", "exposicionRcVehiculo"));
    personaReclamacionAuto =
        new Persona(genericStep.getFilasModelo("parametros_persona_reclamacion_auto", "conductor"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo("direccion_reclamacion", "direccionExposicionVehicular"));
    crearNuevaExposicionVehicular();
    personaReclamacionAuto =
        new Persona(genericStep.getFilasModelo("parametros_persona_reclamacion_auto", "peaton"));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo("direccion_reclamacion", "direccionExposicionLesiones"));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo("responsabilidad_civil_lesiones", "exposicionRcPersona"));
    crearNuevaExposicionLesiones();
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo("exposicion_automatica", "exposicionesSoloRC"));
    validarExposicionesAutomaticas();
    reserva = new Reserva(genericStep.getFilasModelo("linea_reserva", "soloRC"));
    reclamacionStep.validarValorReservasResponsabilidadCivil(reserva.getLstReserva());
  }

  private void consultarPoliza() {
    reclamacionStep.seleccionarOpcionMenuPrincipal();
    reclamacionStep.completarFormularioBuscarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
    reclamacionStep.buscarPoliza();
  }

  private void crearNuevaExposicionVehicular() {
    reclamacionStep.crearExposicionVehicular(
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        personaReclamacionAuto.getLstPersona(),
        direccionReclamacion.getLstReclamacionAuto());
  }

  private void crearNuevaExposicionLesiones() {
    reclamacionStep.crearExposicionLesiones(
        personaReclamacionAuto.getLstPersona(),
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
    reclamacionStep.finalizarReclamacionAutos();
    reclamacionStep.validarReclamacionAutos();
    reclamacionStep.consultarReclamacionAutos();
  }

  private void validarExposicionesAutomaticas() {
    reclamacionStep.validarExposicion(exposicionesAutomaticasAutos.getLstExposiciones());
  }
}
