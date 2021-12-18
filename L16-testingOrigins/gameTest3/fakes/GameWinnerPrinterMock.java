package gameTest3.fakes;

import application.GameWinnerPrinter;
import application.Player;

public class GameWinnerPrinterMock implements GameWinnerPrinter {
    public String gameWinner;
    @Override
    public void printWinner(Player winner) {
        gameWinner = winner.getName();
    }
}
