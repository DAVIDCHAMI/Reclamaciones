# language: es
Característica: Generación avisos de siniestros autos

  Yo como facilitador Maca/ abogado en sitio/ funcionario de la línea de solución
  Quiero que se puedan generar avisos de autos
  Para afectar las coberturas de una póliza, cuando un afiliado sufra un siniestro

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

