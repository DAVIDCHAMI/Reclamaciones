# language: es
Característica: Anulación de pagos

  Como analista de reclamaciones
  Quiero generar una anulación de un pago
  Para verificar que el proceso de pago sea suspendido y no sea efectuado.

  Antecedentes: Crear poliza
    Dado se tiene una póliza de autos individual con plan Global de vigencia anual con 5 de retroactividad

  @claimsAuto
  @anulacionPagoAutos
  Esquema del escenario: anulación de un pago de autos.
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Tipo de cobertura>
    Y se valida en sarlaft el beneficiario <Beneficiario de pago>
    Cuando se realiza un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la línea de reserva <Línea de Reserva> con cobertura de  <Tipo de cobertura> donde el responsable <¿Es pago soloSura?> es Sura
    Y se apliquen las siguientes retenciones
      | Codigos_Retenciones |
      | 0099                |
    Y se genera una orden de pago para que le sea entregado al usuario
    Cuando se anula dicho pago con cobertura <Tipo de cobertura>
    Entonces se debe obtener la anulación del pago, quedando en estado anulado

    Ejemplos:
      | Línea de Reserva     | Tipo de pago | Beneficiario de pago               | Método de pago | ¿Es pago soloSura? | Tipo de cobertura   |
      | (2) 1ª parteVehículo | Parcial      | NESTOR IVAN GAMBOA CONTRERAS CQLII | Caja Sura      | No                 | Perdida total Daños |