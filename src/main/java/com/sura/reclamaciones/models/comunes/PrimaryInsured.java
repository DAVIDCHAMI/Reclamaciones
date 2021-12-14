package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"person"})
public class PrimaryInsured implements Serializable {
  @JsonProperty("person")
  private Person person;

  private static final long serialVersionUID = -8463852335926922132L;

  public PrimaryInsured() {
    // constructor
  }

  @JsonProperty("person")
  public Person getPerson() {
    return this.person;
  }

  @JsonProperty("person")
  public void setPerson(Person person) {
    this.person = person;
  }
}
