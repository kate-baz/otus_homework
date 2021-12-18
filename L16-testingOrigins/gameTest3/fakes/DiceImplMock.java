package gameTest3.fakes;

import application.Dice;

public class DiceImplMock implements Dice {
    boolean isFirstCall = true;
    @Override
    public int roll() {
        if(isFirstCall) {
            isFirstCall = false;
            return 1;
        } else {
            isFirstCall = true;
            return 2;
        }
    }
}
