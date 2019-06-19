# language: es
Característica: Limite de aprobación

  Como analista de reclamaciones
  Quiero que al crear o modificar una reserva por un valor mayor o
  igual a 500.000.000 de pesos,se genere una actividad de aprobación
  Para para que el monto solicitado sea aprobado por el director del proceso

  @aprobarReserva
  @claimsEmpresarial
  Esquema del escenario: Crear reserva con valor que supera el limite de autoridad
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Y se ajuste la reserva con un valor de <Monto del ajuste>
    Y el estado de la transacción de reserva queda en Aprobación pendiente
    Y se genera la actividad, Revisar y aprobar cambio de reserva al Director o Gerente de atención de reclamaciones Empresariales
    Cuando es aprobada la actividad, Revisar y aprobar cambio de reserva
    Entonces el estado de la transacción de reserva que estaba en aprobación pendiente, debe pasar a estado solicitado

    Ejemplos:
      | Tipo y Cobertura                             | Causa    | Valor de Pretensión | Tipo de incidente | Monto del ajuste | Deducible  |
      | Multiriesgo corporativo con cobertura básica | Incendio | 5000000             | Propiedad         | 800000000        | -120000000 |
    