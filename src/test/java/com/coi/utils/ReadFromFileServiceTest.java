package com.coi.utils;

import com.coi.domain.Customer;
import com.coi.domain.Product;
import com.coi.domain.Sale;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ReadFromFileServiceTest {
    HashMap<Integer, Customer> customers = new HashMap<>();
    HashMap<Integer, Product> products = new HashMap<>();
    HashMap<Integer, Sale> sales = new HashMap<>();
    @Test
    void readCustomers() {
        ReadFromFileService.readCustomers(customers);
        assertAll(() -> assertEquals(new Customer(0, "Сергей", "Сергеев", 800), customers.get(0)),
                () -> assertEquals(new Customer(1, "Алексей", "Алексеев", 800), customers.get(1)),
                () -> assertEquals(new Customer(2, "Максим", "Максимов", 200), customers.get(2)));
    }

    @Test
    void readProducts() {
        ReadFromFileService.readProducts(products);
        assertAll(() -> assertEquals(new Product(0, "Молоко", 60, 10), products.get(0)),
                () -> assertEquals(new Product(1, "Огурцы", 80, 20), products.get(1)),
                () -> assertEquals(new Product(2, "Хлеб", 20, 30), products.get(2)),
                () -> assertEquals(new Product(3, "Конфеты", 120, 5), products.get(3)),
                () -> assertEquals(new Product(4, "Морковь", 50, 2), products.get(4)),
                () -> assertEquals(new Product(5, "Coca-Cola", 35, 10), products.get(5)));
    }

    @Test
    void readSales() {
        ReadFromFileService.readSales(sales);
        int[][] x = new int[2][50];
        x[0][0] = 0;
        x[0][1] = 4;
        x[0][2] = 5;
        x[1][0] = 45;
        x[1][1] = 30;
        x[1][2] = 25;
        assertEquals(new Sale(0, x), sales.get(0));
    }
}