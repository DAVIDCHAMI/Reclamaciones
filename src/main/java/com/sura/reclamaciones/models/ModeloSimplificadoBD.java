package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModeloSimplificadoBD extends ModeloSimplificado {

  List<ModeloSimplificadoBD> lstModeloSimplificadoBD = new ArrayList<>();

  private ModeloSimplificadoBD(Map<String, String> datosTablaModeloSimplificado) {
    super();
    this.numeroMovimientoFinanciero = datosTablaModeloSimplificado.get("REFERENCE");
    this.numeroReclamacion = datosTablaModeloSimplificado.get("CLAIMNUMBER");
    this.valorCedidoReaseguradoras = datosTablaModeloSimplificado.get("CEDEDREINSURANCE");
    this.valorNeto = datosTablaModeloSimplificado.get("NETAMOUNT");
    this.valorMovimientoFinanciero = datosTablaModeloSimplificado.get("AMOUNT");
  }

  public ModeloSimplificadoBD(List<Map<String, String>> datosTablaModeloSimplificado) {
    asignarDatos(datosTablaModeloSimplificado);
  }

  @Override
  public void asignarDatos(List<Map<String, String>> datosTablaModeloSimplificado) {
    super.asignarDatos(datosTablaModeloSimplificado);
    for (Map<String, String> dato : datosTablaModeloSimplificado) {
      lstModeloSimplificadoBD.add(new ModeloSimplificadoBD(dato));
    }
  }

  public List<ModeloSimplificadoBD> getLstModeloSimplificadoBD() {
    return lstModeloSimplificadoBD;
  }
}
