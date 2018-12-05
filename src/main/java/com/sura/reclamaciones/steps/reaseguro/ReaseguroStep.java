package com.sura.reclamaciones.steps.reaseguro;

import static com.sura.reclamaciones.utils.Constantes.RETENCION_PURA;
import static org.junit.Assert.assertTrue;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.models.Reasegurador;
import com.sura.reclamaciones.pages.reaseguro.ReaseguroDetalladoTransaccionPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;

public class ReaseguroStep {

  @Page ReaseguroDetalladoTransaccionPage reaseguroDetalladoTransaccionPage;

  public void verificarReaseguro(
      List<Contrato> lstContrato1,
      List<Reasegurador> lstReasegurador1,
      List<Reasegurador> lstReasegurador2,
      List<Reasegurador> lstReasegurador3) {
    reaseguroDetalladoTransaccionPage.ingresarSeccionReaseguroDetallado();
    lstContrato1.forEach(
        verificador -> {
          assertTrue(
              "La retencion nula es mayor a lo esperado",
              reaseguroDetalladoTransaccionPage.verificarRetencionPura(
                  Double.parseDouble(RETENCION_PURA.getValor())));
          assertTrue(
              "El retenido no corresponde a lo esperado",
              reaseguroDetalladoTransaccionPage.verificarRetenido(
                  lstReasegurador2,
                  verificador.getDeducibleMinimo(),
                  verificador.getPorcentajeDeducibleminimo(),
                  verificador.getProporcionCuotaParte()));
          assertTrue(
              "El cedido no corresponde a lo esperado",
              reaseguroDetalladoTransaccionPage.verificarCedido(
                  lstReasegurador2,
                  verificador.getDeducibleMinimo(),
                  verificador.getPorcentajeDeducibleminimo(),
                  verificador.getProporcionCuotaParte()));
        });
  }
}
