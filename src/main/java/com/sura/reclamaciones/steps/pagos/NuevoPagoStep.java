package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.Constantes.CANTIDAD;
import static com.sura.reclamaciones.constantes.Constantes.CODIGO_RETENCION;
import static com.sura.reclamaciones.constantes.Constantes.CUENTA;
import static com.sura.reclamaciones.constantes.Constantes.EXPOSICIONES;
import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.LINEA_RESERVA_LESIONES_CORPORALES;
import static com.sura.reclamaciones.constantes.Constantes.PAGOS;
import static com.sura.reclamaciones.constantes.Constantes.SELECCIONAR;
import static com.sura.reclamaciones.constantes.Constantes.UBICACION_ESTADO_PAGO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RESERVA;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleExposicionAutomaticaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.ExposicionesAutomaticasPage;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import com.sura.reclamaciones.pages.pagos.EstablecerInstruccionPagoPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionBeneficiarioPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

public class NuevoPagoStep {

  List<WebElement> lstFilaPago;

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleExposicionAutomaticaPage detalleExposicionAutomaticaPage;

  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;

  @Page IntroducirInformacionBeneficiarioPage introducirInformacionBeneficiarioPage;

  @Page VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page ExposicionesAutomaticasPage exposicionesAutomaticasPage;

  @Page EstablecerInstruccionPagoPage establecerInstruccionPagoPage;

  @Page GeneralPage generalPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  @Step
  public void consultarNumeroReclamacion() {
    resumenReclamacionPage.obtenerNumeroReclamacion();
  }

  @Step
  public void ingresarInformacionBeneficiarioPago(
      String strLineaReserva,
      String strTipoPago,
      String strBeneficiarioPago,
      String strMetodoPago,
      String strPagoSoloSura,
      String strCodigoRetencion,
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
      introducirInformacionPagoPage.seleccionarLineaReserva(strLineaReserva);
      introducirInformacionPagoPage.seleccionarTipoPago(strTipoPago);
      introducirInformacionPagoPage.ingresarComentario(diligenciador.getComentario());
      introducirInformacionPagoPage.ingresarCodigoRetencion(
          strCodigoRetencion, CODIGO_RETENCION.getValor());
      introducirInformacionPagoPage.ingresarCantidadPago(strTipoPago, CANTIDAD.getValor());
      introducirInformacionPagoPage.irSiguientePantalla();
      if (!strLineaReserva.equals(LINEA_RESERVA_LESIONES_CORPORALES.getValor())) {
        establecerInstruccionPagoPage.ingresarFechaFactura();
        establecerInstruccionPagoPage.ingresarNumeroFactura(diligenciador.getNumeroFactura());
      }
      establecerInstruccionPagoPage.finalizarProceso();
    }
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
              (Serenity.sessionVariableCalled(SESION_CC_VALOR_RESERVA.getValor()));
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
  public void consultarNumeroReclamacionAutos(String numReclamacion) {
    menuClaimPage.buscarReclamacion(MenuConstante.RECLAMACION_MENU, numReclamacion);
  }

  @Step
  public void crearNuevoPago() {
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(PAGOS.getValor());
  }

  @Step
  public void seleccionarExposicionAutomatica() {
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

  public void ingresarEstadoLegalReclamacion() {
    detalleExposicionAutomaticaPage.seleccionarDetalleExposicion();
    detalleExposicionAutomaticaPage.editarDetalleExposicion();
    detalleExposicionAutomaticaPage.ingresarEstadoLegalReclamacion();
    detalleExposicionAutomaticaPage.actualizarDetalleExposicion();
  }

  public void riesgoConsultable() {}
}
