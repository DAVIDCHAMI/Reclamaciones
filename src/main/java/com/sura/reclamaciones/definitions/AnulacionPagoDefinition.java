package com.sura.reclamaciones.definitions;

import static com.sura.reclamaciones.constantes.Constantes.ESTADO_ANULACION;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.steps.anulaciontransaccion.AnulacionTransaccionStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class AnulacionPagoDefinition {

  @Steps GenericStep genericStep;

  @Steps AnulacionTransaccionStep anulacionTransaccionStep;

  PagoSiniestro pagoSiniestro;

  @Cuando("^se realice la anulación del pago$")
  public void anularTransaccionPagoEmpresariales() throws IOException {
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(
                PAGO_SINIESTRO.getValor(),
                Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()))));
    anulacionTransaccionStep.ingresarAnulacionPago(pagoSiniestro.getLstPago());
  }

  @Cuando("^se anula dicho pago con cobertura (.*)$")
  public void anularTransaccionPagoAutos(String cobertura) throws IOException {
    pagoSiniestro =
        new PagoSiniestro((genericStep.getFilasModelo(PAGO_SINIESTRO.getValor(), cobertura)));
    anulacionTransaccionStep.ingresarAnulacionPago(pagoSiniestro.getLstPago());
  }

  @Entonces("^se debe obtener la anulación del pago, quedando en estado anulado$")
  public void verificarAnulacionPago() {
    anulacionTransaccionStep.verificarAnulacionRealizada(ESTADO_ANULACION.getValor());
  }
}
