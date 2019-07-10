package com.sura.reclamaciones.constantes;

public enum Posiciones
{
    POSICION_FILA("1");

    private String valor;

    Posiciones(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
