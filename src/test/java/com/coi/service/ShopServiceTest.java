package com.coi.service;

import com.coi.domain.Customer;
import com.coi.domain.Product;
import com.coi.service.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {
    ShopService shopService = new ShopService();
    @BeforeEach
    void setUp() {
        shopService.getCustomers().put(0, new Customer(0, "Алексей", "Васькин", 200));
        shopService.getProducts().put(0, new Product(0, "Молоко", 50 ,3));
        shopService.getProducts().put(1, new Product(1, "Виски", 500 ,2));
    }

    @Test
    void sellProduct() {
        assertEquals("Error!", shopService.sellProduct(5, 0));
        assertEquals("Error!", shopService.sellProduct(0, 5));

        assertEquals("OK", shopService.sellProduct(0, 0));
        assertEquals("OK", shopService.sellProduct(0, 0));
        assertEquals("OK", shopService.sellProduct(0, 0));

        assertEquals("Product is over", shopService.sellProduct(0, 0));
        assertEquals("Customer have not enough money", shopService.sellProduct(1, 0));
    }
}