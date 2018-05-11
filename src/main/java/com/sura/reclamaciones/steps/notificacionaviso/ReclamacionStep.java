package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.pages.autos.LugarPage;
import com.sura.reclamaciones.pages.autos.ReclamacionPage;

public class ReclamacionStep {

    ReclamacionPage reclamacionPage;
    LugarPage lugarPage;

    public void completarDetalleSiniestro(String sucedido, String causa, String origen, String valorPretension, String autoridad) {
        reclamacionPage.escribirSucedido(sucedido);
        reclamacionPage.seleccionarCausa(causa);
        reclamacionPage.seleccionarOrigen(origen);
        reclamacionPage.escribirValorPretension(valorPretension);
        reclamacionPage.seleccionarIntervinoAutoridad(autoridad);
    }

    public void completarLugar(String pais, String departamento, String ciudad, String direccion){
        lugarPage.seleccionarPais(pais);
        lugarPage.seleccionarDepartamento(departamento);
        lugarPage.seleccionarCiudad(ciudad);
        lugarPage.escribirDireccion(direccion);
    }

    public void completarCulpabilidad(String culpabilidad){
        reclamacionPage.seleccionarCulpabilidad(culpabilidad);
    }
}
