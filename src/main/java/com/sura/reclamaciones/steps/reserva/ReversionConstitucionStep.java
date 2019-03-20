package com.sura.reclamaciones.steps.reserva;

import static com.sura.reclamaciones.constantes.Constantes.CATEGORIA_COSTO_CAMPO;
import static com.sura.reclamaciones.constantes.Constantes.DEDUCIBLE_GASTO;
import static com.sura.reclamaciones.constantes.Constantes.EXPOSICION_LINEA_RESERVA;
import static com.sura.reclamaciones.constantes.Constantes.POSICION_COLUMNA_RESERVA;
import static com.sura.reclamaciones.constantes.Constantes.POSICION_VALOR_RESERVA;
import static com.sura.reclamaciones.constantes.Constantes.TIPO_CATEGORIA_COSTO_GASTO;
import static com.sura.reclamaciones.constantes.Constantes.TIPO_COSTO_CAMPO;
import static com.sura.reclamaciones.constantes.Constantes.VALOR_NUEVA_RESERVA_CAMPO;
import static com.sura.reclamaciones.constantes.MenuConstante.RESERVA;
import static com.sura.reclamaciones.constantes.ReservaConstante.NUEVAS_RESERVAS_DISPONIBLES;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.reservas.AjusteReservaPage;
import com.sura.reclamaciones.pages.reservas.TransaccionDatoFinancieroPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

public class ReversionConstitucionStep {

  List<WebElement> lstFilaReserva;

  @Page
  AjusteReservaPage ajusteReservaPage;

  @Page
  VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page
  GeneralPage generalPage;

  @Page
  MenuClaimPage menuClaimPage;

  @Page
  TransaccionDatoFinancieroPage transaccionDatoFinancieroPage;

  public void ajustarReserva(String valorAjustar) {
    ajusteReservaPage.ajustarReserva();
    ajusteReservaPage
        .diligenciarCampoLineaReserva(valorAjustar, NUEVAS_RESERVAS_DISPONIBLES, Integer.parseInt(
            POSICION_VALOR_RESERVA.getValor()));
  }

  public void crearNuevaLineaReserva(String lineaReserva, String tipoCosto,
      String categoriaCosto, String valorNuevaReserva) {
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(RESERVA);
    ajusteReservaPage
        .diligenciarCampoLineaReserva(lineaReserva, EXPOSICION_LINEA_RESERVA.getValor(),
            Integer.valueOf(POSICION_COLUMNA_RESERVA.getValor()));
    ajusteReservaPage.diligenciarCampoLineaReserva(categoriaCosto, CATEGORIA_COSTO_CAMPO.getValor(),
        Integer.valueOf(POSICION_COLUMNA_RESERVA.getValor()));
    ajusteReservaPage.diligenciarCampoLineaReserva(tipoCosto, TIPO_COSTO_CAMPO.getValor(),
        Integer.valueOf(POSICION_COLUMNA_RESERVA.getValor()));
    ajusteReservaPage
        .diligenciarCampoLineaReserva(valorNuevaReserva, VALOR_NUEVA_RESERVA_CAMPO.getValor(),
            Integer.parseInt(POSICION_VALOR_RESERVA.getValor()));
  }

  public void verificarAjusteReserva(String categoriaCosto, String deducible) {
    String deducibleVisualizado;
    if (categoriaCosto.contains(TIPO_CATEGORIA_COSTO_GASTO.getValor())) {
      deducibleVisualizado = DEDUCIBLE_GASTO.getValor();
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