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
      |Hurto     |
      |Gastos de transporte |
      |vehículo de reemplazo|
      |Responsabilidad Civil|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |causa                   |culpabilidad|
      |Colisión con vehículo   |Responsabilidad civil    |
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva reserva, según la culpabilidad marcada RC
      |culpabilidad|
      |Responsabilidad civil|

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Archivo
    Dado que se tiene una poliza con las coberturas para Daños
      |coberturas|
      |Hurto     |
      |Gastos de transporte |
      |vehículo de reemplazo|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |causa                            |culpabilidad|
      |Amit, Disturbios o desorden civil|Archivo   |
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva reserva, según la culpabilidad marcada Archivo
      |culpabilidad|
      |Archivo|

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Subrogación
    Dado que se tiene una poliza con las coberturas para Subrogación
      |coberturas|
      |Hurto     |
      |Gastos de transporte |
      |vehículo de reemplazo|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |causa                |culpabilidad|
      |Colisión con bicicleta|Archivo   |
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva reserva, según la culpabilidad marcada Archivo
      |culpabilidad|
      |Subrogación|


  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo SoloRC
    Dado que se tiene una poliza con las coberturas para SoloRC
      |coberturas|
      |Hurto     |
      |Gastos de transporte |
      |vehículo de reemplazo|
    Cuando se genere un siniestro por la causa y la culpabilidad
      |causa                |culpabilidad|
      |Colisión con vehículo|Archivo   |
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva reserva, según la culpabilidad marcada SoloRC
      |culpabilidad|
      |Solo RC|
