# language: es
Característica: Anulación de pagos.

  Como analista de reclamaciones
  Quiero generar una anulación de pago y de recupero
  Para verificar que cambie su estado a anulado

#  @claimsEmpresarial
#  Esquema del escenario: anulación pago
#    Dado que se tiene una póliza de <Tipo y Cobertura>
#    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
#    Y un incidente de tipo <Tipo de incidente>
#    Y que se realice un pago, de un siniestro de una póliza empresarial con producto <Tipo y Cobertura> y código de retención <Código Retención Pago>
#    Cuando se realice la anulación del pago
#    Entonces se debe obtener la anulación del pago, quedando en estado anulado
#
#    Ejemplos:
#      | Tipo y Cobertura                                     | Código Retención Pago   | Causa                                 | Valor de Pretensión | Tipo de incidente |
#      | Multiriesgo corporativo con cobertura básica         | 0028                    | Incendio                              |3000000              |Propiedad          |
#      |PES Emergente	Responsabilidad civil                | 0010                    |Responsabilidad civil del asegurado    |5000000              |Propiedad          |
  @claimsAuto
  Esquema del escenario: anulación de un pago de autos.
    Dado que se tiene una reclamación de <Origen de siniestro> con un tipo de cobertura de <Tipo de cobertura>
    Y se cree un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la linea de reserva <Línea de reserva> donde el responsable <Solo Sura> es Sura con una retención de <Código de retención pago>
    Cuando se anula dicho pago con cobertura <Tipo de cobertura>
    Entonces se debe obtener la anulación del pago, quedando en estado anulado

    Ejemplos:
      |Origen de siniestro       | Línea de reserva                | Tipo de pago| Beneficiario de pago                    | Método de pago  | Código de retención pago | Solo Sura| Tipo de cobertura   | Tipo de recupero | Código de retención recupero |
      |Servicio de Maca          | (1) 3ª parteLesiones corporales | Parcial     | JHON FEOR FEOR FEOR                     | Pago por banco  | 0099                     | No       | RC Lesión a Persona |  Ingreso (otro)  |        0099                  |
      |Servicio de Maca          | (2) 1ª parteVehículo            | Parcial     | DIOGENES MANUEL BETANCOURT MADERA CQLII | Caja Sura       | 0099                     | No       | Perdida total Daños |  Subrogación     |        0099                  |
