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
  "periodEndDate",
  "periodEffectiveDate",
  "totalPremium",
  "totalTaxes",
  "rate",
  "costChange",
  "taxes",
  "latestTaxes",
  "jobNumber",
  "accountNumber",
  "isValid",
  "isValidQuote",
  "isValidIssue",
  "policyNumber",
  "validationData",
  "uWIssues",
  "inconsistencyList",
  "detailCoverages"
})
public class QuotingData implements Serializable {
  @JsonProperty("periodStartDate")
  private String periodStartDate;

  @JsonProperty("periodEndDate")
  private String periodEndDate;

  @JsonProperty("periodEffectiveDate")
  private String periodEffectiveDate;

  @JsonProperty("totalPremium")
  private Integer totalPremium;

  @JsonProperty("totalTaxes")
  private Integer totalTaxes;

  @JsonProperty("rate")
  private Integer rate;

  @JsonProperty("costChange")
  private Integer costChange;

  @JsonProperty("taxes")
  private Integer taxes;

  @JsonProperty("latestTaxes")
  private Integer latestTaxes;

  @JsonProperty("jobNumber")
  private String jobNumber;

  @JsonProperty("accountNumber")
  private String accountNumber;

  @JsonProperty("isValid")
  private Boolean isValid;

  @JsonProperty("isValidQuote")
  private Boolean isValidQuote;

  @JsonProperty("isValidIssue")
  private Boolean isValidIssue;

  @JsonProperty("policyNumber")
  private String policyNumber;

  @JsonProperty("validationData")
  private List<Object> validationData = null;

  @JsonProperty("uWIssues")
  private List<Object> uWIssues = null;

  @JsonProperty("inconsistencyList")
  private List<Object> inconsistencyList = null;

  @JsonProperty("detailCoverages")
  private List<DetailCoverage> detailCoverages = null;

  private static final long serialVersionUID = 1643513469606899417L;

  public QuotingData() {
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

  @JsonProperty("periodEndDate")
  public String getPeriodEndDate() {
    return this.periodEndDate;
  }

  @JsonProperty("periodEndDate")
  public void setPeriodEndDate(String periodEndDate) {
    this.periodEndDate = periodEndDate;
  }

  @JsonProperty("periodEffectiveDate")
  public String getPeriodEffectiveDate() {
    return this.periodEffectiveDate;
  }

  @JsonProperty("periodEffectiveDate")
  public void setPeriodEffectiveDate(String periodEffectiveDate) {
    this.periodEffectiveDate = periodEffectiveDate;
  }

  @JsonProperty("totalPremium")
  public Integer getTotalPremium() {
    return this.totalPremium;
  }

  @JsonProperty("totalPremium")
  public void setTotalPremium(Integer totalPremium) {
    this.totalPremium = totalPremium;
  }

  @JsonProperty("totalTaxes")
  public Integer getTotalTaxes() {
    return this.totalTaxes;
  }

  @JsonProperty("totalTaxes")
  public void setTotalTaxes(Integer totalTaxes) {
    this.totalTaxes = totalTaxes;
  }

  @JsonProperty("rate")
  public Integer getRate() {
    return this.rate;
  }

  @JsonProperty("rate")
  public void setRate(Integer rate) {
    this.rate = rate;
  }

  @JsonProperty("costChange")
  public Integer getCostChange() {
    return this.costChange;
  }

  @JsonProperty("costChange")
  public void setCostChange(Integer costChange) {
    this.costChange = costChange;
  }

  @JsonProperty("taxes")
  public Integer getTaxes() {
    return this.taxes;
  }

  @JsonProperty("taxes")
  public void setTaxes(Integer taxes) {
    this.taxes = taxes;
  }

  @JsonProperty("latestTaxes")
  public Integer getLatestTaxes() {
    return this.latestTaxes;
  }

  @JsonProperty("latestTaxes")
  public void setLatestTaxes(Integer latestTaxes) {
    this.latestTaxes = latestTaxes;
  }

  @JsonProperty("jobNumber")
  public String getJobNumber() {
    return this.jobNumber;
  }

  @JsonProperty("jobNumber")
  public void setJobNumber(String jobNumber) {
    this.jobNumber = jobNumber;
  }

  @JsonProperty("accountNumber")
  public String getAccountNumber() {
    return this.accountNumber;
  }

  @JsonProperty("accountNumber")
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  @JsonProperty("isValid")
  public Boolean getIsValid() {
    return this.isValid;
  }

  @JsonProperty("isValid")
  public void setIsValid(Boolean isValid) {
    this.isValid = isValid;
  }

  @JsonProperty("isValidQuote")
  public Boolean getIsValidQuote() {
    return this.isValidQuote;
  }

  @JsonProperty("isValidQuote")
  public void setIsValidQuote(Boolean isValidQuote) {
    this.isValidQuote = isValidQuote;
  }

  @JsonProperty("isValidIssue")
  public Boolean getIsValidIssue() {
    return this.isValidIssue;
  }

  @JsonProperty("isValidIssue")
  public void setIsValidIssue(Boolean isValidIssue) {
    this.isValidIssue = isValidIssue;
  }

  @JsonProperty("policyNumber")
  public String getPolicyNumber() {
    return this.policyNumber;
  }

  @JsonProperty("policyNumber")
  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
  }

  @JsonProperty("validationData")
  public List<Object> getValidationData() {
    return this.validationData;
  }

  @JsonProperty("validationData")
  public void setValidationData(List<Object> validationData) {
    this.validationData = validationData;
  }

  @JsonProperty("uWIssues")
  public List<Object> getUWIssues() {
    return this.uWIssues;
  }

  @JsonProperty("uWIssues")
  public void setUWIssues(List<Object> uWIssues) {
    this.uWIssues = uWIssues;
  }

  @JsonProperty("inconsistencyList")
  public List<Object> getInconsistencyList() {
    return this.inconsistencyList;
  }

  @JsonProperty("inconsistencyList")
  public void setInconsistencyList(List<Object> inconsistencyList) {
    this.inconsistencyList = inconsistencyList;
  }

  @JsonProperty("detailCoverages")
  public List<DetailCoverage> getDetailCoverages() {
    return this.detailCoverages;
  }

  @JsonProperty("detailCoverages")
  public void setDetailCoverages(List<DetailCoverage> detailCoverages) {
    this.detailCoverages = detailCoverages;
  }
}
