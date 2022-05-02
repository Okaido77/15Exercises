package relatedException.documentException;

public class InvalidNumberOfReleaseException extends RuntimeException{
    public InvalidNumberOfReleaseException() {
        super("InvalidNumberOfReleaseException");
    }

    public InvalidNumberOfReleaseException(String s) {
        super(s);
    }
}
