package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
  "codeModifier",
  "typeModifier",
  "bigDecimalValue",
  "stringValue",
  "booleanValue"
})
public class Modifier implements Serializable {

  @JsonProperty("codeModifier")
  private String codeModifier;

  @JsonProperty("typeModifier")
  private String typeModifier;

  @JsonProperty("bigDecimalValue")
  private Integer bigDecimalValue;

  @JsonProperty("stringValue")
  private String stringValue;

  @JsonProperty("booleanValue")
  private Boolean booleanValue;

  private static final long serialVersionUID = 3136351025459843374L;

  public Modifier() {
    // constructor
  }

  @JsonProperty("codeModifier")
  public String getCodeModifier() {
    return this.codeModifier;
  }

  @JsonProperty("codeModifier")
  public void setCodeModifier(String codeModifier) {
    this.codeModifier = codeModifier;
  }

  @JsonProperty("typeModifier")
  public String getTypeModifier() {
    return this.typeModifier;
  }

  @JsonProperty("typeModifier")
  public void setTypeModifier(String typeModifier) {
    this.typeModifier = typeModifier;
  }

  @JsonProperty("bigDecimalValue")
  public Integer getBigDecimalValue() {
    return this.bigDecimalValue;
  }

  @JsonProperty("bigDecimalValue")
  public void setBigDecimalValue(Integer bigDecimalValue) {
    this.bigDecimalValue = bigDecimalValue;
  }

  @JsonProperty("stringValue")
  public String getStringValue() {
    return this.stringValue;
  }

  @JsonProperty("stringValue")
  public void setStringValue(String stringValue) {
    this.stringValue = stringValue;
  }

  @JsonProperty("booleanValue")
  public Boolean getBooleanValue() {
    return this.booleanValue;
  }

  @JsonProperty("booleanValue")
  public void setBooleanValue(Boolean booleanValue) {
    this.booleanValue = booleanValue;
  }
}
