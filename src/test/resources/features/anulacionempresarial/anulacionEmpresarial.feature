# language: es
Característica: Anulacion Empresarial

  @claims
  Esquema del escenario: anulacion pago
    Dado que se debe realizar una anulacion de <tipoTransaccion>, de un siniestro de una poliza empresarial con producto <tipoProducto>
    Cuando se realice una transaccion de <tipoTransaccion> sobre un <tipoTransaccion> asociado
    Entonces se debe obtener un estado de tipo <tipoEstado>

    Ejemplos:
     |tipoTransaccion   |tipoProducto  | tipoEstado|
     |Pago              |MRC(1)        |Anulado|
     |Pago              |MRC(2)       |Anulado       |
     | Recupero         | MRC(3)       | Anulado    |
     | Recupero         | MRC(4)       | Anulado    |



