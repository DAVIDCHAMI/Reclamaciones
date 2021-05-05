# language: es
Característica: Constitución de una línea de reserva de un siniestro

  Como analista de reclamaciones
  Quiero que sea posible crear una línea de reserva a una exposición
  Para que se pueda cubrir los costos y los gastos que se tienen en un siniestro

  @creacionLineaReserva
  @claimsAuto
  Esquema del escenario: creación de nueva línea de reserva por honorarios en una reclamación de autos
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Cobertura>
    Cuando se crea una nueva línea de reserva por la Exposición de <Exposición> por <Categoría> con un tipo de costo <Tipo costo> por un valor de <Valor de Pretensión>
    Entonces se genera una nueva línea de reserva de <Categoría> con un deducible de <Deducible>

    Ejemplos:

      | Exposición           | Categoría               | Tipo costo                                    | Valor de Pretensión | Deducible | Cobertura           |
      | (2) 1ª parteVehículo | Gastos proceso jurídico | Gasto - D&CC (defensa y contención de gastos) | 4000000             | 0         | Perdida total Daños |