package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"addressLine1", "country", "state", "city", "addressType"})
public class Address implements Serializable {
  @JsonProperty("addressLine1")
  private String addressLine1;

  @JsonProperty("country")
  private String country;

  @JsonProperty("state")
  private String state;

  @JsonProperty("city")
  private String city;

  @JsonProperty("addressType")
  private String addressType;

  private static final long serialVersionUID = -7151197055754102160L;

  public Address() {
    // constructor
  }

  @JsonProperty("addressLine1")
  public String getAddressLine1() {
    return this.addressLine1;
  }

  @JsonProperty("addressLine1")
  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  @JsonProperty("country")
  public String getCountry() {
    return this.country;
  }

  @JsonProperty("country")
  public void setCountry(String country) {
    this.country = country;
  }

  @JsonProperty("state")
  public String getState() {
    return this.state;
  }

  @JsonProperty("state")
  public void setState(String state) {
    this.state = state;
  }

  @JsonProperty("city")
  public String getCity() {
    return this.city;
  }

  @JsonProperty("city")
  public void setCity(String city) {
    this.city = city;
  }

  @JsonProperty("addressType")
  public String getAddressType() {
    return this.addressType;
  }

  @JsonProperty("addressType")
  public void setAddressType(String addressType) {
    this.addressType = addressType;
  }
}
