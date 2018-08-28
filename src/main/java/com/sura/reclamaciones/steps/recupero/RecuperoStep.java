package com.sura.reclamaciones.steps.recupero;

import static org.junit.Assert.assertTrue;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.pages.recupero.CreacionRecuperoPage;
import com.sura.reclamaciones.pages.recupero.MenuRecuperoPage;
import com.sura.reclamaciones.pages.recupero.VerificacionRecuperoPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class RecuperoStep {

  @Page MenuRecuperoPage menuRecuperoPage;
  @Page CreacionRecuperoPage creacionRecuperoPage;
  @Page VerificacionRecuperoPage verificacionRecuperoPage;

  @Step
  public void seleccionarNumeroReclamacion(String reclamacion, List<Recupero> lstRecupero) {
    lstRecupero.forEach(
        menu -> {
          menuRecuperoPage.seleccionarNumeroReclamacion(reclamacion, menu.getNumeroReclamacion());
        });
  }

  public void seleccionarRecupero() {
    menuRecuperoPage.irMenuRecupero();
  }

  @Step
  public void diligenciarCreacionRecupero(
      List<Recupero> lstRecupero, String tipoRecupero, String codigoRetencion) {
    lstRecupero.forEach(
        formulario -> {
          creacionRecuperoPage.seleccionarPagador(formulario.getPagador());
          creacionRecuperoPage.seleccionarLineaReserva(formulario.getLineaRecupero());
          creacionRecuperoPage.seleccionarMoneda(formulario.getMoneda());
          creacionRecuperoPage.seleccionarPais(formulario.getPais());
          creacionRecuperoPage.seleccionarDepartamento(formulario.getDepartamento());
          creacionRecuperoPage.seleccionarCiudad(formulario.getCiudad());
          creacionRecuperoPage.seleccionarCategoriaRecuperacion(tipoRecupero);
          creacionRecuperoPage.diligenciarCodigoRetencion(
              codigoRetencion, ReclamacionConstante.CODIGO_RETENCION);
          creacionRecuperoPage.diligenciarCantidadRecupero(
              formulario.getCantidad(), ReclamacionConstante.CANTIDAD);
          creacionRecuperoPage.actualizarRecupero();
        });
  }

  @Step
  public void validarCreacionRecupero(List<Recupero> lstRecupero) {
    lstRecupero.forEach(
        validador -> {
          assertTrue(verificacionRecuperoPage.validarRecupero(validador.getCategoriaRecupero()));
          assertTrue(verificacionRecuperoPage.validarRecupero(validador.getEstadoRecupero()));
        });
  }
}
