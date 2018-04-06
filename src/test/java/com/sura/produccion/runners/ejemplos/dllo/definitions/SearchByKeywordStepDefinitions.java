package com.sura.produccion.runners.ejemplos.dllo.definitions;

import com.sura.produccion.models.Vehiculo;
import com.sura.produccion.steps.ejemplos.BuyerSteps;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.util.List;
import net.thucydides.core.annotations.Steps;

public class SearchByKeywordStepDefinitions {
  @Steps BuyerSteps buyer;

  @Dado("I want to buy (.*)")
  public void buyerWantsToBuy(String article) {
    buyer.opens_etsy_home_page();
  }

  @Cuando("I search for items containing '(.*)'")
  public void searchByKeyword(String keyword) {
    buyer.searches_for_items_containing(keyword);
  }

  @Entonces("I should only see items related to '(.*)'")
  public void resultsForACategoryAndKeywordInARegion(String keyword) {
    buyer.should_see_items_related_to(keyword);
  }

  @Entonces("agrego el siguiente vehiculo$")
  public void resultsForACategoryAndKeywordInARegion(DataTable datosVehiculo) {
    List<Vehiculo> miVehiculo = datosVehiculo.asList(Vehiculo.class);
    System.out.println(miVehiculo.get(0).getPlaca());
  }
}
