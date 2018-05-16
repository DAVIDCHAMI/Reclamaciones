package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.LugarDTO;
import com.sura.reclamaciones.models.ReclamacionDTO;
import com.sura.reclamaciones.pages.autos.LugarPage;
import com.sura.reclamaciones.pages.autos.ReclamacionPage;

import java.util.List;

public class ReclamacionStep {

    ReclamacionPage reclamacionPage;
    LugarPage lugarPage;

    public void completarDetalleSiniestro(List<ReclamacionDTO> datosReclamacion) {
        for (ReclamacionDTO dato : datosReclamacion) {
            reclamacionPage.escribirSucedido(dato.getSucedido());
            reclamacionPage.seleccionarCausa(dato.getCausa());
            reclamacionPage.seleccionarOrigen(dato.getOrigen());
            reclamacionPage.escribirValorPretension(dato.getValorPredeterminado());
            reclamacionPage.seleccionarIntervinoAutoridad(dato.getAutoridad());
        }
    }

    public void completarLugar(List<LugarDTO> datosLugar){
        for (LugarDTO dato : datosLugar){
            lugarPage.seleccionarPais(dato.getPais());
            lugarPage.seleccionarDepartamento(dato.getDepartamento());
            lugarPage.seleccionarCiudad(dato.getCiudad());
            lugarPage.escribirDireccion(dato.getDireccion());
        }
    }

    public void completarCulpabilidad(String culpabilidad){
        reclamacionPage.seleccionarCulpabilidad(culpabilidad);
    }
}
