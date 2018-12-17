package com.sura.reclamaciones.pages.login;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.WebDriver;

@DefaultUrl(
    "https://arlappslab.suramericana.com/SSAutenticacion/faces/autenticacion/paginaAutenticacion.jspx?cdApp=SURACOM&cookies=false&ReturnUrl=%2fdefault.aspx")
@NamedUrls({
  @NamedUrl(
    name = "uat",
    url =
        "https://arlappslab.suramericana.com/SSAutenticacion/faces/autenticacion/paginaAutenticacion.jspx?cdApp=SURACOM&cookies=false"
  ),
})
public class AutenticacionAtrPage extends GeneralPage {

  public AutenticacionAtrPage(WebDriver wdriver) {
    super(wdriver);
  }

  private String btnClave =
      "//img[@src='/SSAutenticacion/imagenes/teclado/btnTec_COMODIN_off.gif']";
  private String auxiliarBtnClave = "";

  @FindBy(id = "tempUserID")
  private WebElementFacade txtUsuario;

  @FindBy(id = "autenticacionUsuario:tipoDocUsuario")
  private WebElementFacade lstTipoDocumento;

  @FindBy(id = "autenticacionUsuario:claveUsuario")
  private WebElementFacade txtClave;

  @FindBy(id = "medidasSeg:aceptar")
  private WebElementFacade btnAceptarCondicionUso;

  @FindBy(xpath = "//option[@value='C']")
  private WebElementFacade lstCedula;

  @FindBy(xpath = "//table[@width='36%']")
  private WebElementFacade tblNumeros;

  @FindBy(xpath = "//img[@src='/SSAutenticacion/imagenes/btnIngresar.jpg']")
  private WebElementFacade btnIngresar;

  public void iniciarSesionUAT(String usuario, String contrasena) {
    lstTipoDocumento.click();
    lstCedula.click();
    for (int cadenaString = 0; cadenaString < 4; cadenaString++) {
      String digito = contrasena.substring(cadenaString, cadenaString + 1);
      auxiliarBtnClave = btnClave.replace(ConstanteGlobal.COMODIN, digito);
      $(auxiliarBtnClave).click();
      txtClave.click();
    }
    txtUsuario.type(usuario);
    btnIngresar.click();
    btnAceptarCondicionUso.waitUntilVisible().click();
  }
}
