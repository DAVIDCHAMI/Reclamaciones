package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExposicionVehiculoTercero {

  private String placaTercero;
  private String tallerReparacionAsignado;
  private String lugarAtencion;
  private String paisAtencion;
  private String departamentoAtencion;
  private String ciudadAtencion;
  private String direccionAtencion;

  private List<ExposicionVehiculoTercero> lstExposicionTercero = new ArrayList<>();

  public ExposicionVehiculoTercero() {
    super();
  }

  private ExposicionVehiculoTercero(Map<String, String> datosExposicionTercero) {
    this.placaTercero = datosExposicionTercero.get("placaTercero");
    this.tallerReparacionAsignado = datosExposicionTercero.get("tallerReparacionAsignado");
    this.lugarAtencion = datosExposicionTercero.get("lugarAtencion");
    this.paisAtencion = datosExposicionTercero.get("PaisAtencion");
    this.departamentoAtencion = datosExposicionTercero.get("DepartamentoAtencion");
    this.ciudadAtencion = datosExposicionTercero.get("CiudadAtencion");
    this.direccionAtencion = datosExposicionTercero.get("DireccionAtencion");
  }

  public ExposicionVehiculoTercero(List<Map<String, String>> datosTerceroAuto) {
    asignarDatos(datosTerceroAuto);
  }

  public List<ExposicionVehiculoTercero> getLstExposicionTerceros() {
    return lstExposicionTercero;
  }

  public String getTallerReparacionAsignado() {
    return tallerReparacionAsignado;
  }

  public String getPlacaTercero() {
    return placaTercero;
  }

  public String getLugarAtencion() {
    return lugarAtencion;
  }

  public String getPaisAtencion() {
    return paisAtencion;
  }

  public String getDepartamentoAtencion() {
    return departamentoAtencion;
  }

  public String getCiudadAtencion() {
    return ciudadAtencion;
  }

  public String getDireccionAtencion() {
    return direccionAtencion;
  }

  private void asignarDatos(List<Map<String, String>> datosTerceroAuto) {
    for (Map<String, String> dato : datosTerceroAuto) {
      lstExposicionTercero.add(new ExposicionVehiculoTercero(dato));
    }
  }
}
