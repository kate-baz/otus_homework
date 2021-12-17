package hw7;

import java.util.ArrayList;

public class KinderGarden {
    private final int capacity = 3;
    private static boolean isFull = false;
    private boolean isEmpty;
    private static ArrayList<Kid> kindergarden = new ArrayList<>();

    public void addKid (Kid kid) throws FullKindergardenException {
        if (isFull) {
            throw new FullKindergardenException("Kindergarden is full");
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

    public static void main(String[] args) throws WrongKidException {
        KinderGarden kg = new KinderGarden();
        Kid kid1 = new Kid("Ilya");
        Kid kid2 = new Kid("Masha");
        Parent parent1 = new Parent(kid1);
        Parent parent2 = new Parent(kid2);

        try {
            kg.addKid(kid1);
            kg.addKid(kid2);
            isFull = true;
            kg.addKid(new Kid("Ivan"));
        }
        catch (FullKindergardenException ex) {
            System.out.println(ex.getMessage());
        }

        try (Book book = new Book()) {
            kid1.read(book);
            kid2.read(book);
        }
//        catch (Exception ex) {
//            System.out.println("The book is closed.");
//        }


        try {
            parent1.takeKidHome(kid2);
        }
        catch (WrongKidException ex) {
            ex.printStackTrace();
//            throw new IllegalArgumentException(ex.getMessage());
            throw ex;
        }
    }
}
