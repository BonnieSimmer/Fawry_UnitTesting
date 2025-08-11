package com.fawry;

import java.util.ArrayList;
import java.util.List;

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




    }
}
