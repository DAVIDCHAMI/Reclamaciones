# language: es
Característica: Anulacion de recuperos

  Como analista de reclamaciones
  Quiero generar una anulación de un recupero
  Para verificar que el proceso de recuperación sea suspendido y no sea efectuado.

  @Autos
  @claimsAuto
  Esquema del escenario: anulación de un recupero de autos.
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Tipo de cobertura>
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario del pago> por el medio de pago de <Método del pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo de cobertura> donde el responsable <¿Es pago soloSura?> es Sura
    Y se apliquen las siguientes retenciones
      |Codigos_Retenciones|
      |0099   |
    Y se genera una orden de pago para que le sea entregado al usuario
    Y se cree el recupero con un código de retención <Código de retención recupero> a una cobertura <Tipo de cobertura>
    Y se obtiene un ingreso de dinero sobre el siniestro
    Cuando se anula el ingreso con cobertura <Tipo de cobertura>
    Entonces se debe obtener la anulación del recupero, quedando en estado anulado

    Ejemplos:
      | Línea de Reserva                | Tipo de pago | Beneficiario del pago | Método del pago | ¿Es pago soloSura? | Tipo de cobertura   | Tipo de recupero | Código de retención recupero |
      | (2) 1ª parteVehículo            | Parcial      |  CARLOS ARTURO CEBALLOS NUÑEZ CQLII       | Caja Sura       | No                 | Perdida total Daños | Subrogación      | 0099                         |