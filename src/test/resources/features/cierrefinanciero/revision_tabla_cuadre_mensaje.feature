# language: es
Característica: Consulta a tabla de cuadre

  Como analista del cierre financiero
  Quiero consultar las transacciones de pagos, recuperos y reservas que se generen en la tabla de cuadre
  Para verificar que se guarda correctamente la fecha de contabilizacion y el estado de la transaccion.

  Esquema del escenario: Consulta transaccion en tabla de cuadre
    Cuando se genera un movimiento financiero de tipo <movimientoFinanciero>
    Entonces se garantiza que el movimiento cumpla con los filtros de la tabla para que se entregue correctamente a el sistema contables

    Ejemplos:
      | movimientoFinanciero |
      | Reserva              |