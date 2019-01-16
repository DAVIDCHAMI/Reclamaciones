package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonaReclamacion extends Persona {

  private String parteLesionada;
  private String gravedadLesion;
  private String descripcionLesion;
  private String lesionGeneral;
  private String detalleLesion;
  private String parteCuerpo;
  private String detalleParteCuerpo;

  private List<PersonaReclamacion> lstPersonaReclamacion = new ArrayList<>();

  public PersonaReclamacion() {
    super();
  }

  private PersonaReclamacion(Map<String, String> datoPersonaReclamacion) {
    super(datoPersonaReclamacion);
    this.parteLesionada = datoPersonaReclamacion.get("parteLesionada");
    this.descripcionLesion = datoPersonaReclamacion.get("descripcionLesion");
    this.gravedadLesion = datoPersonaReclamacion.get("gravedadLesion");
    this.lesionGeneral = datoPersonaReclamacion.get("lesionGeneral");
    this.detalleLesion = datoPersonaReclamacion.get("detalleLesion");
    this.parteCuerpo = datoPersonaReclamacion.get("parteCuerpo");
    this.detalleParteCuerpo = datoPersonaReclamacion.get("detalleParteCuerpo");
  }

  public PersonaReclamacion(List<Map<String, String>> datoPersonaReclamacion) {
    super();
    asignarDatosPersona(datoPersonaReclamacion);
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

  public List<PersonaReclamacion> getLstPersonaReclamacion() {
    return lstPersonaReclamacion;
  }

  public void asignarDatosPersona(List<Map<String, String>> datoPersonaReclamacion) {
    for (Map<String, String> dato : datoPersonaReclamacion) {
      lstPersonaReclamacion.add(new PersonaReclamacion(dato));
    }
  }
}
