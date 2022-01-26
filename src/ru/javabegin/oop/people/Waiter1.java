package ru.javabegin.oop.people;

import ru.javabegin.oop.Restaurant;


public class Waiter1 extends Thread{
    private Restaurant restaurant;

    public Waiter1(String name, Restaurant restaurant) {
        super(name);
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            restaurant.receiveGoods();
        }
        restaurant.receiveGoods();

    }
}
