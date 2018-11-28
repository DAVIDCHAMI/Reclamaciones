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
      |Daños    |
      |vehículo de reemplazo|
      |Responsabilidad Civil|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |causa                   |culpabilidad|
      |Colisión con vehículo   |Responsabilidad civil    |
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil
      |culpabilidad|
      |Responsabilidad civil|

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Archivo
    Dado que se tiene una poliza con las coberturas para Daños
      |coberturas|
      |Daños   |
      |vehículo de reemplazo|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |causa                            |culpabilidad|
      |Amit, Disturbios o desorden civil|Archivo   |
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo
      |culpabilidad|
      |Archivo|

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Subrogación
    Dado que se tiene una poliza con las coberturas para Subrogación
      |coberturas|
      |Daños    |
    Cuando se genere un siniestro por la causa y la culpabilidad
      |causa                |culpabilidad|
      |Colisión con bicicleta|Archivo   |
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo
      |culpabilidad|
      |Subrogación|

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Solo Responsabilidad Civil
    Dado que se tiene una poliza con las coberturas para Solo Responsabilidad Civil
      |coberturas|
      |Responsabilidad civil|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |causa                |culpabilidad|
      |Colisión con vehículo|Archivo   |
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Solo Responsabilidad Civil
      |culpabilidad|
      |Solo RC|
