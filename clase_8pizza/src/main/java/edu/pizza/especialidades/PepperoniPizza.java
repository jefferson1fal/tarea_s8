package edu.pizza.especialidades;

import edu.pizza.base.Pizza;

public class PepperoniPizza extends Pizza {
    public PepperoniPizza(String pizzaPepperoni, Size size) {
        super("Pizza Pepperoni", calculatePrice(size), size);
    }

    // Método para calcular el precio basado en el tamaño
    private static double calculatePrice(Size size) {
        switch (size) {
            case SMALL:
                return 8.0;  // Precio para pizza pequeña
            case MEDIUM:
                return 10.0; // Precio para pizza mediana
            case LARGE:
                return 12.0; // Precio para pizza grande
            default:
                return 10.0; // Precio predeterminado para pizza mediana si el tamaño no está definido
        }
    }
}
