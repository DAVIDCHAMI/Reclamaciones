# language: es
Característica: Anulacion Pago

  @claims
  Esquema del escenario: anulacion pago
    Dado Un siniestro de una poliza empresarial con producto <tipoProducto>
    Cuando se realice una transaccion de Anulación de pago
    Entonces se debe obtener un estado de tipo <tipoEstado>

    Ejemplos:
      |tipoProducto  | tipoEstado|
      | MRC(1)        | Anulado   |
      | MRC(2)        | Anulado   |



