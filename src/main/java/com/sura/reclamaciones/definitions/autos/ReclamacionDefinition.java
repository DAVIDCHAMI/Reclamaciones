package com.sura.reclamaciones.definitions.autos;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.Lugar;
import com.sura.reclamaciones.models.Reclamacion;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.steps.generics.CSVStep;
import com.sura.reclamaciones.steps.notificacionaviso.BuscarPolizaStep;
import com.sura.reclamaciones.steps.notificacionaviso.ReclamacionStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class ReclamacionDefinition {

    private MenuClaimPage menuClaimPage;

    @Steps
    private CSVStep csvStep;

    @Steps
    private BuscarPolizaStep buscarPolizaStep;

    @Steps
    private ReclamacionStep reclamacionStep;

    private Reclamacion reclamacion;
    private Lugar lugarDTO;
    private Vehiculo vehiculo;

    @Dado("^que se recibe (Autos|multiRiesgo) con causa de siniestro por danos$")
    public void recibirReclamo(String tipoPoliza) throws Exception {
        reclamacion = new Reclamacion(csvStep.getFilasModelo("reclamacion", "identificador", "COL001"));
        vehiculo = new Vehiculo(csvStep.getFilasModelo("vehiculo","identificador","COL001"));
        menuClaimPage.seleccionarOpcionMenuSegundoNivel(MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
        buscarPolizaStep.completarFormularioBuscarPoliza(tipoPoliza, reclamacion.getReclamaciones(), vehiculo.getVehiculos());
        buscarPolizaStep.buscarPoliza();
    }

    @Cuando("se toman los datos del siniestro")
    public void ingresarDatosSiniestro() throws IOException {
        reclamacion = new Reclamacion(csvStep.getFilasModelo("reclamacion", "identificador", "COL001"));
        lugarDTO = new Lugar(csvStep.getFilasModelo("lugar", "pais", "Colombia"));
        reclamacionStep.seleccionarNombreAutorReporte();
        reclamacionStep.completarDetalleSiniestro(reclamacion.getReclamaciones());
        reclamacionStep.completarLugar(lugarDTO.getLugares());
        reclamacionStep.completarCategorizacion(reclamacion.getCulpabilidad());
        reclamacionStep.editarVehiculo();
    }

    @Entonces("se le brindara al reclamante un numero de reclamacion")
    public void generarReclamacion() {

    }

    @Y("se valida el encabezado en STAR")
    public void validarStar() {

    }
}
