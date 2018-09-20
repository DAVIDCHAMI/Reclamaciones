# language: es
Característica: Realizar pago de un siniestro

  @claims
  Esquema del escenario: Pago
    Dado que se tiene el siniestro <numeroReclamacion>  del producto <producto>
    Cuando se realice un pago <tipoPago> a un <beneficiarioPago> por medio de <metodoPago> el cual cuenta con una linea de reserva <lineaReserva> donde el responsable <soloSura> es Sura por una retención de <codigoRetencion>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | numeroReclamacion  | producto                     | lineaReserva              |tipoPago    | beneficiarioPago                       | metodoPago       | soloSura  | codigoRetencion    |
      | 9180000020103      | Multiriesgo corporativo (1) |(1) 1ª partePropiedad    | Parcial    |VICTOR HUGO SEPULVEDA VALLEJO CQLII     | Transferencia    | Sí        | 0099               |
      | 9180000020946      | Multiriesgo corporativo (2) |(1) 1ª partePropiedad    | Parcial    |VICTOR HUGO SEPULVEDA VALLEJO CQLII     | Caja Sura        | No        | 0023               |