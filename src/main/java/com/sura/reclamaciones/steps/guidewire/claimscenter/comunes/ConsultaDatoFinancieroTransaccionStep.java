package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.Constantes.ITERACIONES_PAGO;
import static com.sura.reclamaciones.utils.enums.Constantes.VALOR_CERO;
import static com.sura.reclamaciones.utils.enums.Posiciones.POSICION_FILA;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;

import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.ConsultaReclamacionPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.DatoFinancieroTransaccionPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.DatoReservaPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.empresariales.PlanTrabajoActividadPage;
import com.sura.reclamaciones.utils.constantes.MenuConstante;
import net.serenitybdd.core.Serenity;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ConsultaDatoFinancieroTransaccionStep {

  private static final String TIPO_CATEGORIA_COSTO_GASTO = "Gasto";

  @Page DatoFinancieroTransaccionPage datoFinancieroTransaccionPage;

  @Page DatoReservaPage datoReservaPage;

  @Page MenuClaimPage menuClaimPage;

  @Page PlanTrabajoActividadPage planTrabajoActividadPage;

  @Page ConsultaReclamacionPage consultaReclamacionPage;

  public void verificarEstadoTransaccionReserva(String strEstadoTransaccionReserva) {
    final String TRANSACCION_RESERVA = "Reservas";
    final String ESTADO_SOLICITADO = "Solicitado";
    final int POSICION_ESTADO_SOLICITADO = 2;
    String strEstadoTransaccion = "";
    String numeroReclamacion = "";
    int posicionEstadoVerificar;
    if (strEstadoTransaccionReserva.equals(ESTADO_SOLICITADO)) {
      posicionEstadoVerificar = POSICION_ESTADO_SOLICITADO;
    } else {
      posicionEstadoVerificar = Integer.parseInt(POSICION_FILA.getValor());
    }
    for (int i = 0; i <= Integer.parseInt(ITERACIONES_PAGO.getValor()); i++) {
      planTrabajoActividadPage.realizarEsperaCarga();
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
          MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
      datoFinancieroTransaccionPage.seleccionarTipoTransaccion(TRANSACCION_RESERVA);
      strEstadoTransaccion =
          datoFinancieroTransaccionPage.obtenerEstadoReservaRealizada(posicionEstadoVerificar);
      boolean estadoTransaccionPantalla = strEstadoTransaccionReserva.equals(strEstadoTransaccion);
      if (estadoTransaccionPantalla) {
        break;
      }
    }
    MatcherAssert.assertThat(
        "El estado de la reserva es diferente al de " + strEstadoTransaccionReserva,
        strEstadoTransaccionReserva.equals(strEstadoTransaccion));
    numeroReclamacion = consultaReclamacionPage.obtenerNumeroSiniestro();
    Serenity.setSessionVariable(SESION_CC_NUMERO_SINIESTRO.getValor()).to(numeroReclamacion);
  }

  public void verificarDeducibleReserva(String categoriaCosto, String deducible) {
    String deducibleVisualizado;
    if (categoriaCosto.contains(TIPO_CATEGORIA_COSTO_GASTO)) {
      deducibleVisualizado = VALOR_CERO.getValor();
    } else {
      datoFinancieroTransaccionPage.ingresarDatoReserva();
      deducibleVisualizado = datoReservaPage.obtenerCantidadReserva();
    }
    MatcherAssert.assertThat(
        "Se esperaba un deducible de: "
            + deducible
            + " Pero se obtuvo un deducible de: "
            + deducibleVisualizado,
        deducibleVisualizado.equals(deducible));
  }
}
