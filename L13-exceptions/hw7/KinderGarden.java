package hw7;

import java.util.ArrayList;

public class KinderGarden {
    private final int capacity = 3;
    private boolean isFull;
    private boolean isEmpty;
    private ArrayList<Kid> kindergarden;

    public void addKid (Kid kid) throws FullKindergardenException {
        if (isFull) {
            throw new FullKindergardenException();
        }
        kindergarden.add(kid);
    }

    public void giveKidToParent(Parent parent, Kid kid) throws EmptyKindergardenException, WrongKidException {
        if(isEmpty) {
            throw new EmptyKindergardenException("All kids are at home.");
        }
        parent.takeKidHome(kid);
    }

    public boolean isFull() {
        return isFull;
    }

    public static void main(String[] args) {
        KinderGarden kg = new KinderGarden();
        Kid kid1 = new Kid("Ilya");
        Kid kid2 = new Kid("Masha");
        Parent parent1 = new Parent(kid1);
        Parent parent2 = new Parent(kid2);

        try {
            kg.addKid(kid1);
            kg.addKid(kid2);
        }
        catch (FullKindergardenException ex) {
            System.out.println(ex.getMessage());
        }

        try (Kid.Book book = new Kid.Book()) {
            kid1.read(book);
            kid2.read(book);
        }
        catch (Exception ex) {
            System.out.println("The book is closed.");
        }


        try {
            parent1.takeKidHome(kid1);
        }
        catch (WrongKidException ex) {
            ex.printStackTrace();
        }
    }
}
