package com.sura.reclamaciones.models;

import java.util.Map;

public abstract class Persona {
  private String primerNombre;
  private String segundoNombre;
  private String primerApellido;
  private String segundoApellido;
  private String tipoDocumento;
  private String numeroDocumento;
  private String correoElectronico;
  private String telefonoPrincipal;
  private String celular;

  public Persona() {}

  public Persona(Map<String, String> datosPersona) {
    this.primerNombre = datosPersona.get("primerNombre");
    this.segundoNombre = datosPersona.get("segundoNombre");
    this.primerApellido = datosPersona.get("primerApellido");
    this.segundoApellido = datosPersona.get("segundoApellido");
    this.tipoDocumento = datosPersona.get("tipoDocumento");
    this.numeroDocumento = datosPersona.get("numeroDocumento");
    this.correoElectronico = datosPersona.get("correoElectronico");
    this.telefonoPrincipal = datosPersona.get("telefonoPrincipal");
    this.celular = datosPersona.get("celular");
  }

  public String getPrimerNombre() {
    return primerNombre;
  }

  public String getSegundoNombre() {
    return segundoNombre;
  }

  public String getPrimerApellido() {
    return primerApellido;
  }

  public String getSegundoApellido() {
    return segundoApellido;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public String getnumeroDocumento() {
    return numeroDocumento;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public String getTelefonoPrincipal() {
    return telefonoPrincipal;
  }

  public String getCelular() {
    return celular;
  }
}
