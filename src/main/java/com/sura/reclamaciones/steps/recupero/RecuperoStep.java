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
import org.openqa.selenium.WebElement;

public class RecuperoStep {

  @Page MenuRecuperoPage menuRecuperoPage;
  @Page CreacionRecuperoPage creacionRecuperoPage;
  @Page VerificacionRecuperoPage verificacionRecuperoPage;
  @Page MenuClaimPage menuClaimPage;

  @Step
  public void seleccionarNumeroReclamacion(String reclamacion, List<Recupero> lstRecupero) {
    for (Recupero menu : lstRecupero) {
      menuClaimPage.buscarReclamacion(reclamacion, menu.getNumeroReclamacion());
    }
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
        (Recupero validador) -> {
          List<WebElement> lstFilaRecupero = verificacionRecuperoPage.obtenerListaRecupero();
          assertTrue(
              "No coincide la categoria del recupero",
              verificacionRecuperoPage.verificarRecupero(
                  validador.getCategoriaRecupero(), lstFilaRecupero));
          assertTrue(
              "No llego a SAP el recupero",
              verificacionRecuperoPage.verificarRecupero(
                  validador.getEstadoRecupero(), lstFilaRecupero));
        });
  }
}
