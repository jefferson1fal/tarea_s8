package edu.pizza.especialidades;

import edu.pizza.base.Pizza;

public class PizzaItaliana extends Pizza {
    public PizzaItaliana(String pizzaItaliana, Size size) {
        super("Pizza Italiana", calculatePrice(size), size);
    }

    private static double calculatePrice(Size size) {
        switch (size) {
            case SMALL:
                return 8.0;
            case MEDIUM:
                return 10.0;
            case LARGE:
                return 12.0;
            default:
                return 10.0;
        }
    }
}
