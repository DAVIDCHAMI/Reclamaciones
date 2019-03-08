# language: es

Característica: Distribución del reaseguro de un siniestro

  Como coordinador de empresariales
  Quiero conocer la distribución que tiene el reaseguro de un siniestro en cada movimiento financiero
  Para identificar el monto de los valores que corresponden a los diferentes reaseguradores de acuerdo a los contratos adquiridos con la compañía

  @claimsEmpresarial
  Esquema del escenario: Reaseguro de Constitución de reserva - creación reserva
    Dado  que se tiene una póliza de <Tipo y Cobertura>L
    Cuando se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                        | Tipo Transacción | Causa                        | Valor de Pretensión | Tipo de incidente |
      | Incendio con cobertura Daños materiales | Reserva          | Daños por agua               | 2000000             | Propiedad         |
      | Hogar terremoto                         | Reserva          | Terremoto,temblor o erupción | 3000000             | Propiedad         |

  @claimsEmpresarial
  Esquema del escenario: Reaseguro Reserva de liberación - Pago y liberación de reserva
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Cuando  se realice al siniestro un pago <Tipo Pago> a un <Beneficiario Pago> por medio de <Método Pago> el cual cuenta con una línea de reserva <Línea Reserva> donde el responsable <¿Solo Sura?> es Sura por una retención de <Código Retención>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                            | Línea Reserva       | Tipo Pago | Beneficiario Pago    | Método Pago    | ¿Solo Sura? | Código Retención | Tipo Transacción | Causa                               | Valor de Pretensión | Tipo de incidente |
      | Responsabilidad Civil Predios y operaciones | (1) 1ª parteGeneral | Final     | HERMANOS LTDA. CQLII | Pago por banco | No          | 0099             | Pago             | Responsabilidad civil del asegurado | 3000000             | General           |

  @claimsEmpresarial
  Esquema del escenario: Reaseguro  del Recupero después del pago
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Cuando  se realice al siniestro un pago <Tipo Pago> a un <Beneficiario Pago> por medio de <Método Pago> el cual cuenta con una línea de reserva <Línea Reserva> donde el responsable <¿Solo Sura?> es Sura por una retención de <Código Retención Pago>
    Y se realice al siniestro un recupero de tipo <Tipo Recupero> con un código de retención <Código Retención Recupero>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                        | Línea Reserva         | Tipo Pago | Beneficiario Pago               | Método Pago | ¿Solo Sura? | Código Retención Pago | Tipo Transacción | Tipo Recupero | Código Retención Recupero | Causa          | Valor de Pretensión | Tipo de incidente |
      | Incendio con cobertura Daños materiales | (1) 1ª parteContenido | Final     | MARTHA ENID ROJAS MARIACA CQLII | Caja Sura   | No          | 0010                  | Recupero         | Salvamento    | 0099                      | Daños por agua | 3000000             | Contenido         |

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

  @claimsEmpresarial
  Esquema del escenario: Reaseguro Reversión de liberación - Anulación de pago y reversión de reserva
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Y que se realice un pago, de un siniestro de una póliza empresarial con producto <Tipo y Cobertura> y código de retención <Código Retención Pago>
    Cuando se realice la anulación del pago
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                             | Código Retención Pago | Tipo Transacción | Causa    | Valor de Pretensión | Tipo de incidente |
      | Multiriesgo corporativo con cobertura básica | 0099                  | Anulación Pago   | Incendio | 3000000             | Propiedad         |

  @claimsEmpresarial
  Esquema del escenario: Reaseguro Anulación de recupero
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Y que se realice un pago, de un siniestro de una póliza empresarial con producto <Tipo y Cobertura> y código de retención <Código Retención Pago>
    Y una transacción de recupero, de un siniestro de una póliza empresarial con producto <Tipo y Cobertura> y código de retención <Código Retención Recupero>
    Cuando se realice la anulación del recupero
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                        | Código Retención Pago | Tipo Transacción   | Causa          | Valor de Pretensión | Tipo de incidente | Código Retención Recupero |
      | Incendio con cobertura Daños materiales | 0028                  | Anulación Recupero | Daños por agua | 3000000             | Contenido         | 0099                      |

  @claimsEmpresarial
  Esquema del escenario: Reaseguro Reversión de constitución
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se ajuste la reserva con un valor de <Monto del ajuste>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
      | Tipo y Cobertura                             | Causa             | Valor de pretensión | Tipo de incidente | Monto del ajuste | Tipo Transacción       |
      | Multiriesgo corporativo con cobertura básica | Rotura de vidrios | 2000000             | Propiedad         | 4000000          | Reversión Constitución |


