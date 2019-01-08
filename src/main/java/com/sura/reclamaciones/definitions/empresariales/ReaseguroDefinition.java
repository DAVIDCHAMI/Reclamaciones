package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.utils.Constantes.PAGO;
import static com.sura.reclamaciones.utils.Constantes.RECUPERO;
import static com.sura.reclamaciones.utils.Constantes.RESERVA;
import static com.sura.reclamaciones.utils.NombresCsv.CONTRATO;
import static com.sura.reclamaciones.utils.NombresCsv.PAGO_EMPRESARIAL;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.models.PagoEmpresarial;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionSiniestroStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.reaseguro.ReaseguroStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;

import net.thucydides.core.annotations.Steps;

public class ReaseguroDefinition {

  private String strTipoContrato;
  private String strTransaccion;

  @Steps ReaseguroStep reaseguroStep;

  @Steps GenericStep genericStep;

  @Steps ConsumoServicioCreacionSiniestroStep creacionSiniestro;

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps RecuperoStep recuperoStep;

  @Cuando("^se genere una reclamación de un contrato tipo (.*)$")
  public void crearSiniestro(String tipoContratoPoliza) throws IOException {
    strTransaccion = RESERVA.getValor();
    strTipoContrato = tipoContratoPoliza;
    creacionSiniestro.asignarValoresSiniestro(tipoContratoPoliza);
    creacionSiniestro.siniestrarPolizaEmpresarialAtr();
    reaseguroStep.buscarReclamacion();
  }

  @Cuando(
      "^se realice al siniestro un pago (.*) a un (.*) por medio de (.*) el cual cuenta con una línea de reserva (.*) donde el responsable (.*) es Sura por una retención de (.*)$")
  public void realizarPagoSiniestroEmpresarial(
      String lineaReserva,
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String aplicaSoloSura,
      String codigoRetencion)
      throws IOException {
    strTransaccion = PAGO.getValor();
    PagoEmpresarial pagoEmpresarial =
        new PagoEmpresarial(
            (genericStep.getFilasModelo(PAGO_EMPRESARIAL.getValor(), strTipoContrato)));
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

  @Y("^se realice al siniestro un recupero de tipo (.*) con un código de retención (.*)$")
  public void realizarRecuperoSiniestroEmpresarial(
      String strTipoRecupero, String strCodigoRetencionRecupero) throws IOException {
    strTransaccion = RECUPERO.getValor();
    Recupero recupero =
        new Recupero(genericStep.getFilasModelo(RECUPERO.getValor(), strTipoContrato));
    recuperoStep.seleccionarRecupero();
    recuperoStep.diligenciarCreacionRecupero(
        recupero.getLstRecupero(), strTipoRecupero, strCodigoRetencionRecupero);
  }

  @Entonces(
      "^para la transacción (.*) se distribuye el reaseguro según el retenido y el cedido de manera adecuada$")
  public void verificarReaseguro(String tipoTransaccion) throws IOException {
    Contrato contrato =
        new Contrato(genericStep.getFilasModelo(CONTRATO.getValor(), strTipoContrato));
    reaseguroStep.verificarReaseguro(contrato.getLstContrato(), strTransaccion);
  }
}
