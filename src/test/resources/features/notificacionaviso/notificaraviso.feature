# language: es
Característica: Notificacion de aviso de una reclamacion

  Como analista de reclamacion
  Quiero registrar los datos de un afectado en un siniestro
  Para recibir la notificacion de aviso

  @claims
 Esquema del escenario: aviso
    Dado que se tiene una poliza de <tipoCobertura>
    Cuando se genere un siniestro por causal <causa> con un valor de pretension de <valorPretension>
    Y un incidente de tipo <tipoIncidente>
    Entonces se obtiene una reclamacion que <generaExpo> genera exposicion
    Y que <generaReserva> genera reserva con un monto <monto>, envia correo y se asigna a un analista

    Ejemplos:
      | tipoCobertura                                | causa                         | valorPretension | tipoIncidente | generaExpo | generaReserva | monto   |
      | Multiriesgo corporativo con cobertura basica | Rotura de Vidrios             | 2000000         | Contenido     | si         | si            | 1000000 |
      | Hogar con cobertura basica                   | Rotura de vidrios             | 2000000         | ""            | no         | no            | 1000000 |
      | Multiriesgo corporativo con cobertura basica | Amit/ Huelga, Conmoción Civil | 2000000         | Propiedad     | no         | no            | 1000000 |


