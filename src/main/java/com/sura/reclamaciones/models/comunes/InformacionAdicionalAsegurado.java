package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"documentNumber", "documentType", "dateOfBirth", "dateOfEntry"})
public class InformacionAdicionalAsegurado implements Serializable {

  @JsonProperty("documentNumber")
  private String documentNumber;

  @JsonProperty("documentType")
  private String documentType;

  @JsonProperty("dateOfBirth")
  private String dateOfBirth;

  @JsonProperty("dateOfEntry")
  private String dateOfEntry;

  private static final long serialVersionUID = -3460085803239088012L;

  public InformacionAdicionalAsegurado() {
    // constructor
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getDateOfEntry() {
    return dateOfEntry;
  }

  public void setDateOfEntry(String dateOfEntry) {
    this.dateOfEntry = dateOfEntry;
  }
}
