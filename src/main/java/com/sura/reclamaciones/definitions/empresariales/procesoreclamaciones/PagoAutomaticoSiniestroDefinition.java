package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;

import com.sura.reclamaciones.constantes.NombresCsv;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.steps.exposiciones.ExposicionStep;
import com.sura.reclamaciones.steps.generics.PagoAutomaticoStep;
import com.sura.reclamaciones.steps.notificacionaviso.BuscarPolizaStep;
import com.sura.reclamaciones.steps.notificacionaviso.InformacionBasicaStep;
import com.sura.reclamaciones.steps.notificacionaviso.InformacionReclamacionStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionGuardadaStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class PagoAutomaticoSiniestroDefinition {

  String productoPoliza = "";

  @Steps PagoAutomaticoStep pagoAutomaticoStep;
  @Steps ReclamacionEmpresarial reclamacionEmpresarial;

  @Steps BuscarPolizaStep buscarPolizaStep;

  @Steps InformacionBasicaStep informacionBasicaStep;

  @Steps InformacionReclamacionStep informacionReclamacionStep;

  @Steps NuevaReclamacionGuardadaStep nuevaReclamacionGuardadaStep;

  @Steps ExposicionStep exposicionStep;

  @Dado("^que se tiene una póliza del producto (.*)$")
  public void obtenerPoliza(String producto) throws IOException {
    reclamacionEmpresarial =
        new ReclamacionEmpresarial(
            obtenerDatosPrueba(NombresCsv.RECLAMACION_EMPRESARIAL.getValor(), producto));
    buscarPolizaStep.buscarPolizaEmpresarial(reclamacionEmpresarial.getLstReclamo());
  }

  @Cuando("^se realiza un siniestro por causa (.*) con valor de pretensión (.*) e incidente (.*)$")
  public void realizarSiniestro(String causa, String valorPretension, String tipoIncidente) {
    informacionBasicaStep.diligenciarInformacionBasica(reclamacionEmpresarial.getLstReclamo());
    informacionReclamacionStep.diligenciarInformacionIncidente(
        causa, valorPretension, tipoIncidente);
  }

  @Entonces("^se genera una reclamación con exposición automática (.*)$")
  public void verificarGeneracionExposicionAutomatica(String tipoExposicion) {
    nuevaReclamacionGuardadaStep.abrirReclamacionGuardada();
    exposicionStep.validarExposicionEmpresariales(tipoExposicion);
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
