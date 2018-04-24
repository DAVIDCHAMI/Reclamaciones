# language: es
Característica: Hacer lista de mercado

    Como Ama de casa
    Quiero crear articulos en la lista de TODO
    Para crear una lista de mercado
    
    Esquema del escenario: Crear un nuevo artico para gestionarlo posteriormente
        Dado necesito <necesidad>
        Cuando agrego el articulo <articulo>
        Entonces el articulo <articulo>, debe ser agregado a mi lista de TODO

        Ejemplos:
        |necesidad|articulo|
        |comprar Leche|Comprar Leche|
        |comprar Azucar|Comprar Azucar|
        |comprar Arepas|Comprar Arepas|