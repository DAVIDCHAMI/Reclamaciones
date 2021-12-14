package com.sura.reclamaciones.models.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"person", "account"})
public class Driver implements Serializable {
  @JsonProperty("person")
  private Person person;

  @JsonProperty("account")
  private Account account;

  private static final long serialVersionUID = 7029690650420771753L;

  public Driver() {
    // constructor
  }

  @JsonProperty("person")
  public Person getPerson() {
    return this.person;
  }

  @JsonProperty("person")
  public void setPerson(Person person) {
    this.person = person;
  }

  @JsonProperty("account")
  public Account getAccount() {
    return this.account;
  }

  @JsonProperty("account")
  public void setAccount(Account account) {
    this.account = account;
  }
}
