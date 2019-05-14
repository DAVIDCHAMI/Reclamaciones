package com.sura.reclamaciones.definitions.autos.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Filtros.CREACION_AVISO_AUTOS_WS;
import static com.sura.reclamaciones.constantes.Filtros.PERSONA_CONDUCTOR;
import static com.sura.reclamaciones.constantes.Filtros.PERSONA_LESIONADA;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_RECLAMACION_PERSONA_AUTO;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_SINIESTRO_AUTOS;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_VEHICULO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PagoSiniestroDefinition {

  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;

  @Steps GenericStep genericStep;

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps PagoSiniestro pagoSiniestro;

  String cobertura;

  @Dado("^que se tiene un siniestro de (.*) con un tipo de cobertura de (.*)$")
  public void crearSiniestroAutos(String origenSiniestro, String tipoCobertura) throws IOException {
    cobertura = tipoCobertura;
    PersonaReclamacion parametroPersonaReclamacionAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION_PERSONA_AUTO.getValor(), PERSONA_LESIONADA.getValor()));
    PersonaReclamacion parametroPersonaConductorAuto =
        new PersonaReclamacion(
            genericStep.getFilasModelo(
                PARAMETROS_RECLAMACION_PERSONA_AUTO.getValor(), PERSONA_CONDUCTOR.getValor()));
    Vehiculo reclamacionVehiculo =
        new Vehiculo(genericStep.getFilasModelo(PARAMETROS_VEHICULO.getValor(), origenSiniestro));
    ReclamacionAuto parametroAviso =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                PARAMETROS_SINIESTRO_AUTOS.getValor(), CREACION_AVISO_AUTOS_WS.getValor()));
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos(
        parametroAviso.getLstReclamacionAuto(),
        parametroPersonaReclamacionAuto.getLstPersonaReclamacion(),
        parametroPersonaConductorAuto.getLstPersonaReclamacion(),
        reclamacionVehiculo.getLstVehiculos());
    creacionAvisoSiniestroAutoStep.verificarSiniestro();
  }

  @Cuando(
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
        Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor()));
    nuevoPagoStep.declararReclamacionPerdidaTotal();
    nuevoPagoStep.ingresarEstadoLegalReclamacion();
    nuevoPagoStep.crearNuevoPago();
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(String.valueOf(PAGO_SINIESTRO.getValor()), cobertura)));
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(
        beneficiarioPago, metodoPago, aplicaSoloSura, pagoSiniestro.getLstPago());
    nuevoPagoStep.ingresarInformacionDetallePago(
        tipoPago, lineaReserva, codigoRetencion, pagoSiniestro.getLstPago());
  }

  @Entonces("^se obtiene el pago del beneficiario$")
  public void verificarPagoAutos() {
    nuevoPagoStep.verificarPagoRealizado(pagoSiniestro.getLstPago());
  }
}
