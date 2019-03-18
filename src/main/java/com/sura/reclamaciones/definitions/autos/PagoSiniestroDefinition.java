package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.poliza.ConsumoServicioExpedicionAutoStep;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

import static com.sura.reclamaciones.constantes.NombresCsv.*;

public class PagoSiniestroDefinition {

  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;

  @Steps ConsumoServicioExpedicionAutoStep consumoServicioExpedicionAutoStep;

  @Steps GenericStep genericStep;

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps PagoSiniestro pagoSiniestro;

  String cobertura;

  @Dado("^que se tiene un siniestro de (.*) con un tipo de cobertura de (.*)$")
  public void crearSiniestroAutos(String tipoReserva, String tipoCobertura) throws IOException {
    cobertura = tipoCobertura;
    PersonaReclamacion parametroPersonaReclamacionAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION_PERSONA.getValor(), PARAMETRO_PERSONA_LESIONADA.getValor()));
    PersonaReclamacion parametroPersonaConductorAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION_PERSONA.getValor(), PARAMETRO_PERSONA_CONDUCTOR.getValor()));
    Vehiculo reclamacionVehiculo =
        new Vehiculo(genericStep.getFilasModelo(PARAMETROS_VEHICULO.getValor(), tipoReserva));
    ReclamacionAuto parametroAviso =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_SINIESTRO_AUTOS.getValor(),
                PARAMETRO_CREACION_AVISO_AUTOS_WS.getValor()));
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos(
        parametroAviso.getLstReclamacionAuto(),
        parametroPersonaReclamacionAuto.getLstPersonaReclamacion(),
        parametroPersonaConductorAuto.getLstPersonaReclamacion(),
        reclamacionVehiculo.getLstVehiculos());
    creacionAvisoSiniestroAutoStep.verificarSiniestro();
  }

  @Dado(
      "^se genere un pago (.*) al beneficiario (.*) por el medio de pago de (.*) sobre la linea de reserva (.*) donde el responsable (.*) es Sura con una retención de (.*)$")
  public void crearPagoAutos(
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String lineaReserva,
      String aplicaSoloSura,
      String codigoRetencion)
      throws IOException {
    nuevoPagoStep.consultarNumeroReclamacionAutos(
        Serenity.sessionVariableCalled(ReclamacionConstante.NUMERO_SINIESTRO));
    nuevoPagoStep.seleccionarExposicionAutomatica();
    nuevoPagoStep.declararReclamacionPerdidaTotal();
    nuevoPagoStep.ingresarEstadoLegalReclamacion();
    nuevoPagoStep.crearNuevoPago();
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(String.valueOf(PAGO_SINIESTRO.getValor()), cobertura)));
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(
        lineaReserva,
        tipoPago,
        beneficiarioPago,
        metodoPago,
        aplicaSoloSura,
        codigoRetencion,
        pagoSiniestro.getLstPago());
  }

  @Entonces("^se obtiene el pago del beneficiario$")
  public void verificarPagoAutos()
  {
    nuevoPagoStep.verificarPagoRealizado(pagoSiniestro.getLstPago());
  }
}
