package com.sura.reclamaciones.steps.reaseguro;

import static com.sura.reclamaciones.utils.Constantes.NUMERO_SINIESTRO;
import static com.sura.reclamaciones.utils.Constantes.REASEGURO_DETALLADO;
import static com.sura.reclamaciones.utils.Constantes.RETENCION_PURA;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.reaseguro.ReaseguroDetalladoTransaccionPage;
import com.sura.reclamaciones.utils.Constantes;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
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

  @Step
  public void verificarReaseguro(List<Contrato> lstContrato, String strTransaccion) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(REASEGURO_DETALLADO.getValor());
    lstContrato.forEach(
        verificador ->
            MatcherAssert.assertThat(
                "El reaseguro no se distribuyó de forma correcta",
                reaseguroDetalladoTransaccionPage.verificarReaseguro(
                    Double.parseDouble(RETENCION_PURA.getValor()),
                    strTransaccion,
                    verificador.getPorcentajeRetenido(),
                    verificador.getDeducibleMinimo(),
                    verificador.getPorcentajeDeducibleMinimo(),
                    verificador.getProporcionCuotaParte())));
  }
}
