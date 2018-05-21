package com.sura.reclamaciones.models;

import java.util.Map;

public abstract class PersonaDTO {

  private String tipoDocumento;
  private String nroDocumento;
  private String nombre1;
  private String nombre2;
  private String apellido1;
  private String apellido2;
  private String fechaNacimiento;
  private String edad;
  private String sexo;
  private String celular;
  private String correo;
  private String tipoCorreo;
  private String razonSocial;
  private String direccionTrabajo;
  private String ciudadTrabajo;
  private String telefonoTrabajo;
  private String tipoDireccionTrabajo;
  private String direccionResidencia;
  private String ciudadResidencia;
  private String telefonoResidencia;
  private String tipoDireccionResidencia;
  private String direccionOtra;
  private String ciudadOtra;
  private String telefonoOtra;
  private String tipoDireccionOtra;

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public String getNroDocumento() {
    return nroDocumento;
  }

  public String getNombre1() {
    return nombre1;
  }

  public String getNombre2() {
    return nombre2;
  }

  public String getApellido1() {
    return apellido1;
  }

  public String getApellido2() {
    return apellido2;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public String getEdad() {
    return edad;
  }

  public String getSexo() {
    return sexo;
  }

  public String getCelular() {
    return celular;
  }

  public String getCorreo() {
    return correo;
  }

  public String getTipoCorreo() {
    return tipoCorreo;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public String getDireccionTrabajo() {
    return direccionTrabajo;
  }

  public String getCiudadTrabajo() {
    return ciudadTrabajo;
  }

  public String getTelefonoTrabajo() {
    return telefonoTrabajo;
  }

  public String getTipoDireccionTrabajo() {
    return tipoDireccionTrabajo;
  }

  public String getDireccionResidencia() {
    return direccionResidencia;
  }

  public String getCiudadResidencia() {
    return ciudadResidencia;
  }

  public String getTelefonoResidencia() {
    return telefonoResidencia;
  }

  public String getTipoDireccionResidencia() {
    return tipoDireccionResidencia;
  }

  public String getDireccionOtra() {
    return direccionOtra;
  }

  public String getCiudadOtra() {
    return ciudadOtra;
  }

  public String getTelefonoOtra() {
    return telefonoOtra;
  }

  public String getTipoDireccionOtra() {
    return tipoDireccionOtra;
  }

  private void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  private void setNroDocumento(String nroDocumento) {
    this.nroDocumento = nroDocumento;
  }

  private void setNombre1(String nombre1) {
    this.nombre1 = nombre1;
  }

  private void setNombre2(String nombre2) {
    this.nombre2 = nombre2;
  }

  private void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
  }

  private void setApellido2(String apellido2) {
    this.apellido2 = apellido2;
  }

  private void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  private void setEdad(String edad) {
    this.edad = edad;
  }

  private void setSexo(String sexo) {
    this.sexo = sexo;
  }

  private void setCelular(String celular) {
    this.celular = celular;
  }

  private void setCorreo(String correo) {
    this.correo = correo;
  }

  private void setTipoCorreo(String tipoCorreo) {
    this.tipoCorreo = tipoCorreo;
  }

  private void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  private void setDireccionTrabajo(String direccionTrabajo) {
    this.direccionTrabajo = direccionTrabajo;
  }

  private void setCiudadTrabajo(String ciudadTrabajo) {
    this.ciudadTrabajo = ciudadTrabajo;
  }

  private void setTelefonoTrabajo(String telefonoTrabajo) {
    this.telefonoTrabajo = telefonoTrabajo;
  }

  private void setTipoDireccionTrabajo(String tipoDireccionTrabajo) {
    this.tipoDireccionTrabajo = tipoDireccionTrabajo;
  }

  private void setDireccionResidencia(String direccionResidencia) {
    this.direccionResidencia = direccionResidencia;
  }

  private void setCiudadResidencia(String ciudadResidencia) {
    this.ciudadResidencia = ciudadResidencia;
  }

  private void setTelefonoResidencia(String telefonoResidencia) {
    this.telefonoResidencia = telefonoResidencia;
  }

  private void setTipoDireccionResidencia(String tipoDireccionResidencia) {
    this.tipoDireccionResidencia = tipoDireccionResidencia;
  }

  private void setDireccionOtra(String direccionOtra) {
    this.direccionOtra = direccionOtra;
  }

  private void setCiudadOtra(String ciudadOtra) {
    this.ciudadOtra = ciudadOtra;
  }

  private void setTelefonoOtra(String telefonoOtra) {
    this.telefonoOtra = telefonoOtra;
  }

  private void setTipoDireccionOtra(String tipoDireccionOtra) {
    this.tipoDireccionOtra = tipoDireccionOtra;
  }

  public PersonaDTO() {}

  public PersonaDTO(Map<String, String> datosPersona) {
    setTipoDocumento(datosPersona.get("tipoDocumento"));
    setNroDocumento(datosPersona.get("nroDocumento"));
    setNombre1(datosPersona.get("nombre1"));
    setNombre2(datosPersona.get("nombre2"));
    setApellido1(datosPersona.get("apellido1"));
    setApellido2(datosPersona.get("apellido2"));
    setFechaNacimiento(datosPersona.get("fechaNacimiento"));
    setEdad(datosPersona.get("edad"));
    setSexo(datosPersona.get("sexo"));
    setCelular(datosPersona.get("celular"));
    setCorreo(datosPersona.get("correo"));
    setTipoCorreo(datosPersona.get("tipoCorreo"));
    setRazonSocial(datosPersona.get("tipoDocumento"));
    setDireccionTrabajo(datosPersona.get("direccionTrabajo"));
    setCiudadTrabajo(datosPersona.get("ciudadTrabajo"));
    setTelefonoTrabajo(datosPersona.get("telefonoTrabajo"));
    setTipoDireccionTrabajo(datosPersona.get("tipoDireccionTrabajo"));
    setDireccionResidencia(datosPersona.get("direccionResidencia"));
    setCiudadResidencia(datosPersona.get("ciudadResidencia"));
    setTelefonoResidencia(datosPersona.get("telefonoResidencia"));
    setTipoDireccionResidencia(datosPersona.get("tipoDireccionResidencia"));
    setDireccionOtra(datosPersona.get("direccionOtra"));
    setCiudadOtra(datosPersona.get("ciudadOtra"));
    setTelefonoOtra(datosPersona.get("telefonoOtra"));
    setTipoDireccionOtra(datosPersona.get("tipoDireccionOtra"));
  }
}
