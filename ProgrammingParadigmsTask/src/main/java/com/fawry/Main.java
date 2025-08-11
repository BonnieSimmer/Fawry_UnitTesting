package com.fawry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Set up for slide 15
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(100.0, true));
        customers.add(new Customer(50.0, false));
        customers.add(new Customer(200.0, true));
        customers.add(new Customer(0.0, true));
        customers.add(new Customer(150.0, true));
        customers.add(new Customer(75.0, false));
        customers.add(new Customer(300.0, true));

        // Solution for slide 15
        System.out.println("The sum of the balances of all active customers is: " +
                customers.stream()
                        .filter(Customer::isActive)
                        .mapToDouble(Customer::getBalance)
                        .sum()
        );

        // Functions as arguments
        Consumer<String> sendWelcomeMail = mail -> System.out.println("Sending welcome mail to: " + mail);
        register("JohnDoe",sendWelcomeMail);

        // Function as a return type
        Function<Integer, Integer> doubleNumber = multiplyBy(2);
        Function<Integer, Integer> tripleNumber = multiplyBy(3);

        System.out.println(doubleNumber.apply(4));
        System.out.println(tripleNumber.apply(4));
        System.out.println(multiplyBy(5).apply(6));

    }

    public static void register(String name, Consumer<String> callback) {
        // Simulate some registration logic
        callback.accept(name + "@domain.com");
    }

    public static Function<Integer, Integer> multiplyBy(int x) {
        return y -> x * y;
    }
}
