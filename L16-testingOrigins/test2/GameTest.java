package test2;

import assertions.Assertions;
import game.*;
import test2.fakes.DiceImplStub;

public class GameTest {
    String scenario = "Тест работы приложения";

    public void testGame() {
        try {
            String expectedWinner = "Петя";

            Dice diceStub = new DiceImplStub();
            GameWinnerPrinter printer = new GameWinnerConsolePrinter();
            Game game = new Game(diceStub, printer);

            Player player1 = new Player("Женя");
            Player player2 = new Player("Петя");
            game.playGame(player1, player2);

            Assertions.assertEquals(expectedWinner, player2.getName());

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public static void main(String[] args) {
        GameTest gameTest = new GameTest();
        gameTest.testGame();
    }
}
