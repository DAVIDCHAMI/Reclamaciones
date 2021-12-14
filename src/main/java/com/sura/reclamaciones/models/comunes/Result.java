package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sura.service.expedicionautosindividual.gen.QuotingData;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"quotingData", "idCustom"})
public class Result implements Serializable {
  @JsonProperty("quotingData")
  private QuotingData quotingData;

  @JsonProperty("idCustom")
  private String idCustom;

  private static final long serialVersionUID = 1819521972115472528L;

  public Result() {
    // constructor
  }

  @JsonProperty("quotingData")
  public QuotingData getQuotingData() {
    return this.quotingData;
  }

  @JsonProperty("quotingData")
  public void setQuotingData(QuotingData quotingData) {
    this.quotingData = quotingData;
  }

  @JsonProperty("idCustom")
  public String getIdCustom() {
    return this.idCustom;
  }

  @JsonProperty("idCustom")
  public void setIdCustom(String idCustom) {
    this.idCustom = idCustom;
  }
}
