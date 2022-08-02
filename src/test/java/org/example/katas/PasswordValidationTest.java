package org.example.katas;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PasswordValidationTest {

    // TODO:
    // 1- The password must be at least 8 characters long.
    // 2- The password must contain at least 2 numbers.
    // 3- The validation function should handle multiple validation errors.
    // 4- The password must contain at least one capital letter.
    // 5- The password must contain at least one special character.

    @Test
    public void testMustBeAtLeastEightCharactersLong() {
        PasswordValidation pw = new PasswordValidation("Pas!12");
        String message = pw.validatePassword();
        assertEquals(message, "Password must be at least 8 characters");
    }

    @Test
    public void testMustContainAtLeastTwoNumbers() {
        PasswordValidation pw = new PasswordValidation("pas$Word");
        String message = pw.validatePassword();
        assertEquals(message, "The password must contain at least 2 numbers");
    }

    @Test
    public void testHandleMultipleValidationErrors() {
        PasswordValidation pw = new PasswordValidation("paS#1");
        String message = pw.validatePassword();
        assertEquals(message, "Password must be at least 8 characters\nThe password must contain at least 2 numbers");
    }

    @Test
    public void testMustContainAtLeastOneCapitalLetter() {
        PasswordValidation pw = new PasswordValidation("pass#ord123");
        String message = pw.validatePassword();
        assertEquals(message, "Password must contain at least one capital letter");
    }

    @Test
    public void testMustContainAtLeastOneSpecialCharacter() {
        PasswordValidation pw = new PasswordValidation("ValidPassword123");
        String message = pw.validatePassword();
        assertEquals(message, "Password must contain at least one special character");
    }

    @Test
    public void testPasswordFullFillsAllRequirements() {
        PasswordValidation pwd = new PasswordValidation("PassWord123$");
        String message = pwd.validatePassword();
        assertEquals(message, "User created successfully");
    }

}
