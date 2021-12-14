package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"producerCode", "primaryInsured"})
public class Account implements Serializable {

  @JsonProperty("producerCode")
  private String producerCode;

  @JsonProperty("primaryInsured")
  private PrimaryInsured primaryInsured;

  private static final long serialVersionUID = -4989701136431313775L;

  public Account() {
    // constructor
  }

  @JsonProperty("producerCode")
  public String getProducerCode() {
    return this.producerCode;
  }

  @JsonProperty("producerCode")
  public void setProducerCode(String producerCode) {
    this.producerCode = producerCode;
  }

  @JsonProperty("primaryInsured")
  public PrimaryInsured getPrimaryInsured() {
    return this.primaryInsured;
  }

  @JsonProperty("primaryInsured")
  public void setPrimaryInsured(PrimaryInsured primaryInsured) {
    this.primaryInsured = primaryInsured;
  }
}
