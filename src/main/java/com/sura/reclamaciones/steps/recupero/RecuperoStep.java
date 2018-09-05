package com.sura.reclamaciones.steps.recupero;

import static org.junit.Assert.assertTrue;

import com.sura.reclamaciones.constantes.RecuperoConstante;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
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
  @Page MenuClaimPage menuClaimPage;

  @Step
  public void seleccionarNumeroReclamacion(String reclamacion, List<Recupero> lstRecupero) {
    lstRecupero.forEach(
        menu -> {
          menuClaimPage.seleccionarOpcionMenuPrimerNivel(reclamacion);
          menuClaimPage.buscarReclamacion(menu.getNumeroReclamacion());
        });
  }

  public void seleccionarRecupero() {
    menuRecuperoPage.ingresarMenuRecupero();
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
              codigoRetencion, RecuperoConstante.CODIGO_RETENCION);
          creacionRecuperoPage.diligenciarCantidadRecupero(
              formulario.getCantidad(), RecuperoConstante.CANTIDAD);
          creacionRecuperoPage.actualizarRecupero();
        });
  }

  @Step
  public void verificarCreacionRecupero(List<Recupero> lstRecupero) {
    lstRecupero.forEach(
        validador -> {
          assertTrue(verificacionRecuperoPage.verificarRecupero(validador.getCategoriaRecupero()));
          assertTrue(verificacionRecuperoPage.verificarRecupero(validador.getEstadoRecupero()));
        });
  }
}
