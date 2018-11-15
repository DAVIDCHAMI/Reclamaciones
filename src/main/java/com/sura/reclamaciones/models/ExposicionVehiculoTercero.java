package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExposicionTerceroAutos {

    private String tipoDocumento;
    private String numeroDocumentoConductor;
    private String primerNombre;
    private String primerApellido;
    private String departamento;
    private String ciudad;
    private String direccion;
    private String tipoDireccion;
    private String placaTercero;
    private String taller;
    private String numeroDocumentoPeaton;
    private String primerNombrePeaton;
    private String PrimerApellidoPeaton;
    private String direccionPeaton;
    private String gravedadLesion;
    private String tipoLesion;
    private String detallesTipoLesion;
    private String zonaCuerpo;
    private String parteCuerpo;
    private String describirLesiones;
    private List<ExposicionTerceroAutos> lstExposicionTercero = new ArrayList<>();

    public String getGravedadLesion() {
        return gravedadLesion;
    }

    public String getdescribirLesiones() {
        return describirLesiones;
    }

    public String getTipoLesion() {
        return tipoLesion;
    }

    public String getDetallesTipoLesion() {
        return detallesTipoLesion;
    }

    public String getZonaCuerpo() {
        return zonaCuerpo;
    }

    public String getParteCuerpo() {
        return parteCuerpo;
    }

    public String getNumeroDocumentoPeaton() {
        return numeroDocumentoPeaton;
    }

    public String getPrimerNombrePeaton() {
        return primerNombrePeaton;
    }

    public String getPrimerApellidoPeaton() {
        return PrimerApellidoPeaton;
    }

    public String getDireccionPeaton() {
        return direccionPeaton;
    }

    public List<ExposicionTerceroAutos> getLstExposicionTerceros() {
        return lstExposicionTercero;
    }
    public String getTaller() {
        return taller;
    }
    public String getPlacaTercero() {
        return placaTercero;
    }

    public void setPlacaTercero(String placaTercero) {
        this.placaTercero = placaTercero;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumentoConductor() {
        return numeroDocumentoConductor;
    }

    public void setNumeroDocumentoConductor(String numeroDocumento) {this.numeroDocumentoConductor = numeroDocumento; }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }


    public ExposicionTerceroAutos() {
        super();
    }

    private ExposicionTerceroAutos(Map<String, String> datosExposicionTercero) {
        this.tipoDocumento = datosExposicionTercero.get("tipoDocumento");
        this.numeroDocumentoConductor = datosExposicionTercero.get("numeroDocumentoConductor");
        this.primerNombre = datosExposicionTercero.get("primerNombre");
        this.primerApellido = datosExposicionTercero.get("primerApellido");
        this.departamento = datosExposicionTercero.get("departamento");
        this.ciudad = datosExposicionTercero.get("ciudad");
        this.direccion = datosExposicionTercero.get("direccion");
        this.tipoDireccion = datosExposicionTercero.get("tipoDireccion");
        this.placaTercero = datosExposicionTercero.get("placaTercero");
        this.taller = datosExposicionTercero.get("taller");
        this.numeroDocumentoPeaton = datosExposicionTercero.get("numeroDocumentoPeaton");
        this.primerNombrePeaton = datosExposicionTercero.get("primerNombrePeaton");
        this.PrimerApellidoPeaton = datosExposicionTercero.get("PrimerApellidoPeaton");
        this.direccionPeaton = datosExposicionTercero.get("direccionPeaton");
        this.gravedadLesion = datosExposicionTercero.get("gravedadLesion");
        this.describirLesiones = datosExposicionTercero.get("describirLesiones");
        this.tipoLesion = datosExposicionTercero.get("tipoLesion");
        this.detallesTipoLesion = datosExposicionTercero.get("detallesTipoLesion");
        this.zonaCuerpo = datosExposicionTercero.get("zonaCuerpo");
        this.parteCuerpo = datosExposicionTercero.get("parteCuerpo");
            }

    public ExposicionTerceroAutos(List<Map<String, String>> datosTerceroAuto) {
        asignarDatos(datosTerceroAuto);
    }

    private void asignarDatos(List<Map<String, String>> datosTerceroAuto) {
        for (Map<String, String> dato : datosTerceroAuto) {
            lstExposicionTercero.add(new ExposicionTerceroAutos(dato));
        }
    }


}