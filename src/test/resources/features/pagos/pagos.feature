# language: es
Característica: Notificacion de aviso de una reclamacion


  @pagos
  Esquema del escenario: aviso
    Dado que se tiene el siniestro <numeroReclamacion>  del producto <producto> el cual cuenta con una linea de reserva <lineaReserva>
    Cuando se realice un pago <tipoPago> a un <beneficiarioPago> por medio de <metodoPago> y que el responsable <soloSura> es Sura por una retención de <codigoRetencion>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Producto                | Número de Reclamacion | Beneficiario           | Método de Pago | Solo Sura | Línea de reserva | Tipo Pago | Código de Retención |
      | Multiriesgo corporativo | 9180000014929         | PINTORES S.A. CQLII II | transferencia  | si        | si               | final     | 0018                |
      | Multiriesgo corporativo | 9180000015675         | Jose Alfredo Martinez  | caja sura      | no        | no               | parcial   | 0020                |


