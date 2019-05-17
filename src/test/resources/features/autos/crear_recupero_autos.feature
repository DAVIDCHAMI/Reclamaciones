# language: es
Característica: Crear un recupero de un siniestro

  Como analista de reclamación
  Quiero crear un recupero a partir de una línea de reserva
  Para que Suramericana recupere una parte del valor pagado sobre el siniestro

  @claimsAuto
  Esquema del escenario: crear recupero de subrogación o ingreso (otro)
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso
    Y se declara la reclamación como perdida total
    Y se realiza un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la línea de reserva <Línea de reserva> con cobertura de  <Tipo de cobertura> donde el responsable <¿Es pago soloSura?> es Sura con una retención de <Código de retención pago>
    Y se genera una orden de pago para que le sea entregado al usuario
    Cuando se cree el recupero por el tipo de <Tipo de recupero> con un código de retención <Código de retención recupero> a una cobertura <Tipo de cobertura>
    Entonces se obtiene un ingreso de dinero sobre el siniestro

    Ejemplos:
      | Línea de reserva                | Tipo de pago | Beneficiario de pago                    | Método de pago | Código de retención pago | ¿Es pago soloSura? | Tipo de cobertura   | Tipo de recupero | Código de retención recupero |
      | (1) 3ª parteLesiones corporales | Parcial      | JHON FEOR FEOR FEOR                     | Pago por banco | 0099                     | No                 | RC Lesión a Persona | Ingreso (otro)   | 0099                         |
      | (2) 1ª parteVehículo            | Parcial      | DIOGENES MANUEL BETANCOURT MADERA CQLII | Caja Sura      | 0099                     | No                 | Perdida total Daños | Subrogación      | 0099                         |
