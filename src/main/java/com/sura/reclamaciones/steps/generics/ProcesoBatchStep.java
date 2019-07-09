package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.pages.generics.ProcesoBatchPage;
import org.fluentlenium.core.annotation.Page;
import static com.sura.reclamaciones.constantes.NombreProcesoBatch.ENVIO_FACTURA_VOLUMEN;
import static com.sura.reclamaciones.constantes.NombreProcesoBatch.MONITOR_FLUJO_TRABAJO_FACTURA_VOLUMEN;
import static com.sura.reclamaciones.constantes.NombreProcesoBatch.TRANSFERENCIA_FACTURA_VOLUMEN;

public class ProcesoBatchStep
{

    @Page ProcesoBatchPage procesoBatchPage;

    public void ejecutarProcesoBatch ()
    {
        procesoBatchPage.ejecutarBatch();
        procesoBatchPage.ejecutarProcesoBatch(ENVIO_FACTURA_VOLUMEN.getValor());
        procesoBatchPage.ejecutarProcesoBatch(MONITOR_FLUJO_TRABAJO_FACTURA_VOLUMEN.getValor());
        procesoBatchPage.ejecutarProcesoBatch(TRANSFERENCIA_FACTURA_VOLUMEN.getValor());
    }
}
