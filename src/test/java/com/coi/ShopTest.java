package com.coi;

import com.coi.domain.Customer;
import com.coi.domain.Product;
import com.coi.domain.Sale;
import com.coi.utils.ReadFromFileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    @BeforeEach
    void setUp() {
        Shop.customers.put(0, new Customer(0, "Алексей", "Васькин", 200));
        Shop.products.put(0, new Product(0, "Молоко", 50 ,3));
        Shop.products.put(1, new Product(1, "Виски", 500 ,2));
    }

    @Test
    void sellProduct() {
        assertEquals("Error!", Shop.sellProduct(5, 0));
        assertEquals("Error!", Shop.sellProduct(0, 5));

        assertEquals("OK", Shop.sellProduct(0, 0));
        assertEquals("OK", Shop.sellProduct(0, 0));
        assertEquals("OK", Shop.sellProduct(0, 0));

        assertEquals("Product is over", Shop.sellProduct(0, 0));
        assertEquals("Customer have not enough money", Shop.sellProduct(1, 0));
    }
}