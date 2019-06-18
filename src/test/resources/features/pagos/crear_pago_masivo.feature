# language: es
Característica: Realizar un pago masivo a un proveedor

  Como auxiliar de cartera
  Quiero efectuar uno o varios pagos a un mismo proveedor
  Para pagar al proveedor del taller los presupuestos y/o reparaciones realizadas al beneficiario o al tercero involucrado

  @pagoMasivoProveedor
  @claimsEmpresarialSuperUsuario
  Esquema del escenario: Crear pago masivo a un mismo proveedor.
    Dado que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Cobertura>
    Cuando se efectue uno o varios pagos a un mismo proveedor
    #Y se declara la reclamación como perdida total
   # Cuando
    #Entonces

    Ejemplos:
      | Línea de Reserva                |
      | (2) 1ª parteVehículo            |

