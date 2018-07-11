package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReclamacionEmpresariales extends Reclamacion {

  private List<ReclamacionEmpresariales> lstReclamoEmp = new ArrayList<>();
  private String numeroContrato;
  private String detalleHechos;
  private String pais;
  private String departamento;
  private String ciudad;
  private String direccion;
  private String tipoIncidente;
  private String tipoPoliza;
  private String numPoliza;
  private String origen;
  private String valorPretension;
  private String fechaSiniestro;
  private String lugar;
  private String causaDelSiniestro;

  public ReclamacionEmpresariales() {}

  private ReclamacionEmpresariales(Map<String, String> datosReclamacionEmp) {
    this.numeroContrato = datosReclamacionEmp.get("numeroContrato");
    this.detalleHechos = datosReclamacionEmp.get("detalleHechos");
    this.pais = datosReclamacionEmp.get("pais");
    this.departamento = datosReclamacionEmp.get("departamento");
    this.ciudad = datosReclamacionEmp.get("ciudad");
    this.direccion = datosReclamacionEmp.get("direccion");
    this.tipoIncidente = datosReclamacionEmp.get("tipoIncidente");
    this.tipoPoliza = datosReclamacionEmp.get("tipoPoliza");
    this.numPoliza = datosReclamacionEmp.get("numPoliza");
    this.origen = datosReclamacionEmp.get("origen");
    this.valorPretension = datosReclamacionEmp.get("valorPretension");
    this.fechaSiniestro = datosReclamacionEmp.get("fechaSiniestro");
    this.lugar = datosReclamacionEmp.get("lugar");
    this.causaDelSiniestro = datosReclamacionEmp.get("causaDelSiniestro");
  }

  public ReclamacionEmpresariales(List<Map<String, String>> datosReclamacionesEmp) {
    asignarDatos(datosReclamacionesEmp);
  }

  public String getPais() {
    return pais;
  }

  public String getDepartamento() {
    return departamento;
  }

  public String getCiudad() {
    return ciudad;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getTipoIncidente() {
    return tipoIncidente;
  }

  public String getNumeroContrato() {
    return numeroContrato;
  }

  public String getDetalleHechos() {
    return detalleHechos;
  }

  public String getCausaDelSiniestro() {
    return causaDelSiniestro;
  }

  public String getTipoPoliza() {
    return tipoPoliza;
  }

  public String getNumPoliza() {
    return numPoliza;
  }

  public String getOrigen() {
    return origen;
  }

  public String getValorPretension() {
    return valorPretension;
  }

  public String getFechaSiniestro() {
    return fechaSiniestro;
  }

  public String getLugar() {
    return lugar;
  }

  public List<ReclamacionEmpresariales> getLstReclamo() {
    return lstReclamoEmp;
  }

  private void asignarDatos(List<Map<String, String>> datosReclamacionesEmp) {
    for (Map<String, String> dato : datosReclamacionesEmp) {
      lstReclamoEmp.add(new ReclamacionEmpresariales(dato));
    }
  }
}
