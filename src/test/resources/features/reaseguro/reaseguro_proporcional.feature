# language: es

Característica: Distribución del reaseguro de un siniestro

  Como coordinador de empresariales
  Quiero conocer la distribución que tiene el reaseguro de un siniestro en cada movimiento financiero
  Para identificar el monto de los valores que corresponden a los diferentes reaseguradores de acuerdo a los contratos adquiridos con la compañía

  @reaseguroReserva
  @claimsEmpresarial
  Esquema del escenario: Reaseguro de Constitución de reserva - creación reserva
    Dado  que se tiene una póliza de <Tipo y Cobertura>
    Cuando se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                        | Tipo Transacción | Causa                        | Valor de Pretensión | Tipo de incidente |
      | Incendio con cobertura Daños materiales | Reserva          | Daños por agua               | 2000000             | Propiedad         |
      | Hogar terremoto                         | Reserva          | Terremoto,temblor o erupción | 3000000             | Propiedad         |

  @reaseguroPagoYLiberacion
  @claimsEmpresarial
  Esquema del escenario: Reaseguro Reserva de liberación - Pago y liberación de reserva
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura
    Y se apliquen las siguientes retenciones
      | Codigos_Retenciones |
      | 099                 |
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura           | Línea de Reserva      | Tipo de pago | Beneficiario del pago         | Método del pago | ¿Es pago soloSura? | Tipo Transacción | Causa    | Valor de Pretensión | Tipo de incidente |
      | Hogar con cobertura básica | (1) 1ª partePropiedad | Parcial      | AURA JUDITH LOPEZ JULIO CQLII | Pago por banco  | No                 | Pago             | Incendio | 3000000             | Propiedad         |

  @reaseguroPagoYRecupero
  @claimsEmpresarial
  Esquema del escenario: Reaseguro  del Recupero después del pago
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura
    Y se apliquen las siguientes retenciones
      | Codigos_Retenciones |
      | 099                 |
    Y se realice al siniestro un recupero de tipo <Tipo Recupero> con un código de retención <Código Retención Recupero>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                        | Línea de Reserva      | Tipo de pago | Beneficiario del pago           | Método del pago | ¿Es pago soloSura? | Tipo Transacción | Tipo Recupero | Código Retención Recupero | Causa          | Valor de Pretensión | Tipo de incidente |
      | Incendio con cobertura Daños materiales | (1) 1ª parteContenido | Final        | MARTHA ENID ROJAS MARIACA CQLII | Caja Sura       | No                 | Recupero         | Salvamento    | 0099                      | Daños por agua | 3000000             | Contenido         |

  @reaseguroRecupero
  @claimsEmpresarial
  Esquema del escenario: Reaseguro  del Recupero antes del pago
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Cuando se genere un recupero de tipo <Tipo Recupero> con un código de retención <Código Retención Recupero>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                        | Tipo Transacción | Tipo Recupero | Código Retención Recupero | Causa          | Valor de Pretensión | Tipo de incidente |
      | Incendio con cobertura Daños materiales | Recupero         | Salvamento    | 0099                      | Daños por agua | 3000000             | Contenido         |

  @reaseguroAnulacionPago
  @claimsEmpresarial
  Esquema del escenario: Reaseguro Reversión de liberación - Anulación de pago y reversión de reserva
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura
    Y se apliquen las siguientes retenciones
      | Codigos_Retenciones |
      | 099                 |
    Cuando se realice la anulación del pago
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                        | Línea de Reserva      | Tipo de pago | Beneficiario del pago           | Método del pago | ¿Es pago soloSura? | Tipo Transacción | Causa          | Valor de Pretensión | Tipo de incidente |
      | Incendio con cobertura Daños materiales | (1) 1ª parteContenido | Final        | MARTHA ENID ROJAS MARIACA CQLII | Caja Sura       | No                 | Anulacion Pago   | Daños por agua | 3000000             | Contenido         |

  @reaseguroAnulacionRecupero
  @claimsEmpresarial
  Esquema del escenario: Reaseguro Anulación de recupero
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura
    Y se apliquen las siguientes retenciones
      | Codigos_Retenciones |
      | 028                 |
    Y una transacción de recupero, de un siniestro de una póliza empresarial con producto <Tipo y Cobertura> y código de retención <Código Retención Recupero>
    Cuando se realice la anulación del recupero
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                        | Línea de Reserva      | Tipo de pago | Beneficiario del pago           | Método del pago | ¿Es pago soloSura? |Tipo Transacción   | Causa          | Valor de Pretensión | Tipo de incidente | Código Retención Recupero |
      | Incendio con cobertura Daños materiales | (1) 1ª parteContenido | Final        | MARTHA ENID ROJAS MARIACA CQLII | Caja Sura       | No                 |Anulación Recupero | Daños por agua | 3000000             | Contenido         | 0099                      |

  @reaseguroReversion
  @claimsEmpresarial
  Esquema del escenario: Reaseguro Reversión de constitución
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se ajuste la reserva con un valor de <Monto del ajuste>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                             | Causa             | Valor de pretensión | Tipo de incidente | Monto del ajuste | Tipo Transacción       |
      | Multiriesgo corporativo con cobertura básica | Rotura de vidrios | 2000000             | Propiedad         | 4000000          | Reversión Constitución |


