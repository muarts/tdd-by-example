package org.example;

import org.testng.Assert;
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
        five.times(2);
        Assert.assertEquals(five.amount, 10);
    }

    /**
     * 1- Made a list of the tests we knew we needed to have working
     * 2- Told a story with a snippet of code about how we wanted to view one operation
     * 3- Made the test compile with stubs
     * 4- Made the test run by committing horrible sins
     * 5- Gradually generalized the working code, replacing constants with variables
     * 6- Added items to our to-do list rather than addressing them all at once
     */
}
