package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonaConductorAuto extends Persona {

  private String numeroTrabajo;
  private String policyRole;
  private String ciudad;
  private String direccion;
  private String tipoDireccion;

  public String getNumeroTrabajo() {
    return numeroTrabajo;
  }

  public void setNumeroTrabajo(String numeroTrabajo) {
    this.numeroTrabajo = numeroTrabajo;
  }

  public String getPolicyRole() {
    return policyRole;
  }

  public void setPolicyRole(String policyRole) {
    this.policyRole = policyRole;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTipoDireccion() {
    return tipoDireccion;
  }

  public void setTipoDireccion(String tipoDireccion) {
    this.tipoDireccion = tipoDireccion;
  }

  public List<PersonaConductorAuto> getLstPersonaConductorAuto() {
    return lstPersonaConductorAuto;
  }

  private List<PersonaConductorAuto> lstPersonaConductorAuto = new ArrayList<>();

  public PersonaConductorAuto() {
    super();
  }

  public PersonaConductorAuto(List<Map<String, String>> datoPersonaConductorAuto) {
    super();
    asignarDatos(datoPersonaConductorAuto);
  }

  public void asignarDatos(List<Map<String, String>> datoPersonaConductorAuto) {
    for (Map<String, String> dato : datoPersonaConductorAuto) {
      lstPersonaConductorAuto.add(new PersonaConductorAuto(dato));
    }
  }

  private PersonaConductorAuto(Map<String, String> datoPersonaConductorAuto) {
    super(datoPersonaConductorAuto);
    this.numeroTrabajo = datoPersonaConductorAuto.get("numeroTrabajo");
    this.policyRole = datoPersonaConductorAuto.get("policyRole");
    this.ciudad = datoPersonaConductorAuto.get("ciudad");
    this.direccion = datoPersonaConductorAuto.get("direccion");
    this.tipoDireccion = datoPersonaConductorAuto.get("tipoDireccion");
  }
}
