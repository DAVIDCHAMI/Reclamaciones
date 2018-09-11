package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.MenuConstante.RECLAMACION_MENU;
import static org.junit.Assert.assertTrue;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.models.PagoEmpresarial;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagos.EstablecerInstruccionPagoPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionBeneficiarioPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import com.sura.reclamaciones.pages.pagos.VerificarPagoPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebElement;

public class NuevoPagoStep {

  @Page IntroducirInformacionBeneficiarioPage introducirInformacionBeneficiarioPage;
  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;
  @Page EstablecerInstruccionPagoPage establecerInstruccionPagoPage;
  @Page VerificarPagoPage verificarPagoPage;
  @Page GeneralPage generalPage;
  @Page MenuClaimPage menuClaimPage;

  @Step
  public void consultarNumeroReclamacion(String strNumeroReclamacion) {
    menuClaimPage.buscarReclamacion(RECLAMACION_MENU, strNumeroReclamacion);
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(PagoConstante.PAGOS);
  }

  @Step
  public void ingresarInformacionBeneficiarioPago(
      String strTipoPago,
      String strBeneficiarioPago,
      String strMetodoPago,
      String strLineaReserva,
      String strPagoSoloSura,
      String strCodigoRetencion,
      List<PagoEmpresarial> lstPago) {
    lstPago.forEach(
        diligenciador -> {
          introducirInformacionBeneficiarioPage.seleccionarNombreBeneficiario(strBeneficiarioPago);
          introducirInformacionBeneficiarioPage.seleccionarTipoBeneficiario(
              diligenciador.getTipoBeneficiario());
          introducirInformacionBeneficiarioPage.seleccionarMetodoPago(
              strMetodoPago, PagoConstante.CUENTA, PagoConstante.SELECCIONAR);
          introducirInformacionBeneficiarioPage.seleccionarPagoSura(strPagoSoloSura);
        introducirInformacionBeneficiarioPage.seleccionarPais(
            PagoConstante.PAIS, diligenciador.getPais());
          introducirInformacionBeneficiarioPage.seleccionarDepartamento(
                  PagoConstante.DEPARTAMENTO, diligenciador.getDepartamento());
          introducirInformacionBeneficiarioPage.seleccionarCiudad(
              PagoConstante.CIUDAD, diligenciador.getCiudad());
          introducirInformacionBeneficiarioPage.seleccionarTipoDireccion(
              PagoConstante.TIPO_DIRECCION, diligenciador.getTipoDireccion());
          generalPage.continuarSiguientePantalla();
          introducirInformacionPagoPage.seleccionarLineaReserva(strLineaReserva);
          introducirInformacionPagoPage.seleccionarTipoPago(strTipoPago);
          introducirInformacionPagoPage.ingresarComentario(diligenciador.getComentario());
          introducirInformacionPagoPage.ingresarCodigoRetencion(
              strCodigoRetencion, PagoConstante.CODIGO_RETENCION);
          introducirInformacionPagoPage.ingresarCantidadPago(strTipoPago, PagoConstante.CANTIDAD);
          generalPage.continuarSiguientePantalla();
          establecerInstruccionPagoPage.ingresarFecha();
          establecerInstruccionPagoPage.ingresarNumeroFactura(diligenciador.getNumeroFactura());
          generalPage.finalizarProceso();
        });
  }

  @Step
  public void verificarPagoRealizado(List<PagoEmpresarial> lstPago) {
      lstPago.forEach(
              validador->{
                  String strNumeroTransaccion= verificarPagoPage.capturarNumeroPagoRealizado();
                  List<WebElement> lstFilaPago=  verificarPagoPage.obtenerFilaTabla(strNumeroTransaccion);
                  verificarPagoPage.ingresarMenuTransacciones();
                  assertTrue(
                          "No llego a SAP el recupero", verificarPagoPage.verificarPagoMenuTransaccion(validador.getEstado(), lstFilaPago));
              }
      );
  }
}
