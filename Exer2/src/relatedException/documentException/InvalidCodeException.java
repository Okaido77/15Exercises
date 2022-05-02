package relatedException.documentException;

public class InvalidCodeException extends RuntimeException{
    public InvalidCodeException() {
        super("InvalidCodeException");
    }

    public InvalidCodeException(String s) {
        super(s);
    }
}
