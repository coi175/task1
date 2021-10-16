package com.coi;

import com.coi.service.ReadFromFileService;
import com.coi.service.ShopService;

public class Main {

    public static void main(String[] args) {
        ReadFromFileService readFromFileService = new ReadFromFileService();
        ShopService shopService = new ShopService();
        // read files
        readFromFileService.readCustomers(shopService.getCustomers());
        readFromFileService.readProducts(shopService.getProducts());
        readFromFileService.readSales(shopService.getSales());

        shopService.printCustomerInfo(1);
        shopService.printGoodInfo(1);
        shopService.printGoodInfo(3);
        // do something
        System.out.println(shopService.sellProduct(1, 1));
        System.out.println(shopService.sellProduct(3, 1));
        System.out.println(shopService.sellProduct(3, 1));
        System.out.println(shopService.sellProduct(3, 1));
        System.out.println(shopService.sellProduct(3, 1));
        System.out.println(shopService.sellProduct(3, 1));
        System.out.println(shopService.sellProduct(3, 1));
        System.out.println(shopService.sellProduct(1, 1));
        System.out.println(shopService.sellProduct(1, 1));
        System.out.println(shopService.sellProduct(1, 1));

        shopService.printCustomerInfo(1);
        shopService.printGoodInfo(1);
        shopService.printGoodInfo(3);
    }
}
