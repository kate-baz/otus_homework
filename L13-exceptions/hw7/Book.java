package hw7;

public class Book implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("The book is closed");
        }
    }
