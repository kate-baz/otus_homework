package test;

import main.PriceSpelledOutApp;

public class NumberBlockToTextTest {
    public static void billionsToTextTest() {
        String scenario = "Test billions conversion to text";
        int number = 904;
        String expectedText = "девятьсот четыре миллиарда ";
        try {
            String actualText = PriceSpelledOutApp.numberBlockToText(number, 0);
            Assertions.assertEquals(expectedText, actualText);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public static void millionsToTextTest() {
        String scenario = "Test millions conversion to text";
        int number = 170;
        String expectedText = "сто семьдесят миллионов ";
        try {
            String actualText = PriceSpelledOutApp.numberBlockToText(number, 1);
            Assertions.assertEquals(expectedText, actualText);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public static void thousandsToTextTest() {
        String scenario = "Test thousands conversion to text";
        int number = 54;
        String expectedText = "пятьдесят четыре тысячи ";
        try {
            String actualText = PriceSpelledOutApp.numberBlockToText(number, 2);
            Assertions.assertEquals(expectedText, actualText);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public static void toThousandsToTextTest() {
        String scenario = "Test to thousands conversion to text";
        int number = 16;
        String expectedText = "шестнадцать рублей";
        try {
            String actualText = PriceSpelledOutApp.numberBlockToText(number, 3);
            Assertions.assertEquals(expectedText, actualText);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public static void main(String[] args) {
        billionsToTextTest();
        millionsToTextTest();
        thousandsToTextTest();
        toThousandsToTextTest();
    }
}
