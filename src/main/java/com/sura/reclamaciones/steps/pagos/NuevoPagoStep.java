package com.sura.reclamaciones.steps.pagos;


import com.sura.reclamaciones.models.PagoEmpresariales;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagos.EstablecerInstruccionPagoPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionBeneficiarioPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

public class NuevoPagoStep {

    @Page private IntroducirInformacionBeneficiarioPage introducirInformacionBeneficiarioPage;
    @Page private IntroducirInformacionPagoPage introducirInformacionPagoPage;
    @Page private EstablecerInstruccionPagoPage establecerInstruccionPagoPage;
    @Page private GeneralPage generalPage;
    @Page private MenuClaimPage menuClaimPage;


    @Step
    public void consultarNumeroReclamacion(String strNumeroReclamacion) {

    }

    @Step
    public void ingresarInformacionBeneficiarioPago(String strTipoPago, String strBeneficiarioPago, String strMetodoPago, String strLineaReserva, String strSoloSura, String strCodigoRetencion) {
        introducirInformacionBeneficiarioPage.seleccionarNombreBeneficiario(strBeneficiarioPago);
        introducirInformacionBeneficiarioPage.seleccionarMetodoPago(strMetodoPago);
        introducirInformacionBeneficiarioPage.seleccionarPagoSura(strSoloSura);
        introducirInformacionPagoPage.seleccionarLineaReserva(strLineaReserva);
        introducirInformacionPagoPage.seleccionarTipoPago(strTipoPago);


    }

    @Step
    public void verificarPagoRealizado() {

    }
}
