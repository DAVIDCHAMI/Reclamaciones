package com.sura.reclamaciones.steps.guidewire.claimscenter.empresariales;

import static com.sura.reclamaciones.utils.enums.Constantes.REASEGURO_DETALLADO;
import static com.sura.reclamaciones.utils.enums.Constantes.RETENCION_PURA;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.empresariales.ReaseguroDetalladoTransaccionPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ReaseguroStep {

  @Page ReaseguroDetalladoTransaccionPage reaseguroDetalladoTransaccionPage;

  @Page MenuClaimPage menuClaimPage;

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
                    verificador.getProporcionCuotaParte(),
                    verificador.getPorcentajeCoaseguroCedido())));
  }
}
