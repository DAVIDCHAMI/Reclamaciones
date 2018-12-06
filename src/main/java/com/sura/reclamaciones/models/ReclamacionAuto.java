package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReclamacionAuto extends Reclamacion {

  private String relacionAsegurado;
  private String sucedido;
  private String causa;
  private String vehiculoRetenido;
  private String autoridad;
  private String culpabilidad;
  private String taller;
  private String valorPretension;
  private String pais;
  private String departamento;
  private String ciudad;
  private String direccion;
  private List<ReclamacionAuto> lstReclamacionAuto = new ArrayList<>();

  public ReclamacionAuto() {
    super();
  }

  private ReclamacionAuto(Map<String, String> datosReclamacionAut) {
    super(datosReclamacionAut);
    this.relacionAsegurado = datosReclamacionAut.get("relacionAsegurado");
    this.sucedido = datosReclamacionAut.get("sucedido");
    this.pais = datosReclamacionAut.get("pais");
    this.departamento = datosReclamacionAut.get("departamento");
    this.ciudad = datosReclamacionAut.get("ciudad");
    this.direccion = datosReclamacionAut.get("direccion");
    this.causa = datosReclamacionAut.get("causa");
    this.vehiculoRetenido = datosReclamacionAut.get("vehiculoRetenido");
    this.autoridad = datosReclamacionAut.get("autoridad");
    this.culpabilidad = datosReclamacionAut.get("culpabilidad");
    this.taller = datosReclamacionAut.get("taller");
    this.valorPretension = datosReclamacionAut.get("valorPretension");
  }

  public ReclamacionAuto(List<Map<String, String>> datosReclamacionAut) {
    asignarDatos(datosReclamacionAut);
  }

  public String getRelacionAsegurado() {
    return relacionAsegurado;
  }

  public String getSucedido() {
    return sucedido;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
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

  public String getCausa() {
    return causa;
  }

  public String getVehiculoRetenido() {
    return vehiculoRetenido;
  }

  public String getAutoridad() {
    return autoridad;
  }

  public String getCulpabilidad() {
    return culpabilidad;
  }

  public String getTaller() {
    return taller;
  }

  public String getValorPretension() {
    return valorPretension;
  }

  public List<ReclamacionAuto> getLstReclamacionAuto() {
    return lstReclamacionAuto;
  }

  private void asignarDatos(List<Map<String, String>> datosReclamacionAut) {
    for (Map<String, String> dato : datosReclamacionAut) {
      lstReclamacionAuto.add(new ReclamacionAuto(dato));
    }
  }
}
