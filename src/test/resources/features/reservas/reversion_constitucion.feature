# language: es
Característica: Reversión de constitución o ajuste manual de la reserva de un siniestro

  Como analista de reclamaciones
  Quiero que sea posible realizar ajustes en las reservas
  Para que se pueda cubrir el monto del valor del siniestro

  @claimsEmpresarial
  Esquema del escenario: reversión de constitución
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <causa>, valor de pretensión <valor de pretension> y tipo incidente de <Tipo de incidente>
    Cuando se ajuste la reserva con un valor de <Monto del ajuste>
    Entonces se obtiene una reversión de constitución y el deducible es generado por un valor <Deducible>

    Ejemplos:
      | Tipo y Cobertura                             | causa             | valor de pretension | Tipo de incidente | Monto del ajuste | Deducible |
      | Multiriesgo corporativo con cobertura básica | Rotura de vidrios | 2000000             | Propiedad         | 4000000          | -1562484  |
      | Multiriesgo corporativo con cobertura básica | Rotura de vidrios | 2000000             | Propiedad         | 50000000         | -5000000  |



