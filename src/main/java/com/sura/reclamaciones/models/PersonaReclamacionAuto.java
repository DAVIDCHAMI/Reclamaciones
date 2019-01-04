package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonaReclamacionAuto extends Persona {

  private String numeroTrabajo;
  private String policyRole;
  private String ciudad;
  private String direccion;
  private String tipoDireccion;
  private String parteLesionada;
  private String gravedadLesion;
  private String descripcionLesion;
  private String lesionGeneral;
  private String detalleLesion;
  private String parteCuerpo;
  private String detalleParteCuerpo;

  private List<PersonaReclamacionAuto> lstPersonaReclamacionAuto = new ArrayList<>();

  public PersonaReclamacionAuto() {
    super();
  }

  private PersonaReclamacionAuto(Map<String, String> datoPersonaReclamacionAuto) {
    super(datoPersonaReclamacionAuto);
    this.numeroTrabajo = datoPersonaReclamacionAuto.get("numeroTrabajo");
    this.policyRole = datoPersonaReclamacionAuto.get("policyRole");
    this.ciudad = datoPersonaReclamacionAuto.get("ciudad");
    this.direccion = datoPersonaReclamacionAuto.get("direccion");
    this.tipoDireccion = datoPersonaReclamacionAuto.get("tipoDireccion");
    this.parteLesionada = datoPersonaReclamacionAuto.get("parteLesionada");
    this.descripcionLesion = datoPersonaReclamacionAuto.get("descripcionLesion");
    this.gravedadLesion = datoPersonaReclamacionAuto.get("gravedadLesion");
    this.lesionGeneral = datoPersonaReclamacionAuto.get("lesionGeneral");
    this.detalleLesion = datoPersonaReclamacionAuto.get("detalleLesion");
    this.parteCuerpo = datoPersonaReclamacionAuto.get("parteCuerpo");
    this.detalleParteCuerpo = datoPersonaReclamacionAuto.get("detalleParteCuerpo");
  }

  public PersonaReclamacionAuto(List<Map<String, String>> datoPersonaReclamacionAuto) {
    super();
    asignarDatosPersona(datoPersonaReclamacionAuto);
  }

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

  public String getParteLesionada() {
    return parteLesionada;
  }

  public void setParteLesionada(String parteLesionada) {
    this.parteLesionada = parteLesionada;
  }

  public String getGravedadLesion() {
    return gravedadLesion;
  }

  public void setGravedadLesion(String gravedadLesion) {
    this.gravedadLesion = gravedadLesion;
  }

  public String getDescripcionLesion() {
    return descripcionLesion;
  }

  public void setDescripcionLesion(String descripcionLesion) {
    this.descripcionLesion = descripcionLesion;
  }

  public String getLesionGeneral() {
    return lesionGeneral;
  }

  public void setLesionGeneral(String lesionGeneral) {
    this.lesionGeneral = lesionGeneral;
  }

  public String getDetalleLesion() {
    return detalleLesion;
  }

  public void setDetalleLesion(String detalleLesion) {
    this.detalleLesion = detalleLesion;
  }

  public String getParteCuerpo() {
    return parteCuerpo;
  }

  public void setParteCuerpo(String parteCuerpo) {
    this.parteCuerpo = parteCuerpo;
  }

  public String getDetalleParteCuerpo() {
    return detalleParteCuerpo;
  }

  public void setDetalleParteCuerpo(String detalleParteCuerpo) {
    this.detalleParteCuerpo = detalleParteCuerpo;
  }

  public List<PersonaReclamacionAuto> getLstPersonaReclamacionAuto() {
    return lstPersonaReclamacionAuto;
  }

  public void asignarDatosPersona(List<Map<String, String>> datoPersonaReclamacionAuto) {
    for (Map<String, String> dato : datoPersonaReclamacionAuto) {
      lstPersonaReclamacionAuto.add(new PersonaReclamacionAuto(dato));
    }
  }
}
