package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModeloSimplificado {

  private String numeroMovimientoFinanciero;
  private String numeroReclamacion;
  private String valorCedidoReaseguradoras;
  private String valorNeto;
  private String valorMovimientoFinanciero;

  private List<ModeloSimplificado> lstModeloSimplificado = new ArrayList<>();

  public ModeloSimplificado(Map<String, String> datosModeloSimplificado) {
    super();
    this.numeroReclamacion = datosModeloSimplificado.get("numeroReclamacion");
    this.numeroMovimientoFinanciero = datosModeloSimplificado.get("numeroMovimientoFinanciero");
    this.valorMovimientoFinanciero = datosModeloSimplificado.get("valorMovimientoFinanciero");
    this.valorCedidoReaseguradoras = datosModeloSimplificado.get("valorCedidoReaseguradoras");
    this.valorNeto = datosModeloSimplificado.get("valorNeto");
  }

  public ModeloSimplificado(List<Map<String, String>> datosModeloSimplificado) {
    asignarDatos(datosModeloSimplificado);
  }

  public ModeloSimplificado() {}

  public String getTransaccion() {
    return numeroMovimientoFinanciero;
  }

  public String getValorMovimientoFinanciero() {
    return valorMovimientoFinanciero;
  }

  public String getValorCedidoReaseguradoras() {
    return valorCedidoReaseguradoras;
  }

  public String getValorNeto() {
    return valorNeto;
  }

  public String getNumeroReclamacion() {
    return numeroReclamacion;
  }

  public List<ModeloSimplificado> getlstModeloSimplificado() {
    return lstModeloSimplificado;
  }

  private void asignarDatos(List<Map<String, String>> datosModeloSimplificado) {
    for (Map<String, String> dato : datosModeloSimplificado) {
      lstModeloSimplificado.add(new ModeloSimplificado(dato));
    }
  }
}
