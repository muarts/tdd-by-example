package org.example.katas;

public class PasswordValidation {

    private String password;
    private String message = "";
    private String digits = "0123456789";
    private String specialCharacters = "!@#$%^&*()_+";
    private int numberOfDigits;
    private int numberOfCapitalLetters;
    private int numberOfSpecialCharacters;

    public PasswordValidation(String password) {
        this.password = password;
    }

    public String validatePassword() {
        checkIfPasswordContainsMinimumEightCharacters();
        checkIfPasswordContainsRequiredCharactersInSufficientAmount();
        if (message.equals("")) {
            message = "User created successfully\n";
        }
        return message.substring(0, message.length() - 1);
    }

    public void checkIfPasswordContainsMinimumEightCharacters() {
        if (password.length() < 8) {
            message += "Password must be at least 8 characters\n";
        }
    }

    public void checkIfPasswordContainsRequiredCharactersInSufficientAmount() {
        String[] characters = password.split("");
        for (String character : characters) {
            if (Character.isUpperCase(character.charAt(0))) {
                numberOfCapitalLetters++;
            }
            if (specialCharacters.contains(character)) {
                numberOfSpecialCharacters++;
            }
            if (digits.contains(character)) {
                numberOfDigits++;
            }
        }
        if (numberOfDigits < 2) {
            message += "The password must contain at least 2 numbers\n";
        }
        if (numberOfCapitalLetters < 1) {
            message += "Password must contain at least one capital letter\n";
        }
        if (numberOfSpecialCharacters < 1) {
            message += "Password must contain at least one special character\n";
        }
    }
}
