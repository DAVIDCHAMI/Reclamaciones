package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.ProcesoBatchPage;
import org.fluentlenium.core.annotation.Page;

import static com.sura.reclamaciones.constantes.Constantes.PAGOS;
import static com.sura.reclamaciones.constantes.MenuConstante.VOLVER_CLAIMCENTER_MENU;
import static com.sura.reclamaciones.constantes.NombreProcesoBatch.ENVIO_FACTURA_VOLUMEN;
import static com.sura.reclamaciones.constantes.NombreProcesoBatch.MONITOR_FLUJO_TRABAJO_FACTURA_VOLUMEN;
import static com.sura.reclamaciones.constantes.NombreProcesoBatch.TRANSFERENCIA_FACTURA_VOLUMEN;

public class ProcesoBatchStep
{

    @Page ProcesoBatchPage procesoBatchPage;

    @Page MenuClaimPage menuClaimPage;

    public void ejecutarProcesoBatch ()
    {
        procesoBatchPage.ejecutarBatch();
        /*procesoBatchPage.ejecutarProcesoBatch(ENVIO_FACTURA_VOLUMEN.getValor());
        procesoBatchPage.ejecutarProcesoBatch(MONITOR_FLUJO_TRABAJO_FACTURA_VOLUMEN.getValor());
        procesoBatchPage.ejecutarProcesoBatch(TRANSFERENCIA_FACTURA_VOLUMEN.getValor());*/
        procesoBatchPage.seleccionarOpcionMenuAccion();
        procesoBatchPage.seleccionarOpcionMenuAccionesPrimerNivel();

    }

    public void regresarClaimCenter ()
    {


        //menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(VOLVER_CLAIMCENTER_MENU);

    }
}
