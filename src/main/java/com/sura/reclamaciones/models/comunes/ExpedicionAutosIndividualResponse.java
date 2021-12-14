package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"result", "method", "responseType", "jsonrpc"})
public class ExpedicionAutosIndividualResponse implements Serializable {
  @JsonProperty("result")
  private Result result;

  @JsonProperty("method")
  private String method;

  @JsonProperty("responseType")
  private String responseType;

  @JsonProperty("jsonrpc")
  private String jsonrpc;

  private static final long serialVersionUID = 874740267422177784L;

  public ExpedicionAutosIndividualResponse() {
    // constructor
  }

  @JsonProperty("result")
  public Result getResult() {
    return this.result;
  }

  @JsonProperty("result")
  public void setResult(Result result) {
    this.result = result;
  }

  @JsonProperty("method")
  public String getMethod() {
    return this.method;
  }

  @JsonProperty("method")
  public void setMethod(String method) {
    this.method = method;
  }

  @JsonProperty("responseType")
  public String getResponseType() {
    return this.responseType;
  }

  @JsonProperty("responseType")
  public void setResponseType(String responseType) {
    this.responseType = responseType;
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
