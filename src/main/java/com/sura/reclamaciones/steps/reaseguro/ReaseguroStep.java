package com.sura.reclamaciones.steps.reaseguro;

import static com.sura.reclamaciones.utils.Constantes.NUMERO_SINIESTRO;
import static com.sura.reclamaciones.utils.Constantes.REASEGURO_DETALLADO;
import static com.sura.reclamaciones.utils.Constantes.RETENCION_PURA;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.models.Reasegurador;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.reaseguro.ReaseguroDetalladoTransaccionPage;
import com.sura.reclamaciones.utils.Constantes;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ReaseguroStep {

  @Page ReaseguroDetalladoTransaccionPage reaseguroDetalladoTransaccionPage;

  @Page MenuClaimPage menuClaimPage;

  public void buscarReclamacion() {
    menuClaimPage.buscarReclamacion(
        Constantes.RECLAMACION_MENU.getValor(),
        Serenity.sessionVariableCalled(NUMERO_SINIESTRO.getValor()));
  }

  public void verificarReaseguro(
      List<Contrato> lstContrato1,
      List<Reasegurador> lstReasegurador1,
      List<Reasegurador> lstReasegurador2,
      List<Reasegurador> lstReasegurador3) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(REASEGURO_DETALLADO.getValor());
    lstContrato1.forEach(
        verificador -> {
          MatcherAssert.assertThat(
              "La retencion nula es mayor a lo esperado",
              reaseguroDetalladoTransaccionPage.verificarRetencionPura(
                  Double.parseDouble(RETENCION_PURA.getValor())));
          MatcherAssert.assertThat(
              "El retenido no corresponde a lo esperado",
              reaseguroDetalladoTransaccionPage.verificarRetenido(
                  lstReasegurador2,
                  verificador.getDeducibleMinimo(),
                  verificador.getPorcentajeDeducibleminimo(),
                  verificador.getProporcionCuotaParte()));
          MatcherAssert.assertThat(
              "El cedido no corresponde a lo esperado",
              reaseguroDetalladoTransaccionPage.verificarCedido(
                  lstReasegurador2,
                  verificador.getDeducibleMinimo(),
                  verificador.getPorcentajeDeducibleminimo(),
                  verificador.getProporcionCuotaParte()));
        });
  }
}
