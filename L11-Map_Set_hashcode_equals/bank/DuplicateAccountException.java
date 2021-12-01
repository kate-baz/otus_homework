public class DuplicateAccountException extends Exception {
    String message;

    public DuplicateAccountException(String message) {
        this.message = message;
    }
}
