package gameTest2;

import assertions.Assertions;
import application.*;
import gameTest2.fakes.*;

public class GameTestStub {
    String scenario = "Тест работы приложения";

    public void testIfPlayersGetEqualResults() {
        try {
            String expectedResult = "Ничья";

            Dice diceStub = new DiceImplStub();
            GameWinnerPrinterStub printer = new GameWinnerPrinterStub();
            Game game = new Game(diceStub, printer);

            Player player1 = new Player("Женя");
            Player player2 = new Player("Петя");
            game.playGame(player1, player2);
            String actualResult = printer.gameResult;

            Assertions.assertEquals(expectedResult, actualResult);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message %s\" %n", scenario, e.getMessage());
        }
    }

    public static void main(String[] args) {
        GameTestStub gameTest = new GameTestStub();
        for (int i = 0; i < 3; i++) {
            gameTest.testIfPlayersGetEqualResults();
        }
    }
}
