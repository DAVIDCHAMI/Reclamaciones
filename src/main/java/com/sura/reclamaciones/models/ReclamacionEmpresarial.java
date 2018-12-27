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
  private String causaHechosSiniestro;
  private String valorPretension;
  private String tipoIncidente;
  private String ramoPolizaAtr;
  private String identificadorRiesgo;
  private String incidenteContenido;
  private String incidentePropiedad;

  public ReclamacionEmpresarial() {
    super();
  }

  private ReclamacionEmpresarial(Map<String, String> datosReclamacionEmpresarial) {
    super(datosReclamacionEmpresarial);
    this.numeroContrato = datosReclamacionEmpresarial.get("numeroContrato");
    this.detalleHechos = datosReclamacionEmpresarial.get("detalleHechos");
    this.pais = datosReclamacionEmpresarial.get("pais");
    this.departamento = datosReclamacionEmpresarial.get("departamento");
    this.ciudad = datosReclamacionEmpresarial.get("ciudad");
    this.direccion = datosReclamacionEmpresarial.get("direccion");
    this.causaHechosSiniestro = datosReclamacionEmpresarial.get("causa");
    this.valorPretension = datosReclamacionEmpresarial.get("valorPretension");
    this.tipoIncidente = datosReclamacionEmpresarial.get("tipoIncidente");
    this.identificadorRiesgo = datosReclamacionEmpresarial.get("idRiesgo");
    this.incidenteContenido = datosReclamacionEmpresarial.get("incidenteContenido");
    this.incidentePropiedad = datosReclamacionEmpresarial.get("incidentePropiedad");
    this.ramoPolizaAtr = datosReclamacionEmpresarial.get("ramoPolizaAtr");
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

  public String getCausaHechosSiniestro() {
    return causaHechosSiniestro;
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