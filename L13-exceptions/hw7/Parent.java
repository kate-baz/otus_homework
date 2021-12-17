package hw7;

public class Parent {
    private Kid myKid;

    public Parent (Kid kid) {
        this.myKid = kid;
    }

    public void takeKidHome(Kid kid) throws WrongKidException {
        if (!kid.equals(myKid)) {
            throw new WrongKidException("This is not my kid");
        }
    }
}
