package com.coi.domain;

import java.util.Objects;

public class Product {
    private final int ID;
    private String name;
    private int price;
    private int count;

    public Product(int ID, String name, int price, int count) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        Product product = (Product) o;
        return ID == product.ID && price == product.price && count == product.count && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, price, count);
    }
}
