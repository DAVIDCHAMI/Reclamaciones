package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Persona {

  private List<Persona> lstPersona = new ArrayList<>();
  private String primerNombre;
  private String segundoNombre;
  private String primerApellido;
  private String segundoApellido;
  private String tipoDocumento;
  private String numDocumento;
  private String correoElectronico;
  private String telefonoPrincipal;
  private String celular;

  public Persona() {
    super();
  }

  public Persona(Map<String, String> datosPersona) {
    this.primerNombre = datosPersona.get("primerNombre");
    this.segundoNombre = datosPersona.get("segundoNombre");
    this.primerApellido = datosPersona.get("primerApellido");
    this.segundoApellido = datosPersona.get("segundoApellido");
    this.tipoDocumento = datosPersona.get("tipoDocumento");
    this.numDocumento = datosPersona.get("numDocumento");
    this.correoElectronico = datosPersona.get("correoElectronico");
    this.telefonoPrincipal = datosPersona.get("telefonoPrincipal");
    this.celular = datosPersona.get("celular");
  }

  public Persona(List<Map<String, String>> datosPersona) {
    asignarDatos(datosPersona);
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

  public String getNumDocumento() {
    return numDocumento;
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

  public List<Persona> getLstPersona() {
    return lstPersona;
  }

  private void asignarDatos(List<Map<String, String>> datosPersona) {
    for (Map<String, String> dato : datosPersona) {
      lstPersona.add(new Persona(dato));
    }
  }
}
