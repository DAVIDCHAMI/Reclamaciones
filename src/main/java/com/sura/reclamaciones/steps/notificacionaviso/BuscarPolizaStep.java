package com.sura.reclamaciones.steps.notificacionaviso;

import static com.sura.reclamaciones.constantes.Constantes.FECHA_HOY;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;

import java.util.List;

import org.fluentlenium.core.annotation.Page;

public class BuscarPolizaStep {

    @Page
    BuscarPolizaPage buscarPolizaPage;

    @Page
    GeneralPage generalPage;

    @Page
    MenuClaimPage menuClaimPage;

    public void buscarPolizaEmpresarial(List<ReclamacionEmpresarial> datosPolizaEmpresarial) {
        datosPolizaEmpresarial.forEach(
                poliza -> {
                    menuClaimPage.seleccionarOpcionMenuSegundoNivel(MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
                    buscarPolizaPage.seleccionarOpcionBuscarPoliza();
                    buscarPolizaPage.escribirNumeroPoliza(poliza.getNumPoliza());
                    if (FECHA_HOY.getValor().equals(poliza.getFechaSiniestro())) {
                        buscarPolizaPage.seleccionarFechaHoySiniestro();
                    } else {
                        buscarPolizaPage.escribirFechaSiniestro(poliza.getFechaSiniestro());
                    }
                    generalPage.seleccionarPais(poliza.getPais());
                    generalPage.seleccionarDepartamento(poliza.getDepartamento());
                    buscarPolizaPage.buscarPoliza();
                    buscarPolizaPage.seleccionarPoliza();
                    generalPage.continuarSiguientePantalla();
                });
    }
}
