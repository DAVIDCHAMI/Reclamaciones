package com.sura.reclamaciones.definitions.autos;

import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;
import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import java.io.IOException;
import java.util.List;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.PersonaReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import net.serenitybdd.core.Serenity;
import com.sura.reclamaciones.models.PagoSiniestro;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class PagoSiniestroDefinition
{
  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;
  @Steps GenericStep genericStep;
  @Steps NuevoPagoStep nuevoPagoStep;
  @Steps PagoSiniestro pagoSiniestro;
  String cobertura;
  List<ReclamacionAuto> lstReclamacionAuto;
  List<PersonaReclamacionAuto> lstPersonaLesionada;
  List<PersonaReclamacionAuto> lstConductor;
  List<Vehiculo> lstVehiculoParam;
  ReclamacionAuto parametroAviso = new ReclamacionAuto();
  PersonaReclamacionAuto parametroPersonaReclamacionAuto = new PersonaReclamacionAuto();
  PersonaReclamacionAuto parametroPersonaConductorAuto = new PersonaReclamacionAuto();
  Vehiculo reclamacionVehiculo = new Vehiculo();

  @Dado("^que se tiene un siniestro de (.*) con un tipo de cobertura de (.*)$")
  public void crearSiniestroAutos(String filtroCsv, String tipoCobertura) throws IOException {
    cobertura = tipoCobertura;
    parametroPersonaReclamacionAuto =
        new PersonaReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION_PERSONA,
                ConstanteGlobal.PARAMETRO_PERSONA_LESIONADA));
    lstPersonaLesionada = parametroPersonaReclamacionAuto.getLstPersonaReclamacionAuto();
    parametroPersonaConductorAuto =
        new PersonaReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_RECLAMACION_PERSONA,
                ConstanteGlobal.PARAMETRO_PERSONA_CONDUCTOR));
    lstConductor = parametroPersonaConductorAuto.getLstPersonaReclamacionAuto();
    reclamacionVehiculo =
        new Vehiculo(genericStep.getFilasModelo(ConstanteGlobal.PARAMETROS_VEHICULO, filtroCsv));
    lstVehiculoParam = reclamacionVehiculo.getVehiculos();
    parametroAviso =
        new ReclamacionAuto(
            genericStep.getFilasModelo(
                ConstanteGlobal.PARAMETROS_SINIESTRO_AUTOS,
                ConstanteGlobal.PARAMETRO_CREACION_AVISO_AUTOS_WS));
    lstReclamacionAuto = parametroAviso.getLstReclamacionAuto();
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos(
        lstReclamacionAuto, lstPersonaLesionada, lstConductor, lstVehiculoParam);
    creacionAvisoSiniestroAutoStep.verificarSiniestro();
  }

  @Cuando("^se genere un pago (.*) al beneficiario (.*) por el medio de pago de (.*) sobre la linea de reserva (.*) donde el responsable (.*) es Sura con una retención de (.*)$")
  public void crearPagoAutos(String tipoPago, String beneficiarioPago, String metodoPago, String lineaReserva, String aplicaSoloSura, String codigoRetencion) throws IOException {
    nuevoPagoStep.consultarNumeroReclamacionAutos(
        Serenity.sessionVariableCalled(ReclamacionConstante.NUMERO_SINIESTRO));
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(
                String.valueOf(PAGO_SINIESTRO.getValor()), cobertura)));
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



