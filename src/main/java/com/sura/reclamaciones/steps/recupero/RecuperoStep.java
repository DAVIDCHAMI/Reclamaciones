package com.sura.reclamaciones.steps.recupero;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
  public void seleccionarNumeroReclamacion(String nombreOpcion, List<Recupero> lstRecupero) {
    for (Recupero recupero : lstRecupero) {
      menuRecuperoPage.seleccionarOpcionMenuSegundoNivel(
          nombreOpcion, recupero.getNumeroReclamacion());
    }
  }

  @Step
  public void seleccionarRecupero(String tipoReserva) {
    menuRecuperoPage.irMenuRecupero(tipoReserva);
  }

  @Step
  public void diligenciarCreacionRecupero(
      List<Recupero> lstRecupero, String tipoRecupero, String codigoRetencion) {
    lstRecupero.forEach(
        autor -> {
          creacionRecuperoPage.seleccionarPagador(autor.getPagador());
          creacionRecuperoPage.seleccionarLineaReserva(autor.getLineaRecupero());
          creacionRecuperoPage.seleccionarMoneda(autor.getMoneda());
          creacionRecuperoPage.seleccionarPais(autor.getPais());
          creacionRecuperoPage.seleccionarDepartamento(autor.getDepartamento());
          creacionRecuperoPage.seleccionarCiudad(autor.getCiudad());
          creacionRecuperoPage.seleccionarCategoriaRecuperacion(tipoRecupero);
          creacionRecuperoPage.diligenciarComboboxTabla(codigoRetencion, "Código de retención");
          creacionRecuperoPage.diligenciarCantidadRecupero(autor.getCantidad(), "Cantidad");
          creacionRecuperoPage.actualizarRecupero();
        });
  }

  @Step
  public void validarCreacionRecupero(List<Recupero> lstRecupero) {
    lstRecupero.forEach(
        validador -> {
          assertTrue(verificacionRecuperoPage.validarRecupero(validador.getCategoriaRecupero()));
          assertFalse(verificacionRecuperoPage.validarRecupero(validador.getEstadoRecupero()));
        });
  }
}
