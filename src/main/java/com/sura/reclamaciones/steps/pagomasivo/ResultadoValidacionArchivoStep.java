package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.pagomasivo.ResultadoValidacionArchivoPage;
import org.fluentlenium.core.annotation.Page;

public class ResultadoValidacionArchivoStep
{
    @Page ResultadoValidacionArchivoPage resultadoValidacionArchivoPage;

    @Page GeneralPage generalPage;

    public void validarNumeroRegistrosArchivo ()
    {
        resultadoValidacionArchivoPage.capturarNumeroRegistrosPantalla();
        resultadoValidacionArchivoPage.validarNumeroRegistrosArchivoXls();
        generalPage.continuarSiguientePantalla();
    }
}
