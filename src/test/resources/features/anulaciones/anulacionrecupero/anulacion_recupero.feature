# language: es
Característica: Anulación de recuperos

  Como analista de reclamaciones
  Quiero generar una anulación de un recupero
  Para verificar que cambie su estado a anulado

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
      | Tipo y Cobertura                               | Código Retención Pago | Causa          | Valor de Pretensión | Tipo de incidente | Código Retención Recupero |
      | Incendio con cobertura Daños materiales        | 0028                  | Daños por agua | 3000000             | Contenido         | 0099                      |
      | PES Emergente Daño Interno Maquinaria y equipo | 0099                  | Daños por agua | 4000000             | Contenido         | 0099                      |


  @claimsAuto
  Esquema del escenario: anulación de un pago de autos.
    Dado que se tiene una póliza creacionAvisoMACA de autos
    Y se genera un aviso
    Y se declara la reclamación como perdida total
    Y se realiza un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo de cobertura> donde el responsable <¿Es pago soloSura?> es Sura con una retención de <Código de Retención>
    Y se genera una orden de pago para que le sea entregado al usuario
    Cuando se anula dicho pago con cobertura <Tipo de cobertura>
    Entonces se debe obtener la anulación del pago, quedando en estado anulado

    Ejemplos:
      | Línea de Reserva                | Tipo de pago | Beneficiario de pago | Método de pago | Código de Retención | ¿Es pago soloSura? | Tipo de cobertura   |
      | (1) 3ª parteLesiones corporales | Parcial      | JHON FEOR FEOR FEOR  | Pago por banco | 0099                | No                 | RC Lesión a Persona |
      | (3) 1ª parteVehículo            | Parcial      | SOFIA JARAMILLO      | Caja Sura      | 0099                | No                 | Perdida total Daños |
