package edu.pizza.Interfaces;

public class PizzaBase implements IPreparable {

    private String nombre;

    private double precio;

    public <p> PizzaBase(String n, double p){
        this.nombre = n;
        this.precio = p;
    }

    @Override
    public void prepare(){
        System.out.println("Preparando pizza base");
        System.out.println("la pizza esta lista ");
    }

}
