package org.example.katas.salekatav2;

public class Product {

    private String barcode;
    private String currency;
    private Double amount;

    public Product(String barcode, String currency, Double amount) {
        this.barcode = barcode;
        this.currency = currency;
        this.amount = amount;
    }

    public String getPrice() {
        return currency + amount;
    }

    public String getBarcode() {
        return barcode;
    }

    public Double getAmount() {
        return amount;
    }
}
