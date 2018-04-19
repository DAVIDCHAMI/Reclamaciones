package com.sura.reclamaciones.steps.ejemplos;

import static net.serenitybdd.core.pages.PageObject.withParameters;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import com.sura.reclamaciones.pages.ejemplos.HomePage;
import com.sura.reclamaciones.pages.ejemplos.SearchResultsPage;
import com.sura.reclamaciones.utils.AmbientesUtils;
import java.util.List;
import net.thucydides.core.annotations.Step;

public class BuyerSteps {

  HomePage homePage;
  SearchResultsPage searchResultsPage;

  @Step
  public void opens_etsy_home_page() {
    AmbientesUtils ambienteUtils = new AmbientesUtils();
    homePage.open(ambienteUtils.getAmbiente(), withParameters(""));
  }

  @Step
  public void searches_for_items_containing(String keywords) {
    homePage.searchFor(keywords);
  }

  @Step
  public void should_see_items_related_to(String keywords) {
    List<String> resultTitles = searchResultsPage.getResultTitles();
    resultTitles.stream().forEach(title -> assertThat(title, containsString(keywords)));
  }
}
