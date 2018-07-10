package com.sura.reclamaciones.definitions.notificacionavisomrc;

import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import com.sura.reclamaciones.steps.generics.CSVStep;
import com.sura.reclamaciones.steps.notificacionaviso.*;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoDefinition {

    ReclamacionEmpresariales reclamo;
    ReclamacionEmpresariales detalleHechos;
    ReclamacionEmpresariales incidente;
    Persona persona;
    @Steps
    BuscarPolizaStep BuscarPolizaStep;
    @Steps
    NuevaReclamacionStep NuevaReclamacionStep;
    @Steps
    SeleccionarPropiedadesImplicadasStep SeleccionarPropiedadesImplicadasStep;
    @Steps
    InformacionBasicaStep InformacionBasicaStep;
    @Steps
    InformacionReclamacionStep InformacionReclamacionStep;
    @Steps
    CSVStep CSVStep;


    @Dado("que se recibe un reclamo por parte de un afectado")
    public void queSeRecibeUnReclamoPorParteDeUnAfectado() throws Throwable {
        reclamo = new ReclamacionEmpresariales(CSVStep.getFilasModelo("ReclamacionEmpresarial", "escenarioEmpresariales"));
        NuevaReclamacionStep.seleccionarNuevaReclamacion("Re", "Nueva");
        BuscarPolizaStep.seleccionarTipoPoliza(reclamo.getLstReclamo());
        BuscarPolizaStep.seleccionarFecha(reclamo.getLstReclamo());
        BuscarPolizaStep.seleccionarUbicacion(reclamo.getLstReclamo());
        BuscarPolizaStep.buscarPoliza();
    }

    @Cuando("se tomen los datos del siniestro")
    public void seTomenLosDatosDelSiniestro() throws Throwable {
        detalleHechos = new ReclamacionEmpresariales(CSVStep.getFilasModelo("ReclamacionEmpresarial", "escenarioEmpresariales"));
        SeleccionarPropiedadesImplicadasStep.seleccionarPropiedadImplicada();
        InformacionBasicaStep.informacionPersonal(detalleHechos.getLstReclamo());
    }

    @Entonces("^se le brindara al reclamante un numero de reclamacion radicada")
    public void seLeBrindaraAlReclamanteUnNumeroDeReclamacionRadicada() throws Throwable {
        incidente = new ReclamacionEmpresariales(CSVStep.getFilasModelo("ReclamacionEmpresarial", "escenarioEmpresariales"));
        InformacionReclamacionStep.informacionIncidente(incidente.getLstReclamo());
    }
}
