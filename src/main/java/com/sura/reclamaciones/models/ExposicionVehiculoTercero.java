package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExposicionVehiculoTercero {

  private String tipoDocumento;
  private String numeroDocumentoConductor;
  private String primerNombre;
  private String primerApellido;
  private String departamento;
  private String ciudad;
  private String direccion;
  private String tipoDireccion;
  private String placaTercero;
  private String taller;

  private List<ExposicionVehiculoTercero> lstExposicionTercero = new ArrayList<>();

  public List<ExposicionVehiculoTercero> getLstExposicionTerceros() {
    return lstExposicionTercero;
  }

  public String getTaller() {
    return taller;
  }

  public String getPlacaTercero() {
    return placaTercero;
  }

  public void setPlacaTercero(String placaTercero) {
    this.placaTercero = placaTercero;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getNumeroDocumentoConductor() {
    return numeroDocumentoConductor;
  }

  public void setNumeroDocumentoConductor(String numeroDocumento) {
    this.numeroDocumentoConductor = numeroDocumento;
  }

  public String getPrimerNombre() {
    return primerNombre;
  }

  public void setPrimerNombre(String primerNombre) {
    this.primerNombre = primerNombre;
  }

  public String getPrimerApellido() {
    return primerApellido;
  }

  public void setPrimerApellido(String primerApellido) {
    this.primerApellido = primerApellido;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
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

  public ExposicionVehiculoTercero() {
    super();
  }

  private ExposicionVehiculoTercero(Map<String, String> datosExposicionTercero) {
    this.tipoDocumento = datosExposicionTercero.get("tipoDocumento");
    this.numeroDocumentoConductor = datosExposicionTercero.get("numeroDocumentoConductor");
    this.primerNombre = datosExposicionTercero.get("primerNombre");
    this.primerApellido = datosExposicionTercero.get("primerApellido");
    this.departamento = datosExposicionTercero.get("departamento");
    this.ciudad = datosExposicionTercero.get("ciudad");
    this.direccion = datosExposicionTercero.get("direccion");
    this.tipoDireccion = datosExposicionTercero.get("tipoDireccion");
    this.placaTercero = datosExposicionTercero.get("placaTercero");
    this.taller = datosExposicionTercero.get("taller");
  }

  public ExposicionVehiculoTercero(List<Map<String, String>> datosTerceroAuto) {
    asignarDatos(datosTerceroAuto);
  }

  private void asignarDatos(List<Map<String, String>> datosTerceroAuto) {
    for (Map<String, String> dato : datosTerceroAuto) {
      lstExposicionTercero.add(new ExposicionVehiculoTercero(dato));
    }
  }
}
