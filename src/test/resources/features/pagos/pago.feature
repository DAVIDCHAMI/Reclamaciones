# language: es
Característica: Realizar pago de un siniestro

  @claimsEmpresarial
  Esquema del escenario: Pago
    Dado que se tiene el siniestro <numeroReclamacion>  del producto <producto>
    Cuando se realice un pago <tipoPago> a un <beneficiarioPago> por medio de <metodoPago> el cual cuenta con una linea de reserva <lineaReserva> donde el responsable <soloSura> es Sura por una retención de <codigoRetencion>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | numeroReclamacion  | producto     | lineaReserva            |tipoPago    | beneficiarioPago                       | metodoPago       | soloSura  | codigoRetencion    |
      | 9180000020103      | MRC_01       |(1) 1ª partePropiedad    | Parcial    |VICTOR HUGO SEPULVEDA VALLEJO CQLII     | Transferencia    | Sí        | 0099               |
      | 9180000019212      | MRC_02       |(2) 1ª partePropiedad    | Parcial    |ROBIN EDULFO BAUTISTA ALVAREZ CQLII     | Pago por banco   | No        | 0023               |

