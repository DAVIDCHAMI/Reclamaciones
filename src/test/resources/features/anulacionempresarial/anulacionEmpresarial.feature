# language: es
Característica: Anulacion Empresarial

  Como analista de reclamaciones
  Quiero generar una anulación de pago y de recupero
  Para verificar que cambie su estado a anulado

  @claimsEmpresarial
  Esquema del escenario: anulación pago
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Y que se realice un pago, de un siniestro de una póliza empresarial con producto <Tipo y Cobertura> y código de retención <Código Retención Pago>
    Cuando se realice la anulación del pago
    Entonces se debe obtener la anulación del pago, quedando en estado anulado

    Ejemplos:
      | Tipo y Cobertura                                     | Código Retención Pago   | Causa      | Valor de Pretensión | Tipo de incidente |
      | Multiriesgo corporativo con cobertura basica         | 0028                    | Incendio       |3000000              |Propiedad          |

  @claimsEmpresarial
  Esquema del escenario: anulacion  recupero
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Y que se realice un pago, de un siniestro de una póliza empresarial con producto <Tipo y Cobertura> y código de retención <Código Retención Pago>
    Y una transacción de recupero, de un siniestro de una póliza empresarial con producto <Tipo y Cobertura> y código de retención <Código Retención Recupero>
    Cuando se realice la anulación del recupero
    Entonces se debe obtener la anulación del recupero, quedando en estado anulado

    Ejemplos:
      | Tipo y Cobertura                         | Código Retención Pago            |  Causa               | Valor de Pretensión | Tipo de incidente |Código Retención Recupero|
      | Incendio con cobertura Daños materiales  |  0028                            | Daños por agua       |3000000              |Contenido          |0099                     |



