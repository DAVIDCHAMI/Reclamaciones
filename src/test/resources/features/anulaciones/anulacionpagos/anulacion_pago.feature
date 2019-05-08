# language: es
Característica: Anulación de pagos.

  Como analista de reclamaciones
  Quiero generar una anulación de pago y de recupero
  Para verificar que cambie su estado a anulado

  @claimsEmpresarial
  Esquema del escenario: anulación de un pago de empresariales.
   # Dado que se tiene una póliza de <Tipo y Cobertura>
    #Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    #Y un incidente de tipo <Tipo de incidente>
    #Y se efectua un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura con una retención de <Código de Retención>
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Y se realiza un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo y Cobertura> donde el responsable <¿Es pago soloSura?> es Sura con una retención de <Código de Retención>
    Y se genera una orden de pago para que le sea entregado al usuario
    Cuando se realice la anulación del pago
    Entonces se debe obtener la anulación del pago, quedando en estado anulado

    Ejemplos:
      | Línea de Reserva      | Tipo de pago | Beneficiario del pago           | Método del pago | ¿Es pago soloSura? | Código de Retención | Tipo y Cobertura                        | Causa          | Valor de Pretensión | Tipo de incidente |
      | (1) 1ª partePropiedad | Parcial      | MARTHA ENID ROJAS MARIACA CQLII | Pago por banco  | No                 | 0099                | Incendio con cobertura Daños materiales | Daños por agua | 5000000             | Propiedad         |
      | (1) 1ª partePropiedad | Final        | AURA JUDITH LOPEZ JULIO CQLII   | Caja Sura       | No                 | 0023                | Hogar con cobertura básica              | Incendio       | 2000000             | Propiedad         |


  @claimsAuto
  Esquema del escenario: anulación de un pago de autos.
    Dado que se tiene una reclamación de <Origen de siniestro> con un tipo de cobertura de <Tipo de cobertura>
    Y se cree un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la linea de reserva <Línea de reserva> donde el responsable <Solo Sura> es Sura con una retención de <Código de retención pago>
    Cuando se realice la anulación del pago
    Entonces se debe obtener la anulación del pago, quedando en estado anulado

    Ejemplos:
      | Origen de siniestro | Línea de reserva                | Tipo de pago | Beneficiario de pago                    | Método de pago | Código de retención pago | Solo Sura | Tipo de cobertura   |
      | Servicio de Maca    | (1) 3ª parteLesiones corporales | Parcial      | JHON FEOR FEOR FEOR                     | Pago por banco | 0099                     | No        | RC Lesión a Persona |
      | Servicio de Maca    | (2) 1ª parteVehículo            | Parcial      | DIOGENES MANUEL BETANCOURT MADERA CQLII | Caja Sura      | 0099                     | No        | Perdida total Daños |
