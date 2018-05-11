package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.steps.generics.CSVStep;
import com.sura.reclamaciones.steps.notificacionaviso.BuscarPolizaStep;
import com.sura.reclamaciones.steps.notificacionaviso.ReclamacionStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;

public class Reclamacion {

    private MenuClaimPage menuClaimPage;
    private CSVStep csvStep;
    private BuscarPolizaStep buscarPolizaStep;
    private ReclamacionStep reclamacionStep;


    @Dado("que se recibe un reclamo con causa de siniestro por danos")
    public void recibirReclamo(){
        menuClaimPage.seleccionarOpcionMenuSegundoNivel(MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
        buscarPolizaStep.seleccionarTipoPoliza("Autos","","DFX003");
        buscarPolizaStep.seleccionarFecha("");
        buscarPolizaStep.buscarPoliza();
        //buscarPolizaStep.
    }

    @Cuando("se tomen los datos del siniestro")
    public void ingresarDatosSiniestro(){
        reclamacionStep.seleccionarNombreAutorReporte();
        reclamacionStep.seleccionarRelacionAsegurado();
        reclamacionStep.completarDetalleSiniestro();
    }
}
