package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.NombresCsv.RECLAMACION_EMPRESARIAL;
import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.ConsultaDatoFinancieroTransaccionStep;
import com.sura.reclamaciones.steps.generics.MovimientoLineaReservaStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionEmpresarialStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ReversionConstitucionDefinition {

  private static final String TIPO_CATEGORIA_COSTO_RESERVA = "Costo";

  @Steps MovimientoLineaReservaStep movimientoLineaReserva;

  @Steps NuevaReclamacionEmpresarialStep reclamacionEmpresarialStep;

  @Steps ConsultaDatoFinancieroTransaccionStep consultaDatoFinancieroTransaccionStep;

  @Dado(
      "^que se genera un siniestro del producto (.*) con causa (.*), valor de pretensión (.*) y tipo incidente de (.*)$")
  public void consultarReserva(
      String producto, String causaSiniestro, String valorPretension, String tipoIncidente)
      throws IOException {
    Serenity.setSessionVariable(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()).to(producto);
    ReclamacionEmpresarial reserva =
        new ReclamacionEmpresarial(
            obtenerDatosPrueba(RECLAMACION_EMPRESARIAL.getValor(), producto));
    reclamacionEmpresarialStep.seleccionarNuevaReclamacion(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
    reclamacionEmpresarialStep.crearNuevaReclamacionEmpresarial(
        reserva.getLstReclamo(), causaSiniestro, valorPretension, tipoIncidente);
  }

  @Cuando("^se ajuste la reserva con un valor de (.*)$")
  public void ajustarReserva(String ajusteReserva) {
    movimientoLineaReserva.ajustarReserva(ajusteReserva);
  }

  @Entonces(
      "^se obtiene una reversión de constitución y el deducible es generado por un valor (.*)$")
  public void verificarReversionConstitucion(String deducible) {
    consultaDatoFinancieroTransaccionStep.verificarDeducibleReserva(
        TIPO_CATEGORIA_COSTO_RESERVA, deducible);
  }
}
