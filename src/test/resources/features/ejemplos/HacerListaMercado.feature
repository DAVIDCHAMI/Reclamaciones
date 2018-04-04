Feature: Hacer lista de mercado

    Como Ama de casa
    Quiero crear articulos en la lista de TODO
    Para crear una lista de mercado
    
    Scenario Outline: Crear un nuevo artico para gestionarlo posteriormente
        Given necesito <necesidad>
        When agrego el articulo <articulo>
        Then el articulo <articulo>, debe ser agregado a mi lista de TODO
        Examples:
        |necesidad|articulo|
        |comprar Leche|Comprar Leche|
        |comprar Azucar|Comprar Azucar|
        |comprar Arepas|Comprar Arepas|