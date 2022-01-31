//Описание задания
//        Необходимо эмулировать работу ресторана. Есть два типа действующих лиц:
//        - официант
//        - посетитель
//
//        Официант принимает заказы и приносит блюда
//        Посетитель делает заказ и ест, когда ему этот заказ приносит.
//
//        Посетители должны уходить сытыми, а официанты не должны заставлять ждать посетителей (то есть официанты не отдыхают).
//
//        Предполагается 2 официанта и 10 посетителей, которые приходят раз в секунду
//
//        Попробуйте найти здесь владельцев критической секции, изменения системы и кто от них зависит. В качестве результата ожидается многопоточное приложение с применением синхронизации.
//
//        * Задание со звездочкой:
//        отдельным ПРом переделайте задачу под использование расширенных стредств синхронизации (ReentrantLock и Condition)
package ru.javabegin.oop;

import ru.javabegin.oop.people.Customer;
import ru.javabegin.oop.people.Waiter1;
import ru.javabegin.oop.people.Waiter2;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static int size;
    public static void main(String[] args) {


        Restaurant restaurant =new Restaurant();
        List<Customer> customer = new ArrayList<>();
        customer.add(new Customer("Клиент 1", restaurant));
        customer.add(new Customer("Клиент 2", restaurant));
        customer.add(new Customer("Клиент 3", restaurant));
        customer.add(new Customer("Клиент 4", restaurant));
        customer.add(new Customer("Клиент 5", restaurant));
        customer.add(new Customer("Клиент 6", restaurant));
        customer.add(new Customer("Клиент 7", restaurant));
        customer.add(new Customer("Клиент 8", restaurant));
        customer.add(new Customer("Клиент 9", restaurant));
        customer.add(new Customer("Клиент 10", restaurant));

        size = customer.size()-1;

        for (Customer customers: customer) {
            customers.start();
        }
        Waiter1 worker = new Waiter1("Официант 1",restaurant);
        worker.start();
        Waiter2 worker2 = new Waiter2("Официант 2",restaurant);
        worker2.start();
    }
}
