package diceTest;

import assertions.Assertions;
import application.*;

public class DiceTest {
    public void testIfNumberIsBetween1And6() {
        String scenario = "Dice class testing";
        Dice dice = new DiceImpl();

        try {
            int actualResult = dice.roll();
            boolean expected = actualResult > 0 && actualResult < 7;
            Assertions.assertTrue(expected, String.format("Dice rolled the number %s", actualResult));

            System.out.printf("%s passed.%n", scenario);
        } catch (Throwable e) {
            System.out.printf("%s failed with the message \"%s\".%n", scenario, e.getMessage());
        }
    }

    public static void main(String[] args) {
        DiceTest diceTest = new DiceTest();
        for (int i = 0; i < 20; i++) {
            diceTest.testIfNumberIsBetween1And6();
        }
    }
}
