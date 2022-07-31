package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        assertEquals(five.times(2), new Dollar(10));
        assertEquals(five.times(3), new Dollar(15));
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

    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertEquals(five.times(2), new Franc(10));
        assertEquals(five.times(3), new Franc(15));
    }
}
