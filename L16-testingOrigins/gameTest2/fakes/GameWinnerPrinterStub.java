package gameTest2.fakes;

import application.GameWinnerPrinter;
import application.Player;

public class GameWinnerPrinterStub implements GameWinnerPrinter {
    public String gameResult;
    @Override
    public void printWinner(Player winner) {
        gameResult = String.format("Победитель: %s", winner.getName());
    }
}
