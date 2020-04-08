package com.sura.reclamaciones.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;

public final class Fecha {

  private Fecha() {}

  public static String obtenerFechaInicioVigenciaSegunTerminoInicio(
      int cantidadDias, String terminoInicioVigencia) {
    DateTime fechaInicio = new DateTime();
    switch (terminoInicioVigencia.toLowerCase()) {
      case "retroactividad":
        return fechaInicio.minusDays(cantidadDias).toString();
      case "anticipación":
        return fechaInicio.plusDays(cantidadDias).toString();
      default:
        throw new IllegalArgumentException(
            "El término de inicio de vigencia solicitado no es válido");
    }
  }

  public static String obtenerFechaFinVigencia(String fechaInicioVigencia, String tipoVigencia) {
    DateTime fechaInicio = new DateTime(fechaInicioVigencia);
    switch (tipoVigencia.toLowerCase()) {
      case "anual":
        return fechaInicio.plusYears(1).toString();
      case "semestral":
        return fechaInicio.plusMonths(6).toString();
      default:
        throw new IllegalArgumentException("El tipo de vigencia solicitado no es válido");
    }
  }

  public static String obtenerFechaActualFormato(String formato) {
    Date fechaActual = new Date();
    SimpleDateFormat formatoFechaSimple = new SimpleDateFormat(formato);
    return formatoFechaSimple.format(fechaActual);
  }

  public static Long convertirFechaUnix(String fecha, String formato) throws ParseException {
    SimpleDateFormat formatoFecha = new SimpleDateFormat(formato);
    return formatoFecha.parse(fecha).getTime();
  }

  public static String obtenerFechaFormatoISO(String fecha) {
    String hora = new DateTime().toLocalTime().toString();
    return new DateTime(fecha + "T" + hora).toString();
  }
}
