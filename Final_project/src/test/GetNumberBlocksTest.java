package test;

import main.PriceSpelledOutApp;

public class GetNumberBlocksTest {
    public static void getNumberBlocksTest() {
        String scenario = "Test that number is divided into blocks";
        long number = 978503970005L;
        int expectedBillions = 978;
        int expectedMillions = 503;
        int expectedThousands = 970;
        int expectedToThousands = 5;

        try {
            PriceSpelledOutApp.getNumberBlocks(number);
            Assertions.assertEquals(expectedBillions, PriceSpelledOutApp.getBillions());
            Assertions.assertEquals(expectedMillions, PriceSpelledOutApp.getMillions());
            Assertions.assertEquals(expectedThousands, PriceSpelledOutApp.getThousands());
            Assertions.assertEquals(expectedToThousands, PriceSpelledOutApp.getToThousand());
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public static void main(String[] args) {
        getNumberBlocksTest();
    }
}
