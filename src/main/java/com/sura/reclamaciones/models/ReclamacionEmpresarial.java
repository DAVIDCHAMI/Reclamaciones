package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReclamacionEmpresarial extends Reclamacion {

  private List<ReclamacionEmpresarial> lstReclamoEmp = new ArrayList<>();
  private String numeroContrato;
  private String detalleHechos;
  private String pais;
  private String departamento;
  private String ciudad;
  private String direccion;
  private String causa;
  private String valorPretension;
  private String tipoIncidente;
  private String ramoPolizaAtr;
  private String identificadorRiesgo;
  private String incidenteContenido;
  private String incidentePropiedad;

  public ReclamacionEmpresarial() {
    super();
  }

  private ReclamacionEmpresarial(Map<String, String> datosReclamacionEmp) {
    super(datosReclamacionEmp);
    this.numeroContrato = datosReclamacionEmp.get("numeroContrato");
    this.detalleHechos = datosReclamacionEmp.get("detalleHechos");
    this.pais = datosReclamacionEmp.get("pais");
    this.departamento = datosReclamacionEmp.get("departamento");
    this.ciudad = datosReclamacionEmp.get("ciudad");
    this.direccion = datosReclamacionEmp.get("direccion");
    this.causa = datosReclamacionEmp.get("causa");
    this.valorPretension = datosReclamacionEmp.get("valorPretension");
    this.tipoIncidente = datosReclamacionEmp.get("tipoIncidente");
    this.identificadorRiesgo = datosReclamacionEmp.get("idRiesgo");
    this.incidenteContenido = datosReclamacionEmp.get("incidenteContenido");
    this.incidentePropiedad = datosReclamacionEmp.get("incidentePropiedad");
    this.ramoPolizaAtr = datosReclamacionEmp.get("ramoPolizaAtr");
  }

  public ReclamacionEmpresarial(List<Map<String, String>> datosReclamacionesEmp) {
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

  public String getNumeroContrato() {
    return numeroContrato;
  }

  public String getDetalleHechos() {
    return detalleHechos;
  }

  public String getCausa() {
    return causa;
  }

  public String getValorPretension() {
    return valorPretension;
  }

  public String getTipoIncidente() {
    return tipoIncidente;
  }

  public String getRamoPolizaAtr() {
    return ramoPolizaAtr;
  }

  public String getIdentificadorRiesgo() {
    return identificadorRiesgo;
  }

  public boolean getIncidenteContenido() {
    return Boolean.parseBoolean(incidenteContenido);
  }

  public boolean getIncidentePropiedad() {
    return Boolean.parseBoolean(incidentePropiedad);
  }

  public List<ReclamacionEmpresarial> getLstReclamo() {
    return lstReclamoEmp;
  }

  private void asignarDatos(List<Map<String, String>> datosReclamacionesEmp) {
    for (Map<String, String> dato : datosReclamacionesEmp) {
      lstReclamoEmp.add(new ReclamacionEmpresarial(dato));
    }
  }
}
