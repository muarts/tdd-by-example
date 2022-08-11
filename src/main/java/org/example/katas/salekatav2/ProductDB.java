package org.example.katas.salekatav2;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    private static List<Product> products = new ArrayList<>();

    static {
        Product productOne = new Product("12345", "$", 7.25);
        Product productTwo = new Product("23456", "$", 12.50);
        Product productThree = new Product("44444", "$", 14.50);
        products.add(productOne);
        products.add(productTwo);
        products.add(productThree);
    }

    public Product scan(String barcode) {
        if (barcode.equals("")) {
            throw new RuntimeException("Error: empty barcode");
        }
        Product productUnderSearch = products
                .stream()
                .filter(product -> product.getBarcode().equals(barcode))
                .findAny()
                .orElse(null);
        if (productUnderSearch == null) {
            throw new RuntimeException("Error: barcode not found");
        }
        return productUnderSearch;
    }

    public String total(List<Product> products) {
        Double sum = 0.0;
        for (Product product : products) {
            Product productUnderSearch = scan(product.getBarcode());
            sum += productUnderSearch.getAmount();
        }
        return "$" + sum;
    }
}
