package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"updated", "selected", "publicID", "terms"})
public class CoverageRequest implements Serializable {

  @JsonProperty("updated")
  private Boolean updated;

  @JsonProperty("selected")
  private Boolean selected;

  @JsonProperty("publicID")
  private String publicID;

  @JsonProperty("terms")
  private List<TermRequest> terms = null;

  private static final long serialVersionUID = -5717050771166325335L;

  public CoverageRequest() {
    // constructor
  }

  @JsonProperty("updated")
  public Boolean getUpdated() {
    return this.updated;
  }

  @JsonProperty("updated")
  public void setUpdated(Boolean updated) {
    this.updated = updated;
  }

  @JsonProperty("selected")
  public Boolean getSelected() {
    return this.selected;
  }

  @JsonProperty("selected")
  public void setSelected(Boolean selected) {
    this.selected = selected;
  }

  @JsonProperty("publicID")
  public String getPublicID() {
    return this.publicID;
  }

  @JsonProperty("publicID")
  public void setPublicID(String publicID) {
    this.publicID = publicID;
  }

  @JsonProperty("terms")
  public List<TermRequest> getTerms() {
    return this.terms;
  }

  @JsonProperty("terms")
  public void setTerms(List<TermRequest> terms) {
    this.terms = terms;
  }
}
