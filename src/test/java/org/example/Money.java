package org.example;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class Money {

    /**
     * to-do:
     * 1- $5 * $2 = $10
     * 2- Make "amount" private
     * 3- Dollar side effects?
     * 4- Money rounding?
     */

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(product.amount, 10);
        product = five.times(3);
        assertEquals(product.amount, 15);
    }

    /**
     * Two of three strategies for quickly getting to green
     * 1- Fake it -> Return a constant and gradually replace constants with variable until you have the real code.
     * 2- Use to obvious implementation -> Type in the real implementation.
     */
}
