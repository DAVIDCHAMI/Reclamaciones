# language: es
Característica: Generación avisos de siniestros autos

  Yo como facilitador Maca/ abogado en sitio/ funcionario de la línea de solución
  Quiero que se puedan generar avisos de autos
  Para afectar las coberturas de una póliza, cuando un afiliado sufra un siniestro

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Responsabilidad Civil
    Dado que se tiene una poliza con las coberturas
    |coberturas|
    |Daños     |
    |Vehículo de reemplazo|
    |responsabilidad_Civil                     |
    Cuando se genere un siniestro por la causa y la culpabilidad Responsabilidad Civil
    |Causa|Culpabilidad|
    |Colisión con vehículo|responsabilidad_Civil|
    Entonces se obtendran exposiciones automaticas y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil
    |Exposiciones|Reservas|
    |Daños       |300000  |
    |Responsabilidad civil - daños a la persona|3600000|
    |Responsabilidad civil - daños al vehículo |3400000|
    |Vehiculo de reemplazo                     |       |

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Archivo
    Dado que se tiene una poliza con las coberturas para Daños
      |coberturas|
      |Daños     |
      |Responsabilidad Civil|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |Causa|Culpabilidad|
      |Amit, Disturbios o desorden civil|archivo|
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo
      |Daños       |300000  |

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Subrogación
    Dado que se tiene una poliza con las coberturas para Subrogación
      |coberturas|
      |Daños     |
      |Responsabilidad Civil|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |Causa|Culpabilidad|
      |Colisión con vehículo|subrogación|
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo
      |Exposiciones|Reservas|
      |Daños       |300000  |

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Solo Responsabilidad Civil
    Dado que se tiene una poliza con las coberturas para Solo Responsabilidad Civil
      |coberturas|
      |Daños     |
      |Responsabilidad Civil|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |Causa|Culpabilidad|
      |Colisión con vehículo|solo_RC|
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Solo Responsabilidad Civil
      |Exposiciones|Reservas|
      |Responsabilidad civil - daños a la persona|3600000|
      |Responsabilidad civil - daños al vehículo |3400000|
