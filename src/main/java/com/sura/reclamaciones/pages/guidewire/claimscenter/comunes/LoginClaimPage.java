package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.pages.general.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://labcoreseguros.suramericana.com/cc/ClaimCenter.do")
@NamedUrls({
  // @NamedUrl(name = "local", url = "http://todomvc.com/examples/angularjs/#"),
  @NamedUrl(name = "dllo", url = "http://dllocoreseguros.suramericana.com:7005/cc/ClaimCenter.do"),
  @NamedUrl(name = "uat", url = "https://labcoreseguros.suramericana.com/cc/ClaimCenter.do"),
  @NamedUrl(name = "pdn", url = "https://coreseguros.suramericana.com/cc/ClaimCenter.do"),
})
public class LoginClaimPage extends GeneralPage {

  @FindBy(xpath = "//li[@class='ui-state-default ui-corner-top']/a")
  private WebElementFacade btnEmpleado;

  @FindBy(id = "ctl00_ContentMain_txtUser1")
  private WebElementFacade txtusuario;

  @FindBy(id = "ctl00_ContentMain_txtPassword1")
  private WebElementFacade txtcontrasena;

  @FindBy(id = "session-enterprise")
  private WebElementFacade btnIniciarSesion;

  @FindBy(id = "Login:LoginScreen:LoginDV:username-inputEl")
  private WebElementFacade txtNombreUsuario;

  @FindBy(id = "Login:LoginScreen:LoginDV:password-inputEl")
  private WebElementFacade txtContrasenaDllo;

  @FindBy(id = "Login:LoginScreen:LoginDV:submit-btnInnerEl")
  private WebElementFacade btnIniciarSesionDllo;

  public LoginClaimPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void iniciarSesionDLLO(String usuario, String contrasena) {
    txtNombreUsuario.type(usuario);
    txtContrasenaDllo.type(contrasena);
    btnIniciarSesionDllo.click();
  }

  public void iniciarSesionLAB(String usuario, String contrasena) {
    txtusuario.type(usuario);
    txtcontrasena.type(contrasena).sendKeys(Keys.ENTER);
  }
}
