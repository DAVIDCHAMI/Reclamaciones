#language: es

Característica: Prueba automatizada del proceso de expedición de póliza de autos individual TG

  Escenario: Póliza de autos individual expedida por servicio
    Cuando Se genere una expedición por servicio de una póliza de auto individual con 3 días faltantes para el vencimiento
    Entonces Se debe expedir la póliza correctamente
