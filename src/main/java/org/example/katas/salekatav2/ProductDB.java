package org.example.katas.salekatav2;

import org.example.katas.salekatav2.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    private static List<Product> products = new ArrayList<>();

    static {
        Product productOne = new Product("12345", "$", 7.25);
        Product productTwo = new Product("23456", "$", 12.50);
        products.add(productOne);
        products.add(productTwo);
    }

    public Product scan(String barcode) {
        throwExceptionIfBarcodeIsEmpty(barcode);
        Product productUnderSearch = products
                .stream()
                .filter(product -> product.getBarcode().equals(barcode))
                .findAny()
                .orElse(null);
        throwExceptionIfProductUnderSearchIsNull(productUnderSearch);
        return productUnderSearch;
    }

    public void throwExceptionIfBarcodeIsEmpty(String barcode) {
        if (barcode.equals("")) {
            throw new RuntimeException("Error: empty barcode");
        }
    }

    public void throwExceptionIfProductUnderSearchIsNull(Product productUnderSearch) {
        if (productUnderSearch == null) {
            throw new RuntimeException("Error: barcode not found");
        }
    }
}
