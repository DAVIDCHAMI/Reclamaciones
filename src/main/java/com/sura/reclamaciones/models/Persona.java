package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Persona {

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
  private String numeroTrabajo;
  private String policyRole;
  private String ciudad;
  private String direccion;
  private String tipoDireccion;
  private String fechaNacimiento;
  private String genero;
  private String codigoPais;
  private String codigoDepartamento;
  private String tipoTelefono;

  public Persona() {}

  public Persona(Map<String, String> mapDatosPersona) {
    primerNombre = mapDatosPersona.get("primerNombre");
    segundoNombre = mapDatosPersona.get("segundoNombre");
    primerApellido = mapDatosPersona.get("primerApellido");
    segundoApellido = mapDatosPersona.get("segundoApellido");
    tipoDocumento = mapDatosPersona.get("tipoDocumento");
    numDocumento = mapDatosPersona.get("numDocumento");
    correoElectronico = mapDatosPersona.get("correoElectronico");
    telefonoPrincipal = mapDatosPersona.get("telefonoPrincipal");
    celular = mapDatosPersona.get("celular");
    numeroTrabajo = mapDatosPersona.get("numeroTrabajo");
    policyRole = mapDatosPersona.get("policyRole");
    ciudad = mapDatosPersona.get("ciudad");
    direccion = mapDatosPersona.get("direccion");
    tipoDireccion = mapDatosPersona.get("tipoDireccion");
    fechaNacimiento = mapDatosPersona.get("fechaNacimiento");
    genero = mapDatosPersona.get("genero");
    codigoPais = mapDatosPersona.get("codigoPais");
    codigoDepartamento = mapDatosPersona.get("codigoDepartamento");
    tipoTelefono = mapDatosPersona.get("tipoTelefono");
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

  public String getNumeroTrabajo() {
    return numeroTrabajo;
  }

  public String getPolicyRole() {
    return policyRole;
  }

  public String getCiudad() {
    return ciudad;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getTipoDireccion() {
    return tipoDireccion;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public String getGenero() {
    return genero;
  }

  public String getCodigoPais() {
    return codigoPais;
  }

  public String getCodigoDepartamento() {
    return codigoDepartamento;
  }

  public String getTipoTelefono() {
    return tipoTelefono;
  }

  public List<Persona> getLstPersona() {
    return lstPersona;
  }
}
