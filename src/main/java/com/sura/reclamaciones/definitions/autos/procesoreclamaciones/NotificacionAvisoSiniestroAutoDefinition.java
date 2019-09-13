package com.sura.reclamaciones.definitions.autos.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_DIRECCION_SINIESTRO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_EXPOSICION_AUTOMATICA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_PERSONA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_RECLAMACION;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_VEHICULO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_LINEA_RESERVA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO;
import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;

import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.NuevaReclamacionGuardadaStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevoAvisoSiniestroAutoStep;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoSiniestroAutoDefinition {

  @Steps private NuevoAvisoSiniestroAutoStep reclamacionStep;

  @Steps private NuevaReclamacionGuardadaStep nuevaReclamacionGuardadaStep;

  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;
  private ExposicionVehiculoTercero exposicionVehiculoTercero;
  private ExposicionLesiones exposicionLesiones;
  private Reserva reserva;
  private ExposicionesAutomaticasAutos exposicionesAutomaticasAutos;
  private static String DIRECCION_EXPOSICION_VEHICULAR = "direccionExposicionVehicular";
  private static String DIRECCION_EXPOSICION_LESIONES = "direccionExposicionLesiones";
  private static String EXPOSICIONES_RESPONSABILIDAD_CIVIL = "exposicionesRC";
  private static String EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL = "exposicionesSoloRC";
  private static String RECLAMACION_RESPONSABILIDAD_CIVIL = "responsabilidadCivil";
  private static String RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL = "soloRC";
  private static String RECLAMACION_ARCHIVO = "archivo";
  private static String RECLAMACION_SUBROGACION = "subrogacion";
  private static String EXPOSICIONES_ARCHIVO = "exposicionesArchivo";
  private static String LINEA_RESERVA_ARCHIVO = "archivoSubrogacion";
  private static String RESPONSABILIDAD_CIVIL_VEHICULO;
  private static String RESPONSABILIDAD_CIVIL_LESIONES;

  @Dado("^que se tiene una póliza con las coberturas$")
  public void recibirReclamoResponsabilidadCivil(DataTable coberturas) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            obtenerDatosPrueba(
                PARAMETROS_RECLAMACION.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL));
    vehiculo =
        new Vehiculo(
            obtenerDatosPrueba(PARAMETROS_VEHICULO.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Cuando(
      "^se genere un siniestro por la causa y la culpabilidad Responsabilidad civil daños persona y Responsabilidad civil daños vehículo$")
  public void ingresarDatosSiniestroResponsabilidadCivil(DataTable parametrosSiniestro)
      throws IOException {
    RESPONSABILIDAD_CIVIL_LESIONES = parametrosSiniestro.raw().get(1).get(2);
    RESPONSABILIDAD_CIVIL_VEHICULO = parametrosSiniestro.raw().get(1).get(3);
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            obtenerDatosPrueba(
                PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO.getValor(),
                RESPONSABILIDAD_CIVIL_VEHICULO));
    PersonaReclamacion personaResponsabilidadCivilVehiculo =
        new PersonaReclamacion(
            obtenerDatosPrueba(PARAMETROS_PERSONA.getValor(), RESPONSABILIDAD_CIVIL_VEHICULO));
    ReclamacionAuto direccionExposicionVehicularTercero =
        new ReclamacionAuto(
            obtenerDatosPrueba(
                PARAMETROS_DIRECCION_SINIESTRO.getValor(), DIRECCION_EXPOSICION_VEHICULAR));
    PersonaReclamacion personaReclamacionLesionado =
        new PersonaReclamacion(
            obtenerDatosPrueba(PARAMETROS_PERSONA.getValor(), RESPONSABILIDAD_CIVIL_LESIONES));
    ReclamacionAuto direccionExposicionLesionado =
        new ReclamacionAuto(
            obtenerDatosPrueba(
                PARAMETROS_DIRECCION_SINIESTRO.getValor(), DIRECCION_EXPOSICION_LESIONES));
    exposicionLesiones =
        new ExposicionLesiones(
            obtenerDatosPrueba(
                PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES.getValor(),
                RESPONSABILIDAD_CIVIL_LESIONES));
    reclamacionStep.crearAvisoResponsabilidadCivil(
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        personaResponsabilidadCivilVehiculo.getLstPersonaReclamacion(),
        direccionExposicionVehicularTercero.getLstReclamacionAuto(),
        personaReclamacionLesionado.getLstPersonaReclamacion(),
        direccionExposicionLesionado.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
    nuevaReclamacionGuardadaStep.abrirNuevaReclamacionGuardada();
  }

  @Entonces(
      "^se obtendrán exposiciones automáticas y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil$")
  public void generarReclamacionResponsabilidadCivil() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            obtenerDatosPrueba(
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(), EXPOSICIONES_RESPONSABILIDAD_CIVIL));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            obtenerDatosPrueba(
                PARAMETRO_LINEA_RESERVA.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL));
    reclamacionStep.validarValorReservas(reserva.getLstReserva());
  }

  @Dado("^que se tiene una póliza con las coberturas para Daños$")
  public void recibirReclamoArchivo(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            obtenerDatosPrueba(PARAMETROS_RECLAMACION.getValor(), RECLAMACION_ARCHIVO));
    vehiculo =
        new Vehiculo(obtenerDatosPrueba(PARAMETROS_VEHICULO.getValor(), RECLAMACION_ARCHIVO));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Cuando("se genere un siniestro por la causa y la culpabilidad$")
  public void ingresarDatosSiniestro(DataTable culpabilidad) {
    reclamacionStep.crearAvisoPerdidaParcialDanos(reclamacionAuto.getLstReclamacionAuto());
    nuevaReclamacionGuardadaStep.abrirNuevaReclamacionGuardada();
  }

  @Entonces(
      "^se obtendrán exposiciones automáticas de exposición, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo$")
  public void generarReclamacionArchivo() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            obtenerDatosPrueba(PARAMETROS_EXPOSICION_AUTOMATICA.getValor(), EXPOSICIONES_ARCHIVO));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(obtenerDatosPrueba(PARAMETRO_LINEA_RESERVA.getValor(), LINEA_RESERVA_ARCHIVO));
    reclamacionStep.validarValorReservas(reserva.getLstReserva());
  }

  @Dado("^que se tiene una póliza con las coberturas para Subrogación$")
  public void recibirReclamoSubrogacion(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            obtenerDatosPrueba(PARAMETROS_RECLAMACION.getValor(), RECLAMACION_SUBROGACION));
    vehiculo =
        new Vehiculo(obtenerDatosPrueba(PARAMETROS_VEHICULO.getValor(), RECLAMACION_SUBROGACION));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Dado("^que se tiene una póliza con las coberturas para Solo Responsabilidad Civil$")
  public void recibirReclamoSoloResponsabilidadCivil(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            obtenerDatosPrueba(
                PARAMETROS_RECLAMACION.getValor(), RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL));
    vehiculo =
        new Vehiculo(
            obtenerDatosPrueba(
                PARAMETROS_VEHICULO.getValor(), RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Entonces(
      "^se obtendrán las exposiciones automáticas para cada tipo de responsabilidad, con su respectiva reserva$")
  public void generarReclamacionSoloResponsabilidadCivil() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            obtenerDatosPrueba(
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(),
                EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            obtenerDatosPrueba(
                PARAMETRO_LINEA_RESERVA.getValor(), RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL));
    reclamacionStep.validarValorReservas(reserva.getLstReserva());
  }

  private void validarExposicionesAutomaticas() {
    reclamacionStep.validarExposicion(exposicionesAutomaticasAutos.getLstExposiciones());
  }
}
