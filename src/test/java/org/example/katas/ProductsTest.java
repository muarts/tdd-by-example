package org.example.katas;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductsTest {

    @Test
    public void testBarcodeDisplayPrice() {
        Products products = new Products();
        String price = products.scan("12345");
        assertThat(price, equalTo("$7.25"));
        price = products.scan("23456");
        assertThat(price, equalTo("$12.50"));
    }

    @Test
    public void testBarcodeNotFound() {
        Products products = new Products();
        String price = products.scan("99999");
        assertThat(price, equalTo("Error: barcode not found"));
    }

    @Test
    public void testEmptyBarcode() {
        Products products = new Products();
        String price = products.scan("");
        assertThat(price, equalTo("Error: empty barcode"));
    }

    @Test
    public void testTotalPrice() {
        // Arrange
        Products products = new Products();
        List<String> barcodes = new ArrayList<>();
        barcodes.add("12345");
        barcodes.add("23456");
        // Act
        String sum = products.total(barcodes);
        // Assert
        assertThat(sum, equalTo("$19.75"));
    }
}
