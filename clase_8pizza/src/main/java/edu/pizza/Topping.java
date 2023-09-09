package edu.pizza;

// Enumeración que representa los ingredientes (Toppings) disponibles para las pizzas
public enum Topping {
    // Enumerados con nombres y precios
    PEPPERONI("Pepperoni", 1.0),
    QUESO_EXTRA("Queso Extra", 1.5),
    CHAMPIÑONES("Champiñones", 0.75);

    // Variables de instancia para el nombre y el precio del ingrediente
    private final String nombre;
    private final double precio;

    // Constructor de cada enumerado con nombre y precio
    Topping(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Método para obtener el nombre del ingrediente
    public String nombre() {
        return nombre;
    }

    // Método para obtener el precio del ingrediente
    public double precio() {
        return precio;
    }
}
