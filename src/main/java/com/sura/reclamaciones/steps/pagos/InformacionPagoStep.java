package com.sura.reclamaciones.steps.pagos;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

import java.util.List;

import static com.sura.reclamaciones.constantes.Constantes.CANTIDAD;
import static com.sura.reclamaciones.constantes.Constantes.CODIGO_RETENCION;
import static com.sura.reclamaciones.constantes.Constantes.LINEA_RESERVA_LESIONES_CORPORALES;

public class InformacionPagoStep {

    @Page
    IntroducirInformacionPagoPage introducirInformacionPagoPage;

    @Page
    GeneralPage generalPage;

    @Step
    public void ingresarInformacionPago(
            String lineaReserva, String tipoPago, List<PagoSiniestro> lstPago) {
        introducirInformacionPagoPage.seleccionarLineaReserva(lineaReserva);
        introducirInformacionPagoPage.seleccionarTipoPago(tipoPago);
        introducirInformacionPagoPage.ingresarComentario(lstPago.listIterator().next().getComentario());

    }

    @Step
    public void ingresarInformacionDetallePago(
            String codigoRetencion, String tipoPago) {
       // for (PagoSiniestro retencion : lstPago) {
              introducirInformacionPagoPage.ingresarCodigoRetencion(
              codigoRetencion, CODIGO_RETENCION.getValor());
      introducirInformacionPagoPage.ingresarCantidadPago(tipoPago, CANTIDAD.getValor());
    }


}
