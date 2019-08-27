package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.NombresCsv;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.MenuClaimsStep;
import com.sura.reclamaciones.steps.notificacionaviso.BuscarPolizaStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;

public class PagoAutomaticoSiniestroDefinition {

    @Steps
    ReclamacionEmpresarial reclamacionEmpresarial;

    @Steps
    MenuClaimsStep menuClaimsStep;

    @Steps
    BuscarPolizaStep buscarPolizaStep;

    @Dado("^que se tiene una póliza del producto (.*)$")
    public void obtenerPoliza(String producto) throws Exception {
        reclamacionEmpresarial =
                new ReclamacionEmpresarial(
                        obtenerDatosPrueba(NombresCsv.RECLAMACION_EMPRESARIAL.getValor(), producto));
        menuClaimsStep.seleccionarOpcionMenuSegundoNivel(
                MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
        buscarPolizaStep.buscarPolizaEmpresarial(reclamacionEmpresarial.getLstReclamo());
    }

    @Cuando("^se realiza un siniestro por causa (.*) con valor de pretensión (.*) e incidente (.*)$")
    public void realizarSiniestro(String causa, String valorPretension) throws Exception {
        //TO DO
    }

    @Entonces("^se genera una exposición automática, una reserva automática y un pago automático$")
    public void verificarGeneracionPagoAutomatico() throws Exception {
        //TO DO
    }

}
