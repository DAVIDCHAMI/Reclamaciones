# language: es
Característica: Consulta a modelo simplificado

  Como analista de reclamacion
  Quiero consultar en el modelo simplificado las transacciones de pagos, recuperos y reservas
  Para verificar que se guarda correctamente los valores de las transacciones y los valores cedidos a las reaseguradoras

  @claims
  Esquema del escenario: Consulta base de datos modelo simplificado
    Dado que se realiza un <tipoTransaccion>
    Cuando la transaccion se ha efectuado
    Entonces en las fuentes del tablero deben quedar correctos los valores de reaseguro

    Ejemplos:
      | tipoTransaccion   |
      | AnulacionPago     |
      | Pago              |
      | Recupero          |
      | Reserva           |
      | AnulacionRecupero |