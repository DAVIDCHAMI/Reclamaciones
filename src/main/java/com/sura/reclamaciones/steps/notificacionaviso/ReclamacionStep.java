package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.LugarDTO;
import com.sura.reclamaciones.models.Reclamacion;
import com.sura.reclamaciones.pages.autos.reclamacion.ReclamacionPage;
import com.sura.reclamaciones.pages.autos.reclamacion.InformacionBasicaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

public class ReclamacionStep {

    @Page
    private ReclamacionPage reclamacionPage;

    @Page
    private InformacionBasicaPage informacionBasicaPage;

    @Step
    public void completarDetalleSiniestro(List<Reclamacion> datosReclamacion) {
        datosReclamacion.forEach(
                dato -> {
                    reclamacionPage.escribirSucedido(dato.getSucedido());
                    reclamacionPage.seleccionarCausa(dato.getCausa());
                    reclamacionPage.seleccionarOrigen(dato.getOrigen());
                    reclamacionPage.escribirValorPretension(dato.getValorPredeterminado());
                    reclamacionPage.seleccionarIntervinoAutoridad(dato.getAutoridad());
                });
    }

    @Step
    public void completarLugar(List<LugarDTO> datosLugar) {
        for (LugarDTO dato : datosLugar) {
            reclamacionPage.seleccionarPais(dato.getPais());
            reclamacionPage.seleccionarDepartamento(dato.getDepartamento());
            reclamacionPage.seleccionarCiudad(dato.getCiudad());
            reclamacionPage.escribirDireccion(dato.getDireccion());
        }
    }

    @Step
    public void completarCategorizacion(String culpabilidad) {
        reclamacionPage.seleccionarCulpabilidad(culpabilidad);
    }

    @Step
    public void editarVehiculo() {
        reclamacionPage.agregarConductor();
        reclamacionPage.seleccionarTaller();

    }

    public void seleccionarNombreAutorReporte() {
        informacionBasicaPage.seleccionarNombre();
    }
}
