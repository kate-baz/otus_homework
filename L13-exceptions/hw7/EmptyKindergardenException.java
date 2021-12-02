package hw7;

public class EmptyKindergardenException extends Exception {
    private String message;

    public EmptyKindergardenException(String message) {
        this.message = message;
    }
}
