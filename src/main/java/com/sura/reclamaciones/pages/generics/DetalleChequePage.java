package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_ANULACION;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetalleChequePage extends GeneralPage {

  public DetalleChequePage(WebDriver wdriver) {
    super(wdriver);
  }

  public boolean realizarAnulacionCheque() {
    for (int i = 0; i <= Integer.parseInt(ITERACIONES_ANULACION.getValor()); i++)
      if (btnAnular.containsElements(
          By.xpath(
              "//span[@class='x-btn-button']//span[contains(text(),'Anular')]//ancestor::a[contains(@class,'disabled')]"))) {
        realizarEsperaCarga();
        driver.navigate().refresh();
      } else {
        anularTransaccion();
        return true;
      }
    return false;
  }
}
