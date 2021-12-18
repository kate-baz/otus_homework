package gameTest3;

import application.Game;
import application.Player;
import assertions.Assertions;
import gameTest3.fakes.DiceImplMock;
import gameTest3.fakes.GameWinnerPrinterMock;

public class GameTestMock {
    public void testGame() {
        String scenario = "Testing of Game class";
        try {
            String expectedWinner = "Марина";
            DiceImplMock diceImplStub = new DiceImplMock();
            GameWinnerPrinterMock gameWinnerPrinterStub = new GameWinnerPrinterMock();
            Game game = new Game(diceImplStub, gameWinnerPrinterStub);
            Player player1 = new Player("Аня");
            Player player2 = new Player("Марина");
            game.playGame(player1, player2);
            String actualWinner = gameWinnerPrinterStub.gameWinner;

            Assertions.assertEquals(expectedWinner, actualWinner);

            System.out.printf("%s passed.%n", scenario);
        } catch (Throwable e) {
            System.out.printf("%s failed with the message \"%s\".%n", scenario, e.getMessage());
        }
    }

    public static void main(String[] args) {
        GameTestMock gameTestMock = new GameTestMock();
        gameTestMock.testGame();
    }
}
