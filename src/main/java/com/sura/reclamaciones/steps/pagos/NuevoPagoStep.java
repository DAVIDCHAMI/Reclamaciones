package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.Constantes.CANTIDAD;
import static com.sura.reclamaciones.constantes.Constantes.CODIGO_RETENCION;
import static com.sura.reclamaciones.constantes.Constantes.COMODIN;
import static com.sura.reclamaciones.constantes.Constantes.CUENTA;
import static com.sura.reclamaciones.constantes.Constantes.EXPOSICIONES;
import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.OPCION_MENU;
import static com.sura.reclamaciones.constantes.Constantes.PAGOS;
import static com.sura.reclamaciones.constantes.Constantes.PLACA;
import static com.sura.reclamaciones.constantes.Constantes.RECLAMANTE_CONDUCTOR_AFECTADO;
import static com.sura.reclamaciones.constantes.Constantes.SELECCIONAR;
import static com.sura.reclamaciones.constantes.Constantes.UBICACION_ESTADO_PAGO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TOTAL_PAGO_RESERVAS;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.autos.reclamacion.CrearServicioPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleExposicionAutomaticaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleVehiculoPage;
import com.sura.reclamaciones.pages.autos.reclamacion.ExposicionesAutomaticasPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevaExposicionPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevoIncidenteVehicularPage;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import com.sura.reclamaciones.pages.pagos.EstablecerInstruccionPagoPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionBeneficiarioPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import java.util.List;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

public class NuevoPagoStep {

  List<WebElement> lstFilaPago;
  private int campoDato = 0;

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleExposicionAutomaticaPage detalleExposicionAutomaticaPage;

  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;

  @Page IntroducirInformacionBeneficiarioPage introducirInformacionBeneficiarioPage;

  @Page VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page ExposicionesAutomaticasPage exposicionesAutomaticasPage;

  @Page EstablecerInstruccionPagoPage establecerInstruccionPagoPage;

  @Page GeneralPage generalPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  @Page NuevaExposicionPage nuevaExposicionManualPage;

  @Page NuevoIncidenteVehicularPage nuevoIncidenteVehicularPage;

  @Page DetalleVehiculoPage detalleVehiculoPage;

  @Page CrearServicioPage crearServicioPage;

  @Step
  public void consultarNumeroReclamacion() {
    resumenReclamacionPage.obtenerNumeroReclamacion();
  }

  @Step
  public void ingresarInformacionBeneficiarioPago(
      String strBeneficiarioPago,
      String strMetodoPago,
      String strPagoSoloSura,
      List<PagoSiniestro> lstPago) {
    for (PagoSiniestro diligenciador : lstPago) {
      introducirInformacionBeneficiarioPage.seleccionarNombreBeneficiario(strBeneficiarioPago);
      introducirInformacionBeneficiarioPage.seleccionarTipoBeneficiario(
          diligenciador.getTipoBeneficiario());
      introducirInformacionBeneficiarioPage.seleccionarMetodoPago(
          strMetodoPago, CUENTA.getValor(), SELECCIONAR.getValor());
      introducirInformacionBeneficiarioPage.seleccionarPagoSura(strPagoSoloSura);
      introducirInformacionBeneficiarioPage.seleccionarPais(diligenciador.getPais());
      introducirInformacionBeneficiarioPage.seleccionarDepartamento(
          diligenciador.getDepartamento());
      introducirInformacionBeneficiarioPage.seleccionarCiudad(diligenciador.getCiudad());
      introducirInformacionBeneficiarioPage.seleccionarTipoDireccion(
          diligenciador.getTipoDireccion());
      introducirInformacionPagoPage.irSiguientePantalla();
    }
  }

  @Step
  public void ingresarInformacionPago(
      String lineaReserva, String tipoPago, String codigoRetencion, List<PagoSiniestro> lstPago) {
    introducirInformacionPagoPage.seleccionarLineaReserva(lineaReserva);
    introducirInformacionPagoPage.seleccionarTipoPago(tipoPago);
    introducirInformacionPagoPage.ingresarComentario(lstPago.listIterator().next().getComentario());
    introducirInformacionPagoPage.ingresarCodigoRetencion(
        codigoRetencion, CODIGO_RETENCION.getValor());
    introducirInformacionPagoPage.ingresarCantidadPago(tipoPago, CANTIDAD.getValor());
  }

  @Step
  public void ingresarInstruccionesPago(String lineaReserva, List<PagoSiniestro> lstPago) {
    introducirInformacionPagoPage.irSiguientePantalla();
    establecerInstruccionPagoPage.obtenerPagoReservas();
    establecerInstruccionPagoPage.ingresarFechaFactura();
    establecerInstruccionPagoPage.ingresarNumeroFactura(
        lstPago.listIterator().next().getNumeroFactura());
    establecerInstruccionPagoPage.finalizarProceso();
  }

  @Step
  public void agregarPagoNuevaLineaReserva() {
    introducirInformacionPagoPage.agregarNuevoPago();
  }

  @Step
  public void verificarPagoRealizado(List<PagoSiniestro> lstPago) {
    lstPago.forEach(
        (PagoSiniestro validador) -> {
          for (int i = 0; i <= Integer.parseInt(ITERACIONES_PAGO.getValor()); i++) {
            generalPage.realizarEsperaCarga();
            String strNumeroTransaccion =
                verificacionDatosFinancierosPage.obtenerNumeroPagoRealizado();
            lstFilaPago =
                verificacionDatosFinancierosPage.obtenerFilaTabla(
                    strNumeroTransaccion, verificacionDatosFinancierosPage.getTblPago());
            WebElement elementoXpath =
                lstFilaPago.get(Integer.parseInt(UBICACION_ESTADO_PAGO.getValor()));
            boolean estadoTransaccionPantalla =
                generalPage.actualizarPantalla(validador.getEstadoTransaccion(), elementoXpath);
            if (estadoTransaccionPantalla) break;
          }
          String strValorReserva =
              (Serenity.sessionVariableCalled(SESION_CC_TOTAL_PAGO_RESERVAS.getValor()).toString());
          MatcherAssert.assertThat(
              "El valor reservado no es igual al enviado",
              verificacionDatosFinancierosPage.verificarPagoMenuTransaccion(
                  strValorReserva, lstFilaPago));
          MatcherAssert.assertThat(
              "No llego a SAP el pago",
              verificacionDatosFinancierosPage.verificarPagoMenuTransaccion(
                  validador.getEstadoTransaccion(), lstFilaPago));
        });
  }

  @Step
  public void seleccionarExposicionVehicularAsegurado() {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(EXPOSICIONES.getValor());
    exposicionesAutomaticasPage.seleccionarExposicion();
  }

  @Step
  public void declararReclamacionPerdidaTotal() {
    detalleExposicionAutomaticaPage.seleccionarCalculadoraPerdidaTotal();
    detalleExposicionAutomaticaPage.editarCalculadoraPerdidaTotal();
    detalleExposicionAutomaticaPage.seleccionarIncineracionTotalVehiculo();
    detalleExposicionAutomaticaPage.seleccionarMotorDestruidoFuego();
    detalleExposicionAutomaticaPage.seleccionarHabitaculoPasajerosIncinerado();
    detalleExposicionAutomaticaPage.actualizarCalculadoraPerdidaTotal();
  }

  @Step
  public void ingresarEstadoLegalReclamacion() {
    detalleExposicionAutomaticaPage.seleccionarDetalleExposicion();
    detalleExposicionAutomaticaPage.editarDetalleExposicion();
    detalleExposicionAutomaticaPage.ingresarEstadoLegalReclamacion();
    detalleExposicionAutomaticaPage.actualizarDetalleExposicion();
  }

  @Step
  public void iniciarNuevoPago() {
    menuClaimPage.seleccionarBotonAcciones();
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(PAGOS.getValor());
  }

  @Step
  public void consultarPlacaAsegurado() {
    Serenity.setSessionVariable(PLACA.getValor()).to(resumenReclamacionPage.consultarNumeroPlaca());
  }

  @Step
  public void crearExposicionVehicularManual(
      List<Map<String, String>> opcionesCrearExposicion,
      List<ExposicionVehiculoTercero> datosVehiculoTercero) {
    menuClaimPage.seleccionarBotonAcciones();
    for (int i = 0; i < opcionesCrearExposicion.size(); i++) {
      if (opcionesCrearExposicion
          .listIterator(i)
          .next()
          .get(OPCION_MENU.getValor())
          .equals(COMODIN.getValor())) {
        opcionesCrearExposicion
            .listIterator(i)
            .next()
            .replace(
                OPCION_MENU.getValor(),
                COMODIN.getValor(),
                Serenity.sessionVariableCalled(PLACA.getValor()));
      }
      String opcionMenu =
          opcionesCrearExposicion.listIterator(i).next().get(OPCION_MENU.getValor());
      menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(opcionMenu);
    }
    nuevaExposicionManualPage.seleccionarReclamanteExposicion(
        Serenity.sessionVariableCalled(SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO.getValor()));
    nuevaExposicionManualPage.seleccionarTipoReclamanteExposicion(
        RECLAMANTE_CONDUCTOR_AFECTADO.getValor());
    nuevaExposicionManualPage.crearNuevoIncidenteVehicular();
    nuevoIncidenteVehicularPage.ingresarPlacaVehiculoAfectado(datosVehiculoTercero);
    nuevoIncidenteVehicularPage.consultarInformacionVehiculoAfectado();
    nuevoIncidenteVehicularPage.seleccionarConductoVehiculoAfectado();
    nuevoIncidenteVehicularPage.seleccionarServiciosTaller();
    nuevoIncidenteVehicularPage.seleccionarTaller();
    detalleVehiculoPage.buscarProveedor();
    detalleVehiculoPage.realizarEsperaCarga();
    crearServicioPage.seleccionarProveedor(
        datosVehiculoTercero.get(campoDato).getTallerReparacionAsignado());
    detalleVehiculoPage.aceptarOpcion();
    nuevoIncidenteVehicularPage.aceptarOpcion();
    nuevaExposicionManualPage.actualizarNuevaExposicion();
  }
}
