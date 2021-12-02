package hw7;

public class WrongKidException extends Exception {
    private String message;

    public WrongKidException(String message) {
        this.message = message;
    }
}
