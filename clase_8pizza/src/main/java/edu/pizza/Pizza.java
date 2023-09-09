package edu.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    // Enumeración para los tamaños de la pizza
    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final String nombre;
    private final double precioBase;
    private final Size size;
    private final List<Topping> toppings = new ArrayList<>();

    // Precios base para cada tamaño de pizza
    private static final double SMALL_BASE_PRICE = 8.0;
    private static final double MEDIUM_BASE_PRICE = 10.0;
    private static final double LARGE_BASE_PRICE = 12.0;

    // Constructor de la clase Pizza que toma el nombre, precio base y tamaño como argumentos
    public Pizza(String nombre, double precioBase, Size size) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.size = size;
    }

    // Obtener el nombre de la pizza
    public String getNombre() {
        return nombre;
    }

    // Obtener el precio base de la pizza
    public double getPrecioBase() {
        return precioBase;
    }

    // Obtener el tamaño de la pizza
    public Size getSize() {
        return size;
    }

    // Agregar un topping a la lista de toppings
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Método para obtener el precio base de la pizza según el tamaño
    public double getPrice(Size size) {
        switch (size) {
            case SMALL:
                return SMALL_BASE_PRICE;
            case MEDIUM:
                return MEDIUM_BASE_PRICE;
            case LARGE:
                return LARGE_BASE_PRICE;
            default:
                return 0.0; // Manejar el caso por defecto
        }
    }

    // Método para calcular el precio total de la pizza
    public double calculatorPrecioTotal() {
        // Calcular el precio total sumando el precio base y el precio de los toppings
        double precioTotal = getPrice(size);
        precioTotal += calcularPrecioToppings();

        return precioTotal;
    }

    // Método privado para calcular el precio total de los toppings (sin implementación actual)
    private double calcularPrecioToppings() {
        return 0; // Se debe implementar la lógica real para calcular el precio de los toppings
    }

    // Método para preparar la pizza (sin implementación actual)
    public void prepare() {
        // Lógica para preparar la pizza (debe implementarse)
        System.out.println("Preparando la pizza " + nombre);
    }
}
