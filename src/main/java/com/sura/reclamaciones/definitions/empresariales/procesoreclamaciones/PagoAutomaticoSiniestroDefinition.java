package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;

import com.sura.reclamaciones.constantes.NombresCsv;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.steps.generics.PagoAutomaticoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class PagoAutomaticoSiniestroDefinition {

  String productoPoliza = "";

  @Steps PagoAutomaticoStep pagoAutomaticoStep;

  @Dado("^que se tiene una póliza del producto (.*)$")
  public void obtenerPoliza(String producto) throws IOException {
    //TO DO
  }

  @Cuando("^se realiza un siniestro por causa (.*) con valor de pretensión (.*) e incidente (.*)$")
  public void realizarSiniestro(String causa, String valorPretension, String tipoIncidente) {
    //TO DO
  }

  @Entonces("^se genera una reclamación con exposición automática (.*)$")
  public void verificarGeneracionExposicionAutomatica(String tipoExposicion) throws Throwable {
    //TO DO
  }

  @Y("^una reserva automática$")
  public void verificarGeneracionReservaAutomatica() throws IOException {
    productoPoliza = "Multiriesgo Corporativo pago automático 1";
    Reserva reserva =
        new Reserva(
            obtenerDatosPrueba(NombresCsv.PARAMETRO_LINEA_RESERVA.getValor(), productoPoliza));
    pagoAutomaticoStep.verificarMontoReservaAutomatica(reserva.getLstReserva());
  }

  @Y("^un pago automático$")
  public void verificarGeneracionPagoAutomatico() throws IOException {
    PagoSiniestro pago =
        new PagoSiniestro(obtenerDatosPrueba(NombresCsv.PAGO_SINIESTRO.getValor(), productoPoliza));
    pagoAutomaticoStep.verificarPagoAutomatico(pago.getLstPago());
  }
}
