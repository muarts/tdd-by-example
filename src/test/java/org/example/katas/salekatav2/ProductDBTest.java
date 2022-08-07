package org.example.katas.salekatav2;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProductDBTest {

    // TODO:
    // 1- get price of scanned product.
    // 2- get error message if barcode not found.
    // 3- get error message if barcode is empty.

    @Test
    public void testBarcodeDisplayPrice() {
        Product productOne = new Product("12345", "$", 7.25);
        assertThat(productOne.getPrice(), equalTo("$7.25"));
        // triangulation: find a general solution only if there are two or more examples (i.e. test cases)
        Product productTwo = new Product("23456", "$", 12.50);
        assertThat(productTwo.getPrice(), equalTo("$12.5"));
    }

    @Test
    public void testScanDisplayPrice() {
        ProductDB productDB = new ProductDB();
        Product product = productDB.scan("12345");
        assertThat(product.getPrice(), equalTo("$7.25"));
        product = productDB.scan("23456");
        assertThat(product.getPrice(), equalTo("$12.5"));
    }

    @Test(expectedExceptions = {RuntimeException.class}, expectedExceptionsMessageRegExp = "Error: barcode not found")
    public void testBarcodeNotFoundException() {
        ProductDB productDB = new ProductDB();
        productDB.scan("99999");
    }

    @Test(expectedExceptions = {RuntimeException.class}, expectedExceptionsMessageRegExp = "Error: empty barcode")
    public void testEmptyBarcodeException() {
        ProductDB productDB = new ProductDB();
        productDB.scan("");
    }

    @Test
    public void testTotalPriceOfScannedProducts() {
        // Arrange
        ProductDB productDB = new ProductDB();
        Product productOne = new Product("12345", "$", 7.25);
        Product productTwo = new Product("23456", "$", 12.50);
        Product productThree = new Product("44444", "$", 14.50);
        List<Product> products = new ArrayList<>();
        products.add(productOne);
        products.add(productTwo);
        products.add(productThree);
        // Act
        String totalPrice = productDB.total(products);
        // Assert
        assertThat(totalPrice, equalTo("$34.25"));
    }

}
