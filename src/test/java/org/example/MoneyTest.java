package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MoneyTest {

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(five.times(2), Money.dollar(10));
        assertEquals(five.times(3), Money.dollar(15));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }

    @Test
    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(five.times(2), Money.franc(10));
        assertEquals(five.times(3), Money.franc(15));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        // Operations result in expressions, one of which will be a sum.
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        // Once the operation is complete, the resulting Expression can be reduced
        // back to a single currency given a set of exchange rates.
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(reduced, Money.dollar(10));
    }
}
