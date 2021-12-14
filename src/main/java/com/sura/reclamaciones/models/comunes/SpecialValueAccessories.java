package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"amount", "currency"})
public class SpecialValueAccessories implements Serializable {

  @JsonProperty("amount")
  private Integer amountSpecial;

  @JsonProperty("currency")
  private String currencySpecial;

  private static final long serialVersionUID = 2819083822991047312L;

  public SpecialValueAccessories() {
    // constructor
  }

  @JsonProperty("amount")
  public Integer getAmountSpecial() {
    return this.amountSpecial;
  }

  @JsonProperty("amount")
  public void setAmountSpecial(Integer amountSpecial) {
    this.amountSpecial = amountSpecial;
  }

  @JsonProperty("currency")
  public String getCurrencySpecial() {
    return this.currencySpecial;
  }

  @JsonProperty("currency")
  public void setCurrencySpecial(String currencySpecial) {
    this.currencySpecial = currencySpecial;
  }
}
