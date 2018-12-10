# language: es
Característica: Anulacion Empresarial

  Como analista de reclamaciones
  Quiero generar una anulacion de pago y de recupero
  Para verificar que cambie su estado a anulado

  @claimsEmpresarial
  Esquema del escenario: anulacion pago
    Dado que se cree un siniestro de <tipoProducto>
    Y que se realice un pago, de un siniestro de una poliza empresarial con producto <tipoProducto> y código de retención <codigoRetencion>
    Cuando se realice la anulacion del pago
    Entonces se debe obtener la anulacion del pago, quedando en estado anulado

    Ejemplos:
      | tipoProducto  | codigoRetencion |
      |MRC_01         |0099             |
      |MRC_02         |0028             |
      |HOGAR_01       |0023             |
      |RC_01          |0099             |
      |MRC_03         |0028             |
      |HOGAR_02       |0023             |
      |MRC_04         |0099             |
      |CUMPLIMIENTO_01|0028             |
      |HOGAR_03       |0023             |
      |HOGAR_04       |0099             |

  @claimsEmpresarial
  Esquema del escenario: anulacion  recupero
    Dado que se cree un siniestro de <tipoProducto>
    Y que se realice una transaccion de pago y una transaccion de recupero, de un siniestro de una poliza empresarial con producto <tipoProducto> y código de retención <codigoRetencion>
    Cuando se realice la anulacion del recupero
    Entonces se debe obtener la anulacion del recupero, quedando en estado anulado

    Ejemplos:
      | tipoProducto  | codigoRetencion |
      |MRC_01         |0099             |
      |MRC_02         |0099             |
      |HOGAR_01       |0099             |
      |RC_01          |0099             |
      |MRC_03         |0099             |
      |HOGAR_02       |0099             |
      |MRC_04         |0099             |
      |CUMPLIMIENTO_01|0099             |
      |HOGAR_03       |0099             |
      |HOGAR_04       |0099             |



