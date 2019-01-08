package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.models.PagoEmpresarial;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.utils.NombresCsv;
import com.sura.reclamaciones.utils.VariablesSesion;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PagoSiniestroDefinition {

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps GenericStep genericStep;

  PagoEmpresarial pagoEmpresarial;

  @Cuando(
      "^se realice un pago (.*) a (.*) por medio de (.*) el cual cuenta con una linea de reserva (.*) donde el responsable (.*) es Sura por una retención de (.*)$")
  public void generarPagoReclamacion(
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String lineaReserva,
      String aplicaSoloSura,
      String codigoRetencion)
      throws IOException {
    pagoEmpresarial =
        new PagoEmpresarial(
            (genericStep
                .getFilasModelo(
                    String.valueOf(NombresCsv.PAGO_EMPRESARIAL),
                    Serenity.sessionVariableCalled(VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL))));
    nuevoPagoStep.consultarNumeroReclamacion();
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(
        lineaReserva,
        tipoPago,
        beneficiarioPago,
        metodoPago,
        aplicaSoloSura,
        codigoRetencion,
        pagoEmpresarial.getLstPago());
  }

  @Entonces("^se genera una orden de pago para que le sea entregado al usuario$")
  public void verificarPago() {
    nuevoPagoStep.verificarPagoRealizado(pagoEmpresarial.getLstPago());
  }
}
