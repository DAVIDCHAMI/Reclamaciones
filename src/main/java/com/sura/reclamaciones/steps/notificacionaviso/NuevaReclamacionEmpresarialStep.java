package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import com.sura.reclamaciones.pages.notificacionaviso.NuevaReclamacionPage;
import com.sura.reclamaciones.pages.notificacionaviso.PropiedadesImplicadasPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import com.sura.reclamaciones.steps.generics.UbicacionStep;
import java.util.List;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class NuevaReclamacionEmpresarialStep {

  @Page BuscarPolizaPage buscarPolizaPage;
  @Page NuevaReclamacionPage nuevaReclamacionPage;
  @Page InformacionReclamacionPage informacionReclamacionPage;
  @Page InformacionBasicaPage informacionBasicaPage;
  @Page PropiedadesImplicadasPage seleccionarPropiedadesImplicadasPage;
  @Page ResumenReclamacionPage resumenReclamacionPage;
  @Steps UbicacionStep ubicacionStep;

  public void informacionIncidente(
      List<ReclamacionEmpresariales> datosIncidente, String incidente) {
    datosIncidente.forEach(
        datos -> {
          informacionReclamacionPage.cerrarReclamosDuplicados();
          informacionReclamacionPage.seleccionarTipoIncidente(incidente);
          informacionReclamacionPage.finalizarSiniestro();
        });
  }

  public void causalIncidente(String causa, String valorPretension) {
    informacionReclamacionPage.seleccionarCausaSiniestro(causa);
    informacionReclamacionPage.escribirValorPretension(valorPretension);
  }

  public void validarReclamacion(List<ReclamacionEmpresariales> datosValidacion) {
    datosValidacion.forEach(
        datos -> {
          String verificar;
          verificar = informacionReclamacionPage.validarReclamacionGenerada();
          MatcherAssert.assertThat(
              "No se ha obtenido el número de reclamación",
              verificar.equals(datos.getValidarNumeroReclamacion()));
        });
  }

  public void seleccionarNuevaReclamacion(String nombreOpcion, String subItem) {
    nuevaReclamacionPage.seleccionarOpcionMenuSegundoNivel(nombreOpcion, subItem);
  }

  public void informacionPersonal(List<ReclamacionEmpresariales> datosAutor) {
    datosAutor.forEach(
        autor -> {
          informacionBasicaPage.seleccionarAutorReporte();
          informacionBasicaPage.escribirDetallehechos(autor.getDetalleHechos());
        });
  }

  public void seleccionarPropiedadImplicada() {
    seleccionarPropiedadesImplicadasPage.seleccionarPropiedad();
  }

  public void visualizarResumenReclamacion() {
    resumenReclamacionPage.resumenReclamacion();
  }

  public void validarExposicionVisualizada(String exposicion) {
    String validar = resumenReclamacionPage.validarExposicion();
    MatcherAssert.assertThat(
        "No generó exposición, verificar las reglas de administración de exposiciones o data ingresada",
        validar.equals(exposicion));
  }

  public void validarReservaVisualizada(String monto) {
    String validar = resumenReclamacionPage.validarReserva();
    MatcherAssert.assertThat(
        "No generó reserva, verificar las reglas de administración de reserva o data ingresada",
        validar.equals(monto));
  }

  public void buscarPolizaEmpresarial(List<ReclamacionEmpresariales> datosPolizaEmpresarial) {
    datosPolizaEmpresarial.forEach(
        poliza -> {
          buscarPolizaPage.opcionBuscarPoliza();
          buscarPolizaPage.escribirNumeroPoliza(poliza.getNumPoliza());
          if (ReclamacionConstante.FECHA_HOY.equals(poliza.getFechaSiniestro())) {
            buscarPolizaPage.seleccionarFechaHoySiniestro();
          } else {
            buscarPolizaPage.escribirFechaSiniestro(poliza.getFechaSiniestro());
          }
          ubicacionStep.seleccionarUbicacion(datosPolizaEmpresarial);
          buscarPolizaPage.buscarPoliza();
        });
  }
}
