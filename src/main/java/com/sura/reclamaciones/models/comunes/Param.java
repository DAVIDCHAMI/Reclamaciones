package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
  "periodStartDate",
  "periodEnd",
  "billingData",
  "isInclusion",
  "policyTerm",
  "idCustom",
  "salesOrganizationCode",
  "salesPolicyCode",
  "saleMethodCode",
  "rateOfDate",
  "producerCode",
  "salesChannelCode",
  "policyType",
  "origin",
  "productLine",
  "additionalInterest",
  "officeCode",
  "account",
  "jobNumber",
  "participationPercentage",
  "policyCommissions",
  "lobs",
  "description",
  "dateUpdate"
})
public class Param implements Serializable {

  @JsonProperty("periodStartDate")
  private String periodStartDate;

  @JsonProperty("periodEnd")
  private String periodEnd;

  @JsonProperty("billingData")
  private BillingData billingData;

  @JsonProperty("isInclusion")
  private Boolean isInclusion;

  @JsonProperty("policyTerm")
  private String policyTerm;

  @JsonProperty("idCustom")
  private String idCustom;

  @JsonProperty("salesOrganizationCode")
  private String salesOrganizationCode;

  @JsonProperty("salesPolicyCode")
  private String salesPolicyCode;

  @JsonProperty("saleMethodCode")
  private String saleMethodCode;

  @JsonProperty("rateOfDate")
  private String rateOfDate;

  @JsonProperty("producerCode")
  private String producerCode;

  @JsonProperty("salesChannelCode")
  private String salesChannelCode;

  @JsonProperty("policyType")
  private String policyType;

  @JsonProperty("origin")
  private String origin;

  @JsonProperty("productLine")
  private String productLine;

  @JsonProperty("additionalInterest")
  private List<Object> additionalInterest = null;

  @JsonProperty("officeCode")
  private String officeCode;

  @JsonProperty("account")
  private Account account;

  @JsonProperty("jobNumber")
  private String jobNumber;

  @JsonProperty("participationPercentage")
  private Integer participationPercentage;

  @JsonProperty("policyCommissions")
  private List<Object> policyCommissions = null;

  @JsonProperty("lobs")
  private Lobs lobs;

  @JsonProperty("description")
  private String description;

  @JsonProperty("dateUpdate")
  private Long dateUpdate;

  private static final long serialVersionUID = -3191202645524291250L;

  public Param() {
    // constructor
  }

  @JsonProperty("periodStartDate")
  public String getPeriodStartDate() {
    return this.periodStartDate;
  }

  @JsonProperty("periodStartDate")
  public void setPeriodStartDate(String periodStartDate) {
    this.periodStartDate = periodStartDate;
  }

  @JsonProperty("periodEnd")
  public String getPeriodEnd() {
    return this.periodEnd;
  }

  @JsonProperty("periodEnd")
  public void setPeriodEnd(String periodEnd) {
    this.periodEnd = periodEnd;
  }

  @JsonProperty("billingData")
  public BillingData getBillingData() {
    return this.billingData;
  }

  @JsonProperty("billingData")
  public void setBillingData(BillingData billingData) {
    this.billingData = billingData;
  }

  @JsonProperty("isInclusion")
  public Boolean getIsInclusion() {
    return this.isInclusion;
  }

  @JsonProperty("isInclusion")
  public void setIsInclusion(Boolean isInclusion) {
    this.isInclusion = isInclusion;
  }

  @JsonProperty("policyTerm")
  public String getPolicyTerm() {
    return this.policyTerm;
  }

  @JsonProperty("policyTerm")
  public void setPolicyTerm(String policyTerm) {
    this.policyTerm = policyTerm;
  }

  @JsonProperty("idCustom")
  public String getIdCustom() {
    return this.idCustom;
  }

  @JsonProperty("idCustom")
  public void setIdCustom(String idCustom) {
    this.idCustom = idCustom;
  }

  @JsonProperty("salesOrganizationCode")
  public String getSalesOrganizationCode() {
    return this.salesOrganizationCode;
  }

  @JsonProperty("salesOrganizationCode")
  public void setSalesOrganizationCode(String salesOrganizationCode) {
    this.salesOrganizationCode = salesOrganizationCode;
  }

  @JsonProperty("salesPolicyCode")
  public String getSalesPolicyCode() {
    return this.salesPolicyCode;
  }

  @JsonProperty("salesPolicyCode")
  public void setSalesPolicyCode(String salesPolicyCode) {
    this.salesPolicyCode = salesPolicyCode;
  }

  @JsonProperty("saleMethodCode")
  public String getSaleMethodCode() {
    return this.saleMethodCode;
  }

  @JsonProperty("saleMethodCode")
  public void setSaleMethodCode(String saleMethodCode) {
    this.saleMethodCode = saleMethodCode;
  }

  @JsonProperty("rateOfDate")
  public String getRateOfDate() {
    return this.rateOfDate;
  }

  @JsonProperty("rateOfDate")
  public void setRateOfDate(String rateOfDate) {
    this.rateOfDate = rateOfDate;
  }

  @JsonProperty("producerCode")
  public String getProducerCode() {
    return this.producerCode;
  }

  @JsonProperty("producerCode")
  public void setProducerCode(String producerCode) {
    this.producerCode = producerCode;
  }

  @JsonProperty("salesChannelCode")
  public String getSalesChannelCode() {
    return this.salesChannelCode;
  }

  @JsonProperty("salesChannelCode")
  public void setSalesChannelCode(String salesChannelCode) {
    this.salesChannelCode = salesChannelCode;
  }

  @JsonProperty("policyType")
  public String getPolicyType() {
    return this.policyType;
  }

  @JsonProperty("policyType")
  public void setPolicyType(String policyType) {
    this.policyType = policyType;
  }

  @JsonProperty("origin")
  public String getOrigin() {
    return this.origin;
  }

  @JsonProperty("origin")
  public void setOrigin(String origin) {
    this.origin = origin;
  }

  @JsonProperty("productLine")
  public String getProductLine() {
    return this.productLine;
  }

  @JsonProperty("productLine")
  public void setProductLine(String productLine) {
    this.productLine = productLine;
  }

  @JsonProperty("additionalInterest")
  public List<Object> getAdditionalInterest() {
    return this.additionalInterest;
  }

  @JsonProperty("additionalInterest")
  public void setAdditionalInterest(List<Object> additionalInterest) {
    this.additionalInterest = additionalInterest;
  }

  @JsonProperty("officeCode")
  public String getOfficeCode() {
    return this.officeCode;
  }

  @JsonProperty("officeCode")
  public void setOfficeCode(String officeCode) {
    this.officeCode = officeCode;
  }

  @JsonProperty("account")
  public Account getAccount() {
    return this.account;
  }

  @JsonProperty("account")
  public void setAccount(Account account) {
    this.account = account;
  }

  @JsonProperty("jobNumber")
  public String getJobNumber() {
    return this.jobNumber;
  }

  @JsonProperty("jobNumber")
  public void setJobNumber(String jobNumber) {
    this.jobNumber = jobNumber;
  }

  @JsonProperty("participationPercentage")
  public Integer getParticipationPercentage() {
    return this.participationPercentage;
  }

  @JsonProperty("participationPercentage")
  public void setParticipationPercentage(Integer participationPercentage) {
    this.participationPercentage = participationPercentage;
  }

  @JsonProperty("policyCommissions")
  public List<Object> getPolicyCommissions() {
    return this.policyCommissions;
  }

  @JsonProperty("policyCommissions")
  public void setPolicyCommissions(List<Object> policyCommissions) {
    this.policyCommissions = policyCommissions;
  }

  @JsonProperty("lobs")
  public Lobs getLobs() {
    return this.lobs;
  }

  @JsonProperty("lobs")
  public void setLobs(Lobs lobs) {
    this.lobs = lobs;
  }

  @JsonProperty("description")
  public String getDescription() {
    return this.description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  @JsonProperty("dateUpdate")
  public Long getDateUpdate() {
    return this.dateUpdate;
  }

  @JsonProperty("dateUpdate")
  public void setDateUpdate(Long dateUpdate) {
    this.dateUpdate = dateUpdate;
  }
}
