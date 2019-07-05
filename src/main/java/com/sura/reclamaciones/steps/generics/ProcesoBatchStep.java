package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.pages.generics.ProcesoBatchPage;
import org.fluentlenium.core.annotation.Page;

public class ProcesoBatchStep
{

    @Page ProcesoBatchPage procesoBatchPage;

    public void ejecutarProcesoBatch ()
    {
        procesoBatchPage.ejecutarProcesoBatch();
        procesoBatchPage.buscarProcesoBatch();
    }
}
