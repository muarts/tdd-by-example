package org.example.katas;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void testFizzBuzz() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals(fb.fizzBuzz(1), "1");
        assertEquals(fb.fizzBuzz(2), "2");
    }

    @Test
    public void testMultipliesOfThree() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals(fb.fizzBuzz(3), "Fizz");
        assertEquals(fb.fizzBuzz(9), "Fizz");
    }

    @Test
    public void testMultiplesOfFive() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals(fb.fizzBuzz(5), "Buzz");
        assertEquals(fb.fizzBuzz(10), "Buzz");
    }

    @Test
    public void testMultiplesOfBothThreeAndFive() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals(fb.fizzBuzz(0), "FizzBuzz");
        assertEquals(fb.fizzBuzz(15), "FizzBuzz");
    }
}
