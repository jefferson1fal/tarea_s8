package edu.pizza.base;

import edu.pizza.Topping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private String name;
    private double price;
    private final List<Topping> toppings = new ArrayList<>();
    private Size size = null;

    // Constructor principal que toma el nombre, precio, tamaño y los ingredientes como argumentos
    public Pizza(String name, double price, Size size, Topping... toppings) {
        this.name = name;
        this.price = calculatePrice(price, size); // Calcula el precio basado en el tamaño
        this.toppings.addAll(Arrays.asList(toppings)); // Agrega los ingredientes a la lista
        this.size = size;
    }

    // Constructor vacío
    public Pizza() {

    }

    // Constructor que toma el nombre y el precio como argumentos
    public Pizza(String name, double price, Topping[] toppings) {
    }

    // Constructor que toma el nombre de la pizza y un valor
    public Pizza(String pizzaPepperoni, double v) {
    }

    // Agrega un ingrediente a la pizza
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    // Remueve un ingrediente de la pizza por índice
    public void removeTopping(int index) {
        this.toppings.remove(index);
    }

    // Obtiene una lista inmutable de ingredientes
    public List<Topping> getToppings() {
        return Collections.unmodifiableList(new ArrayList<>(toppings));
    }

    // Obtiene el nombre de la pizza
    public String getName() {
        return name;
    }

    // Obtiene el precio de la pizza
    public double getPrice() {
        return price;
    }

    // Obtiene el tamaño de la pizza
    public Size getSize() {
        return size;
    }

    // Método toString para representación de cadena de la pizza
    @Override
    public String toString() {
        return "Pizza{" + "name='" + name + '\'' + ", price=" + price + ", size=" + size + ", toppings=" + toppings + '}';
    }

    // Prepara la pizza, mostrando los ingredientes uno por uno
    public void prepare() {
        System.out.println("Preparing..... " + name);
        System.out.println("Adding toppings:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.nombre());
            // Pone un retraso de 1 segundo (simulando la preparación)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The Pizza is ready!");
    }

    // Método privado para calcular el precio basado en el tamaño
    private double calculatePrice(double basePrice, Size size) {
        return switch (size) {
            case MEDIUM -> basePrice * 1.20;
            case LARGE -> basePrice * 1.35;
            default -> basePrice;
        };
    }

    // Otros métodos sin implementación actual
    public double getPrecio() {
        return 0;
    }

    public String getNombre() {
        return null;
    }

    public double calculateToppingsPrice() {
        return 0;
    }

    public double calcularPrecioToppings() {
        return 0;
    }

    public String getPrecioBase() {
        return null;
    }

    public double calcularPrecioTotal() {
        return 0;
    }

    public double getPrice(Size selectedSize) {
        return 0;
    }

    public double calculatorPrecioTotal() {
        return 0;
    }

    // Enumeración para los tamaños de la pizza
    public enum Size {
        SMALL, MEDIUM, LARGE
    }
}
