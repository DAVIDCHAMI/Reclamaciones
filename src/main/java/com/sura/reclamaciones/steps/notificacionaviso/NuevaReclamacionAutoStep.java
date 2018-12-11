package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.DatosFinancierosConstante;
import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ExposicionLesiones;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.models.PersonaReclamacionAuto;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.pages.autos.reclamacion.AgregarExposicionLesionesPage;
import com.sura.reclamaciones.pages.autos.reclamacion.AgregarInformacionSiniestroAutosPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DatosFinancierosPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleVehiculoPage;
import com.sura.reclamaciones.pages.autos.reclamacion.ExposicionesAutomaticasPage;
import com.sura.reclamaciones.pages.autos.reclamacion.InformacionBasicaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevaReclamacionGuardadaPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class NuevaReclamacionAutoStep {

  @Page private InformacionBasicaPage informacionBasicaPage;
  @Page private BuscarPolizaPage buscarPolizaPage;
  @Page private AgregarInformacionSiniestroAutosPage agregarInformacionSiniestroAutosPage;
  @Page private DetalleVehiculoPage detalleVehiculoPage;
  @Page private NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;
  @Page private DatosFinancierosPage datosFinancierosPage;
  @Page private ExposicionesAutomaticasPage exposicionesAutomaticasPage;
  @Page private AgregarExposicionLesionesPage agregarExposicionLesionesPage;
  @Page MenuClaimPage menuClaimPage;

  @Step()
  public void completarDetalleSiniestro(List<ReclamacionAuto> datosReclamacion) {
    datosReclamacion.forEach(
        dato -> {
          agregarInformacionSiniestroAutosPage.cerrarVentanaEmergente();
          agregarInformacionSiniestroAutosPage.seleccionarLugar(dato.getLugarSiniestro());
          agregarInformacionSiniestroAutosPage.escribirSucedido(dato.getSucedido());
          agregarInformacionSiniestroAutosPage.seleccionarCausa(dato.getCausa());
          agregarInformacionSiniestroAutosPage.seleccionarOrigen(dato.getOrigen());
          agregarInformacionSiniestroAutosPage.escribirValorPretension(dato.getValorPretension());
          agregarInformacionSiniestroAutosPage.seleccionarIntervinoAutoridad(dato.getAutoridad());
        });
  }

  @Step
  public void completarDatosReclamacionAutos(List<ReclamacionAuto> datosReclamacion) {
    for (ReclamacionAuto dato : datosReclamacion) {
      agregarInformacionSiniestroAutosPage.seleccionarCulpabilidad(dato.getCulpabilidad());
    }
  }

  @Step
  public void crearExposionVehicular(
      List<ExposicionVehiculoTercero> datosExposicionTercero,
      List<PersonaReclamacionAuto> datosPersonaReclamacion,
      List<ReclamacionAuto> datosReclamacionAuto) {
    agregarInformacionSiniestroAutosPage.agregarExposicionVehiculoTercero();
    detalleVehiculoPage.agregarTerceroConductor(datosPersonaReclamacion, datosReclamacionAuto);
    detalleVehiculoPage.ingresarVehiculoTercero(datosExposicionTercero);
    for (ExposicionVehiculoTercero dato : datosExposicionTercero) {
      detalleVehiculoPage.seleccionarTaller(dato.getTallerReparacionAsignado());
    }
    detalleVehiculoPage.volverPasoAnterior();
  }

  @Step
  public void crearExposicionLesiones(
      List<PersonaReclamacionAuto> datopersonaReclamacion,
      List<ReclamacionAuto> datosReclamacionAuto,
      List<ExposicionLesiones> datosExposicionLesiones) {
    agregarExposicionLesionesPage.agregarPersonaLesionada(
        datopersonaReclamacion, datosReclamacionAuto, datosExposicionLesiones);
  }

  @Step
  public void editarInformacionVehiculo(List<ReclamacionAuto> datosReclamacion) {
    agregarInformacionSiniestroAutosPage.ingresarEdicionVehiculo();
    detalleVehiculoPage.agregarConductor();
    datosReclamacion.forEach(
        dato -> {
          if (!dato.getCulpabilidad().equals(ReclamacionConstante.CULPABILIDAD_SOLO_RC)) {
            detalleVehiculoPage.seleccionarTaller(dato.getTaller());
          }
        });
    detalleVehiculoPage.volverPasoAnterior();
  }

  @Step
  public void seleccionarNombreAutorReporte(List<ReclamacionAuto> lstReclamacionAuto) {
    lstReclamacionAuto.forEach(
        dato -> {
          informacionBasicaPage.seleccionarNombre();
          informacionBasicaPage.validarMsjAdvertenciaRelacionAsegurado(dato.getRelacionAsegurado());
        });
  }

  public void validarReclamacion() {
    String mensajeValidado = nuevaReclamacionGuardadaPage.obtenerMensajeValidador();
    MatcherAssert.assertThat(
        "No se encontro el mensaje a validar",
        mensajeValidado.equals(ReclamacionConstante.VALIDADOR_NUEVA_RECLAMACION));
  }

  public void validarExposicion(List<ExposicionesAutomaticasAutos> datosExposicionAutomatica) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(DatosFinancierosConstante.EXPOSICIONES);
    boolean exposicionAutomatica =
        exposicionesAutomaticasPage.validarExposiciones(datosExposicionAutomatica);
    MatcherAssert.assertThat(
        "No coinciden todos los valores de las líneas de reserva", exposicionAutomatica);
  }

  public void finalizarReclamacion() {
    agregarInformacionSiniestroAutosPage.concluirReclamacion();
  }

  @Step
  public void completarFormularioBuscarPoliza(
      List<ReclamacionAuto> datosReclamacion, List<Vehiculo> datosVehiculo) {
    for (Vehiculo datoReclamacion : datosVehiculo) {
      buscarPolizaPage.escribirPlaca(datoReclamacion.getPlaca());
    }
    for (ReclamacionAuto dato : datosReclamacion) {
      seleccionarFecha(dato.getFechaSiniestro());
    }
  }

  @Step
  public void seleccionarFecha(String fecha) {
    if ("Hoy".equals(fecha)) {
      buscarPolizaPage.seleccionarFechaHoySiniestro();
    } else {
      buscarPolizaPage.escribirFechaSiniestro(fecha);
    }
  }

  @Step
  public void buscarPoliza() {
    buscarPolizaPage.buscarPoliza();
  }

  @Step
  public void seleccionarMenu() {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
  }

  public void consultarReclamacion() {
    nuevaReclamacionGuardadaPage.abrirReclamacion();
  }

  public void consultarReservaResponsabilidadCivil(List<Reserva> lineaReserva) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(
        DatosFinancierosConstante.DATOS_FINANCIEROS);
    boolean valorLineaReserva = datosFinancierosPage.obtenerDatosFinancieros(lineaReserva);
    MatcherAssert.assertThat(
        "No coinciden todos los valores de las líneas de reserva", valorLineaReserva);
  }

  public void consultarValorReservaArchivo(List<Reserva> lineaReserva) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(
        DatosFinancierosConstante.DATOS_FINANCIEROS);
    boolean valorLineaReserva = datosFinancierosPage.obtenerDatosFinancieros(lineaReserva);
    MatcherAssert.assertThat(
        "No coinciden todos los valores de las líneas de reserva", valorLineaReserva);
  }
}
