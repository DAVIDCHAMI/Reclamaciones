# language: es
Característica:Recupero de una reclamacion

  Como analista de reclamacion
  Quiero registrar un recupero a partir de una reserva


  @claimsEmpresarial
  Esquema del escenario: recupero
    Dado que se tiene un siniestro con una reserva por <tipo reserva>
    Cuando se genere un recupero de tipo <tipo recupero> con un código de retención <codigoRetencion>
    Entonces se obtiene un reintegro de dinero al siniestro

    Ejemplos:

      |tipo reserva        |tipo recupero  |codigoRetencion|
    #  |Daños materiales_01 |Salvamento     |0005           |
   #  |Daños materiales_02 |Subrogación    |0099           |
   #  |Daños materiales_03 |Ingreso (otro) |0099           |
      |HOGAR_01              |Salvamento     |0099           |
     # |MRC                 |Subrogación    |0099           |
      #|Maquinaria          |Ingreso (otro) |0099           |

