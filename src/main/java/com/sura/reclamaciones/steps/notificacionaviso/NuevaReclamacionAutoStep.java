package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.constantes.TransaccionModeloSimplificadoConstante;
import com.sura.reclamaciones.models.*;
import com.sura.reclamaciones.pages.autos.reclamacion.*;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.sentenciasSQL.ConsultarCondicionesPoliza;
import com.sura.reclamaciones.utils.ConexionBaseDatosUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class NuevaReclamacionAutoStep {

  ConsultarCondicionesPoliza consultarCondicionesPoliza = new ConsultarCondicionesPoliza();
  ConexionBaseDatosUtil conexionBaseDatosUtil = new ConexionBaseDatosUtil();

  Connection conexion = null;
  private String transaccionConsulta = null;
  private Map<String, String> sql = null;
  private List<Map<String, String>> resultadoConsulta = null;

  @Page private InformacionBasicaPage informacionBasicaPage;
  @Page private BuscarPolizaPage buscarPolizaPage;
  @Page private AgregarInformacionPage agregarInformacionPage;
  @Page private DetalleVehiculoPage detalleVehiculoPage;
  @Page private NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;
  @Page private DatosFinancierosPage datosFinancierosPage;
  @Page private ExposicionesAutomaticasPage exposicionesAutomaticasPage;
  @Page private AgregarExposicionPersonaPage agregarExposicionPersonaPage;
  @Page MenuClaimPage menuClaimPage;

  @Step()
  public void completarDetalleSiniestro(List<ReclamacionAuto> datosReclamacion) {
    datosReclamacion.forEach(
        dato -> {
          agregarInformacionPage.cerrarVentanaEmergente();
          agregarInformacionPage.seleccionarLugar(dato.getLugar());
          agregarInformacionPage.escribirSucedido(dato.getSucedido());
          agregarInformacionPage.seleccionarCausa(dato.getCausa());
          agregarInformacionPage.seleccionarOrigen(dato.getOrigen());
          agregarInformacionPage.escribirValorPretension(dato.getValorPretension());
          agregarInformacionPage.seleccionarIntervinoAutoridad(dato.getAutoridad());
        });
  }

  @Step
  public void completarCategorizacion(List<ReclamacionAuto> datosReclamacion) {
    datosReclamacion.forEach(
        dato -> {
          agregarInformacionPage.seleccionarCulpabilidad(dato.getCulpabilidad());
        });
  }

  @Step
  public void crearExposionVehiculoTercero(List<ExposicionVehiculoTercero> datosExposicionTercero) {

    agregarInformacionPage.agregarExposicionVehiculoTercero();
    detalleVehiculoPage.ingresarVehiculoTercero(datosExposicionTercero);
    detalleVehiculoPage.agregarTerceroConductor(datosExposicionTercero);
    datosExposicionTercero.forEach(
        dato -> {
          detalleVehiculoPage.seleccionarTaller(dato.getTaller());
        });
    detalleVehiculoPage.volverPasoAnterior();
  }

  @Step
  public void crearExposicionPersona(List<ExposicionPersona> datosExposicionPersona) {
    agregarExposicionPersonaPage.agregarPeaton(datosExposicionPersona);
  }

  @Step
  public void editarVehiculo(List<ReclamacionAuto> datosReclamacion) {
    agregarInformacionPage.ingresarEdicionVehiculo();
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

  public void validarExposicion(
      List<ExposicionAutomaticaReservaAutomatica> datosExposicionAutomatica) throws SQLException {
    boolean exposicionAutomatica =
        exposicionesAutomaticasPage.validarExposiciones(datosExposicionAutomatica);
    MatcherAssert.assertThat(
        "No coinciden todos los valores de las líneas de reserva", exposicionAutomatica);
  }

  public void visualizarResumenSiniestro() {
    nuevaReclamacionGuardadaPage.obtenerNumeroReclamacion();
  }

  public void finalizarReclamacion() {
    agregarInformacionPage.concluirReclamacion();
  }

  @Step
  public void completarFormularioBuscarPoliza(
      List<ReclamacionAuto> datosReclamacion, List<Vehiculo> datosVehiculo) {
    datosVehiculo.forEach(
        datoReclamacion -> {
          buscarPolizaPage.escribirPlaca(datoReclamacion.getPlaca());
        });
    datosReclamacion.forEach(
        dato -> {
          seleccionarFecha(dato.getFechaSiniestro());
        });
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

  @Step
  public Connection conectarBaseDatos() {
    conexion =
        ConexionBaseDatosUtil.conectarBaseDatos(
            TransaccionModeloSimplificadoConstante.USUARIO,
            TransaccionModeloSimplificadoConstante.CLAVE,
            TransaccionModeloSimplificadoConstante.URL,
            TransaccionModeloSimplificadoConstante.DRIVER);
    return conexion;
  }

  public void consultarReclamacion() {
    nuevaReclamacionGuardadaPage.abrirReclamacion();
  }

  public void consultarLineaReservaValorReservaRC(
      List<LineaReservaValorReservaAutos> lineaReservaValorReservaAutos) throws SQLException {
    boolean valorLineaReserva =
        datosFinancierosPage.obtenerDatosFinancieros(lineaReservaValorReservaAutos);
    MatcherAssert.assertThat(
        "No coinciden todos los valores de las líneas de reserva", valorLineaReserva);
  }

  public void consultarLineayValorReservaArchivo(
      List<LineaReservaValorReservaAutos> lineaReservaValorReservaAutos) throws SQLException {
    boolean valorLineaReserva =
        datosFinancierosPage.obtenerDatosFinancieros(lineaReservaValorReservaAutos);
    MatcherAssert.assertThat(
        "No coinciden todos los valores de las líneas de reserva", valorLineaReserva);
  }
}
