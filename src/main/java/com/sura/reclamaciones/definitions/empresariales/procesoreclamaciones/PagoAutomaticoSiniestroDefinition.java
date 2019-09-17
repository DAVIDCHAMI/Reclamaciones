package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.NombresCsv;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.ConsultaDatoFinancieroPagoStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionEmpresarialStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.core.Serenity;

import java.io.IOException;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

public class PagoAutomaticoSiniestroDefinition {

    ReclamacionEmpresarial reclamacionEmpresarial;

    String productoPoliza = "";

    NuevaReclamacionEmpresarialStep nuevaReclamacionEmpresarialStep;

    ConsultaDatoFinancieroPagoStep consultaDatoFinancieroPagoStep;

    @Dado("^que se tiene una póliza del producto (.*)$")
    public void obtenerPoliza(String producto) throws IOException {
        Serenity.setSessionVariable(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()).to(producto);
        reclamacionEmpresarial =
                new ReclamacionEmpresarial(
                        obtenerDatosPrueba(ReclamacionConstante.RECLAMACION_EMPRESARIAL, producto));
        nuevaReclamacionEmpresarialStep.seleccionarNuevaReclamacion(
                MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
        nuevaReclamacionEmpresarialStep.buscarPolizaEmpresarial(reclamacionEmpresarial.getLstReclamo());  }

    @Cuando("^se realiza un siniestro por causa (.*) con valor de pretensión (.*) e incidente (.*)$")
    public void realizarSiniestro(String causa, String valorPretension, String tipoIncidente) {
        nuevaReclamacionEmpresarialStep.seleccionarPropiedadImplicada();
        nuevaReclamacionEmpresarialStep.diligenciarInformacionPersonal(
                reclamacionEmpresarial.getLstReclamo());
        nuevaReclamacionEmpresarialStep.seleccionarCausalIncidente(causa, valorPretension);
    }

    @Entonces("^se genera una reclamación con exposición automática (.*)$")
    public void verificarGeneracionExposicionAutomatica(String tipoExposicion) throws Throwable {
        //TO DO
    }

    @Y("^una reserva automática$")
    public void verificarGeneracionReservaAutomatica() throws IOException {
        /*Reserva reserva =
                new Reserva(
                        obtenerDatosPrueba(NombresCsv.PARAMETRO_LINEA_RESERVA.getValor(), productoPoliza));

        menuClaimsStep.seleccionarOpcionMenuLateralSegundoNivel(DATOS_FINANCIEROS.getValor(), TRANSACCIONES);
        datosFinancierosStep.verificarMontoReservaAutomatica(reserva.getLstReserva());*/
    }

    @Y("^un pago automático$")
    public void verificarGeneracionPagoAutomatico() throws IOException {
        PagoSiniestro pago =
                new PagoSiniestro(
                        obtenerDatosPrueba(NombresCsv.PAGO_SINIESTRO.getValor(), productoPoliza));
        consultaDatoFinancieroPagoStep.verificarPagoAutomatico(pago.getLstPago());
    }
}