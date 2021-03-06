package com.sura.reclamaciones.definitions.empresariales.pagos;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.BusquedaPolizaStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.ExposicionStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.InformacionBasicaStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.InformacionReclamacionStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.NuevaReclamacionGuardadaStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.empresariales.PagoAutomaticoStep;
import com.sura.reclamaciones.utils.enums.NombresCsv;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class PagoAutomaticoSiniestroDefinition {

  ReclamacionEmpresarial reclamacionEmpresarial;

  private String productoPoliza;

  @Steps PagoAutomaticoStep pagoAutomatico;

  @Steps BusquedaPolizaStep busquedaPolizaStep;

  @Steps InformacionBasicaStep informacionBasicaStep;

  @Steps InformacionReclamacionStep informacionReclamacionStep;

  @Steps NuevaReclamacionGuardadaStep nuevaReclamacionGuardadaStep;

  @Steps ExposicionStep exposicionStep;

  @Dado("^que se tiene una póliza del producto (.*)$")
  public void obtenerPoliza(String producto) throws IOException {
    productoPoliza = producto;
    reclamacionEmpresarial =
        new ReclamacionEmpresarial(
            obtenerDatosPrueba(NombresCsv.RECLAMACION_EMPRESARIAL.getValor(), productoPoliza));
    busquedaPolizaStep.buscarPolizaEmpresarial(reclamacionEmpresarial.getLstReclamo());
  }

  @Cuando("^se realiza un siniestro por causa (.*) con valor de pretensión (.*) e incidente (.*)$")
  public void realizarSiniestro(String causa, String valorPretension, String tipoIncidente) {
    informacionBasicaStep.diligenciarInformacionBasica(reclamacionEmpresarial.getLstReclamo());
    informacionReclamacionStep.diligenciarInformacionIncidente(
        causa, valorPretension, tipoIncidente);
  }

  @Entonces("^se genera una reclamación con exposición automática (.*)$")
  public void verificarGeneracionExposicionAutomatica(String tipoExposicion) {
    nuevaReclamacionGuardadaStep.abrirNuevaReclamacionGuardada();
    exposicionStep.validarExposicionEmpresariales(tipoExposicion);
  }

  @Y("^una reserva automática$")
  public void verificarGeneracionReservaAutomatica() throws IOException {
    Reserva reserva =
        new Reserva(
            obtenerDatosPrueba(NombresCsv.PARAMETRO_LINEA_RESERVA.getValor(), productoPoliza));
    pagoAutomatico.verificarMontoReservaAutomatica(reserva.getLstReserva());
  }

  @Y("^un pago automático$")
  public void verificarGeneracionPagoAutomatico() throws IOException {
    PagoSiniestro pago =
        new PagoSiniestro(obtenerDatosPrueba(NombresCsv.PAGO_SINIESTRO.getValor(), productoPoliza));
    pagoAutomatico.verificarPagoAutomatico(pago.getLstPago());
  }
}
