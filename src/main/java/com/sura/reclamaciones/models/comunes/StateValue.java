package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"amount", "currency"})
public class StateValue implements Serializable {

  @JsonProperty("amount")
  private Integer amountState;

  @JsonProperty("currency")
  private String currencyState;

  private static final long serialVersionUID = -9082950668048829927L;

  public StateValue() {
    // constructor
  }

  @JsonProperty("amount")
  public Integer getAmountState() {
    return this.amountState;
  }

  @JsonProperty("amount")
  public void setAmountState(Integer amountState) {
    this.amountState = amountState;
  }

  @JsonProperty("currency")
  public String getCurrencyState() {
    return this.currencyState;
  }

  @JsonProperty("currency")
  public void setCurrencyState(String currencyState) {
    this.currencyState = currencyState;
  }
}
