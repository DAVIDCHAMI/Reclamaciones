package com.sura.reclamaciones.models.Usuario;

import com.sura.reclamaciones.models.Persona;
import com.sura.reclamaciones.models.Vehiculo;

public class PolizaDTO {

    private Persona persona;
    private Vehiculo vehiculoDTO;
    private String fechaSiniestro;


    public Persona getPersona() {
        return persona;
    }

    public Vehiculo getVehiculoDTO() {
        return vehiculoDTO;
    }

    public String getFechaSiniestro() {
        return fechaSiniestro;
    }
}
