package com.sura.reclamaciones.steps.recupero;

import static com.sura.reclamaciones.utils.Constantes.CANTIDAD;
import static com.sura.reclamaciones.utils.Constantes.CODIGO_RETENCION;

import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import com.sura.reclamaciones.pages.recupero.CreacionRecuperoPage;
import com.sura.reclamaciones.pages.recupero.MenuRecuperoPage;
import com.sura.reclamaciones.pages.recupero.VerificacionRecuperoPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

public class RecuperoStep {

  @Page MenuRecuperoPage menuRecuperoPage;

  @Page CreacionRecuperoPage creacionRecuperoPage;

  @Page VerificacionRecuperoPage verificacionRecuperoPage;

  @Page MenuClaimPage menuClaimPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  @Step
  public void seleccionarNumeroReclamacion(String reclamacionMenu, List<Recupero> lstRecupero) {
    resumenReclamacionPage.obtenerNumeroReclamacion();
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
              codigoRetencion, CODIGO_RETENCION.getValor());
          creacionRecuperoPage.diligenciarCantidadRecupero(
              formulario.getValorTransaccion(), CANTIDAD.getValor());
          creacionRecuperoPage.actualizarRecupero();
        });
  }

  @Step
  public void verificarCreacionRecupero(List<Recupero> lstRecupero) {
    lstRecupero.forEach(
        (Recupero validador) -> {
          List<WebElement> lstFilaRecupero = verificacionRecuperoPage.obtenerListaRecupero();
          MatcherAssert.assertThat(
              "No coincide la categoria del recupero",
              verificacionRecuperoPage.verificarRecupero(
                  validador.getCategoriaRecupero(), lstFilaRecupero));
          MatcherAssert.assertThat(
              "No llego a SAP el recupero",
              verificacionRecuperoPage.verificarRecupero(
                  validador.getEstadoTransaccion(), lstFilaRecupero));
        });
  }
}
