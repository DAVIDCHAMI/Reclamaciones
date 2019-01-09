package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.utils.Constantes.CANTIDAD;
import static com.sura.reclamaciones.utils.Constantes.CODIGO_RETENCION;
import static com.sura.reclamaciones.utils.Constantes.CUENTA;
import static com.sura.reclamaciones.utils.Constantes.PAGOS;
import static com.sura.reclamaciones.utils.Constantes.SELECCIONAR;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RESERVA;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.PagoSiniestro;
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

  @Page IntroducirInformacionBeneficiarioPage introducirInformacionBeneficiarioPage;

  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;

  @Page EstablecerInstruccionPagoPage establecerInstruccionPagoPage;

  @Page VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  @Page MenuClaimPage menuClaimPage;

  @Step
  public void consultarNumeroReclamacion() {
    resumenReclamacionPage.obtenerNumeroReclamacion();
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(PAGOS.getValor());
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
      establecerInstruccionPagoPage.ingresarFechaFactura();
      establecerInstruccionPagoPage.ingresarNumeroFactura(diligenciador.getNumeroFactura());
      establecerInstruccionPagoPage.finalizarProceso();
    }
  }

  @Step
  public void verificarPagoRealizado(List<PagoSiniestro> lstPago) {
    lstPago.forEach(
        (PagoSiniestro validador) -> {
          String strNumeroTransaccion =
              verificacionDatosFinancierosPage.obtenerNumeroPagoRealizado();
          menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
              MenuConstante.DATOS_FINANCIEROS, PAGOS.getValor());
          List<WebElement> lstFilaPago =
              verificacionDatosFinancierosPage.obtenerFilaTabla(
                  strNumeroTransaccion, verificacionDatosFinancierosPage.getTblPago());
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
}
