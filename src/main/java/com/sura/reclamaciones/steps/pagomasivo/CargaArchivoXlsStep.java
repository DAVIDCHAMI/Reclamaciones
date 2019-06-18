package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.pagomasivo.CargaArchivoXlsPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class CargaArchivoXlsStep
{
    @Page CargaArchivoXlsPage cargaArchivoXlsStep;

    @Step
    public void seleccionarArchivoXls()
    {
        cargaArchivoXlsStep.seleccionarArchivoXls();
    }



}
