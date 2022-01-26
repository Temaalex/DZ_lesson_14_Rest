package ru.javabegin.oop.people;

import ru.javabegin.oop.Restaurant;

public class Customer extends Thread{
    private Restaurant restaurant;

    public Customer(String name, Restaurant restaurant) {
        super(name);
        this.restaurant = restaurant;
    }


    @Override
    public void run() {
        restaurant.buySomething();
    }
}
