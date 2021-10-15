package com.coi.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1, "Сливки", 79, 5);
    }

    @Test
    void getID() {
        assertEquals(1, product.getID());
    }

    @Test
    void getName() {
        assertEquals("Сливки", product.getName());
    }

    @Test
    void getPrice() {
        assertEquals(79, product.getPrice());
    }

    @Test
    void getCount() {
        assertEquals(5, product.getCount());
    }
}