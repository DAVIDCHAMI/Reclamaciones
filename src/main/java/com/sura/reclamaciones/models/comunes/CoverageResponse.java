package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"code", "amount", "terms"})
public class CoverageResponse implements Serializable {
  @JsonProperty("code")
  private String code;

  @JsonProperty("amount")
  private Integer amount;

  @JsonProperty("terms")
  private List<TermRequest> terms = null;

  private static final long serialVersionUID = -3508373856969322897L;

  public CoverageResponse() {
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

  @JsonProperty("amount")
  public Integer getAmount() {
    return this.amount;
  }

  @JsonProperty("amount")
  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @JsonProperty("terms")
  public List<TermRequest> getTerms() {
    return this.terms;
  }

  @JsonProperty("terms")
  public void setTerms(List<TermRequest> terms) {
    this.terms = terms;
  }
}
