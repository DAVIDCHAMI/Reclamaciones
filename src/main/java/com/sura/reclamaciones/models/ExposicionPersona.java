package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExposicionPersona {

  private String tipoDocumento;
  private String numeroDocumentoPeaton;
  private String primerNombrePeaton;
  private String PrimerApellidoPeaton;
  private String departamento;
  private String ciudad;
  private String direccionPeaton;
  private String tipoDireccion;
  private String gravedadLesion;
  private String tipoLesion;
  private String detallesTipoLesion;
  private String zonaCuerpo;
  private String parteCuerpo;
  private String describirLesiones;

  private List<ExposicionPersona> lstExposicionPersona = new ArrayList<>();

  public List<ExposicionPersona> getLstExposicionPersona() {
    return lstExposicionPersona;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public String getNumeroDocumentoPeaton() {
    return numeroDocumentoPeaton;
  }

  public String getPrimerNombrePeaton() {
    return primerNombrePeaton;
  }

  public String getPrimerApellidoPeaton() {
    return PrimerApellidoPeaton;
  }

  public String getDepartamento() {
    return departamento;
  }

  public String getCiudad() {
    return ciudad;
  }

  public String getDireccionPeaton() {
    return direccionPeaton;
  }

  public String getTipoDireccion() {
    return tipoDireccion;
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

  private ExposicionPersona(Map<String, String> datosExposicionPersona) {
    this.tipoDocumento = datosExposicionPersona.get("tipoDocumento");
    this.numeroDocumentoPeaton = datosExposicionPersona.get("numeroDocumentoPeaton");
    this.primerNombrePeaton = datosExposicionPersona.get("primerNombrePeaton");
    this.PrimerApellidoPeaton = datosExposicionPersona.get("PrimerApellidoPeaton");
    this.departamento = datosExposicionPersona.get("departamento");
    this.ciudad = datosExposicionPersona.get("ciudad");
    this.direccionPeaton = datosExposicionPersona.get("direccionPeaton");
    this.tipoDireccion = datosExposicionPersona.get("tipoDireccion");
    this.gravedadLesion = datosExposicionPersona.get("gravedadLesion");
    this.describirLesiones = datosExposicionPersona.get("describirLesiones");
    this.tipoLesion = datosExposicionPersona.get("tipoLesion");
    this.detallesTipoLesion = datosExposicionPersona.get("detallesTipoLesion");
    this.zonaCuerpo = datosExposicionPersona.get("zonaCuerpo");
    this.parteCuerpo = datosExposicionPersona.get("parteCuerpo");
  }

  public ExposicionPersona(List<Map<String, String>> datosExposicionPersona) {
    asignarDatos(datosExposicionPersona);
  }

  private void asignarDatos(List<Map<String, String>> datosTerceroAuto) {
    for (Map<String, String> dato : datosTerceroAuto) {
      lstExposicionPersona.add(new ExposicionPersona(dato));
    }
  }
}
