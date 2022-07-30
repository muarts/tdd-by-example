package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
     * Triangulation: We only generalize (finding a general solution) code
     * when we have two examples or more.
     */
    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }

}
