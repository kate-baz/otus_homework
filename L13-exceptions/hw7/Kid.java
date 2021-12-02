package hw7;

public class Kid {
    String name;

    public Kid (String name) {
        this.name = name;
    }

    public void read (Book book) {
        System.out.println("I am reading a book");
    }

    static class Book implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("The book is closed");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;

        Kid otherKid = (Kid) object;
        return name.equals((otherKid.name));
    }
    public void play(KinderGarden kg) throws FullKindergardenException {
        if (kg.isFull()) {
            throw new FullKindergardenException();
        }
        System.out.println("I am playing");
    }
}
