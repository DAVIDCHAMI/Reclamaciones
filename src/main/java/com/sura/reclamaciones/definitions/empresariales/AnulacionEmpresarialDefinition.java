package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.constantes.ReclamacionConstante.NUMERO_SINIESTRO;
import static com.sura.reclamaciones.utils.Constantes.ESTADO_ANULACION;

import com.sura.reclamaciones.models.AnulacionEmpresarial;
import com.sura.reclamaciones.models.PagoEmpresarial;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.anulacionempresarial.AnulacionEmpresarialStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionSiniestroStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class AnulacionEmpresarialDefinition {

  @Steps GenericStep genericStep;

  @Steps AnulacionEmpresarialStep anulacionEmpresarialStep;

  @Steps RecuperoStep recuperoStep;

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps ConsumoServicioCreacionSiniestroStep crearSiniestro;

  Recupero recupero;
  AnulacionEmpresarial anulacionEmpresarial;
  PagoEmpresarial pagoEmpresarial;

  @Dado("^que se cree un siniestro de (.*)$")
  public void crearSiniestro(String strTipoProducto) throws IOException {
    crearSiniestro.asignarValoresSiniestro(strTipoProducto);
    crearSiniestro.siniestrarPolizaEmpresarialAtr();
  }

  @Y("^que se realice un pago, de un siniestro de una poliza empresarial con producto (.*) y código de retención (.*)$")
  public void crearPago(String strTipoProducto, String strCodigoRetencion) throws IOException {
    pagoEmpresarial =
        new PagoEmpresarial((genericStep.getFilasModelo("pago_empresarial", strTipoProducto)));
    anulacionEmpresarial =
        new AnulacionEmpresarial(
            (genericStep.getFilasModelo("anulacion_empresarial", strTipoProducto)));
    anulacionEmpresarial
        .getLstAnulacionEmpresarial()
        .forEach(
            ajustador -> {
              nuevoPagoStep.consultarNumeroReclamacion(
                  Serenity.sessionVariableCalled(NUMERO_SINIESTRO));
              nuevoPagoStep.ingresarInformacionBeneficiarioPago(
                  ajustador.getTipoPago(),
                  ajustador.getBeneficiarioPago(),
                  ajustador.getMetodoPago(),
                  ajustador.getLineaReserva(),
                  ajustador.getSoloSura(),
                  strCodigoRetencion,
                  pagoEmpresarial.getLstPago());
            });
  }

  @Cuando("^se realice la anulacion del pago$")
  public void anularPago() {
    anulacionEmpresarialStep.ingresarAnulacionPago(pagoEmpresarial.getLstPago());
  }

  @Entonces("^se debe obtener la anulacion del pago, quedando en estado anulado$")
  public void verificarAnulacionPago() {
    anulacionEmpresarialStep.verificarAnulacionRealizada(ESTADO_ANULACION.getValor());
  }

  @Y(
      "^que se realice una transaccion de pago y una transaccion de recupero, de un siniestro de una poliza empresarial con producto (.*) y código de retención (.*)$")
  public void crearPagoRecupero(String strTipoProducto, String strCodigoRetencion)
      throws IOException {
    pagoEmpresarial =
        new PagoEmpresarial((genericStep.getFilasModelo("pago_empresarial", strTipoProducto)));
    anulacionEmpresarial =
        new AnulacionEmpresarial(
            (genericStep.getFilasModelo("anulacion_empresarial", strTipoProducto)));
    anulacionEmpresarial
        .getLstAnulacionEmpresarial()
        .forEach(
            ajustador -> {
              nuevoPagoStep.consultarNumeroReclamacion(
                  Serenity.sessionVariableCalled(NUMERO_SINIESTRO));
              nuevoPagoStep.ingresarInformacionBeneficiarioPago(
                  ajustador.getTipoPago(),
                  ajustador.getBeneficiarioPago(),
                  ajustador.getMetodoPago(),
                  ajustador.getLineaReserva(),
                  ajustador.getSoloSura(),
                  strCodigoRetencion,
                  pagoEmpresarial.getLstPago());
            });
    if (strTipoProducto.equals(strTipoProducto)) {
      recupero = new Recupero(genericStep.getFilasModelo("recupero", strTipoProducto));
      recuperoStep.seleccionarRecupero();
      recuperoStep.diligenciarCreacionRecupero(
          recupero.getLstRecupero(), recupero.getCategoriaRecupero(), strCodigoRetencion);
    }
  }

  @Cuando("^se realice la anulacion del recupero$")
  public void realizarAnulacionTransaccion() {
    anulacionEmpresarialStep.ingresarAnulacionRecupero(recupero.getLstRecupero());
  }

  @Entonces("^se debe obtener la anulacion del recupero, quedando en estado anulado$")
  public void verificarAnulacionRecupero() {
    anulacionEmpresarialStep.verificarAnulacionRealizada(ESTADO_ANULACION.getValor());
  }
}