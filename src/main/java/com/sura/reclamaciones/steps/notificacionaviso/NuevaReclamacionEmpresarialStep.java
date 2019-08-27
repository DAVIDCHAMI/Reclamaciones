package com.sura.reclamaciones.steps.notificacionaviso;

import static com.sura.reclamaciones.constantes.Constantes.FECHA_HOY;
import static com.sura.reclamaciones.constantes.Constantes.VALIDADOR_NUEVA_RECLAMACION;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_VALOR_RESERVA_CONSTITUCION;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import com.sura.reclamaciones.pages.notificacionaviso.PropiedadesImplicadasPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import com.sura.reclamaciones.steps.generics.UbicacionStep;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class NuevaReclamacionEmpresarialStep {

  @Page BuscarPolizaPage buscarPolizaPage;

  @Page MenuClaimPage menuClaimPage;

  @Page InformacionReclamacionPage informacionReclamacionPage;

  @Page InformacionBasicaPage informacionBasicaPage;

  @Page PropiedadesImplicadasPage seleccionarPropiedadesImplicadasPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  @Page GeneralPage generalPage;

  @Steps UbicacionStep ubicacionStep;

  public void diligenciarInformacionIncidente(String incidente) {
    informacionReclamacionPage.seleccionarTipoIncidente(incidente);
    informacionReclamacionPage.finalizarSiniestro();
  }

  public void seleccionarCausalIncidente(String causa, String valorPretension) {
    informacionReclamacionPage.cerrarReclamosDuplicados();
    informacionReclamacionPage.escribirValorPretension(valorPretension);
    informacionReclamacionPage.seleccionarCausaSiniestro(causa);
  }

  public void validarReclamacion() {
    String verificar;
    verificar = informacionReclamacionPage.obtenerTituloReclamacionGenerada();
    MatcherAssert.assertThat(
        "No se ha obtenido el número de reclamación",
        verificar.equals(VALIDADOR_NUEVA_RECLAMACION.getValor()));
  }

  public void seleccionarNuevaReclamacion(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(nombreOpcion, subItem);
  }

  public void diligenciarInformacionPersonal(List<ReclamacionEmpresarial> datosAutor) {
    datosAutor.forEach(
        autor -> {
          informacionBasicaPage.seleccionarAutorReporte();
          informacionBasicaPage.escribirDetalleHechos(autor.getDetalleHechos());
        });
  }

  public void seleccionarPropiedadImplicada() {
    seleccionarPropiedadesImplicadasPage.seleccionarPropiedad();
  }

  public void visualizarResumenReclamacion() {
    resumenReclamacionPage.obtenerNumeroReclamacion();
  }

  public void validarExposicionVisualizada(String exposicion) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(ReclamacionConstante.EXPOSICIONES);
    MatcherAssert.assertThat(
        "No generó exposición, verificar las reglas de administración de exposiciones o data ingresada",
        resumenReclamacionPage.validarExposicion().equals(exposicion));
  }

  public void buscarPolizaEmpresarial(List<ReclamacionEmpresarial> datosPolizaEmpresarial) {
    datosPolizaEmpresarial.forEach(
        poliza -> {
          Serenity.setSessionVariable(SESION_CC_VALOR_RESERVA_CONSTITUCION.getValor())
              .to(poliza.getReservaTransaccion());
          buscarPolizaPage.seleccionarOpcionBuscarPoliza();
          buscarPolizaPage.escribirNumeroPoliza(poliza.getNumPoliza());
          if (FECHA_HOY.getValor().equals(poliza.getFechaSiniestro())) {
            buscarPolizaPage.seleccionarFechaHoySiniestro();
          } else {
            buscarPolizaPage.escribirFechaSiniestro(poliza.getFechaSiniestro());
          }
          ubicacionStep.seleccionarUbicacion(datosPolizaEmpresarial);
          buscarPolizaPage.buscarPoliza();
          buscarPolizaPage.seleccionarPoliza();
          generalPage.continuarSiguientePantalla();
        });
  }

  public void validarReservaDatosFinancieros(List<ReclamacionEmpresarial> datoReserva) {
    datoReserva.forEach(
        reserva -> {
          String validar =
              resumenReclamacionPage.validarReservaTransaccion(reserva.getReservaTransaccion());
          MatcherAssert.assertThat(
              "Se esperaba una reserva de: "
                  + reserva.getReservaTransaccion()
                  + ", pero se ha obtenido una reserva de: "
                  + validar,
              reserva.getReservaTransaccion().equals(validar));
        });
  }

  public void crearNuevaReclamacionEmpresarial(
      List<ReclamacionEmpresarial> reclamacionEmpresarial,
      String causaSiniestro,
      String valorPretension,
      String tipoIncidente) {
    buscarPolizaEmpresarial(reclamacionEmpresarial);
    seleccionarPropiedadImplicada();
    diligenciarInformacionPersonal(reclamacionEmpresarial);
    seleccionarCausalIncidente(causaSiniestro, valorPretension);
    diligenciarInformacionIncidente(tipoIncidente);
    visualizarResumenReclamacion();
  }
}