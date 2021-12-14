package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"code", "coverages"})
public class CoverageCategory implements Serializable {
  @JsonProperty("code")
  private String code;

  @JsonProperty("coverages")
  private List<CoverageResponse> coverages = null;

  private static final long serialVersionUID = -2040197601680283210L;

  public CoverageCategory() {
    // constructor
  }

  @JsonProperty("code")
  public String getCode() {
    return this.code;
  }

  @JsonProperty("code")
  public void setCode(String code) {
    this.code = code;
  }

  @JsonProperty("coverages")
  public List<CoverageResponse> getCoverages() {
    return this.coverages;
  }

  @JsonProperty("coverages")
  public void setCoverages(List<CoverageResponse> coverages) {
    this.coverages = coverages;
  }
}
