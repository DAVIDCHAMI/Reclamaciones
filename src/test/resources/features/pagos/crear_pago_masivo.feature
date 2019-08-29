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
    Cuando se registra la información de las facturas del pago masivo de los siniestros con cobertura <Tipo de cobertura> a un proveedor
    Y se ingresa el tipo de proveedor <Tipo de contacto> y el nombre del proveedor <Proveedor> con el tipo de moneda <Tipo de moneda> de la factura y el método de pago <Método de pago> del cheque
    Entonces se genera un número de pago individual por cada uno de los pagos registrados en el archivo de pagos masivos con un estado de pago solicitado

    Ejemplos:
      | Tipo de contacto | Proveedor  | Tipo de moneda | Método de pago |Tipo de cobertura|
      | Empresa          | ANDAR S.A. | COP            | Pago por banco |Pérdida parcial daños|
