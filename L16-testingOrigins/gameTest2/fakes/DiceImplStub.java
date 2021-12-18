package gameTest2.fakes;

import application.Dice;

public class DiceImplStub implements Dice {
    @Override
    public int roll() {
        return 1;
    }
}
