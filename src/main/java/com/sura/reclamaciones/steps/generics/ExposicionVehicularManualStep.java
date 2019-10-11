package com.sura.reclamaciones.steps.generics;

import static com.sura.reclamaciones.constantes.Constantes.COMODIN;
import static com.sura.reclamaciones.constantes.Constantes.OPCION_MENU;
import static com.sura.reclamaciones.constantes.Constantes.PLACA;
import static com.sura.reclamaciones.constantes.Constantes.RECLAMANTE_CONDUCTOR_AFECTADO;
import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.pages.autos.reclamacion.CreacionServicioPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleVehiculoPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevoIncidenteVehicularPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.NuevaExposicionVehiculoPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import java.util.List;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class ExposicionVehicularManualStep {

  @Page MenuClaimPage menuClaimPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  @Page NuevaExposicionVehiculoPage nuevaExposicionManualPage;

  @Page NuevoIncidenteVehicularPage nuevoIncidenteVehicularPage;

  @Page DetalleVehiculoPage detalleVehiculoPage;

  @Page CreacionServicioPage crearServicioPage;

  @Step
  public void consultarPlacaAsegurado() {
    Serenity.setSessionVariable(PLACA.getValor()).to(resumenReclamacionPage.consultarNumeroPlaca());
  }

  @Step
  public void crearExposicionVehicularManual(
      List<Map<String, String>> opcionesCrearExposicion,
      List<ExposicionVehiculoTercero> datosVehiculoTercero,
      int numeroVehiculosInvolucradosTercero) {
    for (int j = 0; j <= numeroVehiculosInvolucradosTercero - 1; j++) {
      menuClaimPage.seleccionarBotonAcciones();
      for (int i = 0; i < opcionesCrearExposicion.size(); i++) {
        if (opcionesCrearExposicion
            .listIterator(i)
            .next()
            .get(OPCION_MENU.getValor())
            .equals(COMODIN.getValor())) {
          opcionesCrearExposicion
              .listIterator(i)
              .next()
              .replace(
                  OPCION_MENU.getValor(),
                  COMODIN.getValor(),
                  Serenity.sessionVariableCalled(PLACA.getValor()));
        }
        String opcionMenu =
            opcionesCrearExposicion.listIterator(i).next().get(OPCION_MENU.getValor());
        menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(opcionMenu);
      }
      nuevaExposicionManualPage.seleccionarReclamanteExposicion();
      nuevaExposicionManualPage.seleccionarTipoReclamanteExposicion(
          RECLAMANTE_CONDUCTOR_AFECTADO.getValor());
      nuevaExposicionManualPage.crearNuevoIncidenteVehicular();
      nuevoIncidenteVehicularPage.ingresarPlacaVehiculoAfectado(datosVehiculoTercero, j);
      nuevoIncidenteVehicularPage.consultarInformacionVehiculoAfectado();
      datosVehiculoTercero.forEach(
          formularioLugarAtencion -> {
            nuevoIncidenteVehicularPage.seleccionarLugarAtencion(
                formularioLugarAtencion.getLugarAtencion());
            nuevoIncidenteVehicularPage.seleccionarPaisAtencion(
                formularioLugarAtencion.getPaisAtencion());
            nuevoIncidenteVehicularPage.seleccionarDepartamentoAtencion(
                formularioLugarAtencion.getDepartamentoAtencion());
            nuevoIncidenteVehicularPage.seleccionarCiudadAtencion(
                formularioLugarAtencion.getCiudadAtencion());
            nuevoIncidenteVehicularPage.seleccionarDireccionAtencion(
                formularioLugarAtencion.getDireccionAtencion());
          });
      nuevoIncidenteVehicularPage.seleccionarConductorVehiculoAfectado();
      nuevoIncidenteVehicularPage.seleccionarServiciosTaller();
      nuevoIncidenteVehicularPage.seleccionarTaller();
      detalleVehiculoPage.buscarProveedor();
      detalleVehiculoPage.realizarEsperaCarga();
      crearServicioPage.seleccionarProveedor(
          datosVehiculoTercero
              .get(Integer.parseInt(VALOR_CERO.getValor()))
              .getTallerReparacionAsignado());
      detalleVehiculoPage.aceptarOpcion();
      nuevoIncidenteVehicularPage.aceptarOpcion();
      nuevaExposicionManualPage.actualizarNuevaExposicion();
    }
  }
}
