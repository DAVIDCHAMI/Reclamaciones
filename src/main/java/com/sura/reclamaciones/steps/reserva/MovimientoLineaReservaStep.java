package com.sura.reclamaciones.steps.reserva;

import static com.sura.reclamaciones.constantes.Constantes.CC_NOMBRE_CAMPO_VALOR_NUEVA_RESERVA;
import static com.sura.reclamaciones.constantes.Constantes.CC_POSICION_VALOR_RESERVA_EMPRESARIALES;
import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;
import static com.sura.reclamaciones.constantes.MenuConstante.RESERVA;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.reservas.EstablecerReservaPage;
import com.sura.reclamaciones.pages.reservas.TransaccionDatoFinancieroPage;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class MovimientoLineaReservaStep {

  private static final String NOMBRE_CAMPO_CATEGORIA_COSTO_RESERVA_EMPRESARIALES =
      "Categoría de costo";
  private static final String NOMBRE_CAMPO_EXPOSICION_LINEA_RESERVA_EMPRESARIALES = "Exposición";
  private static final String NOMBRE_CAMPO_TIPO_COSTO_RESERVA_EMPRESARIALES = "Tipo de costo";
  private static final String TIPO_CATEGORIA_COSTO_GASTO = "Gasto";

  @Page EstablecerReservaPage establecerReservaPage;

  @Page GeneralPage generalPage;

  @Page MenuClaimPage menuClaimPage;

  @Page TransaccionDatoFinancieroPage transaccionDatoFinancieroPage;

  public void ajustarReserva(String valorAjustar) {
    establecerReservaPage.ingresarReservasReclamacion();
    establecerReservaPage.eliminarReservaVacia();
    establecerReservaPage.diligenciarCampoLineaReserva(
        valorAjustar,
        CC_NOMBRE_CAMPO_VALOR_NUEVA_RESERVA.getValor(),
        Integer.parseInt(CC_POSICION_VALOR_RESERVA_EMPRESARIALES.getValor()));
  }

  public void crearNuevaLineaReserva(
      String lineaReserva, String tipoCosto, String categoriaCosto, String valorNuevaReserva) {
    menuClaimPage.seleccionarBotonAcciones();
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(RESERVA);
    generalPage.realizarEsperaCarga();
    establecerReservaPage.diligenciarCampoLineaReserva(
        lineaReserva,
        NOMBRE_CAMPO_EXPOSICION_LINEA_RESERVA_EMPRESARIALES,
        Integer.valueOf(VALOR_CERO.getValor()));
    establecerReservaPage.diligenciarCampoLineaReserva(
        categoriaCosto,
        NOMBRE_CAMPO_CATEGORIA_COSTO_RESERVA_EMPRESARIALES,
        Integer.valueOf(VALOR_CERO.getValor()));
    establecerReservaPage.diligenciarCampoLineaReserva(
        tipoCosto,
        NOMBRE_CAMPO_TIPO_COSTO_RESERVA_EMPRESARIALES,
        Integer.valueOf(VALOR_CERO.getValor()));
    establecerReservaPage.diligenciarCampoLineaReserva(
        valorNuevaReserva,
        CC_NOMBRE_CAMPO_VALOR_NUEVA_RESERVA.getValor(),
        Integer.parseInt(CC_POSICION_VALOR_RESERVA_EMPRESARIALES.getValor()));
  }

  public void verificarAjusteReserva(String categoriaCosto, String deducible) {
    String deducibleVisualizado;
    if (categoriaCosto.contains(TIPO_CATEGORIA_COSTO_GASTO)) {
      deducibleVisualizado = VALOR_CERO.getValor();
    } else {
      deducibleVisualizado = transaccionDatoFinancieroPage.obtenerDeducibleReversionConstitucion();
    }
    MatcherAssert.assertThat(
        "Se esperaba un deducible de: "
            + deducible
            + " Pero se obtuvo un deducible de: "
            + deducibleVisualizado,
        deducibleVisualizado.equals(deducible));
  }
}
