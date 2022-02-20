package test;

import main.PriceSpelledOutApp;

public class GetNumberFromUserTest {

    public static void getNumberFromUserTest() {
        String scenario = "Test of getNumberFromUser method";
        PriceSpelledOutApp mainApp = new PriceSpelledOutApp();
        try {
            long expectedNumber = 1234567;
            String actualInput = "1234567";
            long actualNumber = mainApp.getNumberFromUser(actualInput);
            Assertions.assertEquals(expectedNumber, actualNumber);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }


    public static void throwsExceptionIfNotParseableText() {
        String scenario = "Test that getNumberFromUser method throws NumberFormatException if number is not parseable";
        try {
            String actualInput = "Not parseable text";
            Assertions.assertThrows(NumberFormatException.class, () -> PriceSpelledOutApp.getNumberFromUser(actualInput));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public static void main(String[] args) {
        getNumberFromUserTest();
        throwsExceptionIfNotParseableText();
    }
}
