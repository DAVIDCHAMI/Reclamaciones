package com.sura.reclamaciones.steps.reserva;

import static com.sura.reclamaciones.constantes.Constantes.EXPOSICION_LINEA_RESERVA;
import static com.sura.reclamaciones.constantes.Constantes.UBICACION_ESTADO_PAGO;
import static com.sura.reclamaciones.constantes.MenuConstante.RESERVA;
import static com.sura.reclamaciones.constantes.ReservaConstante.NUEVAS_RESERVAS_DISPONIBLES;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.reservas.AjusteReservaPage;
import com.sura.reclamaciones.pages.reservas.TransaccionDatoFinancieroPage;
import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

public class ReversionConstitucionStep {

  List<WebElement> lstFilaReserva;

  String strNombreLineaReserva= "Ninguna (nivel de reclamación)";

  @Page
  AjusteReservaPage ajusteReservaPage;

  @Page
  VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page GeneralPage generalPage;

  @Page
  MenuClaimPage menuClaimPage;

  @Page
  TransaccionDatoFinancieroPage transaccionDatoFinancieroPage;

  public void ajustarReserva(String valorAjustar) {
    ajusteReservaPage.ajustarReserva();
    ajusteReservaPage.diligenciarCantidadAjusteReserva(valorAjustar, NUEVAS_RESERVAS_DISPONIBLES);
    ajusteReservaPage.cerrarAdvertenciaLimiteAgregado();
  }

  public void crearNuevaLineaReserva(String lineaReserva, String tipoCosto,
      String categoriaCosto, String valorNuevaReserva) {
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(RESERVA);
    lstFilaReserva = verificacionDatosFinancierosPage.obtenerFilaTabla(strNombreLineaReserva, ajusteReservaPage.getTblLineaReserva());
    //List<WebElement> lineaNuevaReserva = generalPage.obtenerElementoTablaDatoDesconocido((WebElementFacade) lstFilaReserva, EXPOSICION_LINEA_RESERVA.getValor(), -1);
   // ajusteReservaPage.diligenciarNuevaLineaReserva(lineaReserva, EXPOSICION_LINEA_RESERVA.getValor());
    //lstFilaReserva = generalPage.obtenerElementoTablaDatoDesconocido(ajusteReservaPage.getTblLineaReserva(),strNombreColumna, -2);
  }

  public void verificarAjusteReserva(String deducible) {
    String deducibleVisualizado;
    deducibleVisualizado = transaccionDatoFinancieroPage.obtenerDeducibleReversionConstitucion();
    MatcherAssert.assertThat(
        "Se esperaba un deducible de: "
            + deducible
            + " Pero se obtuvo un deducible de: "
            + deducibleVisualizado,
        deducibleVisualizado.equals(deducible));
  }
}
