package ru.javabegin.oop;

public class Restaurant {
    private int food = 0;

    public synchronized void buySomething(){
        System.out.println(Thread.currentThread().getName() + " делает заказ");
        if (food == 0) {
            System.out.println(" Повор начинает готовить заказ.");
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        if(food>0){
            food--;
            System.out.println(Thread.currentThread().getName() + " поел и ушел.");
        }
    }
    public synchronized void receiveGoods(){
        System.out.println(Thread.currentThread().getName()+" несет заказ повору");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        food +=1;
        System.out.println(Thread.currentThread().getName()+ " принес блюдо клиенту ");
        notify();
    }
}
