package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.pagomasivo.FacturaVolumenPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class FacturaVolumenStep
{
    @Page FacturaVolumenPage facturaVolumenPage;

    @Step
    public void generarFacturacionMasiva()
    {
        facturaVolumenPage.generarFacturacionMasiva();
    }
}
