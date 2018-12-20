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
  Cuando  se realice al siniestro un pago <tipoPago> a un <beneficiarioPago> por medio de <metodoPago> el cual cuenta con una linea de reserva <lineaReserva> donde el responsable <soloSura> es Sura por una retención de <codigoRetencion>
  Entonces para la transaccion <Tipo Transaccion> se distribuye el reaseguro segun el retenido y el cedido de manera adecuada

  Ejemplos:
    | Tipo Contrato Poliza |  lineaReserva           | tipoPago | beneficiarioPago                    | metodoPago | soloSura | codigoRetencion |Tipo Transaccion   | Tipo Contrato 1       | Tipo Contrato 2       |
    | MRC_01               | (1) 1ª parteContenido   | Final    |  SOLO FAMILIAR LTDA. CQLII          | Caja Sura  | No       | 0099            | reservaLiberacion | primeraTx18T03AH030EX | primeraTx18T03AH030CP |


