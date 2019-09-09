package com.sura.reclamaciones.definitions.autos.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_DIRECCION_SINIESTRO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_EXPOSICION_AUTOMATICA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_PERSONA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_RECLAMACION;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_VEHICULO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_LINEA_RESERVA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO;

import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.ConsultaDatoFinancieroResumenStep;
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

  @Steps ConsultaDatoFinancieroResumenStep consultaDatoFinancieroResumenStep;

  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;
  private ExposicionVehiculoTercero exposicionVehiculoTercero;
  private PersonaReclamacion personaReclamacion;
  private Reserva reserva;
  private ReclamacionAuto direccionReclamacion;
  private ExposicionesAutomaticasAutos exposicionesAutomaticasAutos;
  private static final String DIRECCION_EXPOSICION_VEHICULAR = "direccionExposicionVehicular";
  private static final String DIRECCION_EXPOSICION_LESIONES = "direccionExposicionLesiones";
  private static final String EXPOSICIONES_RESPONSABILIDAD_CIVIL = "exposicionesRC";
  private static final String EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL = "exposicionesSoloRC";
  private static final String RECLAMACION_RESPONSABILIDAD_CIVIL = "responsabilidadCivil";
  private static final String RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL = "soloRC";
  private static final String RECLAMACION_ARCHIVO = "archivo";
  private static final String RECLAMACION_SUBROGACION = "subrogacion";
  private static final String EXPOSICIONES_ARCHIVO = "exposicionesArchivo";
  private static final String LINEA_RESERVA_ARCHIVO = "archivoSubrogacion";

  String resposabilidadCivilVehiculo;
  String resposabilidadCivilLesiones;

  @Dado("^que se tiene una póliza con las coberturas$")
  public void recibirReclamoResponsabilidadCivil(DataTable coberturas) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                PARAMETROS_VEHICULO.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Cuando(
      "^se genere un siniestro por la causa y la culpabilidad Responsabilidad civil daños persona y Responsabilidad civil daños vehículo$")
  public void ingresarDatosSiniestroResponsabilidadCivil(DataTable parametrosSiniestro)
      throws IOException {
    resposabilidadCivilLesiones = parametrosSiniestro.raw().get(1).get(2);
    resposabilidadCivilVehiculo = parametrosSiniestro.raw().get(1).get(3);
    reclamacionStep.seleccionarNombreAutorReporte(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDetalleSiniestro(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.editarInformacionVehiculo(reclamacionAuto.getLstReclamacionAuto());
    reclamacionStep.completarDatosReclamacionAutos(reclamacionAuto.getLstReclamacionAuto());
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(
                PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO.getValor(), resposabilidadCivilVehiculo));
    personaReclamacion =
        new PersonaReclamacion(
            genericStep.getFilasModelo(PARAMETROS_PERSONA.getValor(), resposabilidadCivilVehiculo));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_DIRECCION_SINIESTRO.getValor(), DIRECCION_EXPOSICION_VEHICULAR));
    crearNuevaExposicionVehicular();
    personaReclamacion =
        new PersonaReclamacion(
            genericStep.getFilasModelo(PARAMETROS_PERSONA.getValor(), resposabilidadCivilLesiones));
    direccionReclamacion =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_DIRECCION_SINIESTRO.getValor(), DIRECCION_EXPOSICION_LESIONES));
    ExposicionLesiones exposicionLesiones =
        new ExposicionLesiones(
            genericStep.getFilasModelo(
                PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES.getValor(), resposabilidadCivilLesiones));
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
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(), EXPOSICIONES_RESPONSABILIDAD_CIVIL));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                PARAMETRO_LINEA_RESERVA.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL));
    consultaDatoFinancieroResumenStep.validarValorReservas(reserva.getLstReserva());
  }

  @Dado("^que se tiene una póliza con las coberturas para Daños$")
  public void recibirReclamoArchivo(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(PARAMETROS_RECLAMACION.getValor(), RECLAMACION_ARCHIVO));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(PARAMETROS_VEHICULO.getValor(), RECLAMACION_ARCHIVO));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
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
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(), EXPOSICIONES_ARCHIVO));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(PARAMETRO_LINEA_RESERVA.getValor(), LINEA_RESERVA_ARCHIVO));
    consultaDatoFinancieroResumenStep.validarValorReservas(reserva.getLstReserva());
  }

  @Dado("^que se tiene una póliza con las coberturas para Subrogación$")
  public void recibirReclamoSubrogacion(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(PARAMETROS_RECLAMACION.getValor(), RECLAMACION_SUBROGACION));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(PARAMETROS_VEHICULO.getValor(), RECLAMACION_SUBROGACION));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Dado("^que se tiene una póliza con las coberturas para Solo Responsabilidad Civil$")
  public void recibirReclamoSoloResponsabilidadCivil(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION.getValor(), RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL));
    vehiculo =
        new Vehiculo(
            genericStep.getFilasModelo(
                PARAMETROS_VEHICULO.getValor(), RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Entonces(
      "^se obtendrán las exposiciones automáticas para cada tipo de responsabilidad, con su respectiva reserva$")
  public void generarReclamacionSoloResponsabilidadCivil() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            genericStep.getFilasModelo(
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(),
                EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            genericStep.getFilasModelo(
                PARAMETRO_LINEA_RESERVA.getValor(), RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL));
    consultaDatoFinancieroResumenStep.validarValorReservas(reserva.getLstReserva());
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
