package com.sura.reclamaciones.steps.guidewire.claimscenter;

import static com.sura.reclamaciones.constantes.Constantes.CUENTA;
import static com.sura.reclamaciones.constantes.Constantes.SELECCIONAR;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.IntroducirInformacionBeneficiarioPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class InformacionBeneficiarioPagoStep {

  @Page IntroducirInformacionBeneficiarioPage introducirInformacionBeneficiarioPage;

  @Page GeneralPage generalPage;

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
      generalPage.continuarSiguientePantalla();
    }
  }
}
