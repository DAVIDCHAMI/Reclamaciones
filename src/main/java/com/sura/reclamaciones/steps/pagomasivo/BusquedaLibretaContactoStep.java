package com.sura.reclamaciones.steps.pagomasivo;

import com.sura.reclamaciones.pages.pagomasivo.BusquedaLibretaContactoPage;
import org.fluentlenium.core.annotation.Page;

public class BusquedaLibretaContactoStep
{
    @Page BusquedaLibretaContactoPage busquedaLibretaContactoPage;

    public void buscarContactoPagoMasivo (String tipoContacto, String nombreContacto)
    {
        busquedaLibretaContactoPage.seleccionarTipoContacto(tipoContacto);
        busquedaLibretaContactoPage.ingresarNombreContacto(nombreContacto);
        busquedaLibretaContactoPage.buscarContacto();
        busquedaLibretaContactoPage.buscarContactoPagoMasivo(nombreContacto);
    }


}

