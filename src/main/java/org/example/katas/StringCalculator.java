package org.example.katas;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    private final String metaCharacters = "( ) [ ] { { \\ ^ $ | ? * + .";

    public int add(String input) {
        if (!inputValidator(input)) {
            return -1;
        }
        if (input.startsWith("//")) {
            return getSum(getArrayOfNumbersWithDelimiter(input));
        }
        return getSum(getArrayOfNumbers(input));
    }

    public String extractDelimiter(String input) {
        return StringUtils.substringBetween(input, "//", "\n");
    }

    public String extractNumbers(String input) {
        return StringUtils.substringAfter(input, "\n");
    }

    public String[] getArrayOfNumbersWithDelimiter(String input) {
        String delimiter = extractDelimiter(input);
        String numbers = extractNumbers(input);
        if (metaCharacters.contains(delimiter)) {
            return numbers.split(String.format("\\%s", delimiter));
        }
        return numbers.split(delimiter);
    }

    public String[] getArrayOfNumbers(String input) {
        String[] arrayOfNumbers = {};
        if (inputValidator(input)) {
            arrayOfNumbers = input.split("[,\n]");
        }
        return arrayOfNumbers;
    }

    public boolean inputValidator(String input) {
        if (input.startsWith("//")) {
            String delimiter = extractDelimiter(input);
            String numbers = extractNumbers(input);
            String validNumbersPattern = String.format("^[0-9%s]*$", delimiter);
            return numbers.matches(validNumbersPattern);
        }
        return !input.endsWith(",");
    }

    public int getSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            try {
                sum += Integer.parseInt(number);
            } catch (NumberFormatException numberFormatException) {
                continue;
            }
        }
        return sum;
    }
}
