package test1;

import assertions.Assertions;
import game.*;
import test1.fakes.DiceSpy;
import test1.fakes.GameWinnerPrinterSpy;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    public void testGameFlow() {
        String scenario = "Тест работы приложения";

        try {
            List<String> expectedFlow = List.of("Первый игрок бросает кубик",
                    "Второй игрок бросает кубик",
                    "Выводим имя победителя - Петя");
            List<String> actualFlow = new ArrayList<>();

            Dice diceSpy = new DiceSpy(actualFlow);
            GameWinnerPrinter gameWinnerPrinterSpy = new GameWinnerPrinterSpy(actualFlow);
            Game game = new Game(diceSpy, gameWinnerPrinterSpy);
            Player player1 = new Player("Женя");
            Player player2 = new Player("Петя");
            game.playGame(player1, player2);

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        }
        catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public static void main(String[] args) {
        GameTest gameTest = new GameTest();
        gameTest.testGameFlow();
    }
}
