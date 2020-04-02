package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.constantes.MenuConstante.RESERVA;
import static com.sura.reclamaciones.utils.enums.Constantes.*;

import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.EstablecerReservaPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import org.fluentlenium.core.annotation.Page;

public class MovimientoLineaReservaStep {

  private static final String NOMBRE_CAMPO_CATEGORIA_COSTO_RESERVA_EMPRESARIALES =
      "Categoría de costo";
  private static final String NOMBRE_CAMPO_EXPOSICION_LINEA_RESERVA_EMPRESARIALES = "Exposición";
  private static final String NOMBRE_CAMPO_TIPO_COSTO_RESERVA_EMPRESARIALES = "Tipo de costo";

  @Page EstablecerReservaPage establecerReservaPage;

  @Page GeneralPage generalPage;

  @Page MenuClaimPage menuClaimPage;

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

  public void ajustarReserva(String valorAjustar) {
    menuClaimPage.seleccionarBotonAcciones();
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(RESERVA);
    establecerReservaPage.eliminarReservaVacia();
    establecerReservaPage.diligenciarCampoLineaReserva(
        valorAjustar,
        CC_NOMBRE_CAMPO_VALOR_NUEVA_RESERVA.getValor(),
        Integer.parseInt(CC_POSICION_VALOR_RESERVA_EMPRESARIALES.getValor()));
  }
}
