package com.sura.reclamaciones.pages.login;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://labcoreseguros.suramericana.com/cc/ClaimCenter.do")
@NamedUrls({
  //@NamedUrl(name = "local", url = "http://todomvc.com/examples/angularjs/#"),
  @NamedUrl(name = "dllo", url = "http://dllocoreseguros.suramericana.com:7005/cc/ClaimCenter.do"),
  @NamedUrl(name = "uat", url = "https://labcoreseguros.suramericana.com/cc/ClaimCenter.do"),
  @NamedUrl(name = "pdn", url = "https://coreseguros.suramericana.com/cc/ClaimCenter.do"),
})
public class LoginClaimPage extends GeneralPage {

  public LoginClaimPage(WebDriver wdriver) {
    super(wdriver);
  }

  @FindBy(id = "idTabEmpleado")
  private WebElementFacade btnEmpleado;

  @FindBy(id = "suranetName")
  private WebElementFacade txtusuario;

  @FindBy(id = "suranetPassword")
  private WebElementFacade txtcontrasena;

  @FindBy(id = "session-enterprise")
  private WebElementFacade btnIniciarSesion;

  @FindBy(id = "Login:LoginScreen:LoginDV:username-inputEl")
  private WebElementFacade txtNombreUsuario;

  @FindBy(id = "Login:LoginScreen:LoginDV:password-inputEl")
  private WebElementFacade txtContrasenaDllo;

  @FindBy(id = "Login:LoginScreen:LoginDV:submit-btnInnerEl")
  private WebElementFacade btnIniciarSesionDllo;

  public void iniciarSesionDLLO(String usuario, String contrasena) {
    txtNombreUsuario.type(usuario);
    txtContrasenaDllo.type(contrasena);
    btnIniciarSesionDllo.click();
  }

  public void inisiarSesionLAB(String usuario, String contrasena) {
    btnEmpleado.click();
    txtusuario.type(usuario);
    txtcontrasena.type(contrasena).sendKeys(Keys.ENTER);
  }
}
