package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.pagomasivo.BusquedaLibretaContactoPage;
import org.fluentlenium.core.annotation.Page;

public class BusquedaLibretaContactoStep
{
    @Page BusquedaLibretaContactoPage busquedaLibretaContactoPage;

    public void buscarContactoPagoMasivo (String tipoContacto, String contacto)
    {
        busquedaLibretaContactoPage.seleccionarTipoContacto(tipoContacto);
        busquedaLibretaContactoPage.ingresarContacto(contacto);
        busquedaLibretaContactoPage.buscarContacto();
    }
}

