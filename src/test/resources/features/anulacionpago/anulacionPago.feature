# language: es
Característica: Anulacion Pago

  @claims
  Esquema del escenario: anulacion pago
    Dado Un siniestro de una poliza empresarial con producto <TipoProducto>
    Cuando se realice una transaccion de Anulación de pago
    Entonces se debe obtener un estado de tipo <TipoEstado>

    Ejemplos:
      |TipoProducto | TipoEstado|
      | MRC         | Anulado   |


