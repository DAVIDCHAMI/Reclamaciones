package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExposicionLesiones {

  private String gravedadLesion;
  private String tipoLesion;
  private String detallesTipoLesion;
  private String zonaCuerpo;
  private String parteCuerpo;
  private String describirLesiones;

  private List<ExposicionLesiones> lstExposicionLesiones = new ArrayList<>();

  public ExposicionLesiones(List<Map<String, String>> datosExposicionPersona) {
    asignarDatos(datosExposicionPersona);
  }

  private ExposicionLesiones(Map<String, String> datosExposicionPersona) {
    this.gravedadLesion = datosExposicionPersona.get("gravedadLesion");
    this.describirLesiones = datosExposicionPersona.get("describirLesiones");
    this.tipoLesion = datosExposicionPersona.get("tipoLesion");
    this.detallesTipoLesion = datosExposicionPersona.get("detallesTipoLesion");
    this.zonaCuerpo = datosExposicionPersona.get("zonaCuerpo");
    this.parteCuerpo = datosExposicionPersona.get("parteCuerpo");
  }

  public List<ExposicionLesiones> getLstExposicionLesiones() {
    return lstExposicionLesiones;
  }

  public String getGravedadLesion() {
    return gravedadLesion;
  }

  public String getTipoLesion() {
    return tipoLesion;
  }

  public String getDetallesTipoLesion() {
    return detallesTipoLesion;
  }

  public String getZonaCuerpo() {
    return zonaCuerpo;
  }

  public String getParteCuerpo() {
    return parteCuerpo;
  }

  public String getDescribirLesiones() {
    return describirLesiones;
  }

  private void asignarDatos(List<Map<String, String>> datosTerceroAuto) {
    for (Map<String, String> dato : datosTerceroAuto) {
      lstExposicionLesiones.add(new ExposicionLesiones(dato));
    }
  }
}
