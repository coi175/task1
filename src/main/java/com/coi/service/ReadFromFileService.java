package com.coi.service;

import com.coi.domain.Customer;
import com.coi.domain.Product;
import com.coi.domain.Sale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

public final class ReadFromFileService {
    private static final String PATH = "src/main/resources/";

    public void readCustomers(HashMap<Integer, Customer> customers) {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + "customers.txt"))) {
            stream.forEach(k -> {
                String [] values = k.split(" ");
                customers.put(Integer.parseInt(values[0]), new Customer(Integer.parseInt(values[0]), values[1], values[2], Integer.parseInt(values[3])));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readProducts(HashMap<Integer, Product> products) {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + "goods.txt"))) {
            stream.forEach(k -> {
                String [] values = k.split(" ");
                products.put(Integer.parseInt(values[0]), new Product(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3])));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readSales(HashMap<Integer, Sale> sales) {
        try (Stream<String> stream = Files.lines(Paths.get(PATH + "sales.txt"))) {
            stream.forEach(k -> {
                String [] values = k.split(" ");
                int[][] dm = new int[2][50];
                int j = 0;
                for(int i = 1; i < values.length; i += 2) {
                    dm[0][j] = Integer.parseInt(values[i]);
                    dm[1][j] = Integer.parseInt(values[i + 1]);
                    j++;
                }
                sales.put(Integer.parseInt(values[0]), new Sale(Integer.parseInt(values[0]), dm));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
