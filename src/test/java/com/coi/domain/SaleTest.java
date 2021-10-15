package com.coi.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    Sale sale;

    @BeforeEach
    void setUp() {
        sale = new Sale(0, new int[][] {{0, 1, 2}, {15, 14, 54}});
    }
    @Test
    void getID() {
        assertEquals(0, sale.getID());
    }

    @Test
    void getGoodsToSale() {
        assertArrayEquals(new int[][] {{0, 1, 2}, {15, 14, 54}}, sale.getGoodsToSale());
    }
}