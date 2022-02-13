package test;

import main.IOService;
import main.PriceSpelledOutApp;

public class GetNumberFromUserTest {

    public static void getNumberFromUserTest() {
        String scenario = "Test of getNumberFromUser method";
        PriceSpelledOutApp mainApp = new PriceSpelledOutApp();
        IOStreamsServiceStub1 ioService = new IOStreamsServiceStub1();
        try {
            long expectedNumber = 1234567;
            long actualNumber = mainApp.getNumberFromUser(ioService);
            Assertions.assertEquals(expectedNumber, actualNumber);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
    static class IOStreamsServiceStub1 implements IOService {

        @Override
        public void outputString(String message) { }

        @Override
        public String inputString() {
            return "1234567";
        }
    }

    public static void throwsExceptionIfNotParseableText() {
        String scenario = "Test that getNumberFromUser method throws NumberFormatException if number is not parseable";
        PriceSpelledOutApp mainApp = new PriceSpelledOutApp();
        IOStreamsServiceStub2 ioService = new IOStreamsServiceStub2();
        try {
            Assertions.assertThrows(NumberFormatException.class, () -> mainApp.getNumberFromUser(ioService));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
    static class IOStreamsServiceStub2 implements IOService {

        @Override
        public void outputString(String message) { }

        @Override
        public String inputString() {
            return "Not parseable text";
        }
    }

    public static void main(String[] args) {
        getNumberFromUserTest();
        throwsExceptionIfNotParseableText();
    }
}
