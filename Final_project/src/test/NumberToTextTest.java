package test;

import main.PriceSpelledOutApp;

public class NumberToTextTest {
    public static void numberToTextTest() {
        String scenario = "Test whole number conversion to text";
        int billions = 906;
        int millions = 18;
        int thousands = 450;
        int toThousands = 119;
        String expectedText = "девятьсот шесть миллиардов восемнадцать миллионов четыреста пятьдесят тысяч сто девятнадцать рублей";
        try {
            String actualText = PriceSpelledOutApp.numberToText(billions, millions, thousands, toThousands);
            Assertions.assertEquals(expectedText, actualText);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public static void main(String[] args) {
        numberToTextTest();
    }
}
