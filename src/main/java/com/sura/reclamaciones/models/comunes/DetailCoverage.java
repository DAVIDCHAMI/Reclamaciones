package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"plate", "currency", "coverageCategories"})
public class DetailCoverage implements Serializable {
  @JsonProperty("plate")
  private String plate;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("coverageCategories")
  private List<CoverageCategory> coverageCategories = null;

  private static final long serialVersionUID = 330740853544996833L;

  public DetailCoverage() {
    // constructor
  }

  @JsonProperty("plate")
  public String getPlate() {
    return this.plate;
  }

  @JsonProperty("plate")
  public void setPlate(String plate) {
    this.plate = plate;
  }

  @JsonProperty("currency")
  public String getCurrency() {
    return this.currency;
  }

  @JsonProperty("currency")
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @JsonProperty("coverageCategories")
  public List<CoverageCategory> getCoverageCategories() {
    return this.coverageCategories;
  }

  @JsonProperty("coverageCategories")
  public void setCoverageCategories(List<CoverageCategory> coverageCategories) {
    this.coverageCategories = coverageCategories;
  }
}
