package com.sura.reclamaciones.pages.ejemplos;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://www.local-etsy.com")
@NamedUrls({
  @NamedUrl(name = "local", url = "http://www.etsy.com"),
  @NamedUrl(name = "dllo", url = "http://www.etsy.com"),
  @NamedUrl(name = "lab", url = "http://www.etsy.com"),
  @NamedUrl(name = "pdn", url = "http://www.etsy.com")
})
public class HomePage extends PageObject {

  @FindBy(css = "button[value='Search']")
  WebElement searchButton;

  public void searchFor(String keywords) {
    $("#search-query").sendKeys(keywords);
    searchButton.click();
  }
}
