package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.constantes.NombresCsv;
import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.models.PersonaReclamacion;
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

public class NotificacionAvisoSiniestroAutoDefinition {

  @Steps private GenericStep genericStep;

  @Steps private NuevoAvisoSiniestroAutoStep reclamacionStep;

  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;
  private ExposicionVehiculoTercero exposicionVehiculoTercero;
  private PersonaReclamacion personaReclamacion;
  private ExposicionLesiones exposicionLesiones;
  private Reserva reserva;
  private ReclamacionAuto direccionReclamacion;
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
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_RECLAMACION, RECLAMACION_RESPONSABILIDAD_CIVIL));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_VEHICULO, RECLAMACION_RESPONSABILIDAD_CIVIL));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Cuando(
      "^se genere un siniestro por la causa y la culpabilidad Responsabilidad_civil_daños_persona y Responsabilidad_civil_daños_vehículo$")
  public void ingresarDatosSiniestroResponsabilidadCivil(DataTable parametrosSiniestro)
      throws IOException {
    RESPONSABILIDAD_CIVIL_LESIONES = parametrosSiniestro.raw().get(1).get(2);
    RESPONSABILIDAD_CIVIL_VEHICULO = parametrosSiniestro.raw().get(1).get(3);
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO,
                RESPONSABILIDAD_CIVIL_VEHICULO));
    personaReclamacion =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_PERSONA, RESPONSABILIDAD_CIVIL_VEHICULO));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_DIRECCION_SINIESTRO, DIRECCION_EXPOSICION_VEHICULAR));
    crearNuevaExposicionVehicular();
    personaReclamacion =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_PERSONA, RESPONSABILIDAD_CIVIL_LESIONES));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_DIRECCION_SINIESTRO, DIRECCION_EXPOSICION_LESIONES));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES,
                RESPONSABILIDAD_CIVIL_LESIONES));
    reclamacionStep.crearNuevaExposicionLesiones(
        personaReclamacion.getLstPersonaReclamacion(),
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
  }

  @Entonces(
      "^se obtendrán exposiciones automáticas y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil$")
  public void generarReclamacionResponsabilidadCivil() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_EXPOSICION_AUTOMATICA,
                EXPOSICIONES_RESPONSABILIDAD_CIVIL));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETRO_LINEA_RESERVA, RECLAMACION_RESPONSABILIDAD_CIVIL));
    reclamacionStep.validarValorReservasResponsabilidadCivil(reserva.getLstReserva());
  }

  @Dado("^que se tiene una póliza con las coberturas para Daños$")
  public void recibirReclamoArchivo(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_RECLAMACION, RECLAMACION_ARCHIVO));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(NombresCsv.PARAMETROS_VEHICULO, RECLAMACION_ARCHIVO));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Cuando("se genere un siniestro por la causa y la culpabilidad$")
  public void ingresarDatosSiniestro(DataTable culpabilidad) {
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.finalizarReclamacionAutos();
    reclamacionStep.consultarReclamacionAutos();
  }

  @Entonces(
      "^se obtendrán exposiciones automáticas de exposición, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo$")
  public void generarReclamacionArchivo() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_EXPOSICION_AUTOMATICA, EXPOSICIONES_ARCHIVO));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETRO_LINEA_RESERVA, LINEA_RESERVA_ARCHIVO));
    reclamacionStep.validarValorReservasArchivo(reserva.getLstReserva());
  }

  @Dado("^que se tiene una póliza con las coberturas para Subrogación$")
  public void recibirReclamoSubrogacion(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_RECLAMACION, RECLAMACION_SUBROGACION));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_VEHICULO, RECLAMACION_SUBROGACION));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Dado("^que se tiene una póliza con las coberturas para Solo Responsabilidad Civil$")
  public void recibirReclamoSoloResponsabilidadCivil(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_RECLAMACION, RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_VEHICULO, RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getVehiculos());
  }

  @Cuando(
      "^se genere un siniestro por la causa y la culpabilidad SoloRC con Responsabilidad_civil_daños_persona y Responsabilidad_civil_daños_vehículo$")
  public void ingresarDatosSiniestroSoloResponsabilidadCivil(DataTable parametrosSiniestro)
      throws IOException {
    RESPONSABILIDAD_CIVIL_LESIONES = parametrosSiniestro.raw().get(1).get(2);
    RESPONSABILIDAD_CIVIL_VEHICULO = parametrosSiniestro.raw().get(1).get(3);
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO,
                RESPONSABILIDAD_CIVIL_VEHICULO));
    personaReclamacion =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_PERSONA, RESPONSABILIDAD_CIVIL_VEHICULO));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_DIRECCION_SINIESTRO, DIRECCION_EXPOSICION_VEHICULAR));
    crearNuevaExposicionVehicular();
    personaReclamacion =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_PERSONA, RESPONSABILIDAD_CIVIL_LESIONES));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_DIRECCION_SINIESTRO, DIRECCION_EXPOSICION_LESIONES));
    exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES,
                RESPONSABILIDAD_CIVIL_LESIONES));
    reclamacionStep.crearNuevaExposicionLesiones(
        personaReclamacion.getLstPersonaReclamacion(),
        reclamacionAuto.getLstReclamacionAuto(),
        exposicionLesiones.getLstExposicionLesiones());
  }

  @Entonces(
      "^se obtendrán las exposiciones automáticas para cada tipo de responsabilidad, con su respectiva reserva$")
  public void generarReclamacionSoloResponsabilidadCivil() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETROS_EXPOSICION_AUTOMATICA,
                EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                NombresCsv.PARAMETRO_LINEA_RESERVA, RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL));
    reclamacionStep.validarValorReservasResponsabilidadCivil(reserva.getLstReserva());
  }

  private void crearNuevaExposicionVehicular() {
    reclamacionStep.crearExposicionVehicular(
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        personaReclamacion.getLstPersonaReclamacion(),
        direccionReclamacion.getLstReclamacionAuto());
  }

  private void validarExposicionesAutomaticas() {
    reclamacionStep.validarExposicion(exposicionesAutomaticasAutos.getLstExposiciones());
  }
}
