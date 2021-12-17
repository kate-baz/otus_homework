package test2.fakes;

import game.Dice;

public class DiceImplStub implements Dice {

    private boolean isFirstCall;
    @Override
    public int roll() {
        if (isFirstCall) {
            isFirstCall = false;
            return 1;
        }
        isFirstCall = true;
        return 2;
    }
}
