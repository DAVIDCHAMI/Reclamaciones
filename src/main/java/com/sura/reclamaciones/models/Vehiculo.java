package com.sura.reclamaciones.models;

import static com.sura.reclamaciones.utils.enums.NombresCsv.CIUDADES;

import com.sura.reclamaciones.utils.Utilidades;
import com.sura.reclamaciones.utils.UtilidadesCSV;
import com.sura.reclamaciones.utils.enums.ClaseVehiculo;
import com.sura.reclamaciones.utils.enums.PlanPolizaAutos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Vehiculo {
  private String claseVehiculo;
  private String codigoClaseVehiculo;
  private String linea;
  private String placa;
  private String modelo;
  private String marca;
  private String motor;
  private String chasis;
  private int anio;
  private String tipoVehiculo;
  private String color;
  private String codigoFasecolda;
  private int numeroVehiculo;
  private String marcaLinea;
  private String plan;
  private String codigoPlan;
  private String tipoServicio;
  private boolean esCeroKms;
  private boolean transportaCombustible;
  private boolean tieneTrailer;
  private boolean esImportado;
  private boolean tieneInscripcionExtranjera;
  private boolean requiereInspeccion;
  private boolean esBlindado;
  private String ciudadCirculacion;
  private String codigoCiudadCirculacion;
  private String codigoZonaCirculacion;
  private int valorAsegurado;
  private int valorAccesorios;
  private int valorAccesoriosEspeciales;
  private String grupoTarifa;
  private String dispositivoSeguridad;
  private int bonificacionComercial;
  private int bonificacionTecnica;
  private List<Vehiculo> vehiculos = new ArrayList<>();

  public Vehiculo() {}

  public Vehiculo(List<Map<String, String>> datoVehiculo) throws IOException {
    asignarDatos(datoVehiculo);
  }

  public Vehiculo(Map<String, String> datosVehiculos) throws IOException {
    List<Map<String, String>> lstCiudades =
        UtilidadesCSV.obtenerDatosPrueba(CIUDADES.getValor(), "");
    claseVehiculo = datosVehiculos.get("claseVehiculo");
    codigoClaseVehiculo = ClaseVehiculo.obtenerCodigoClaseVehiculo(claseVehiculo);
    linea = datosVehiculos.get("linea");
    if (datosVehiculos.get("placa").equals("RANDOM")) {
      placa = Utilidades.generarPlacaAleatoria(4, 3);
    } else {
      placa = datosVehiculos.get("placa");
    }
    modelo = datosVehiculos.get("modelo");
    marca = datosVehiculos.get("marca");
    motor = datosVehiculos.get("motor");
    chasis = datosVehiculos.get("chasis");
    anio = Integer.parseInt(datosVehiculos.get("anio"));
    color = datosVehiculos.get("color");
    codigoFasecolda = datosVehiculos.get("codigoFasecolda");
    tipoVehiculo = datosVehiculos.get("tipoVehiculo");
    numeroVehiculo = Integer.parseInt(datosVehiculos.get("numeroVehiculo"));
    marcaLinea = datosVehiculos.get("marcaLinea");
    plan = datosVehiculos.get("plan");
    codigoPlan = PlanPolizaAutos.obtenerCodigoPlan(plan);
    tipoServicio = datosVehiculos.get("tipoServicio");
    esCeroKms = Utilidades.transformarCadenaValorlogico(datosVehiculos.get("esCeroKms"));
    transportaCombustible =
        Utilidades.transformarCadenaValorlogico(datosVehiculos.get("transportaCombustible"));
    tieneTrailer = Utilidades.transformarCadenaValorlogico(datosVehiculos.get("tieneTrailer"));
    esImportado = Utilidades.transformarCadenaValorlogico(datosVehiculos.get("esImportado"));
    tieneInscripcionExtranjera =
        Utilidades.transformarCadenaValorlogico(datosVehiculos.get("tieneInscripcionExtranjera"));
    requiereInspeccion =
        Utilidades.transformarCadenaValorlogico(datosVehiculos.get("requiereInspeccion"));
    esBlindado = Utilidades.transformarCadenaValorlogico(datosVehiculos.get("esBlindado"));
    ciudadCirculacion = datosVehiculos.get("ciudadCirculacion");
    codigoCiudadCirculacion =
        Utilidades.obtenerDatosDiccionario(lstCiudades, ciudadCirculacion, "codigoCiudad");
    codigoZonaCirculacion =
        Utilidades.obtenerDatosDiccionario(lstCiudades, ciudadCirculacion, "codigoZonaCiudad");
    valorAsegurado = Integer.parseInt(datosVehiculos.get("valorAsegurado"));
    valorAccesorios = Integer.parseInt(datosVehiculos.get("valorAccesorios"));
    valorAccesoriosEspeciales = Integer.parseInt(datosVehiculos.get("valorAccesoriosEspeciales"));
    grupoTarifa = datosVehiculos.get("grupoTarifa");
    dispositivoSeguridad = datosVehiculos.get("dispositivoSeguridad");
    bonificacionComercial = Integer.parseInt(datosVehiculos.get("bonificacionComercial"));
    bonificacionTecnica = Integer.parseInt(datosVehiculos.get("bonificacionTecnica"));
  }

  public String getClaseVehiculo() {
    return claseVehiculo;
  }

  public String getCodigoClaseVehiculo() {
    return codigoClaseVehiculo;
  }

  public String getLinea() {
    return linea;
  }

  public String getPlaca() {
    return placa;
  }

  public String getModelo() {
    return modelo;
  }

  public String getMarca() {
    return marca;
  }

  public String getMotor() {
    return motor;
  }

  public String getChasis() {
    return chasis;
  }

  public int getAnio() {
    return anio;
  }

  public String getTipoVehiculo() {
    return tipoVehiculo;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getCodigoFasecolda() {
    return codigoFasecolda;
  }

  public int getNumeroVehiculo() {
    return numeroVehiculo;
  }

  public String getMarcaLinea() {
    return marcaLinea;
  }

  public String getPlan() {
    return plan;
  }

  public String getCodigoPlan() {
    return codigoPlan;
  }

  public String getTipoServicio() {
    return tipoServicio;
  }

  public boolean getEsCeroKms() {
    return esCeroKms;
  }

  public boolean getTransportaCombustible() {
    return transportaCombustible;
  }

  public boolean getTieneTrailer() {
    return tieneTrailer;
  }

  public boolean getEsImportado() {
    return esImportado;
  }

  public boolean getTieneInscripcionExtranjera() {
    return tieneInscripcionExtranjera;
  }

  public boolean getRequiereInspeccion() {
    return requiereInspeccion;
  }

  public boolean getEsBlindado() {
    return esBlindado;
  }

  public String getCiudadCirculacion() {
    return ciudadCirculacion;
  }

  public String getCodigoCiudadCirculacion() {
    return codigoCiudadCirculacion;
  }

  public String getCodigoZonaCirculacion() {
    return codigoZonaCirculacion;
  }

  public int getValorAsegurado() {
    return valorAsegurado;
  }

  public int getValorAccesorios() {
    return valorAccesorios;
  }

  public int getValorAccesoriosEspeciales() {
    return valorAccesoriosEspeciales;
  }

  public String getGrupoTarifa() {
    return grupoTarifa;
  }

  public String getDispositivoSeguridad() {
    return dispositivoSeguridad;
  }

  public int getBonificacionComercial() {
    return bonificacionComercial;
  }

  public int getBonificacionTecnica() {
    return bonificacionTecnica;
  }

  public List<Vehiculo> getLstVehiculos() {
    return vehiculos;
  }

  public void asignarDatos(List<Map<String, String>> datoVehiculo) throws IOException {
    for (Map<String, String> dato : datoVehiculo) {
      vehiculos.add(new Vehiculo(dato));
    }
  }
}
