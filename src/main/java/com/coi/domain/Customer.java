package com.coi.domain;

import java.util.HashMap;
import java.util.Objects;

public class Customer {
    private final int ID;
    private final String firstName;
    private final String lastName;
    private int money;
    private int count;

    public Customer(int ID, String firstName, String lastName, int money) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.count = 0;
        this.money = money;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return ID == customer.ID && money == customer.money && count == customer.count && firstName.equals(customer.firstName) && lastName.equals(customer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, money, count);
    }
}
