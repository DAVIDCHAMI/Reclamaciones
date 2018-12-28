# language: es

Característica: Distribucion del reaseguro de un siniestro

  Como coordinador de empresariales
  Quiero conocer la distribucion que tiene el reaseguro de un siniestro en cada movimiento financiero
  Para identificar el monto de los valores que corresponden a los diferentes reaseguradores de acuerdo a los contratos adquiridos con la compañía

 @claimsEmpresarial
  Esquema del escenario: Reaseguro de Constitucion de reserva - creación reserva
    Cuando se genere una reclamacion de un contrato tipo <Tipo Contrato Poliza>
    Entonces para la transaccion <Tipo Transaccion> se distribuye el reaseguro segun el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo Contrato Poliza  | Tipo Transaccion    |
      | primeraTxProporcional | constitucionReserva |
      | MRC_01                | constitucionReserva |

  @claimsEmpresarial
  Esquema del escenario: Reaseguro Reserva de liberacion - Pago y liberacion de reserva
  Dado se genere una reclamacion de un contrato tipo <Tipo Contrato Poliza>
  Cuando  se realice al siniestro un pago <Tipo Pago> a un <Beneficiario Pago> por medio de <Metodo Pago> el cual cuenta con una linea de reserva <Linea Reserva> donde el responsable <¿Solo Sura?> es Sura por una retención de <Código Retencion>
  Entonces para la transaccion <Tipo Transaccion> se distribuye el reaseguro segun el retenido y el cedido de manera adecuada

  Ejemplos:
    | Tipo Contrato Poliza |  Linea Reserva          | Tipo Pago | Beneficiario Pago                   | Metodo Pago | ¿Solo Sura?  | Código Retencion  |Tipo Transaccion   |
    | MRC_01               | (1) 1ª parteContenido   | Final     |  SOLO FAMILIAR LTDA. CQLII          | Caja Sura   | No           | 0099              | reservaLiberacion |


