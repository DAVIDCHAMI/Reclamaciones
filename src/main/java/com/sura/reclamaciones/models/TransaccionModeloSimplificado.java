package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransaccionModeloSimplificado {

    private String numeroMovimientoFinanciero;
    private String valorCedidoReaseguradoras;
    private String valorNeto;
    private String valorMovimientoFinanciero;
    private String estadoMovimientoFinanciero;
    private List<TransaccionModeloSimplificado> lstTransaccionModeloSimplificado = new ArrayList<>();

    public TransaccionModeloSimplificado() {
    }

    public TransaccionModeloSimplificado(List<Map<String, String>> datosModeloSimplificado) {
        asignarDatos(datosModeloSimplificado);
    }

    private TransaccionModeloSimplificado(Map<String, String> datosModeloSimplificado) {
        if (datosModeloSimplificado.containsKey("NUMERORECLAMACION")) {
            obtenerCamposBaseDatos(datosModeloSimplificado);
        } else {
            obtenerCamposCsv(datosModeloSimplificado);
        }
    }

    public void obtenerCamposBaseDatos(Map<String, String> datosModeloSimplificado) {
        this.numeroMovimientoFinanciero = datosModeloSimplificado.get("NUMEROMOVIMIENTOFINANCIERO");
        this.valorMovimientoFinanciero = datosModeloSimplificado.get("VALORMOVIMIENTOFINANCIERO");
        this.valorCedidoReaseguradoras = datosModeloSimplificado.get("VALORCEDIDOREASEGURADORAS");
        this.valorNeto = datosModeloSimplificado.get("VALORNETO");
        this.estadoMovimientoFinanciero = datosModeloSimplificado.get("ESTADOMOVIMIENTOFINANCIERO");
    }

    public void obtenerCamposCsv(Map<String, String> datosModeloSimplificado) {
        this.numeroMovimientoFinanciero = datosModeloSimplificado.get("numeroMovimientoFinanciero");
        this.valorMovimientoFinanciero = datosModeloSimplificado.get("valorMovimientoFinanciero");
        this.valorCedidoReaseguradoras = datosModeloSimplificado.get("valorCedidoReaseguradoras");
        this.valorNeto = datosModeloSimplificado.get("valorNeto");
        this.estadoMovimientoFinanciero = datosModeloSimplificado.get("estadoMovimientoFinanciero");
    }

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

    public String getEstadoMovimientoFinanciero() {
        return estadoMovimientoFinanciero;
    }

    public List<TransaccionModeloSimplificado> getlstModeloSimplificado() {
        return lstTransaccionModeloSimplificado;
    }

    public void asignarDatos(List<Map<String, String>> datosModeloSimplificado) {
        for (Map<String, String> dato : datosModeloSimplificado) {
            lstTransaccionModeloSimplificado.add(new TransaccionModeloSimplificado(dato));
        }
    }
}
