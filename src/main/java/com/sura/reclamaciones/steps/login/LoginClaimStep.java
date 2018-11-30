package com.sura.reclamaciones.steps.login;

import static net.serenitybdd.core.pages.PageObject.withParameters;

import com.sura.reclamaciones.models.Credencial;
import com.sura.reclamaciones.pages.login.LoginClaimPage;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.utils.AmbientesUtil;
import java.io.IOException;
import java.util.List;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;

public class LoginClaimStep {

  @Steps Credencial credencial;
  @Page LoginClaimPage loginClaimPage;
  @Steps GenericStep genericStep;

  @Step
  public void abrirClaims() {
    AmbientesUtil ambientesUtil = new AmbientesUtil();
    loginClaimPage.open(ambientesUtil.getAmbiente(), withParameters(""));
  }

  @Step
  public void iniciarSesionUAT(List<Credencial> datosCredencial) {
    datosCredencial.forEach(
        dato -> loginClaimPage.inisiarSesionLAB(dato.getUsuario(), dato.getContrasena()));
  }

  @Step
  public void iniciarSesionDllo(List<Credencial> datosCredencial) {
    datosCredencial.forEach(
        dato -> loginClaimPage.iniciarSesionDLLO(dato.getUsuario(), dato.getContrasena()));
  }

  @Step
  public void iniciarSesionLab(String analista) throws IOException {
    credencial = new Credencial(genericStep.getFilasModelo("credencial", analista));
    abrirClaims();
    iniciarSesionUAT(credencial.getCredenciales());
  }

  @Step
  public void iniciarSesionAmbienteDllo() throws IOException {
    credencial = new Credencial(genericStep.getFilasModelo("credencial", "analistaDllo"));
    abrirClaims();
    iniciarSesionDllo(credencial.getCredenciales());
  }
}
