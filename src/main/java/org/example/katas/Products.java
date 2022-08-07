package org.example.katas;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;

public class Products {

    private static HashMap<String, String> products = new HashMap<>();

    static {
        products.put("12345", "$7.25");
        products.put("23456", "$12.50");
    }

    public String scan(String barcode) {
        if (barcode.equals("")) {
            return "Error: empty barcode";
        }
        if (!products.containsKey(barcode)) {
            return "Error: barcode not found";
        }
        return products.get(barcode);
    }

    public String total(List<String> barcodes) {
        Double sum = 0.0;
        for (int i = 0; i < barcodes.size(); i++) {
            String price = products.get(barcodes.get(i));
            String amount = StringUtils.substringAfter(price, "$");
            sum += Double.parseDouble(amount);
        }
        return "$" + sum;
    }
}
