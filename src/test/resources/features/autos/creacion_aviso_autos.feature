# language: es
Característica: Generación avisos de siniestros autos

  Yo como facilitador Maca/ abogado en sitio/ funcionario de la línea de solución
  Quiero que se puedan generar avisos de autos
  Para afectar las coberturas de una póliza, cuando un afiliado sufra un siniestro

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Responsabilidad Civil
    Dado que se tiene una poliza con las coberturas
    Cuando se genere un siniestro por la causa y la culpabilidad
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Archivo
    Dado que se tiene una poliza con las coberturas para Daños
    Cuando se genere un siniestro por la causa y la culpabilidad
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Subrogación
    Dado que se tiene una poliza con las coberturas para Subrogación
    Cuando se genere un siniestro por la causa y la culpabilidad
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Archivo

  @claimsAuto
  @pruebaRegresion
  Escenario: generacion de reclamacion de tipo Solo Responsabilidad Civil
    Dado que se tiene una poliza con las coberturas para Solo Responsabilidad Civil
    Cuando se genere un siniestro por la causa y la culpabilidad
    Entonces se obtendran exposiciones automaticas de exposicion, y cada una con su respectiva reserva, según la culpabilidad marcada Solo Responsabilidad Civil

