package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"coverageCategory", "coverages"})
public class VehicleCoverage implements Serializable {
  @JsonProperty("coverageCategory")
  private String coverageCategory;

  @JsonProperty("coverages")
  private List<CoverageRequest> coverages = null;

  private static final long serialVersionUID = 2646846771374404590L;

  public VehicleCoverage() {
    // constructor
  }

  @JsonProperty("coverageCategory")
  public String getCoverageCategory() {
    return this.coverageCategory;
  }

  @JsonProperty("coverageCategory")
  public void setCoverageCategory(String coverageCategory) {
    this.coverageCategory = coverageCategory;
  }

  @JsonProperty("coverages")
  public List<CoverageRequest> getCoverages() {
    return this.coverages;
  }

  @JsonProperty("coverages")
  public void setCoverages(List<CoverageRequest> coverages) {
    this.coverages = coverages;
  }
}
