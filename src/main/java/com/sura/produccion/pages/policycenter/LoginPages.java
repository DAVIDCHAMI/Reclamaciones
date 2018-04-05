package com.sura.produccion.pages.policycenter;

import com.sura.produccion.pages.generics.GeneralPages;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPages extends GeneralPages {

  public LoginPages(WebDriver wDriver) {
    super(wDriver);
  }

  @FindBy(id = "country")
  WebElementFacade s;

  @FindBy(id = "username")
  WebElementFacade txtUsuario;

  @FindBy(id = "password")
  WebElementFacade txtPassword;

  @FindBy(xpath = "//input[@value='Iniciar sesión']")
  WebElementFacade btnIniciarSesion;

  public void seleccionarPais(String pais){
      seleccionarElemento(s, pais);
  }

  public void escribirUsuario(String usuario) {

      escribirDato(txtUsuario, usuario);
  }

  public void escribirPassword(String password){
      escribirDato(txtPassword, password);
  }

  public void clicIniciarSesion(){
      clickEnElemento(btnIniciarSesion);
  }


}
