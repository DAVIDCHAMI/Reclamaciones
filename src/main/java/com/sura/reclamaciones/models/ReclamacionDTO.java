package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReclamacionDTO {

    private String fechaSiniestro;
    private String sucedido;
    private String causa;
    private String origen;
    private String valorPredeterminado;
    private String vehiculoRetenido;
    private String autoridad;
    private String culpabilidad;
    private List<ReclamacionDTO> reclamaciones = new ArrayList<>();

    public ReclamacionDTO(){
    }

    public ReclamacionDTO(Map<String, String> datosReclamaciones){
        this.fechaSiniestro = datosReclamaciones.get("fechaSiniestro");
        this.sucedido = datosReclamaciones.get("sucedido");
        this.causa = datosReclamaciones.get("causa");
        this.origen = datosReclamaciones.get("origen");
        this.valorPredeterminado = datosReclamaciones.get("valorpredeterminado");
        this.vehiculoRetenido = datosReclamaciones.get("vehiculoretenido");
        this.autoridad = datosReclamaciones.get("autoridad");
        this.culpabilidad = datosReclamaciones.get("culpabilidad");
    }

    public ReclamacionDTO(List<Map<String, String>> datosReclamacion){
        super();
        asignarDatos(datosReclamacion);
    }

    public List<ReclamacionDTO> getReclamaciones() {
        return reclamaciones;
    }

    public String getFechaSiniestro() {
        return fechaSiniestro;
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
