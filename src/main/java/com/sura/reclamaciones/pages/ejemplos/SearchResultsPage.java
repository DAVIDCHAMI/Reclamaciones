package com.sura.reclamaciones.pages.ejemplos;

import java.util.List;
import java.util.stream.Collectors;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends PageObject {

  @FindBy(css = ".listing-card")
  List<WebElement> listingCards;

  public List<String> getResultTitles() {
    return listingCards.stream().map(element -> element.getText()).collect(Collectors.toList());
  }
}
