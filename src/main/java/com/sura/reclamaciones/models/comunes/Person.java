package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
  "documentType",
  "documentNumber",
  "dateOfBirth",
  "firstName",
  "middleName",
  "lastName",
  "secondLastName",
  "prefixType",
  "suffixType",
  "primaryPhoneType",
  "homeNumber",
  "workNumber",
  "cellNumber",
  "maritalStatusCode",
  "profession",
  "genderCode",
  "emailAddress1",
  "emailAddress2",
  "officialID",
  "officialIDType",
  "preferredCurrency",
  "stablishmentCountry_Ext",
  "DocumentIssueQote_Ext",
  "address"
})
public class Person {
  @JsonProperty("documentType")
  private String documentType;

  @JsonProperty("documentNumber")
  private String documentNumber;

  @JsonProperty("dateOfBirth")
  private String dateOfBirth;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("middleName")
  private String middleName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("secondLastName")
  private String secondLastName;

  @JsonProperty("prefixType")
  private Object prefixType;

  @JsonProperty("suffixType")
  private Object suffixType;

  @JsonProperty("primaryPhoneType")
  private String primaryPhoneType;

  @JsonProperty("homeNumber")
  private String homeNumber;

  @JsonProperty("workNumber")
  private String workNumber;

  @JsonProperty("cellNumber")
  private String cellNumber;

  @JsonProperty("maritalStatusCode")
  private Object maritalStatusCode;

  @JsonProperty("profession")
  private String profession;

  @JsonProperty("genderCode")
  private String genderCode;

  @JsonProperty("emailAddress1")
  private String emailAddress1;

  @JsonProperty("emailAddress2")
  private String emailAddress2;

  @JsonProperty("officialID")
  private Object officialID;

  @JsonProperty("officialIDType")
  private Object officialIDType;

  @JsonProperty("preferredCurrency")
  private String preferredCurrency;

  @JsonProperty("stablishmentCountry_Ext")
  private String stablishmentCountry_Ext;

  @JsonProperty("DocumentIssueQote_Ext")
  private String documentIssueQote_Ext;

  @JsonProperty("address")
  private Address address;

  private static final Map<String, String> VALORES_SERVICIO_EDGE = new HashMap<>();

  static {
    VALORES_SERVICIO_EDGE.put("Colombia", "CO");
  }

  private static final long serialVersionUID = -6020822696484823296L;

  public Person() {
    // constructor
  }

  @JsonProperty("documentType")
  public String getDocumentType() {
    return this.documentType;
  }

  @JsonProperty("documentType")
  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  @JsonProperty("documentNumber")
  public String getDocumentNumber() {
    return this.documentNumber;
  }

  @JsonProperty("documentNumber")
  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  @JsonProperty("dateOfBirth")
  public String getDateOfBirth() {
    return this.dateOfBirth;
  }

  @JsonProperty("dateOfBirth")
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @JsonProperty("firstName")
  public String getFirstName() {
    return this.firstName;
  }

  @JsonProperty("firstName")
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @JsonProperty("middleName")
  public String getMiddleName() {
    return this.middleName;
  }

  @JsonProperty("middleName")
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  @JsonProperty("lastName")
  public String getLastName() {
    return this.lastName;
  }

  @JsonProperty("lastName")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @JsonProperty("secondLastName")
  public String getSecondLastName() {
    return this.secondLastName;
  }

  @JsonProperty("secondLastName")
  public void setSecondLastName(String secondLastName) {
    this.secondLastName = secondLastName;
  }

  @JsonProperty("prefixType")
  public Object getPrefixType() {
    return this.prefixType;
  }

  @JsonProperty("prefixType")
  public void setPrefixType(Object prefixType) {
    this.prefixType = prefixType;
  }

  @JsonProperty("suffixType")
  public Object getSuffixType() {
    return this.suffixType;
  }

  @JsonProperty("suffixType")
  public void setSuffixType(Object suffixType) {
    this.suffixType = suffixType;
  }

  @JsonProperty("primaryPhoneType")
  public String getPrimaryPhoneType() {
    return this.primaryPhoneType;
  }

  @JsonProperty("primaryPhoneType")
  public void setPrimaryPhoneType(String primaryPhoneType) {
    this.primaryPhoneType = primaryPhoneType;
  }

  @JsonProperty("homeNumber")
  public String getHomeNumber() {
    return this.homeNumber;
  }

  @JsonProperty("homeNumber")
  public void setHomeNumber(String homeNumber) {
    this.homeNumber = homeNumber;
  }

  @JsonProperty("workNumber")
  public String getWorkNumber() {
    return this.workNumber;
  }

  @JsonProperty("workNumber")
  public void setWorkNumber(String workNumber) {
    this.workNumber = workNumber;
  }

  @JsonProperty("cellNumber")
  public String getCellNumber() {
    return this.cellNumber;
  }

  @JsonProperty("cellNumber")
  public void setCellNumber(String cellNumber) {
    this.cellNumber = cellNumber;
  }

  @JsonProperty("maritalStatusCode")
  public Object getMaritalStatusCode() {
    return this.maritalStatusCode;
  }

  @JsonProperty("maritalStatusCode")
  public void setMaritalStatusCode(Object maritalStatusCode) {
    this.maritalStatusCode = maritalStatusCode;
  }

  @JsonProperty("profession")
  public String getProfession() {
    return this.profession;
  }

  @JsonProperty("profession")
  public void setProfession(String profession) {
    this.profession = profession;
  }

  @JsonProperty("genderCode")
  public String getGenderCode() {
    return this.genderCode;
  }

  @JsonProperty("genderCode")
  public void setGenderCode(String genderCode) {
    this.genderCode = genderCode;
  }

  @JsonProperty("emailAddress1")
  public String getEmailAddress1() {
    return this.emailAddress1;
  }

  @JsonProperty("emailAddress1")
  public void setEmailAddress1(String emailAddress1) {
    this.emailAddress1 = emailAddress1;
  }

  @JsonProperty("emailAddress2")
  public String getEmailAddress2() {
    return this.emailAddress2;
  }

  @JsonProperty("emailAddress2")
  public void setEmailAddress2(String emailAddress2) {
    this.emailAddress2 = emailAddress2;
  }

  @JsonProperty("officialID")
  public Object getOfficialID() {
    return this.officialID;
  }

  @JsonProperty("officialID")
  public void setOfficialID(Object officialID) {
    this.officialID = officialID;
  }

  @JsonProperty("officialIDType")
  public Object getOfficialIDType() {
    return this.officialIDType;
  }

  @JsonProperty("officialIDType")
  public void setOfficialIDType(Object officialIDType) {
    this.officialIDType = officialIDType;
  }

  @JsonProperty("preferredCurrency")
  public String getPreferredCurrency() {
    return this.preferredCurrency;
  }

  @JsonProperty("preferredCurrency")
  public void setPreferredCurrency(String preferredCurrency) {
    this.preferredCurrency = preferredCurrency;
  }

  @JsonProperty("stablishmentCountry_Ext")
  public String getStablishmentCountry_Ext() {
    return this.stablishmentCountry_Ext;
  }

  @JsonProperty("stablishmentCountry_Ext")
  public void setStablishmentCountry_Ext(String stablishmentCountry_Ext) {
    this.stablishmentCountry_Ext = VALORES_SERVICIO_EDGE.get(stablishmentCountry_Ext);
  }

  @JsonProperty("DocumentIssueQote_Ext")
  public String getDocumentIssueQote_Ext() {
    return this.documentIssueQote_Ext;
  }

  @JsonProperty("DocumentIssueQote_Ext")
  public void setDocumentIssueQote_Ext(String documentIssueQote_Ext) {
    this.documentIssueQote_Ext = documentIssueQote_Ext;
  }

  @JsonProperty("address")
  public Address getAddress() {
    return this.address;
  }

  @JsonProperty("address")
  public void setAddress(Address address) {
    this.address = address;
  }
}
