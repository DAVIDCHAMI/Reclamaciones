package com.sura.reclamaciones.steps.generics;

import static com.sura.reclamaciones.constantes.Constantes.RECUPERO;
import static com.sura.reclamaciones.constantes.Constantes.TIPO_TRANSACCION;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_TRANSACCION;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.pages.anulaciontransaccion.DetalleTransaccionPage;
import com.sura.reclamaciones.pages.generics.DatoFinancieroTransaccionPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class AnulacionTransaccionStep {

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleTransaccionPage detalleTransaccionPage;

  @Page
  DatoFinancieroTransaccionPage datoFinancieroTransaccionPage;

  @Step
  public void ingresarAnulacionRecupero(List<Recupero> lstRecupero) {
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
    for (Recupero diligenciador : lstRecupero) {
      String strNumeroTransaccion =
          detalleTransaccionPage.obtenerDatoTablaCabecera(
              SESION_CC_NUMERO_TRANSACCION.getValor(), 1);
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
          MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
      detalleTransaccionPage.seleccionarTipoTransaccion(TIPO_TRANSACCION.getValor());
      MatcherAssert.assertThat(
          "El estado de la transaccion no permite que sea anulada",
          detalleTransaccionPage.ingresarAnulacionEmpresarial(
              strNumeroTransaccion, diligenciador.getEstadoTransaccion(), RECUPERO.getValor()));
      MatcherAssert.assertThat(
          "El número de transaccion, no tiene habilitado el boton de anular",
          detalleTransaccionPage.realizarAnulacion(RECUPERO.getValor()));
      Serenity.setSessionVariable(SESION_CC_NUMERO_TRANSACCION.getValor()).to(strNumeroTransaccion);
    }
  }

  @Step
  public void verificarAnulacionRealizada(String strAnulacionPago) {
    String strNumeroTransaccion =
        Serenity.sessionVariableCalled(SESION_CC_NUMERO_TRANSACCION.getValor());
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
    datoFinancieroTransaccionPage.seleccionarTipoTransaccion(TIPO_TRANSACCION.getValor());
    MatcherAssert.assertThat(
        "El recupero no quedo en estado anulado",
        datoFinancieroTransaccionPage.verificarEstadoAnulado(
            strAnulacionPago, strNumeroTransaccion));
  }
}
