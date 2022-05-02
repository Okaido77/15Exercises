package relatedException;

public class EmailException extends RuntimeException{
    public EmailException() {
    }

    public EmailException(String s) {
        super(s);
    }

    public EmailException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
