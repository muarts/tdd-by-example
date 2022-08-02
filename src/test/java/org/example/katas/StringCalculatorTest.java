package org.example.katas;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.add(""), 0);
    }

    @Test
    public void testSingleNumber() {
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.add("3"), 3);
    }

    @Test
    public void testMultipleNumbers() {
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.add("1,2"), 3);
        assertEquals(sc.add("1,2,4,7"), 14);
    }

    @Test
    public void testNewlinesAsSeparators() {
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.add("1,2\n3"), 6);
    }

    @Test
    public void testSeparatorAtTheEnd() {
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.add("1,2,"), -1);
    }

    @Test
    public void testExtractDelimiter() {
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.extractDelimiter("//;\n1;3"), ";");
        assertEquals(sc.extractDelimiter("//|\n1|2|3"), "|");
    }

    @Test
    public void testExtractNumbers() {
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.extractNumbers("//;\n1;3"), "1;3");
        assertEquals(sc.extractNumbers("//sep\n2sep5"), "2sep5");
    }

    @Test
    public void testGetArrayOfNumbers() {
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.getArrayOfNumbers("1,2,3"), new String[]{"1", "2", "3"});
        assertEquals(sc.getArrayOfNumbers("1"), new String[]{"1"});
    }

    @Test
    public void testGetArrayOfNumbersWithDelimiter() {
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.getArrayOfNumbersWithDelimiter("//;\n1;3"), new String[]{"1", "3"});
        assertEquals(sc.getArrayOfNumbersWithDelimiter("//sep\n2sep5"), new String[]{"2", "5"});
        assertEquals(sc.getArrayOfNumbersWithDelimiter("//|\n1|2|3"), new String[]{"1", "2", "3"});
    }

    @Test
    public void testInputValidator() {
        StringCalculator sc = new StringCalculator();
        assertTrue(sc.inputValidator("1,2,3"));
        assertFalse(sc.inputValidator("1,2,3,"));
        assertTrue(sc.inputValidator("//sep\n2sep5"));
        assertFalse(sc.inputValidator("//|\n1|2,3"));
    }
}
