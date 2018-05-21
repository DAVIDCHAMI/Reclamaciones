package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReclamacionDTO {

    private String sucedido;
    private String causa;
    private String origen;
    private String valorPredeterminado;
    private String vehiculoRetenido;
    private String autoridad;
    private String culpabilidad;
    private List<ReclamacionDTO> reclamaciones = new ArrayList<>();

    public ReclamacionDTO(String sucedido, String causa, String origen, String valorPredeterminado, String vehiculoRetenido, String autoridad, String culpabilidad) {
        this.sucedido = sucedido;
        this.causa = causa;
        this.origen = origen;
        this.valorPredeterminado = valorPredeterminado;
        this.vehiculoRetenido = vehiculoRetenido;
        this.autoridad = autoridad;
        this.culpabilidad = culpabilidad;
    }

    public ReclamacionDTO(Map<String, String> datosReclamaciones){
        this.sucedido = datosReclamaciones.get("sucedido");
        this.sucedido = datosReclamaciones.get("causa");
        this.sucedido = datosReclamaciones.get("origen");
        this.sucedido = datosReclamaciones.get("valorpredeterminado");
        this.sucedido = datosReclamaciones.get("vehiculoretenido");
        this.sucedido = datosReclamaciones.get("autoridad");
        this.sucedido = datosReclamaciones.get("culpabilidad");
    }

    public ReclamacionDTO(List<Map<String, String>> datosReclamacion){
        asignarDatos(datosReclamacion);
    }

    public List<ReclamacionDTO> getReclamaciones() {
        return reclamaciones;
    }

    public String getSucedido() {
        return sucedido;
    }

    public String getCausa() {
        return causa;
    }

    public String getOrigen() {
        return origen;
    }

    public String getValorPredeterminado() {
        return valorPredeterminado;
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

    public void asignarDatos(List<Map<String, String>> datosReclamacion) {
        for (Map<String, String> dato : datosReclamacion){
            reclamaciones.add(new ReclamacionDTO(dato));
        }
    }

}
