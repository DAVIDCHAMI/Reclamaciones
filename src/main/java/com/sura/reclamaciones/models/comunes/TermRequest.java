package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"patternCode", "chosenTerm", "required", "updated"})
public class TermRequest implements Serializable {
  @JsonProperty("patternCode")
  private String patternCode;

  @JsonProperty("chosenTerm")
  private String chosenTerm;

  @JsonProperty("required")
  private Boolean required;

  @JsonProperty("updated")
  private Boolean updated;

  private static final long serialVersionUID = -2710388914868284321L;

  public TermRequest() {
    // constructor
  }

  @JsonProperty("patternCode")
  public String getPatternCode() {
    return this.patternCode;
  }

  @JsonProperty("patternCode")
  public void setPatternCode(String patternCode) {
    this.patternCode = patternCode;
  }

  @JsonProperty("chosenTerm")
  public String getChosenTerm() {
    return this.chosenTerm;
  }

  @JsonProperty("chosenTerm")
  public void setChosenTerm(String chosenTerm) {
    this.chosenTerm = chosenTerm;
  }

  @JsonProperty("required")
  public Boolean getRequired() {
    return this.required;
  }

  @JsonProperty("required")
  public void setRequired(Boolean required) {
    this.required = required;
  }

  @JsonProperty("updated")
  public Boolean getUpdated() {
    return this.updated;
  }

  @JsonProperty("updated")
  public void setUpdated(Boolean updated) {
    this.updated = updated;
  }
}
