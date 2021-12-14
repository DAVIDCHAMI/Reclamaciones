package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"amount", "currency"})
public class CostNew implements Serializable {

  @JsonProperty("amount")
  private Integer amountCost;

  @JsonProperty("currency")
  private String currencyCost;

  private static final long serialVersionUID = -7815508851296440950L;

  public CostNew() {
    // constructor
  }

  @JsonProperty("amount")
  public Integer getAmountCost() {
    return this.amountCost;
  }

  @JsonProperty("amount")
  public void setAmountCost(Integer amountCost) {
    this.amountCost = amountCost;
  }

  @JsonProperty("currency")
  public String getCurrencyCost() {
    return this.currencyCost;
  }

  @JsonProperty("currency")
  public void setCurrencyCost(String currencyCost) {
    this.currencyCost = currencyCost;
  }
}
