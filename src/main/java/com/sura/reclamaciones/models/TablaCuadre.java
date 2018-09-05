package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TablaCuadre {
  private String referencia;
  private String tipoMovimiento;
  private String estado;
  private String ramo;
  private String fechaContabilizacion;
  private String fechaCreacion;
  private List<TablaCuadre> lstTablaCuadre = new ArrayList<>();

  public TablaCuadre() {
    super();
  }

  private TablaCuadre(Map<String, String> datosCuadre) {
    this.referencia = datosCuadre.get("");
    this.tipoMovimiento = datosCuadre.get("");
    this.estado = datosCuadre.get("");
    this.ramo = datosCuadre.get("");
    this.fechaContabilizacion = datosCuadre.get("");
    this.fechaCreacion = datosCuadre.get("");
  }

  public TablaCuadre(List<Map<String, String>> datosTablaCuadre) {
    asignarDatos(datosTablaCuadre);
  }

  public String getReferencia() {
    return referencia;
  }

  public String getTipoMovimiento() {
    return tipoMovimiento;
  }

  public String getEstado() {
    return estado;
  }

  public String getRamo() {
    return ramo;
  }

  public String getFechaContabilizacion() {
    return fechaContabilizacion;
  }

  public String getFechaCreacion() {
    return fechaCreacion;
  }

  private void asignarDatos(List<Map<String, String>> datosTablaCuadre) {
    for (Map<String, String> dato : datosTablaCuadre) {
      lstTablaCuadre.add(new TablaCuadre(dato));
    }
  }
}
