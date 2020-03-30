package com.sura.reclamaciones.steps.guidewire.claimscenter;

import static com.sura.reclamaciones.constantes.Constantes.CANTIDAD;
import static com.sura.reclamaciones.constantes.Constantes.CODIGO_RETENCION;
import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_RECUPERO;
import static com.sura.reclamaciones.constantes.Constantes.UBICACION_ESTADO_RECUPERO;

import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.pages.general.NuevaReclamacionGuardadaPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.CreacionRecuperoPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.MenuRecuperoPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.VerificacionRecuperoPage;
import java.util.ArrayList;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

public class RecuperoStep {

  @Page CreacionRecuperoPage creacionRecuperoPage;

  @Page GeneralPage generalPage;

  @Page MenuRecuperoPage menuRecuperoPage;

  @Page VerificacionRecuperoPage verificacionRecuperoPage;

  @Page NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;

  @Step
  public void seleccionarNumeroReclamacion() {
    nuevaReclamacionGuardadaPage.obtenerNumeroReclamacion();
  }

  @Step
  public void diligenciarCreacionRecupero(List<Recupero> lstRecupero, String codigoRetencion) {
    menuRecuperoPage.ingresarMenuRecupero();
    lstRecupero.forEach(
        formulario -> {
          creacionRecuperoPage.seleccionarPagador(formulario.getPagador());
          creacionRecuperoPage.seleccionarLineaReserva(formulario.getLineaRecupero());
          creacionRecuperoPage.seleccionarPais(formulario.getPais());
          creacionRecuperoPage.seleccionarDepartamento(formulario.getDepartamento());
          creacionRecuperoPage.seleccionarCiudad(formulario.getCiudad());
          creacionRecuperoPage.seleccionarCategoriaRecuperacion(formulario.getCategoriaRecupero());
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
          List<WebElement> lstFilaRecupero = new ArrayList<>();
          for (int i = 0; i <= Integer.parseInt(ITERACIONES_RECUPERO.getValor()); i++) {
            generalPage.realizarEsperaCarga();
            lstFilaRecupero = verificacionRecuperoPage.obtenerListaRecupero();
            WebElement elementoXpath =
                lstFilaRecupero.get(Integer.parseInt(UBICACION_ESTADO_RECUPERO.getValor()));
            boolean estadoTransaccionPantalla =
                generalPage.actualizarPantalla(validador.getEstadoTransaccion(), elementoXpath);
            if (estadoTransaccionPantalla) break;
          }
          MatcherAssert.assertThat(
              "No coincide la categoria del creacionrecupero",
              verificacionRecuperoPage.verificarRecupero(
                  validador.getCategoriaRecupero(), lstFilaRecupero));
          MatcherAssert.assertThat(
              "No llego a SAP el creacionrecupero",
              verificacionRecuperoPage.verificarRecupero(
                  validador.getEstadoTransaccion(), lstFilaRecupero));
        });
  }
}
