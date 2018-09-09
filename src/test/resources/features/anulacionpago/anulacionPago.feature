# language: es
Característica: Anulacion Pago


  @claims
  Esquema del escenario: anulacion pago
    Dado Un siniestro  de una poliza empresarial con producto <TipoProducto>
    Cuando se realice una transaccion de Anulación
    Entonces se debe obtener una transaccion con tipo de estado <TipoEstado>

    Ejemplos:
      |TipoProducto | TipoEstado|
      | MRC         | Solicitado|


