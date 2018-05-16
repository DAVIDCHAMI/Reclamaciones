package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.LugarDTO;
import com.sura.reclamaciones.models.ReclamacionDTO;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.steps.generics.CSVStep;
import com.sura.reclamaciones.steps.notificacionaviso.BuscarPolizaStep;
import com.sura.reclamaciones.steps.notificacionaviso.ReclamacionStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class ReclamacionDefinition {

    @Steps MenuClaimPage menuClaimPage;
    @Steps CSVStep csvStep;
    @Steps BuscarPolizaStep buscarPolizaStep;
    @Steps ReclamacionStep reclamacionStep;
    ReclamacionDTO reclamacion;
    LugarDTO lugarDTO;

    @Dado("que se recibe un reclamo con causa de siniestro por danos")
    public void recibirReclamo(){
        menuClaimPage.seleccionarOpcionMenuSegundoNivel(MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
        buscarPolizaStep.seleccionarTipoPoliza("Autos","","DFX003");
        buscarPolizaStep.seleccionarFecha("");
        buscarPolizaStep.buscarPoliza();
        //buscarPolizaStep.
    }

    @Cuando("se tomen los datos del siniestro")
    public void ingresarDatosSiniestro() throws IOException {
        reclamacionStep.seleccionarNombreAutorReporte();
        reclamacionStep.seleccionarRelacionAsegurado();
        reclamacion = new ReclamacionDTO(csvStep.getFilasModelo("reclamacion", "sucedido", "ejemplouno"));
        lugarDTO = new LugarDTO(csvStep.getFilasModelo("lugar","pais", "Colombia"));
        reclamacionStep.completarDetalleSiniestro(reclamacion.getReclamaciones());
        reclamacionStep.completarLugar(lugarDTO.getLugares());
    }
}
