package com.fawry;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private double balance;
    private boolean active;

    // Set up for slide 14
    List<Coupon> coupons = new ArrayList<>();

    public Customer(double balance, boolean active) {
        this.balance = balance;
        this.active = active;
    }
    public Customer() {
        this.balance = 0.0;
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Solution for slide 14
    public void setCount(int desired) {
        int actual = coupons.size();
        if (desired < actual) {
            addCoupons(desired - actual);
        } else if (desired > actual) {
            removeCoupons(desired - actual);
        }
    }

    private void removeCoupons(int i) {
        for (int j = 0; j < i && !coupons.isEmpty(); j++) {
            coupons.remove(coupons.size() - 1);
        }
    }

    private void addCoupons(int i) {
        for (int j = 0; j < i; j++) {
            coupons.add(new Coupon());
        }
    }
}
