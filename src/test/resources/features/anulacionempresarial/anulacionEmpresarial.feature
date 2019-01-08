# language: es
Característica: Anulacion Empresarial

  Como analista de reclamaciones
  Quiero generar una anulación de pago y de recupero
  Para verificar que cambie su estado a anulado

  @claimsEmpresarial
  Esquema del escenario: anulación pago
    Dado que se cree un siniestro de <Tipo Producto>
    Y que se realice un pago, de un siniestro de una póliza empresarial con producto <Tipo Producto> y código de retención <Código Retención>
    Cuando se realice la anulación del pago
    Entonces se debe obtener la anulación del pago, quedando en estado anulado

    Ejemplos:
      | Tipo Producto  | Código Retención |
#      |MRC_01         |0099             |
#      |MRC_02         |0028             |
#      |HOGAR_01       |0023             |
      |MRC_03         |0028             |
#      |HOGAR_02       |0023             |
#      |MRC_04         |0099             |
#      |CUMPLIMIENTO_01|0028             |
#      |HOGAR_03       |0023             |
#      |HOGAR_04       |0099             |

#  @claimsEmpresarial
#  Esquema del escenario: anulacion  recupero
#    Dado que se cree un siniestro de <Tipo Producto>
#    Y que se realice una transacción de pago y una transacción de recupero, de un siniestro de una póliza empresarial con producto <Tipo Producto> y código de retención <Código Retención>
#    Cuando se realice la anulación del recupero
#    Entonces se debe obtener la anulación del recupero, quedando en estado anulado
#
#    Ejemplos:
#      | Tipo Producto   | Código Retención |
#      |MRC_01           |0099             |
#      |MRC_02           |0099             |
#      |HOGAR_01         |0099             |
#      |MRC_03           |0099             |
#      |HOGAR_02         |0099             |
#      |MRC_04           |0099             |
#      |CUMPLIMIENTO_01  |0099             |
#      |HOGAR_03         |0099             |
#      |HOGAR_04         |0099             |



