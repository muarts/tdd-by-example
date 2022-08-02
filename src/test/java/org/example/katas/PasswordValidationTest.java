package org.example.katas;

import org.testng.annotations.Test;

import static org.example.katas.constants.Keywords.*;
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
        assertEquals(message, MIN_EIGHT_CHARS_ERROR);
    }

    @Test
    public void testMustContainAtLeastTwoNumbers() {
        PasswordValidation pw = new PasswordValidation("pas$Word");
        String message = pw.validatePassword();
        assertEquals(message, MIN_TWO_NUMS_ERROR);
    }

    @Test
    public void testHandleMultipleValidationErrors() {
        PasswordValidation pw = new PasswordValidation("paS#1");
        String message = pw.validatePassword();
        assertEquals(message, MULTIPLE_ERROR);
    }

    @Test
    public void testMustContainAtLeastOneCapitalLetter() {
        PasswordValidation pw = new PasswordValidation("pass#ord123");
        String message = pw.validatePassword();
        assertEquals(message, MIN_ONE_CAPITAL_LETTER_ERROR);
    }

    @Test
    public void testMustContainAtLeastOneSpecialCharacter() {
        PasswordValidation pw = new PasswordValidation("ValidPassword123");
        String message = pw.validatePassword();
        assertEquals(message, MIN_ONE_SPECIAL_CHAR_ERROR);
    }

    @Test
    public void testPasswordFullFillsAllRequirements() {
        PasswordValidation pwd = new PasswordValidation("PassWord123$");
        String message = pwd.validatePassword();
        assertEquals(message, SUCCESS_MESSAGE);
    }

}
