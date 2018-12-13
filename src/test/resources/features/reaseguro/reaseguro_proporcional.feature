# language: es

Característica: Distribucion del reaseguro de un siniestro

  Como coordinador de empresariales
  Quiero conocer la distribucion que tiene el reaseguro de un siniestro en cada movimiento financiero
  Para identificar el monto de los valores que corresponden a los diferentes reaseguradores de acuerdo a los contratos adquiridos con la compañía

  @claimsEmpresarial
  Esquema del escenario: Reaseguro de Constitucion de reserva - creación reserva
    Cuando se genere una reclamacion de un contrato tipo <Tipo Contrato Poliza>, por causal <Causa> con un valor de pretension de <Valor de Pretension> e incidente de tipo <Tipo de incidente>
    Entonces para la transaccion <Tipo Transaccion> se distribuye el reaseguro por cada contrato <Tipo Contrato 1> <Tipo Contrato 2> <Tipo Contrato 3> y cada uno de los reaseguradores

    Ejemplos:
      | Tipo Contrato Poliza  | Causa                            | Valor de Pretension    | Tipo de incidente | Tipo Transaccion    | Tipo Contrato 1       | Tipo Contrato 2       | Tipo Contrato 3 |
      | primeraTxProporcional |  Amit/ huelga, conmoción civil   | 50000000               | Contenido         | constitucionReserva | primeraTx18T03AH030EX | primeraTx18T03AH030CP |                 |