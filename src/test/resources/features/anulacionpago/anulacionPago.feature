# language: es
Característica: Anulacion Pago

  @claims
  Esquema del escenario: anulacion pago
    Dado Un siniestro de una poliza empresarial con producto <TipoProducto>
    Cuando se realice una transaccion de Anulación de pago
    Entonces se debe obtener un estado de tipo <TipoEstado>

    Ejemplos:
      |TipoProducto  | TipoEstado|
      | MRC 1        | Anulado   |
      | MRC 2        | Anulado   |
      | MRC 3        | Anulado   |
      | MRC 4        | Anulado   |
      | MRC 5        | Anulado   |


