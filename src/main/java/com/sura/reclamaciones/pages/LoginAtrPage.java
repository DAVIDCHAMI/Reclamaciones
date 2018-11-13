package com.sura.reclamaciones.pages;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://loginlab.sura.com/sso/servicelogin.aspx?continueTo=https%3A%2F%2Fappslab.suranet.com%2FATRSura&service=aplicaciones")
@NamedUrls({
    @NamedUrl(name = "uatAtr", url = "https://loginlab.sura.com/sso/servicelogin.aspx?continueTo=https%3A%2F%2Fappslab.suranet.com%2FATRSura&service=aplicaciones"),
})

public class LoginAtrPage extends GeneralPage{

    public LoginAtrPage(WebDriver wdriver) {
      super(wdriver);
    }

    @FindBy(id = "suranetName")
    private WebElementFacade txtUsuario;

    @FindBy(id = "suranetPassword")
    private WebElementFacade txtContrasena;

    @FindBy(id = "session-enterprise")
    private WebElementFacade btnIniciarSesion;

    public void iniciarSesionUAT(String usuario, String contrasena) {
      txtUsuario.type(usuario);
      txtContrasena.type(contrasena).sendKeys(Keys.ENTER);
    }
  }


