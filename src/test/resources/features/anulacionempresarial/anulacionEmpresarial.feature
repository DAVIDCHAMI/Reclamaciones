# language: es
Característica: Anulacion Empresarial

  @claims
  Esquema del escenario: anulacion pago
    Dado Un siniestro de una poliza empresarial con producto <tipoProducto>
    Y conociendo que se debe realizar una anulacion de <tipoTransaccion>
    Cuando se realice una transaccion de <tipoTransaccion> sobre un <tipoTransaccion> asociado
    Entonces se debe obtener un estado de tipo <tipoEstado>

    Ejemplos:
     |tipoTransaccion       |tipoProducto   | tipoEstado|
     | Pago                 | MRC(1)        | Anulado   |
     |Recupero              | MRC(2)        | Anulado   |



