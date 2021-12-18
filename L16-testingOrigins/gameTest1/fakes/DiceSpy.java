package gameTest1.fakes;

import application.Dice;

import java.util.List;

public class DiceSpy implements Dice {
    private final List<String> actualFlow;
    private static boolean isFirstCall = true;

    public DiceSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }
    @Override
    public int roll() {
        if (isFirstCall) {
            actualFlow.add("Первый игрок бросает кубик");
            isFirstCall = false;
            return 1;
        }
        isFirstCall = true;
        actualFlow.add("Второй игрок бросает кубик");
        return 2;
    }
}




