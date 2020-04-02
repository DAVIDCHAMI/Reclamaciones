package com.sura.reclamaciones.steps.guidewire.claimscenter.empresariales;

import static com.sura.reclamaciones.utils.enums.NombresCsv.CREDENCIAL;
import static net.serenitybdd.core.pages.PageObject.withParameters;

import com.sura.reclamaciones.models.Credencial;
import com.sura.reclamaciones.pages.guidewire.claimscenter.empresariales.AutenticacionAtrPage;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.GenericStep;
import com.sura.reclamaciones.utils.AmbientesUtil;
import java.io.IOException;
import java.util.List;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;

public class LoginAtrStep {
  @Page AutenticacionAtrPage autenticacionAtrPage;

  @Steps Credencial credencial;

  @Steps GenericStep genericStep;

  @Step
  public void abrirClaims() {
    AmbientesUtil ambientesUtil = new AmbientesUtil();
    autenticacionAtrPage.open(ambientesUtil.getAmbiente(), withParameters(""));
  }

  @Step
  public void iniciarSesionUAT(List<Credencial> datosCredencial) {
    datosCredencial.forEach(
        dato -> autenticacionAtrPage.iniciarSesionUAT(dato.getUsuario(), dato.getContrasena()));
  }

  @Step
  public void obtenerCredenciales(String analista) throws IOException {
    credencial = new Credencial(genericStep.getFilasModelo(CREDENCIAL.getValor(), analista));
    abrirClaims();
    iniciarSesionUAT(credencial.getCredenciales());
  }
}
