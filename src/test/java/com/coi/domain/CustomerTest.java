package com.coi.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(0, "Имя", "Фамилия", 1300);
    }

    @Test
    void getID() {
        assertEquals(0, customer.getID());
    }

    @Test
    void getMoney() {
        assertEquals(1300, customer.getMoney());
    }

    @Test
    void getFirstName() {
        assertEquals("Имя", customer.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Фамилия", customer.getLastName());
    }
}