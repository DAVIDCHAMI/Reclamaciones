package com.sura.reclamaciones.steps.login;

import static net.serenitybdd.core.pages.PageObject.withParameters;

import com.sura.reclamaciones.models.Usuario.UsuarioVO;
import com.sura.reclamaciones.pages.login.LoginClaimPage;
import com.sura.reclamaciones.utils.AmbientesUtil;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class LoginClaimStep {

  @Page LoginClaimPage loginClaimPage;

  @Step
  public void abrirClaims() {
    AmbientesUtil ambientesUtil = new AmbientesUtil();
    loginClaimPage.open(ambientesUtil.getAmbiente(), withParameters(""));
  }

  @Step
  public void iniciarSesionUAT(String usuario, String pass) {
    loginClaimPage.inisiarSesionLAB(usuario, pass);
  }

  @Step
  public void iniciarSesionDllo(String usuario, String contrasena) {
    loginClaimPage.iniciarSesionDLLO(usuario, contrasena);
  }

  @Step
  public void iniciarSesionLab() {
    UsuarioVO usuarioVO = new UsuarioVO("suragwsu", "sura2017");
    abrirClaims();
    iniciarSesionUAT(usuarioVO.getUsuario(), usuarioVO.getContrasena());
  }

  @Step
  public void iniciarSesionAmbienteDllo() {
    UsuarioVO usuarioVO = new UsuarioVO("su", "gw");
    abrirClaims();
    iniciarSesionDllo(usuarioVO.getUsuario(), usuarioVO.getContrasena());
  }
}
