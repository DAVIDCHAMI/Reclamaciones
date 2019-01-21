# language: es

Característica: Distribución del reaseguro de un siniestro

  Como coordinador de empresariales
  Quiero conocer la distribución que tiene el reaseguro de un siniestro en cada movimiento financiero
  Para identificar el monto de los valores que corresponden a los diferentes reaseguradores de acuerdo a los contratos adquiridos con la compañía

# @claimsEmpresarial
# Esquema del escenario: Reaseguro de Constitución de reserva - creación reserva
#    Dado  que se tiene una póliza de <Tipo y Cobertura>
#    Cuando se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
#    Y un incidente de tipo <Tipo de incidente>
#    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada
#
#    Ejemplos:
#    | Tipo y Cobertura                            | Tipo Transacción    |  Causa          | Valor de Pretensión | Tipo de incidente |
#    | Incendio con cobertura Daños materiales     | constitucionReserva |  Daños por agua | 2000000             | Propiedad         |
#
 @claimsEmpresarial
  Esquema del escenario: Reaseguro Reserva de liberación - Pago y liberación de reserva
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Cuando  se realice al siniestro un pago <Tipo Pago> a un <Beneficiario Pago> por medio de <Método Pago> el cual cuenta con una línea de reserva <Línea Reserva> donde el responsable <¿Solo Sura?> es Sura por una retención de <Código Retención>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
    | Tipo y Cobertura                                  |  Línea Reserva         | Tipo Pago | Beneficiario Pago             | Método Pago     | ¿Solo Sura?  | Código Retención  |Tipo Transacción   | Causa      | Valor de Pretensión | Tipo de incidente |
    | Multiriesgo corporativo con cobertura basica      | (1) 1ª partePropiedad  | Final     | CLUB LOS TRIUNFADORES CQLII  | Pago por banco  | No           | 0099              | reservaLiberacion  | Incendio     |3000000            |Propiedad          |

  @claimsEmpresarial
  Esquema del escenario: Reaseguro  del Recupero
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Cuando  se realice al siniestro un pago <Tipo Pago> a un <Beneficiario Pago> por medio de <Método Pago> el cual cuenta con una línea de reserva <Línea Reserva> donde el responsable <¿Solo Sura?> es Sura por una retención de <Código Retención Pago>
    Y se realice al siniestro un recupero de tipo <Tipo Recupero> con un código de retención <Código Retención Recupero>
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
    | Tipo y Cobertura                         |  Línea Reserva          | Tipo Pago | Beneficiario Pago                   | Método Pago | ¿Solo Sura?  | Código Retención Pago  |Tipo Transacción   |Tipo Recupero|Código Retención Recupero|  Causa               | Valor de Pretensión | Tipo de incidente |
    | Incendio con cobertura Daños materiales  | (1) 1ª parteContenido   | Final     |   MARTHA ENID ROJAS MARIACA CQLII   | Caja Sura   | No           | 0010                   | reservaLiberacion |Salvamento   |0099                     | Daños por agua       |3000000              |Contenido          |
#
  @claimsEmpresarial
 Esquema del escenario: Reaseguro Reversion de liberacion - Anulacion de pago y reversion de reserva
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Y que se realice un pago, de un siniestro de una póliza empresarial con producto <Tipo y Cobertura> y código de retención <Código Retención Pago>
    Cuando se realice la anulación del pago
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
  | Tipo y Cobertura                                     | Código Retención Pago |Tipo Transacción   | Causa      | Valor de Pretensión | Tipo de incidente |
  | Multiriesgo corporativo con cobertura basica         | 0099              | reservaLiberacion  | Incendio       |3000000              |Propiedad          |

  @claimsEmpresarial
  Esquema del escenario: anulacion  recupero
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Y que se realice una transacción de pago y una transacción de recupero, de un siniestro de una póliza empresarial con producto <Tipo y Cobertura> y código de retención <Código Retención>
    Cuando se realice la anulación del recupero
    Entonces para la transacción <Tipo Transacción> se distribuye el reaseguro según el retenido y el cedido de manera adecuada

    Ejemplos:
    | Tipo y Cobertura                         | Código Retención  |Tipo Transacción   |Tipo Recupero|Código Retención Recupero|  Causa               | Valor de Pretensión | Tipo de incidente |
    | Incendio con cobertura Daños materiales  |  0099                   | reservaLiberacion |Salvamento   |0099                     | Daños por agua       |3000000              |Contenido          |