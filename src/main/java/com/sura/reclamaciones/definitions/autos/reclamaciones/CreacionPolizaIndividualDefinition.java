package com.sura.reclamaciones.definitions.autos.reclamaciones;

import static com.sura.reclamaciones.utils.enums.NombresCsv.ASEGURADO;
import static com.sura.reclamaciones.utils.enums.NombresCsv.COBERTURAS_AUTOS;
import static com.sura.reclamaciones.utils.enums.NombresCsv.DICCIONARIO_COBERTURAS_AUTOS;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PARAMETROS_VEHICULO;
import static com.sura.reclamaciones.utils.enums.NombresCsv.TOMADOR;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_PC_NUMERO_POLIZA;

import com.sura.reclamaciones.models.Asegurado;
import com.sura.reclamaciones.models.CoberturaVehiculo;
import com.sura.reclamaciones.models.Tomador;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.guidewire.policycenter.autos.ServicioExpedicionAutosIndividualStep;
import com.sura.reclamaciones.utils.UtilidadesCSV;
import com.sura.reclamaciones.utils.enums.Separador;
import cucumber.api.java.es.Dado;
import java.io.IOException;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class CreacionPolizaIndividualDefinition {

  @Steps ServicioExpedicionAutosIndividualStep servicioExpedicionAutosIndividualStep;

  @Dado(
      "^se tiene una póliza de autos individual con plan (.+) de vigencia (.+) con (\\d+) (?:día|días) de (.+)$")
  public void consumirServicioExpedicion(
      String planAutos, String tipoVigencia, int cantidadDias, String terminoInicioVigencia)
      throws IOException {
    final String filtroAsegurado = "asegurado riesgo estándar";
    final String filtroTomador = "tomador riesgo estándar";
    final String filtroVehiculo = "vehículo riesgo estándar";
    final String filtroCoberturas;
    Asegurado asegurado =
        new Asegurado(UtilidadesCSV.obtenerPrimerDatoPrueba(ASEGURADO.getValor(), filtroAsegurado));
    Tomador tomador =
        new Tomador(UtilidadesCSV.obtenerPrimerDatoPrueba(TOMADOR.getValor(), filtroTomador));
    Vehiculo vehiculo =
        new Vehiculo(
            UtilidadesCSV.obtenerPrimerDatoPrueba(PARAMETROS_VEHICULO.getValor(), filtroVehiculo));
    filtroCoberturas =
        String.format(
            "%s%s%s%s%s",
            vehiculo.getClaseVehiculo(),
            Separador.SEPARADOR_VIRGULILLA.getValor(),
            planAutos,
            Separador.SEPARADOR_VIRGULILLA.getValor(),
            vehiculo.getModelo());
    List<CoberturaVehiculo> lstCoberturasVehiculo =
        CoberturaVehiculo.obtenerListaCoberturas(
            UtilidadesCSV.obtenerDatosPrueba(COBERTURAS_AUTOS.getValor(), filtroCoberturas),
            UtilidadesCSV.obtenerDatosPrueba(DICCIONARIO_COBERTURAS_AUTOS.getValor(), ""));
    servicioExpedicionAutosIndividualStep.asignarInformacionFechas(
        tipoVigencia, terminoInicioVigencia, cantidadDias);
    servicioExpedicionAutosIndividualStep.asignarInformacionCliente(tomador, asegurado);
    servicioExpedicionAutosIndividualStep.asignarInformacionVehiculo(
        vehiculo, lstCoberturasVehiculo);
    servicioExpedicionAutosIndividualStep.expedirPolizaIndividual();
    servicioExpedicionAutosIndividualStep.verificarCreacionPoliza();
    Serenity.setSessionVariable(SESION_PC_NUMERO_POLIZA)
        .to(servicioExpedicionAutosIndividualStep.getNumeroPoliza());
  }
}
