package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"amount", "currency"})
public class ValueAccessories implements Serializable {

  @JsonProperty("amount")
  private Integer amount;

  @JsonProperty("currency")
  private String currency;

  private static final long serialVersionUID = -507085179384794808L;

  public ValueAccessories() {
    // constructor
  }

  @JsonProperty("amount")
  public Integer getAmount() {
    return this.amount;
  }

  @JsonProperty("amount")
  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @JsonProperty("currency")
  public String getCurrency() {
    return this.currency;
  }

  @JsonProperty("currency")
  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
