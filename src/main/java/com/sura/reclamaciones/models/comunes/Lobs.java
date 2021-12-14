package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"personalAuto"})
public class Lobs implements Serializable {
  @JsonProperty("personalAuto")
  private PersonalAuto personalAuto;

  private static final long serialVersionUID = -2057671813949938483L;

  public Lobs() {
    // constructor
  }

  @JsonProperty("personalAuto")
  public PersonalAuto getPersonalAuto() {
    return this.personalAuto;
  }

  @JsonProperty("personalAuto")
  public void setPersonalAuto(PersonalAuto personalAuto) {
    this.personalAuto = personalAuto;
  }
}
