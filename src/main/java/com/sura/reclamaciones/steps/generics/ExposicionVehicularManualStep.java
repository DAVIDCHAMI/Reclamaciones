package com.sura.reclamaciones.steps.generics;

import static com.sura.reclamaciones.constantes.Constantes.PLACA;
import static com.sura.reclamaciones.constantes.Constantes.OPCION_MENU;
import static com.sura.reclamaciones.constantes.Constantes.COMODIN;
import static com.sura.reclamaciones.constantes.Constantes.RECLAMANTE_CONDUCTOR_AFECTADO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO;
import com.sura.reclamaciones.models.CodigoFasecolda;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevoIncidenteVehicularPage;
import com.sura.reclamaciones.pages.generics.CalculadoraCodigoFasecoldaPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;
import java.util.Map;
import com.sura.reclamaciones.pages.generics.NuevaExposicionVehiculoPage;
import net.serenitybdd.core.Serenity;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class ExposicionVehicularManualStep
{

  @Page MenuClaimPage menuClaimPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  @Page NuevaExposicionVehiculoPage nuevaExposicionManualPage;

  @Page NuevoIncidenteVehicularPage nuevoIncidenteVehicularPage;

  @Page CalculadoraCodigoFasecoldaPage calculadoraCodigoFasecoldaPage;

  @Step
  public void consultarPlacaAsegurado() {
    Serenity.setSessionVariable(PLACA.getValor()).to(resumenReclamacionPage.consultarNumeroPlaca());
  }

  @Step
  public void crearExposicionVehicularManual(
      List<Map<String, String>> opcionesCrearExposicion,
      List<ExposicionVehiculoTercero> datosVehiculoTercero,
      int numeroVehiculosInvolucradosTercero,
      List<CodigoFasecolda> datosCodigoFasecolda) {
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
      nuevaExposicionManualPage.seleccionarReclamanteExposicion(
              Serenity.sessionVariableCalled(SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO.getValor()));
      nuevaExposicionManualPage.seleccionarTipoReclamanteExposicion(
              RECLAMANTE_CONDUCTOR_AFECTADO.getValor());
      nuevaExposicionManualPage.crearNuevoIncidenteVehicular();
      nuevoIncidenteVehicularPage.ingresarPlacaVehiculoAfectado(datosVehiculoTercero, j);
      nuevoIncidenteVehicularPage.consultarInformacionVehiculoAfectado();
      nuevoIncidenteVehicularPage.validarPlacaExisteFasecolda();
      datosCodigoFasecolda.forEach(
              formulario -> {
                calculadoraCodigoFasecoldaPage.seleccionarClaseVehiculo(formulario.getClaseVehiculo());
                calculadoraCodigoFasecoldaPage.seleccionarModeloVehiculo(formulario.getModelo());
                calculadoraCodigoFasecoldaPage.seleccionarMarcaVehiculo(formulario.getMarca());
                calculadoraCodigoFasecoldaPage.seleccionarLineaVehiculo(formulario.getLinea());
              });
      /*introducirInformacionBeneficiarioPage.seleccionarTipoBeneficiario(
              diligenciador.getTipoBeneficiario());*/
      /*calculadoraCodigoFasecoldaPage.seleccionarModelo(datosCodigoFasecolda);
      calculadoraCodigoFasecoldaPage.seleccionarMarca(datosCodigoFasecolda);
      calculadoraCodigoFasecoldaPage.seleccionarLinea(datosCodigoFasecolda);*/
    }
  }
}
