package com.sura.reclamaciones.steps.login;

import static net.serenitybdd.core.pages.PageObject.withParameters;

import com.sura.reclamaciones.models.Credencial;
import com.sura.reclamaciones.pages.LoginAtrPage;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.utils.AmbientesUtil;
import java.io.IOException;
import java.util.List;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;

public class LoginAtrStep {
  @Page
  LoginAtrPage loginAtrPage;
  @Steps
  Credencial credencial;
  @Steps
  GenericStep genericStep;

  @Step
  public void abrirClaims() {
    AmbientesUtil ambientesUtil = new AmbientesUtil();
    loginAtrPage.open(ambientesUtil.getAmbiente(), withParameters(""));
  }

  @Step
  public void iniciarSesionUAT(List<Credencial> datosCredencial) {
    datosCredencial.forEach(
        dato -> {
          loginAtrPage.iniciarSesionUAT(dato.getUsuario(), dato.getContrasena());
        });
  }

  @Step
  public void iniciarSesionLab(String analista) throws IOException {
    credencial = new Credencial(genericStep.getFilasModelo("credencial", analista));
    abrirClaims();
    iniciarSesionUAT(credencial.getCredenciales());
  }

}
