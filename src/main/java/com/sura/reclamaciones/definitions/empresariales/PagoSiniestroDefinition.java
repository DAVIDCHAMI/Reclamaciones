package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.constantes.Constantes.SI_RIESGO_CONSULTABLE;
import static com.sura.reclamaciones.constantes.Constantes.TIPO_CATEGORIA_COSTO_GASTO;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.reserva.ReversionConstitucionStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PagoSiniestroDefinition {

  @Steps
  NuevoPagoStep nuevoPagoStep;

  @Steps
  ReversionConstitucionStep reversionConstitucionStep;

  @Steps
  GenericStep genericStep;

  PagoSiniestro pagoSiniestro;

  @Cuando(
      "^se realice un pago (.*) a (.*) por medio de (.*) el cual cuenta con una línea de reserva (.*) por (.*) de (.*) por valor igual a (.*) donde el responsable (.*) es Sura por una retención de (.*) el asegurado (.*) es riesgo consultable$")
  public void generarPagoReclamacion(
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String lineaReserva,
      String categoriaCosto,
      String tipoCosto,
      String valorNuevaReserva,
      String aplicaSoloSura,
      String codigoRetencion,
      String riesgoConsultable
  )
      throws IOException {
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(
                String.valueOf(PAGO_SINIESTRO.getValor()),
                Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()))));
    nuevoPagoStep.consultarNumeroReclamacion();
    if ((riesgoConsultable.equals(SI_RIESGO_CONSULTABLE.getValor()))&&(categoriaCosto.contains(
        TIPO_CATEGORIA_COSTO_GASTO.getValor()))){
      reversionConstitucionStep.crearNuevaLineaReserva(lineaReserva,tipoCosto, categoriaCosto, valorNuevaReserva);
    }
    nuevoPagoStep.crearNuevoPago();
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(
        lineaReserva,
        tipoPago,
        beneficiarioPago,
        metodoPago,
        aplicaSoloSura,
        codigoRetencion,
        pagoSiniestro.getLstPago());
  }

  @Entonces("^(.*) se genera una orden de pago para que le sea entregado al usuario$")
  public void verificarPago(String aplicaOrdenPago) {
    nuevoPagoStep.verificarPagoRealizado(pagoSiniestro.getLstPago());
  }

}
