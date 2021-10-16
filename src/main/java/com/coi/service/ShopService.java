package com.coi.service;

import com.coi.domain.Customer;
import com.coi.domain.Product;
import com.coi.domain.Sale;
import com.coi.service.ReadFromFileService;

import java.util.HashMap;
import java.util.Map;

public class ShopService {
    private HashMap<Integer, Customer> customers = new HashMap<>();
    private HashMap<Integer, Product> products = new HashMap<>();
    private HashMap<Integer, Sale> sales = new HashMap<>();

    public String sellProduct(int productId, int customerId) {
        // if product or customer doesn't exist
        if(!products.containsKey(productId) || !customers.containsKey(customerId)) {
            return "Error!";
        }

        Product product = products.get(productId);
        Customer customer = customers.get(customerId);
        if(product.getCount() <= 0) {
            return "Product is over";
        }

        if(product.getPrice() > customer.getMoney()) {
            return "Customer have not enough money";
        }

        // check if product in sale and if yes change price for it
        int price = product.getPrice();
        for(Map.Entry<Integer, Sale> s : sales.entrySet()) {
            for(int i = 0; i < s.getValue().getGoodsToSale().length; i++) {
                if(s.getValue().getGoodsToSale()[0][i] == productId) {
                    price = s.getValue().getGoodsToSale()[1][0];
                }
            }
        }

        // check if customer have a discount and if yes apply it
        if(customer.getCount() > 5) {
            price = (int) (price * 0.9);
        }

        // make a sell
        customer.setMoney(customer.getMoney() - price);
        product.setCount(product.getCount() - 1);
        customer.setCount(customer.getCount() + 1);

        return "OK";
    }

    public void printCustomersInfo() {
        System.out.println("CUSTOMERS");
        customers.entrySet().stream().forEach(c -> {
            System.out.println("____________________________________");
            System.out.println("ID: " + c.getValue().getID() + "\n FIO: " + c.getValue().getFirstName() + " " + c.getValue().getLastName() +
                    "\n Money: " + c.getValue().getMoney() + "\n goodsCount:" + c.getValue().getCount());
            System.out.println("____________________________________");
        });
    }

    public void printCustomerInfo(int customerId) {
        if(customers.containsKey(customerId)) {
            System.out.println("CUSTOMER " + customerId);
            Customer c = customers.get(customerId);
            System.out.println("____________________________________");
            System.out.println("ID: " + c.getID() + "\n FIO: " + c.getFirstName() + " " + c.getLastName() +
                    "\n Money: " + c.getMoney() + "\n goodsCount:" + c.getCount());
            System.out.println("____________________________________");
        }
    }

    public void printGoodsInfo() {
        System.out.println("GOODS:");
        products.entrySet().stream().forEach(c -> {
            System.out.println("____________________________________");
            System.out.println("ID: " + c.getValue().getID() + "\n Name: " + c.getValue().getName() +
                    "\n Price: " + c.getValue().getPrice() + "\n Count:" + c.getValue().getCount());
            System.out.println("____________________________________");
        });
    }

    public void printGoodInfo(int productId) {
        if(products.containsKey(productId)) {
            System.out.println("Product " + productId);
            Product p = products.get(productId);
            System.out.println("____________________________________");
            System.out.println("ID: " + p.getID() + "\n Name: " + p.getName() +
                    "\n Price: " + p.getPrice() + "\n Count:" + p.getCount());
            System.out.println("____________________________________");
        }
    }

    public HashMap<Integer, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(HashMap<Integer, Customer> customers) {
        this.customers = customers;
    }

    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Product> products) {
        this.products = products;
    }

    public HashMap<Integer, Sale> getSales() {
        return sales;
    }

    public void setSales(HashMap<Integer, Sale> sales) {
        this.sales = sales;
    }
}
