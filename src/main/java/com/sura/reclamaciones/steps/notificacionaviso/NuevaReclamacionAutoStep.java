package com.sura.reclamaciones.steps.notificacionaviso;

import static com.sura.reclamaciones.utils.ConexionBaseDatosUtil.conectarBaseDatos;
import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.constantes.TransaccionModeloSimplificadoConstante;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.pages.autos.reclamacion.AgregarInformacionPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleVehiculoPage;
import com.sura.reclamaciones.pages.autos.reclamacion.InformacionBasicaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevaReclamacionGuardadaPage;
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
  String transaccionConsulta = null;
  Map<String, String> sql = null;
  List<Map<String, String>> resultadoConsulta = null;

  @Page private InformacionBasicaPage informacionBasicaPage;
  @Page private BuscarPolizaPage buscarPolizaPage;
  @Page private AgregarInformacionPage agregarInformacionPage;
  @Page private DetalleVehiculoPage detalleVehiculoPage;
  @Page private NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;
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
  public void diligenciarReclamacion(String culpabilidad){
    switch(culpabilidad) {

      case "Responsabilidad Civil":
        agregarInformacionPage.diligenciarReclamacion(culpabilidad);
        break;

      case "Solo RC":

        break;
    }




  }

  @Step
  public void editarVehiculo(List<ReclamacionAuto> datosReclamacion,String culpabilidad) {
    agregarInformacionPage.ingresarEdicionVehiculo();
    detalleVehiculoPage.agregarConductor();
    datosReclamacion.forEach(
        dato -> {
          if(!dato.getCulpabilidad().equals(culpabilidad)) {
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

  public List<Map<String, String>> consultarReclamacion() throws SQLException {
    String numeroReclamacion;
    String consultaSql;
    nuevaReclamacionGuardadaPage.abrirReclamacion();
    numeroReclamacion = nuevaReclamacionGuardadaPage.obtenerNumeroReclamacionConsultaPoliza();
    sql = consultarCondicionesPoliza.obtenerSentenciaSql(numeroReclamacion);
    consultaSql = sql.get("Datos Poliza");
    //Revisar aquí. Extraer clave de la consulta
    conexion = conectarBaseDatos();
    resultadoConsulta = conexionBaseDatosUtil.consultarBaseDatosCCLab(conexion, consultaSql);
    return resultadoConsulta;
  }

  public void consultarExposicionesyReservas(String culpabilidad) {
    //nuevaReclamacionGuardadaPage.obtenerNumeroReclamacionConsultaPoliza();
    nuevaReclamacionGuardadaPage.consultarReclamacion(culpabilidad);
  }
}
