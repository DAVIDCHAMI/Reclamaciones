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

  public List<ReclamacionEmpresarial> getLstReclamo() {
    return lstReclamoEmp;
  }

  private void asignarDatos(List<Map<String, String>> datosReclamacionesEmp) {
    for (Map<String, String> dato : datosReclamacionesEmp) {
      lstReclamoEmp.add(new ReclamacionEmpresarial(dato));
    }
  }
}
