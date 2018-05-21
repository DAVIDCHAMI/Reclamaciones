package com.sura.reclamaciones.models.Usuario;

import com.sura.reclamaciones.models.PersonaDTO;
import com.sura.reclamaciones.models.Vehiculo;

public class PolizaDTO {

    private PersonaDTO personaDTO;
    private Vehiculo vehiculoDTO;
    private String fechaSiniestro;


    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public Vehiculo getVehiculoDTO() {
        return vehiculoDTO;
    }

    public String getFechaSiniestro() {
        return fechaSiniestro;
    }
}
