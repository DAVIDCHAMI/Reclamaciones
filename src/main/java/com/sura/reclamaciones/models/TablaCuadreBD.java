package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TablaCuadreBD {
  private String numeroPoliza;
  private String referencia;
  private String ramo;
  private String claseMovimiento;
  private String tipoMovimiento;
  private String anulacion;
  private String estado;
  private String fechaContabilizacion;
  private String fechaCreacion;
  private List<TablaCuadreBD> lstTablaCuadreBD = new ArrayList<>();

  public TablaCuadreBD() {
    super();
  }

  private TablaCuadreBD(Map<String, String> datosCuadre) {
    this.numeroPoliza = datosCuadre.get("CDPOLIZA");
    this.referencia = datosCuadre.get("CDMOVIMIENTO");
    this.ramo = datosCuadre.get("CDRAMO");
    this.claseMovimiento = datosCuadre.get("CDCLASE");
    this.tipoMovimiento = datosCuadre.get("DSTIPO_MENSAJE");
    this.anulacion = datosCuadre.get("SNANULACION");
    this.estado = datosCuadre.get("DSRESULTADO_VALIDACION");
    this.fechaContabilizacion = datosCuadre.get("FECONTABILIZACION");
    this.fechaCreacion = datosCuadre.get("FEDOCUMENTO");
  }

  public TablaCuadreBD(List<Map<String, String>> datosTablaCuadre) {
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

  public String getNumeroPoliza() {
    return numeroPoliza;
  }

  public String getClaseMovimiento() {
    return claseMovimiento;
  }

  public String getAnulacion() {
    return anulacion;
  }

  public List<TablaCuadreBD> getLstTablaCuadreBD() {
    return lstTablaCuadreBD;
  }

  private void asignarDatos(List<Map<String, String>> datosTablaCuadre) {
    for (Map<String, String> dato : datosTablaCuadre) {
      lstTablaCuadreBD.add(new TablaCuadreBD(dato));
    }
  }
}
