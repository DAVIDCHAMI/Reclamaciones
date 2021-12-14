package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"method", "params", "jsonrpc"})
public class ExpedicionAutosIndividualRequest implements Serializable {

  @JsonProperty("method")
  private String method;

  @JsonProperty("params")
  private List<Param> params = null;

  @JsonProperty("jsonrpc")
  private String jsonrpc;

  private static final long serialVersionUID = -6942181606850351320L;

  public ExpedicionAutosIndividualRequest() {
    // constructor
  }

  @JsonProperty("method")
  public String getMethod() {
    return this.method;
  }

  @JsonProperty("method")
  public void setMethod(String method) {
    this.method = method;
  }

  @JsonProperty("params")
  public List<Param> getParams() {
    return this.params;
  }

  @JsonProperty("params")
  public void setParams(List<Param> params) {
    this.params = params;
  }

  @JsonProperty("jsonrpc")
  public String getJsonrpc() {
    return this.jsonrpc;
  }

  @JsonProperty("jsonrpc")
  public void setJsonrpc(String jsonrpc) {
    this.jsonrpc = jsonrpc;
  }
}
