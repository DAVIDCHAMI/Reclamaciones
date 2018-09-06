# language: es
Característica: Notificacion de aviso de una reclamacion

  @claims
  Esquema del escenario: aviso
    Dado que se tiene el siniestro <numeroReclamacion>  del producto <producto>
    Cuando se realice un pago <tipoPago> a un <beneficiarioPago> por medio de <metodoPago> el cual cuenta con una linea de reserva <lineaReserva> donde el responsable <soloSura> es Sura por una retención de <codigoRetencion>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | numeroReclamacion  | producto                 | lineaReserva                                                                                               |tipoPago  | beneficiarioPago                       | metodoPago       | soloSura  | codigoRetencion    |
      | 9180000014929      | Multiriesgo corporativo  |(1) 1ª partePropiedad - JOSE ALFREDO MARTINEZ HERRERA CQLII; Costo de reclamación/Daños materiales; COP     | Parcial    |JOSE ALFREDO MARTINEZ HERRERA CQLII     | Transferencia    | Sí        | 0018               |
      | 9180000015675      | Multiriesgo corporativo  |(1) 1ª partePropiedad - JOSE ALFREDO MARTINEZ HERRERA CQLII; Costo de reclamación/Daños materiales; COP     | Final      |JOSE ALFREDO MARTINEZ HERRERA CQLII     | Caja Sura        | No        | 0020               |


