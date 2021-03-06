package com.sura.reclamaciones.definitions.autos.reclamaciones;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import static com.sura.reclamaciones.utils.enums.Filtros.DIRECCION_EXPOSICION_LESIONES;
import static com.sura.reclamaciones.utils.enums.Filtros.DIRECCION_EXPOSICION_VEHICULAR;
import static com.sura.reclamaciones.utils.enums.Filtros.EXPOSICIONES_ARCHIVO;
import static com.sura.reclamaciones.utils.enums.Filtros.EXPOSICIONES_RESPONSABILIDAD_CIVIL;
import static com.sura.reclamaciones.utils.enums.Filtros.EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL;
import static com.sura.reclamaciones.utils.enums.Filtros.LINEA_RESERVA_ARCHIVO;
import static com.sura.reclamaciones.utils.enums.Filtros.RECLAMACION_ARCHIVO;
import static com.sura.reclamaciones.utils.enums.Filtros.RECLAMACION_RESPONSABILIDAD_CIVIL;
import static com.sura.reclamaciones.utils.enums.Filtros.RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL;
import static com.sura.reclamaciones.utils.enums.Filtros.RECLAMACION_SUBROGACION;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_DIRECCION_SINIESTRO;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_EXPOSICION_AUTOMATICA;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_PERSONA;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_RECLAMACION;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_VEHICULO;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETRO_LINEA_RESERVA;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO;

import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.guidewire.claimscenter.autos.NuevoAvisoSiniestroAutoStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.ConsultaDatoFinancieroResumenStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.NuevaReclamacionGuardadaStep;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoSiniestroAutoDefinition {

  @Steps private NuevoAvisoSiniestroAutoStep reclamacionStep;

  @Steps ConsultaDatoFinancieroResumenStep consultaDatoFinancieroResumenStep;

  @Steps private NuevaReclamacionGuardadaStep nuevaReclamacionGuardadaStep;

  private ReclamacionAuto reclamacionAuto;
  private Vehiculo vehiculo;
  private Reserva reserva;
  private ExposicionesAutomaticasAutos exposicionesAutomaticasAutos;

  @Dado("^que se tiene una p??liza con las coberturas$")
  public void recibirReclamoResponsabilidadCivil(DataTable coberturas) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            obtenerDatosPrueba(
                PARAMETROS_RECLAMACION.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL.getValor()));
    vehiculo =
        new Vehiculo(
            obtenerDatosPrueba(
                PARAMETROS_VEHICULO.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL.getValor()));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Cuando(
      "^se genere un siniestro por la causa y la culpabilidad Responsabilidad civil da??os persona y Responsabilidad civil da??os veh??culo$")
  public void ingresarDatosSiniestroResponsabilidadCivil(DataTable parametrosSiniestro)
      throws IOException {
    ExposicionVehiculoTercero exposicionVehiculoTercero;
    final String RESPONSABILIDAD_CIVIL_LESIONES = parametrosSiniestro.raw().get(1).get(2);
    final String RESPONSABILIDAD_CIVIL_VEHICULO = parametrosSiniestro.raw().get(1).get(3);
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
                PARAMETROS_DIRECCION_SINIESTRO.getValor(),
                DIRECCION_EXPOSICION_VEHICULAR.getValor()));
    PersonaReclamacion personaReclamacionLesionado =
        new PersonaReclamacion(
            obtenerDatosPrueba(PARAMETROS_PERSONA.getValor(), RESPONSABILIDAD_CIVIL_LESIONES));
    ReclamacionAuto direccionExposicionLesionado =
        new ReclamacionAuto(
            obtenerDatosPrueba(
                PARAMETROS_DIRECCION_SINIESTRO.getValor(),
                DIRECCION_EXPOSICION_LESIONES.getValor()));
    ExposicionLesiones exposicionLesiones =
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
      "^se obtendr??n exposiciones autom??ticas y cada una con su respectiva reserva, seg??n la culpabilidad marcada Responsabilidad Civil$")
  public void generarReclamacionResponsabilidadCivil() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            obtenerDatosPrueba(
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(),
                EXPOSICIONES_RESPONSABILIDAD_CIVIL.getValor()));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            obtenerDatosPrueba(
                PARAMETRO_LINEA_RESERVA.getValor(), RECLAMACION_RESPONSABILIDAD_CIVIL.getValor()));
    consultaDatoFinancieroResumenStep.validarValorReservas(reserva.getLstReserva());
  }

  @Dado("^que se tiene una p??liza con las coberturas para Da??os$")
  public void recibirReclamoArchivo(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            obtenerDatosPrueba(PARAMETROS_RECLAMACION.getValor(), RECLAMACION_ARCHIVO.getValor()));
    vehiculo =
        new Vehiculo(
            obtenerDatosPrueba(PARAMETROS_VEHICULO.getValor(), RECLAMACION_ARCHIVO.getValor()));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Cuando("se genere un siniestro por la causa y la culpabilidad$")
  public void ingresarDatosSiniestro(DataTable culpabilidad) {
    reclamacionStep.crearAvisoPerdidaParcialDanos(reclamacionAuto.getLstReclamacionAuto());
    nuevaReclamacionGuardadaStep.abrirNuevaReclamacionGuardada();
  }

  @Entonces(
      "^se obtendr??n exposiciones autom??ticas de exposici??n, y cada una con su respectiva reserva, seg??n la culpabilidad marcada Archivo$")
  public void generarReclamacionArchivo() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            obtenerDatosPrueba(
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(), EXPOSICIONES_ARCHIVO.getValor()));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            obtenerDatosPrueba(
                PARAMETRO_LINEA_RESERVA.getValor(), LINEA_RESERVA_ARCHIVO.getValor()));
    consultaDatoFinancieroResumenStep.validarValorReservas(reserva.getLstReserva());
  }

  @Dado("^que se tiene una p??liza con las coberturas para Subrogaci??n$")
  public void recibirReclamoSubrogacion(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            obtenerDatosPrueba(
                PARAMETROS_RECLAMACION.getValor(), RECLAMACION_SUBROGACION.getValor()));
    vehiculo =
        new Vehiculo(
            obtenerDatosPrueba(PARAMETROS_VEHICULO.getValor(), RECLAMACION_SUBROGACION.getValor()));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Dado("^que se tiene una p??liza con las coberturas para Solo Responsabilidad Civil$")
  public void recibirReclamoSoloResponsabilidadCivil(DataTable cobertura) throws IOException {
    reclamacionAuto =
        new ReclamacionAuto(
            obtenerDatosPrueba(
                PARAMETROS_RECLAMACION.getValor(),
                RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL.getValor()));
    vehiculo =
        new Vehiculo(
            obtenerDatosPrueba(
                PARAMETROS_VEHICULO.getValor(), RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL.getValor()));
    reclamacionStep.consultarPoliza(
        reclamacionAuto.getLstReclamacionAuto(), vehiculo.getLstVehiculos());
  }

  @Entonces(
      "^se obtendr??n las exposiciones autom??ticas para cada tipo de responsabilidad, con su respectiva reserva$")
  public void generarReclamacionSoloResponsabilidadCivil() throws IOException {
    exposicionesAutomaticasAutos =
        new ExposicionesAutomaticasAutos(
            obtenerDatosPrueba(
                PARAMETROS_EXPOSICION_AUTOMATICA.getValor(),
                EXPOSICIONES_SOLO_RESPONSABILIDAD_CIVIL.getValor()));
    validarExposicionesAutomaticas();
    reserva =
        new Reserva(
            obtenerDatosPrueba(
                PARAMETRO_LINEA_RESERVA.getValor(),
                RECLAMACION_SOLO_RESPONSABILIDAD_CIVIL.getValor()));
    consultaDatoFinancieroResumenStep.validarValorReservas(reserva.getLstReserva());
  }

  private void validarExposicionesAutomaticas() {
    reclamacionStep.validarExposicion(exposicionesAutomaticasAutos.getLstExposiciones());
  }
}
