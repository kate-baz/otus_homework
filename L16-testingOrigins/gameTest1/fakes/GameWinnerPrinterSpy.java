package gameTest1.fakes;

import application.GameWinnerPrinter;
import application.Player;

import java.util.List;

public class GameWinnerPrinterSpy implements GameWinnerPrinter {
    private final List<String> actualFlow;

    public GameWinnerPrinterSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }

    @Override
    public void printWinner(Player winner) {
        actualFlow.add(String.format("Выводим имя победителя - %s", winner.getName()));
    }
}
