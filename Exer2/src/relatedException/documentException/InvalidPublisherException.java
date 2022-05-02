package relatedException.documentException;

public class InvalidPublisherException extends RuntimeException{
    public InvalidPublisherException() {
        super("Invalid Choice");
    }

    public InvalidPublisherException(String s) {
        super(s);
    }
}
