package com.sura.reclamaciones.steps.login;

import static net.serenitybdd.core.pages.PageObject.withParameters;

import com.sura.reclamaciones.models.Usuario;
import com.sura.reclamaciones.pages.login.LoginClaimPage;
import com.sura.reclamaciones.steps.generics.CSVStep;
import com.sura.reclamaciones.utils.AmbientesUtil;
import java.util.List;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;

public class LoginClaimStep {

  @Page LoginClaimPage loginClaimPage;

  Usuario usuario;
  @Steps CSVStep csvStep;

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
    usuario = new Usuario(csvStep.getFilasModelo("credencial", "identificador", "COL001"));
    abrirClaims();
    iniciarSesionUAT(usuario.getUsuarios());
  }

  @Step
  public void iniciarSesionAmbienteDllo() {
    abrirClaims();
    iniciarSesionDllo(usuario.getUsuarios());
  }
}
