package edu.pizza;

import edu.pizza.base.Pizza;
import edu.pizza.especialidades.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static edu.pizza.Topping.values;

public class Main {
    // Función para imprimir "Preparando la pizza"
    public static void imprimirPreparandoPizza() {
        System.out.println("\n\nPreparando la pizza...");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Permitir al usuario elegir el tamaño de la pizza
        System.out.println("Tamaños disponibles de pizza:");
        Pizza.Size[] sizeValues = Pizza.Size.values();
        for (int i = 0; i < sizeValues.length; i++) {
            Pizza.Size size = sizeValues[i];
            System.out.println((i + 1) + ". " + size);
        }

        System.out.print("Selecciona el tamaño de la pizza (1-" + sizeValues.length + "): ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        if (sizeChoice < 1 || sizeChoice > sizeValues.length) {
            System.out.println("Opción no válida. Saliendo del programa.");
            return;
        }

        Pizza.Size selectedSize = sizeValues[sizeChoice - 1];

        // Crear un ArrayList para almacenar las pizzas disponibles en el menú
        List<Pizza> menu = new ArrayList<>();
        menu.add(new MargheritaPizza("Pizza Margherita", selectedSize));
        menu.add(new PepperoniPizza("Pizza Pepperoni", selectedSize));
        menu.add(new BBQChickenPizza("Pizza de pollo a la barbacoa", selectedSize));
        menu.add(new PizzaItaliana("Pizza Italiana", selectedSize));
        menu.add(new VegetarianPizza("Pizza vegetariana", selectedSize));

        // Mostrar el menú y permitir al usuario elegir una pizza
        System.out.println("Menú de pizzas:");
        for (int i = 0; i < menu.size(); i++) {
            Pizza pizza = menu.get(i);
            System.out.println((i + 1) + ". " + pizza.getName() + " - Precio: $" + pizza.getPrice());
        }

        System.out.print("Selecciona una pizza (1-" + menu.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        // Verificar si la opción seleccionada es válida
        if (choice < 1 || choice > menu.size()) {
            System.out.println("Opción no válida. Saliendo del programa.");
            return;
        }

        // Obtener la pizza seleccionada
        Pizza pizzaSeleccionada = menu.get(choice - 1);

        // Crear una lista para almacenar los toppings seleccionados
        List<Topping> toppingsSeleccionados = new ArrayList<>();

        // Mostrar los toppings disponibles
        System.out.println("\nToppings disponibles:");
        Topping[] toppingValues = values();
        for (int i = 0; i < toppingValues.length; i++) {
            Topping topping = toppingValues[i];
            System.out.println((i + 1) + ". " + topping.nombre() + " - $" + topping.precio());
        }

        // Permitir al usuario elegir los toppings
        while (true) {
            System.out.print("Selecciona un topping para agregar (1-" + toppingValues.length + ") o 0 para finalizar: ");
            int toppingChoice = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            if (toppingChoice == 0) {
                break;  // Salir del bucle si se elige 0
            }

            if (toppingChoice < 1 || toppingChoice > toppingValues.length) {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                continue;  // Volver a solicitar si la opción no es válida
            }

            Topping selectedTopping = toppingValues[toppingChoice - 1];
            toppingsSeleccionados.add(selectedTopping);
        }

        // Agregar los toppings seleccionados a la pizza
        for (Topping topping : toppingsSeleccionados) {
            pizzaSeleccionada.addTopping(topping);
        }

        // Calcular el precio total de la pizza con los toppings
        double precioTotal = pizzaSeleccionada.getPrice();  // Precio base de la pizza

        for (Topping topping : toppingsSeleccionados) {
            precioTotal += topping.precio();  // Sumar el precio de cada topping seleccionado
        }

        // Llamar a la función imprimirPreparandoPizza antes de mostrar el resumen de la orden
        imprimirPreparandoPizza();

        // Mostrar el resumen de la orden
        System.out.println("\nResumen de la orden:");
        System.out.println("Pizza seleccionada: " + pizzaSeleccionada.getName());
        System.out.println("Tamaño de la pizza: " + selectedSize);
        System.out.println("Precio de la pizza: $" + pizzaSeleccionada.getPrice());
        System.out.println("Toppings seleccionados:");
        for (Topping topping : toppingsSeleccionados) {
            System.out.println("- " + topping.nombre() + " - $" + topping.precio());
        }
        System.out.println("Precio total: $" + precioTotal);
    }
}
