# language: es
Característica: Limite de aprobación

  Como analista de reclamaciones
  Quiero que al crear o modificar una reserva por un valor mayor o
  igual a 500.000.000 de pesos,se genere una actividad de aprobación
  Para para que el monto solicitado sea aprobado por el director del proceso

  @claimsEmpresarialSuperUsuario
  Esquema del escenario: aprobar reserva que supera limite de autoridad
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se ajuste la reserva con un valor de <Monto del ajuste>
    Y se obtiene una reversión de constitución y el deducible es generado por un valor <Deducible>
    Y el estado de la transacción de reserva queda pendiente por aprobación

    Ejemplos:
      | Línea de Reserva      | Tipo de pago | Beneficiario del pago           | Método del pago | ¿Es pago soloSura? | Código de Retención | Tipo y Cobertura                             | Causa    | Valor de Pretensión | Tipo de incidente | Monto del ajuste | Deducible  |
      | (1) 1ª partePropiedad | Parcial      | MARTHA ENID ROJAS MARIACA CQLII | Pago por banco  | No                 | 0099                | Multiriesgo corporativo con cobertura básica | Incendio | 5000000             | Propiedad         | 800000000        | -120000000 |
