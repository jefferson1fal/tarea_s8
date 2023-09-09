package edu.pizza.especialidades;

import edu.pizza.base.Pizza;

// La clase VegetarianPizza extiende la clase Pizza
public class VegetarianPizza extends Pizza {
    // Constructor de VegetarianPizza que toma un nombre y un tamaño como argumentos
    public VegetarianPizza(String pizzaVegetariana, Size size) {
        // Llama al constructor de la clase base (Pizza) con un nombre, precio calculado y tamaño
        super("Pizza vegetariana", calculatePrice(size), size);
    }

    // Método privado que calcula el precio basado en el tamaño de la pizza
    private static double calculatePrice(Size size) {
        switch (size) {
            case SMALL:
                return 8.0;
            case MEDIUM:
                return 10.0;
            case LARGE:
                return 12.0;
            default:
                return 10.0; // Valor predeterminado si el tamaño no es válido
        }
    }
}
