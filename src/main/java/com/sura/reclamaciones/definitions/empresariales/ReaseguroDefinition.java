package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.constantes.ReclamacionConstante.NUMERO_SINIESTRO;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.models.PagoEmpresarial;
import com.sura.reclamaciones.models.Reasegurador;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionSiniestroStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.reaseguro.ReaseguroStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ReaseguroDefinition {

  private String tipoContrato;

  PagoEmpresarial pagoEmpresarial;

  @Steps ReaseguroStep reaseguroStep;

  @Steps GenericStep genericStep;

  @Steps ConsumoServicioCreacionSiniestroStep creacionSiniestro;

  @Steps
  NuevoPagoStep nuevoPagoStep;

  @Cuando(
      "^se genere una reclamacion de un contrato tipo (.*)$")
  public void crearSiniestro(
      String tipoContratoPoliza)
      throws IOException {
    tipoContrato = tipoContratoPoliza;
    creacionSiniestro.asignarValoresSiniestro(tipoContratoPoliza);
    creacionSiniestro.siniestrarPolizaEmpresarialAtr();
    reaseguroStep.buscarReclamacion();
  }

  @Entonces(
      "^para la transaccion (.*) se distribuye el reaseguro segun el retenido y el cedido de manera adecuada$")
  public void verificarReaseguro(
      String tipoTransaccion)
      throws IOException {
    Contrato contrato1 = new Contrato(genericStep.getFilasModelo("contrato", tipoContrato));
   reaseguroStep.verificarReaseguro(
        contrato1.getLstContrato());
  }

  @Cuando("^se realice al siniestro un pago (.*) a un (.*) por medio de (.*) el cual cuenta con una linea de reserva (.*) donde el responsable (.*) es Sura por una retención de (.*)$")
  public void RealizarPagoSiniestroEmpresarial(String lineaReserva,
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String aplicaSoloSura,
      String codigoRetencion)
      throws IOException {
    pagoEmpresarial =
        new PagoEmpresarial((genericStep.getFilasModelo("pago_empresarial",tipoContrato)));
    nuevoPagoStep.consultarNumeroReclamacion(Serenity.sessionVariableCalled(NUMERO_SINIESTRO));
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(lineaReserva,
        tipoPago,
        beneficiarioPago,
        metodoPago,
        aplicaSoloSura,
        codigoRetencion,
        pagoEmpresarial.getLstPago());
  }
}
