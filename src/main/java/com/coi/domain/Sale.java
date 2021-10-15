package com.coi.domain;

import java.util.Arrays;
import java.util.Objects;

public class Sale {
    private final int ID;
    private int[][] goodsToSale = new int[2][50];

    public Sale(int ID, int[][] goodsToSale) {
        this.ID = ID;
        this.goodsToSale = goodsToSale;
    }

    public int getID() {
        return ID;
    }

    public int[][] getGoodsToSale() {
        return goodsToSale;
    }

    public void setGoodsToSale(int[][] goodsToSale) {
        this.goodsToSale = goodsToSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return ID == sale.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
