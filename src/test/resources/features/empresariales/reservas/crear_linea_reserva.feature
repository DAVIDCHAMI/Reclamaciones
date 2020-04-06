# language: es
Característica: Constitución de una línea de reserva de un siniestro

  Como analista de reclamaciones
  Quiero que sea posible crear una línea de reserva a una exposición
  Para que se pueda cubrir los costos y los gastos que se tienen en un siniestro

@creacionLineaReservaEmpresarial
@claimsEmpresarial
Esquema del escenario: creación de nueva línea de reserva
Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
Cuando se crea una nueva línea de reserva por la Exposición de <Exposición> por <Categoría> con un tipo de costo <Tipo costo> por un valor de <Valor de Pretensión>
Entonces se genera una nueva línea de reserva de <Categoría> con un deducible de <Deducible>
Ejemplos:

| Tipo y Cobertura                                     | Causa          | Tipo de incidente | Exposición                                | Categoría               | Tipo costo                                    | Valor de Pretensión | Deducible |
| Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento | General           | (1) 1ª parteGeneral - TODO EN VERDE CQLII | Gastos de siniestro     | Gasto - A&O (ajuste y otros)                  | 3000000             | 0         |
| Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento | General           | (1) 1ª parteGeneral - TODO EN VERDE CQLII | Gastos proceso jurídico | Gasto - D&CC (defensa y contención de gastos) | 3000000             | 0         |

