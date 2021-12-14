package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"selectedPaymentPlan", "financingIntention", "customBilling", "automatic"})
public class BillingData implements Serializable {
  @JsonProperty("selectedPaymentPlan")
  private String selectedPaymentPlan;

  @JsonProperty("financingIntention")
  private Boolean financingIntention;

  @JsonProperty("customBilling")
  private Boolean customBilling;

  @JsonProperty("automatic")
  private Boolean automatic;

  private static final long serialVersionUID = 5272967793447257392L;

  public BillingData() {
    // constructor
  }

  @JsonProperty("selectedPaymentPlan")
  public String getSelectedPaymentPlan() {
    return this.selectedPaymentPlan;
  }

  @JsonProperty("selectedPaymentPlan")
  public void setSelectedPaymentPlan(String selectedPaymentPlan) {
    this.selectedPaymentPlan = selectedPaymentPlan;
  }

  @JsonProperty("financingIntention")
  public Boolean getFinancingIntention() {
    return this.financingIntention;
  }

  @JsonProperty("financingIntention")
  public void setFinancingIntention(Boolean financingIntention) {
    this.financingIntention = financingIntention;
  }

  @JsonProperty("customBilling")
  public Boolean getCustomBilling() {
    return this.customBilling;
  }

  @JsonProperty("customBilling")
  public void setCustomBilling(Boolean customBilling) {
    this.customBilling = customBilling;
  }

  @JsonProperty("automatic")
  public Boolean getAutomatic() {
    return this.automatic;
  }

  @JsonProperty("automatic")
  public void setAutomatic(Boolean automatic) {
    this.automatic = automatic;
  }
}
