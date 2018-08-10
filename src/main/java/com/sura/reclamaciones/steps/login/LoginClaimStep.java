package com.sura.reclamaciones.steps.login;

import static net.serenitybdd.core.pages.PageObject.withParameters;

import com.sura.reclamaciones.models.Usuario;
import com.sura.reclamaciones.pages.login.LoginClaimPage;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.utils.AmbientesUtil;
import java.io.IOException;
import java.util.List;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;

public class LoginClaimStep {

  @Steps Usuario usuario;
  @Page LoginClaimPage loginClaimPage;
  @Steps GenericStep genericStep;

  @Step
  public void abrirClaims() {
    AmbientesUtil ambientesUtil = new AmbientesUtil();
    loginClaimPage.open(ambientesUtil.getAmbiente(), withParameters(""));
  }

  @Step
  public void iniciarSesionUAT(List<Usuario> datosUsuario) {
    datosUsuario.forEach(
        dato -> {
          loginClaimPage.inisiarSesionLAB(dato.getUsuario(), dato.getContrasena());
        });
  }

  @Step
  public void iniciarSesionDllo(List<Usuario> datosUsuario) {
    datosUsuario.forEach(
        dato -> {
          loginClaimPage.iniciarSesionDLLO(dato.getUsuario(), dato.getContrasena());
        });
  }

  @Step
  public void iniciarSesionLab() throws Exception {
    usuario = new Usuario(genericStep.getFilasModelo("credencial", "analistaReclamacionEmp"));
    abrirClaims();
    iniciarSesionUAT(usuario.getUsuarios());
  }

  @Step
  public void iniciarSesionAmbienteDllo() throws IOException {
    usuario = new Usuario(genericStep.getFilasModelo("credencial", "analistaDllo"));
    abrirClaims();
    iniciarSesionDllo(usuario.getUsuarios());
  }
}
