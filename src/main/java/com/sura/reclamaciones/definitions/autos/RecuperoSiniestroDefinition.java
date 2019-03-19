package com.sura.reclamaciones.definitions.autos;

import static com.sura.reclamaciones.constantes.NombresCsv.*;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_SINIESTRO_AUTOS;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_CREACION_AVISO_AUTOS_WS;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.*;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class RecuperoSiniestroDefinition {
  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;

  @Steps RecuperoStep recuperoStep;

  @Steps GenericStep genericStep;

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps PagoSiniestro pagoSiniestro;

  Recupero recupero;

  String cobertura;

  @Dado("^que se tiene una reclamación de (.*) con un tipo de cobertura de (.*)$")
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
      "^se cree un pago (.*) al beneficiario (.*) por el medio de pago de (.*) sobre la linea de reserva (.*) donde el responsable (.*) es Sura con una retención de (.*)$")
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

    nuevoPagoStep.verificarPagoRealizado(pagoSiniestro.getLstPago());
  }

  @Cuando("^se cree el recupero por el tipo de (.*) con un código de retención (.*)$")
  public void crearRecuperoReclamacionAutos(String tipoRecupero, String codigoRetencion)
      throws IOException {
    recupero =
        new Recupero(
            (genericStep.getFilasModelo(String.valueOf(RECUPERO_SINIESTRO.getValor()), cobertura)));
    recuperoStep.seleccionarRecupero();
    recuperoStep.diligenciarCreacionRecupero(
        recupero.getLstRecupero(), tipoRecupero, codigoRetencion);
  }

  @Entonces("^se obtiene un ingreso de dinero sobre el siniestro$")
  public void verificarRecuperoAutos() {
    recuperoStep.verificarCreacionRecupero(recupero.getLstRecupero());
  }
}
