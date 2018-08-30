package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.MenuConstante.BUSCAR_RECLAMACION;
import static com.sura.reclamaciones.constantes.MenuConstante.RECLAMACION_MENU;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagos.EstablecerInstruccionPagoPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionBeneficiarioPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class NuevoPagoStep {

  @Page IntroducirInformacionBeneficiarioPage introducirInformacionBeneficiarioPage;
  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;
  @Page EstablecerInstruccionPagoPage establecerInstruccionPagoPage;
  @Page GeneralPage generalPage;
  @Page MenuClaimPage menuClaimPage;

  @Step
  public void consultarNumeroReclamacion(String strNumeroReclamacion) {
    menuClaimPage.seleccionarOpcionMenuPrimerNivel(RECLAMACION_MENU);
    menuClaimPage.buscarReclamacion(strNumeroReclamacion);
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(PagoConstante.PAGOS);
  }

  @Step
  public void ingresarInformacionBeneficiarioPago(
      String strTipoPago,
      String strBeneficiarioPago,
      String strMetodoPago,
      String strLineaReserva,
      String strSoloSura,
      String strCodigoRetencion) {
    introducirInformacionBeneficiarioPage.seleccionarNombreBeneficiario(strBeneficiarioPago);
    introducirInformacionBeneficiarioPage.seleccionarMetodoPago(strMetodoPago);
    introducirInformacionBeneficiarioPage.seleccionarPagoSura(strSoloSura);
    introducirInformacionPagoPage.seleccionarLineaReserva(strLineaReserva);
    introducirInformacionPagoPage.seleccionarTipoPago(strTipoPago);
  }

  @Step
  public void verificarPagoRealizado() {}
}
