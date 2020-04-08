package com.sura.reclamaciones.models;

import com.sura.reclamaciones.utils.Utilidades;
import com.sura.reclamaciones.utils.enums.CodigoCategoriaCoberturaAutos;
import com.sura.reclamaciones.utils.enums.CodigoNombreCoberturaAutos;
import com.sura.reclamaciones.utils.enums.CodigoTerminoCoberturaAutos;
import com.sura.reclamaciones.utils.enums.Separador;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class CoberturaVehiculo {

  private String categoria;
  private String codigoCategoria;
  private String nombre;
  private String codigoNombre;
  private String termino;
  private String codigoTermino;
  private String opcion;
  private String codigoOpcion;

  private CoberturaVehiculo(
      Map<String, String> datosCobertura, List<Map<String, String>> diccionarioCoberturas) {
    categoria = datosCobertura.get("categoria");
    setCodigoCategoria();
    nombre = datosCobertura.get("nombre");
    setCodigoNombre();
    termino = datosCobertura.get("termino");
    setCodigoTermino();
    opcion = datosCobertura.get("opcion");
    setCodigoOpcion(diccionarioCoberturas);
  }

  public static List<CoberturaVehiculo> obtenerListaCoberturas(
      List<Map<String, String>> datosCoberturaAutos,
      List<Map<String, String>> diccionarioCoberturas) {
    List<CoberturaVehiculo> lstCoberturasVehiculo = new ArrayList<>();
    for (Map<String, String> cobertura : datosCoberturaAutos) {
      lstCoberturasVehiculo.add(new CoberturaVehiculo(cobertura, diccionarioCoberturas));
    }
    return lstCoberturasVehiculo;
  }

  public String getCategoria() {
    return categoria;
  }

  public String getCodigoCategoria() {
    return codigoCategoria;
  }

  private void setCodigoCategoria() {
    this.codigoCategoria = CodigoCategoriaCoberturaAutos.obtenerCodigoCategoria(categoria);
  }

  public String getNombre() {
    return nombre;
  }

  public String getCodigoNombre() {
    return codigoNombre;
  }

  private void setCodigoNombre() {
    this.codigoNombre = CodigoNombreCoberturaAutos.obtenerCodigoNombre(nombre);
  }

  public String getTermino() {
    return termino;
  }

  public String getCodigoTermino() {
    return codigoTermino;
  }

  private void setCodigoTermino() {
    String filtroTermino = nombre + Separador.SEPARADOR_FLECHA.getValor() + termino;
    this.codigoTermino = CodigoTerminoCoberturaAutos.obtenerCodigoTermino(filtroTermino);
  }

  public String getOpcion() {
    return opcion;
  }

  public String getCodigoOpcion() {
    return codigoOpcion;
  }

  private void setCodigoOpcion(List<Map<String, String>> diccionarioCoberturas) {
    String idFiltroCobertura =
        nombre
            + Separador.SEPARADOR_FLECHA.getValor()
            + termino
            + Separador.SEPARADOR_FLECHA.getValor()
            + opcion;
    this.codigoOpcion =
        Utilidades.obtenerDatosDiccionario(
            diccionarioCoberturas, idFiltroCobertura, "codigoOpcionCobertura");
  }
}
