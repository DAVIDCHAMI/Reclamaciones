package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonaReclamacionAuto extends Persona {

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
