package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.constantes.ReclamacionConstante.NUMERO_SINIESTRO;

import com.sura.reclamaciones.models.PagoEmpresarial;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionSiniestroStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PagoDefinition {

  @Steps NuevoPagoStep nuevoPagoStep;
  @Steps GenericStep genericStep;
  @Steps ConsumoServicioCreacionSiniestroStep crearSiniestro;

  PagoEmpresarial pagoEmpresarial;

  @Dado("^que se tiene el siniestro del producto (.*)$")
  public void queSeTieneElSiniestroDelProductoProducto(String strTipoProducto) throws IOException {
    crearSiniestro.asignarValoresSiniestro(strTipoProducto);
    crearSiniestro.siniestrarPolizaEmpresarialAtr();
    pagoEmpresarial =
        new PagoEmpresarial((genericStep.getFilasModelo("pago_empresarial", strTipoProducto)));
    nuevoPagoStep.consultarNumeroReclamacion(Serenity.sessionVariableCalled(NUMERO_SINIESTRO));
  }

  @Cuando(
      "^se realice un pago (.*) a un (.*) por medio de (.*) el cual cuenta con una linea de reserva (.*) donde el responsable (.*) es Sura por una retención de (.*)$")
  public void generarPagoReclamacion(
      String lineaReserva,
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String soloSura,
      String codigoRetencion) {
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(
        lineaReserva,
        tipoPago,
        beneficiarioPago,
        metodoPago,
        soloSura,
        codigoRetencion,
        pagoEmpresarial.getLstPago());
  }

  @Entonces("^se genera una orden de pago para que le sea entregado al usuario$")
  public void verificarPago() {
    nuevoPagoStep.verificarPagoRealizado(pagoEmpresarial.getLstPago());
  }
}
