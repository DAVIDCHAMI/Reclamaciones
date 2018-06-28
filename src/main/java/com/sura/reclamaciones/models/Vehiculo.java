package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Vehiculo {
    private String placa;
    private String clase;
    private String modelo;
    private String marca;
    private String linea;
    private String motor;
    private String chasis;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Vehiculo() {
    }

    public Vehiculo(Map<String, String> datosVehiculos) {
        this.placa = datosVehiculos.get("placa");
        this.clase = datosVehiculos.get("clase");
        this.modelo = datosVehiculos.get("modelo");
        this.marca = datosVehiculos.get("marca");
        this.linea = datosVehiculos.get("linea");
        this.motor = datosVehiculos.get("motor");
        this.chasis = datosVehiculos.get("chasis");
    }

    public Vehiculo(List<Map<String, String>> datoVehiculo) {
        super();
        asignarDatos(datoVehiculo);
    }

    public String getPlaca() {
        return placa;
    }

    public String getClase() {
        return clase;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getLinea() {
        return linea;
    }

    public String getMotor() {
        return motor;
    }

    public String getChasis() {
        return chasis;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void asignarDatos(List<Map<String, String>> datoVehiculo) {
        for (Map<String, String> dato : datoVehiculo) {
            vehiculos.add(new Vehiculo(dato));
        }
    }
}
